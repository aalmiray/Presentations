package griffon.slideware

import java.awt.Dimension
import javax.swing.text.AttributeSet
import javax.swing.text.Element
import javax.swing.text.SimpleAttributeSet
import javax.swing.text.Style
import javax.swing.text.StyleConstants
import javax.swing.text.html.HTML

import groovy.ui.SystemOutputInterceptor

import org.codehaus.groovy.runtime.InvokerHelper
import org.codehaus.groovy.runtime.StackTraceUtils
import org.codehaus.groovy.control.ErrorCollector
import org.codehaus.groovy.control.MultipleCompilationErrorsException
import org.codehaus.groovy.control.messages.SyntaxErrorMessage
import org.codehaus.groovy.control.messages.ExceptionMessage
import org.codehaus.groovy.syntax.SyntaxException

class CodeEditorController {
    def model
    def view

    private GroovyShell shell = new GroovyShell()
    private int scriptCount = 0
    private int maxOutputChars = 20000
    private SystemOutputInterceptor systemOutInterceptor

    def mvcGroupInit(Map args){
        app.config.editor.hide.timeout = app.config?.editor?.hide?.timeout ?: 15000
        systemOutInterceptor = new SystemOutputInterceptor({ String str ->
            appendOutput(str, model.styles.outputStyle)
			false
        })
    }

    def runScript = { evt = null ->
        if(!model.script) return
        def scriptText = model.script
        clearOutput()
        systemOutInterceptor.start()
        // model.busy = true
        doOutside {
            try {
                def result = shell.run(scriptText, "Script"+(scriptCount++), [])
                doLater { finishNormal(result) }
            } catch(Throwable t) {
                doLater { finishException(t) }
            } finally {
                systemOutInterceptor.stop()
                // doLater { model.busy = false }
            }
        }
    }

    private finishNormal(result) {
        ensureNoDocLengthOverflow(model.document)
		if(model.document.length) popOutputWindow()
    }

    private finishException(t) {
        if (t instanceof MultipleCompilationErrorsException) {
            MultipleCompilationErrorsException mcee = t
            ErrorCollector collector = mcee.errorCollector
            int count = collector.errorCount
            appendOutputNl("${count} compilation error${count > 1 ? 's' : ''}:\n\n", model.styles.commandStyle)

            collector.errors.each { error ->
                if (error instanceof SyntaxErrorMessage) {
                    SyntaxException se = error.cause
                    int errorLine = se.line
                    String message = se.originalMessage
                    def doc = model.document
                    doc.insertString(doc.length, message + " at ", model.styles.stacktraceStyle)
                    doc.insertString(doc.length, "line: ${se.line}, column: ${se.column}\n\n", model.styles.stacktraceStyle)
                } else if (error instanceof Throwable) {
                    reportException(error)
                } else if (error instanceof ExceptionMessage) {
                    reportException(error.cause)
                }
            }
        } else {
            reportException(t)
        }
        popOutputWindow()
    }

    private reportException(Throwable t) {
        appendOutputNl("Exception thrown: ", model.styles.commandStyle)
        appendOutput(t.message + '\n', model.styles.stacktraceStyle)

        StringWriter sw = new StringWriter()
        new PrintWriter(sw).withWriter {pw -> StackTraceUtils.deepSanitize(t).printStackTrace(pw) }
        appendStacktrace("\n${sw.buffer}\n")
    }

    // Append a string to the output area
    void appendOutput(String text, AttributeSet style){
        def doc = model.document
        doc.insertString(doc.length, text, style)
        ensureNoDocLengthOverflow(doc)
    }

    void appendOutput(Object object, AttributeSet style) {
        append(object.toString(), style)
    }

    void appendStacktrace(text) {
        def doc = model.document

        // split lines by new line separator
        def lines = text.split(/(\n|\r|\r\n|\u0085|\u2028|\u2029)/)

        // Java Identifier regex
        def ji = /([\p{Alnum}_\$][\p{Alnum}_\$]*)/

        // stacktrace line regex
        def stacktracePattern = /\tat $ji(\.$ji)+\((($ji(\.(java|groovy))?):(\d+))\)/

        lines.each { line ->
            int initialLength = doc.length
            doc.insertString(initialLength, line + '\n', model.styles.stacktraceStyle)
        }

        ensureNoDocLengthOverflow(doc)
    }

    // Append a string to the output area on a new line
    void appendOutputNl(text, style){
        def doc = model.document
        def len = doc.length
        if (len > 0 && doc.getText(len - 1, 1) != "\n") {
            appendOutput("\n", style)
        }
        appendOutput(text, style)
    }

    private clearOutput() {
        if(model.document.length) model.document.remove(0, model.document.length)
    }

    private ensureNoDocLengthOverflow(doc) {
        if (doc.length > maxOutputChars) {
            doc.remove(0, doc.length - maxOutputChars)
        }
    }

    private popOutputWindow() {
        model.outputWindow.pack()
		// TODO use the scrollPane's size instead
        def es = view.editor.size
        model.outputWindow.size = es
        model.outputWindow.visible = true
        model.outputWindow.locationRelativeTo = view.editor
        jxwithWorker(start: true) {
            work { Thread.sleep(app.config.editor.hide.timeout) }
            onDone {
                model.outputWindow.visible = false
            }
        }
    }
}