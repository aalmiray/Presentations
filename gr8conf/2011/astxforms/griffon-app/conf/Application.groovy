application {
    title = 'Griffon: Past, Present & Future'
    startupGroups = ['DeckLauncher']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true
}
mvcGroups {
    'charts' {
        chart3d = 'griffonevo.SecondChart3D'
    }
}
