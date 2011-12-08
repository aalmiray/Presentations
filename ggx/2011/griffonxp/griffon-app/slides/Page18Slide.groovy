def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide18')
m.editable = false
m.code = '''package bookclient

class BookstoreController {
  def model
  def view
  def bookstoreService

  def search = {
    execSync {
      model.busy = true
      model.status = ''
      model.results.clear()
    }

    String where = view.choice.selection.actionCommand

    try {
      List results = []
      switch(where) {
        case BookstoreModel.AUTHORS:
          results = bookstoreService.searchAuthors(model)
          break
        case BookstoreModel.BOOKS:
          results = bookstoreService.searchBooks(model)
          break
      }
      execSync {
        int size = results-size()
        model.status = 
          "Found ${size} result${size != 1 ? 's': ''}"
        if(results) model.results.addAll(results)
      }
    } finally {
      execAsync { model.busy = false }
} } }'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Controller')
    widget(v.groovyEditorContainer, constraints: 'grow')
}
