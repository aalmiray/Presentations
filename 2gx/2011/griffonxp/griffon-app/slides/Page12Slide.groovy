def (m1, v1, c1) = createMVCGroup('GroovyCodeEditor', 'editor-slide12-1')
m1.editable = false
m1.code = '''class UrlMappings {
  static mappings = {
    "/author/"(controller: 'author', action: 'list')
    "/author/search"(controller: 'author', action: 'search')
    "/author/list"(controller: 'author', action: 'list')
    "/author/$id"(controller: 'author', action: 'show')
    "/book/"(controller: 'book', action: 'list')
    "/book/search"(controller: 'book', action: 'search')
    "/book/list"(controller: 'book', action: 'list')
    "/book/$id"(controller: 'book', action: 'show')
    "/"(view:"/index")
    "500"(view:'/error')
  }
}'''

def (m2, v2, c2) = createMVCGroup('GroovyCodeEditor', 'editor-slide12-2')
m2.editable = false
m2.code = '''class BootStrap {
  def init = { servletContext ->
    def authors = [
      new Author(name: 'Octavio', lastname: 'Paz'),
      new Author(name: 'Gabriel', lastname: 'Garcia Marquez'),
      new Author(name: 'Douglas R.', lastname: 'Hofstadter')]

    def books = [
      new Book(title: 'The Labyrinth of Solitude'),
      new Book(title: 'No One Writes to the Coronel'),
      new Book(title: 'Goedel, Escher & Bach'),
      new Book(title: 'One Hundred Years of Solitude')]

    authors[0].addToBooks(books[0]).save()
    authors[1].addToBooks(books[1]).save()
    authors[2].addToBooks(books[2]).save()
    authors[1].addToBooks(books[3]).save()
  }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Configuration')
    tabbedPane(constraints: 'grow', cssClass: 'codeEditor', tabPlacement: JTabbedPane.BOTTOM) {
        widget(title: 'UrlMappings', v1.groovyEditorContainer, constraints: 'grow')
        widget(title: 'BootStrap', v2.groovyEditorContainer, constraints: 'grow')
    }
}
