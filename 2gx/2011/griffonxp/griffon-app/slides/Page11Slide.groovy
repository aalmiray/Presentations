def (m1, v1, c1) = createMVCGroup('GroovyCodeEditor', 'editor-slide11-1')
m1.editable = false
m1.code = '''import grails.converters.JSON

class AuthorController {
  static defaultAction = 'list'

  def list = {
    render(Author.list(params) as JSON)
  }

  def show = {
    def author = Author.get(params.id)
      if (!author) {
        redirect(action: 'list')
      } else {
        render(author as JSON)
      }
  }

  def search = {
    def list = []
    if (params.q) {
      list = Author.findAllByNameLike("%${params.q}%")
      if(!list) list = Author.findAllByLastnameLike("%${params.q}%")
    }
    render(list as JSON)
  }
}'''

def (m2, v2, c2) = createMVCGroup('GroovyCodeEditor', 'editor-slide11-2')
m2.editable = false
m2.code = '''import grails.converters.JSON

class BookController {
  static defaultAction = 'list'

  def list = {
      render(Book.list(params) as JSON)
  }

  def show = {
    def book = Book.get(params.id)
    if (!book) {
      redirect(action: 'list')
    } else {
      render(book as JSON)
    }
  }

  def search = {
    def list = []
    if (params.q) {
      list = Book.findAllByTitleLike("%${params.q}%")
    }
    render(list as JSON)
  }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Controllers')
    tabbedPane(constraints: 'grow', cssClass: 'codeEditor', tabPlacement: JTabbedPane.BOTTOM) {
        widget(title: 'Author', v1.groovyEditorContainer, constraints: 'grow')
        widget(title: 'Book', v2.groovyEditorContainer, constraints: 'grow')
    }
}
