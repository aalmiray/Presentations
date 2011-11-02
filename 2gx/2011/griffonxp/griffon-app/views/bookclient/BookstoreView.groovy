package bookclient

makeTableTab = { params ->
  scrollPane(title: params.title) {
    table {
      def tableFormat = defaultTableFormat(columnNames: params.columns)
      eventTableModel(source: params.source, format: tableFormat)
      installTableComparatorChooser(source: params.source)
} } }

actions {
    action(id: 'connectAction',
        name: 'Connect',
        closure: controller.connect)
}

panel(id: 'content', border: lineBorder(color: Color.BLACK, thickness: 2)) {
  migLayout(layoutConstraints: 'fill', rowConstraints: '5%[80%]5%[bottom]')
  tabbedPane(constraints: 'grow, wrap', cssClass: 'demo') {
    makeTableTab(title: 'Authors', columns: ['Name', 'Lastname'],
                 source: model.authors)
    makeTableTab(title: 'Books', columns: ['Title'],
                 source: model.books)
    busyComponent(busy: bind{ model.busy }, title: 'Search') {
      panel {
        migLayout(layoutConstraints: 'fill')
        textField(columns: 30, text: bind('query', target: model), cssClass: 'demo')
        button('Search', actionPerformed: controller.search, cssClass: 'demo',
               enabled: bind{ model.enabled }, constraints: 'wrap')
        buttonGroup(id: 'choice')
        radioButton('Authors', buttonGroup: choice, selected: true, cssClass: 'demo',
                    actionCommand: BookstoreModel.AUTHORS, constraints: 'wrap')
        radioButton('Books', buttonGroup: choice, cssClass: 'demo',
                    actionCommand: BookstoreModel.BOOKS, constraints: 'wrap')
        label(text: bind{ model.status }, cssClass: 'demo', constraints: 'span 2, center, wrap')
        scrollPane(constraints: 'span 2, growx, growy' ) {
          table {
            def tableFormat = defaultTableFormat(columnNames: ['Title', 'Name', 'Lastname'])
            eventTableModel(source: model.results, format: tableFormat)
            installTableComparatorChooser(source: model.results)
} } } } }
  button(connectAction, constraints: 'right', cssClass: 'demo')
}
