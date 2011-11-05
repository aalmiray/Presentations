application {
    title = 'Demo'
    startupGroups = ['login', 'demo']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "ExceptionHandler"
    'exceptionHandler' {
        model      = 'demo.ExceptionHandlerModel'
        view       = 'demo.ExceptionHandlerView'
        controller = 'demo.DialogController'
    }

    // MVC Group for "login"
    'login' {
        model      = 'demo.LoginModel'
        view       = 'demo.LoginView'
        controller = 'demo.LoginController'
    }
    
    // MVC Group for "preferences"
    'preferences' {
        model      = 'demo.PreferencesModel'
        view       = 'demo.PreferencesView'
        controller = 'demo.DialogController'
    }

    // MVC Group for "license"
    'license' {
        model      = 'demo.LicenseModel'
        view       = 'demo.LicenseView'
        controller = 'demo.DialogController'
    }

    // MVC Group for "credits"
    'credits' {
        model      = 'demo.CreditsModel'
        view       = 'demo.CreditsView'
        controller = 'demo.DialogController'
    }

    // MVC Group for "about"
    'about' {
        model      = 'demo.AboutModel'
        view       = 'demo.AboutView'
        controller = 'demo.DialogController'
    }

    // MVC Group for "demo"
    'demo' {
        model      = 'demo.DemoModel'
        view       = 'demo.DemoView'
        controller = 'demo.DemoController'
    }
}
