application {
    title = 'Griffonxp'
    startupGroups = ['DeckLauncher']

    // Should Griffon exit when no Griffon created frames are showing?
    autoShutdown = true
}
mvcGroups {
    // MVC Group for "Bookstore"
    'Bookstore' {
        model      = 'bookclient.BookstoreModel'
        view       = 'bookclient.BookstoreView'
        controller = 'bookclient.BookstoreController'
    }
}
