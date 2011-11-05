import griffon.util.ApplicationHolder
import griffon.util.Environment
import org.jdesktop.swingx.JXErrorPane
import javax.swing.JOptionPane

onBootstrapEnd = { app ->
    app.config.shutdown.proceed = false

    app.addShutdownHandler([
            canShutdown: { a ->
                if (app.windowManager.findWindow('loginWindow').visible) return true

                app.config.shutdown.proceed = JOptionPane.showConfirmDialog(
                        app.windowManager.windows.find {it.focused},
                        "Do you really want to exit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION
                return app.config.shutdown.proceed
            },
            onShutdown: { a -> }
    ] as griffon.core.ShutdownHandler)
}

onShutdownAborted = { app ->
    app.config.shutdown.proceed = false
}

onUncaughtExceptionThrown = { t ->
    if (Environment.current == Environment.TEST) {
        JXErrorPane.showDialog(t)
        return
    }

    def app = ApplicationHolder.application
    app.withMVCGroup('exceptionHandler') { m, v, c ->
        m.message = """
            <html><p>Oops, an unexpected error has occurred!

            However don't panic (unless you forgot your towel
            in which case have a nice day) we got it covered
            and your application will not crash (probably).
            Here's what happened:</p>

            <p>$t</p>

            </html>
        """.stripIndent(12).trim().replace('\n', '<br/>')
        c.show()
    }
}