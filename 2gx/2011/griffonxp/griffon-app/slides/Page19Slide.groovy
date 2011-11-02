def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide19')
m.editable = false
m.code = '''package bookclient

class BookstoreService {
  List searchAuthors(model) {
    withRest(id: 'bookstoreREST') {
      def response = get(path: 'author/search',
                         query: [q: model.query])
      response.data.inject([]) { list, a ->
        author.books.id.collect(list) { bookId ->
          def b = model.books.find{it.id == bookId}
          [title: b.title, name: a.name, lastname: a.lastname]
  }}}}

  List searchBooks(model) {
    withRest(id: 'bookstoreREST') {
      def response = get(path: 'book/search',
                         query: [q: model.query])
      response.data.collect([]) { b ->
        def a = model.authors.find{it.id == b.author.id}
        [title: b.title, name: a.name, lastname: a.lastname]
  }}}

  void populateModel(model) {
    withRest(id: 'bookstoreREST',
             uri: 'http://localhost:8080/bookstore/'){
      def response = get(path: 'author')
      def authors = response.data.collect([]) { a ->
        [name: a.name, lastname: a.lastname, id: a.id]
      }
      execSync {
        model.authors.clear()
        model.authors.addAll(authors)
      }

      response = get(path: 'book')
      def books = response.data.collect([]) { book ->
        [title: book.title, id: book.id]
      }
      execSync {
        model.books.clear()
        model.books.addAll(books)
      }
   }}
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Service')
    widget(v.groovyEditorContainer, constraints: 'grow')
}
