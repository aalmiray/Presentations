application {
    title='Codemash'
    startupGroups = ['codemash']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "codemash"
    'codemash' {
        model = 'CodemashModel'
        controller = 'CodemashController'
        view = 'CodemashView'
    }

}

jme.simpleGameDelegate = "MySimpleGameDelegate"
