log4j = {
    // Example of changing the log pattern for the default console
    // appender:
    appenders {
        console name: 'stdout', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
        event   name: 'logger', layout: pattern(conversionPattern: '%d [%t] %-5p %c - %m%n')
    }

    warn  'org.codehaus.griffon'

    info   'griffon.util',
           'griffon.core',
           'griffon.swing',
           'griffon.app'
}

griffon.gsql.injectInto = ['service']

import griffon.swing.SwingUtils

swing {
    windowManager {
        loginWindow = [
            show: {w, app ->
                SwingUtils.centerOnScreen(w)
                w.visible = true
            }
        ]
        mainWindow = [
            show: {w, app ->
                SwingUtils.centerOnScreen(w)
                w.visible = true
            },
            hide: {w, app -> if(app.config.shutdown.proceed) w.dispose()}
        ]
    }
}
