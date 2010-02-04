application {
    title='JavafxApp'
    startupGroups = ['javafx-app']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "javafx-app"
    'javafx-app' {
        model = 'JavafxAppModel'
        controller = 'JavafxAppController'
        view = 'JavafxAppView'
    }

}
