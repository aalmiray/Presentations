application {
    title = 'Sample2'
    startupGroups = ['sample2']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}
mvcGroups {
    // MVC Group for "sample2"
    'sample2' {
        model      = 'sample2.Sample2Model'
        view       = 'sample2.Sample2View'
        controller = 'sample2.Sample2Controller'
    }

}
