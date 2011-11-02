def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide16')
m.editable = false
m.code = '''package bookclient

makeTableTab = { params ->
  scrollPane(title: params.title) {
    table {
      def tf = defaultTableFormat(columnNames: params.columns)
      eventTableModel(source: params.source, format: tf)
      installTableComparatorChooser(source: params.source)
} } }

panel(id: 'content', border: lineBorder(color: Color.BLACK, thickness: 2)) {
  migLayout(layoutConstraints: 'fill')
  tabbedPane(constraints: 'grow, wrap') {
    makeTableTab(source: model.authors,
        title: 'Authors', columns: ['Name', 'Lastname'])
    makeTableTab(source: model.books, 
        title: 'Books', columns: ['Title'])
    busyComponent(busy: bind{model.busy}, title: 'Search') {
      panel {
        migLayout(layoutConstraints: 'fill')
        textField(columns: 30, text: bind('query', target: model))
        button('Search', actionPerformed: controller.search,
          enabled: bind{ model.enabled }, constraints: 'wrap')
        buttonGroup(id: 'choice')
        radioButton('Authors', buttonGroup: choice, selected: true,
          actionCommand: BookstoreModel.AUTHORS, constraints: 'wrap')
        radioButton('Books', buttonGroup: choice,
          actionCommand: BookstoreModel.BOOKS, constraints: 'wrap')
        label(text: bind{model.status},
              constraints: 'span 2, center, wrap')
        scrollPane(constraints: 'span 2, growx, growy' ) {
          table {
            def tf = defaultTableFormat(
                columnNames: ['Title', 'Name', 'Lastname'])
            eventTableModel(source: model.results, format: tf)
            installTableComparatorChooser(source: model.results)
} } } } } }'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'View')
    widget(v.groovyEditorContainer, constraints: 'grow')
}
