application {
    title='Groovy Testing'
    startupGroups = ['DeckOptions', 'DeckPlayer']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true

    // If you want some non-standard application class, apply it here
    //frameClass = 'javax.swing.JFrame'
}

mvcGroups {
}

resolution {
    screen {
        width = 1152
        height = 864
    }
}

fullscreen = true
