/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres.Almiray
 */

package griffon.slideware

import javax.swing.text.Style
import javax.swing.text.StyleContext
import javax.swing.text.StyledDocument
import groovy.ui.ConsoleTextEditor
import java.awt.Color
import java.awt.Font

def runnable = attrs?.remove("runnable") ?: false

editor = widget(new ConsoleTextEditor(border: emptyBorder(0)))

model.outputWindow = window(visible: false, id: "outputWindow", pack: true, locationRelativeTo: editor) {
    scrollPane(border: emptyBorder(2)/*lineBorder(thickness: 1, color: Color.RED)*/) {
        outputArea = textPane(
            editable: false,
            name: "outputArea",
            contentType: "text/html",
            background: new Color(255,255,218),
            font: new Font("Monospaced", Font.PLAIN, 18),
            border: emptyBorder(4),
            mousePressed: { outputWindow.visible = false }
        )
        noparent {
            StyledDocument doc = outputArea.styledDocument
            model.document = doc
            Style defStyle = StyleContext.defaultStyleContext.getStyle(StyleContext.DEFAULT_STYLE)
            def applyStyle = {Style style, values -> values.each{k, v -> style.addAttribute(k, v)}}

            def styles = EditorStyles.getPlatformStyles()
            model.styles.regular = doc.addStyle("regular", defStyle)
            applyStyle(model.styles.regular, styles.regular)

            model.styles.promptStyle = doc.addStyle("prompt", model.styles.regular)
            applyStyle(model.styles.promptStyle, styles.prompt)

            model.styles.commandStyle = doc.addStyle("command", model.styles.regular)
            applyStyle(model.styles.commandStyle, styles.command)

            model.styles.outputStyle = doc.addStyle("output", model.styles.regular)
            applyStyle(model.styles.outputStyle, styles.output)

            model.styles.resultStyle = doc.addStyle("result", model.styles.regular)
            applyStyle(model.styles.resultStyle, styles.result)

            model.styles.stacktraceStyle = doc.addStyle("stacktrace", model.styles.regular)
            applyStyle(model.styles.stacktraceStyle, styles.stacktrace)
        }
    }
}

EditorStyles.apply(editor)
container(editor.textEditor,
    editable: false,
    font: new Font("Monospaced", Font.PLAIN, 20),
    text: bind(target: model, targetProperty: "script")) {
    if(runnable) {
        action(runAction)
    }
}
keyStrokeAction(component: editor,
    keyStroke: shortcut("shift L"),
    condition: "in focused window",
    action: biggerFontAction)
keyStrokeAction(component: editor,
    keyStroke: shortcut("shift S"),
    condition: "in focused window",
    action: smallerFontAction)
attrs?.each{ k, v -> editor.textEditor[(k)] = v }
busyComponent(busy: bind{ model.busy }) {
    editor
}
