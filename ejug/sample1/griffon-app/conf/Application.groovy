application {
    title = 'Sample1'
    startupGroups = ['sample1']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "sample1"
    'sample1' {
        model      = 'sample1.Sample1Model'
        view       = 'sample1.Sample1View'
        controller = 'sample1.Sample1Controller'
    }

}
