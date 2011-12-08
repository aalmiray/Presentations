def (m1, v1, c1) = createMVCGroup('GroovyCodeEditor', 'editor-slide10-1')
m1.editable = false
m1.code = '''class Author {
  static constraints = {
    name(blank: false)
    lastname(blank: false)
  }

  String name
  String lastname
  
  static hasMany = [books: Book]

  String toString() { "$name $lastname" }
}'''

def (m2, v2, c2) = createMVCGroup('GroovyCodeEditor', 'editor-slide10-2')
m2.editable = false
m2.code = '''class Book {
  static constraints = {
    title(unique: true)
  }

  String title
  Author author

  static belongsTo = [Author]

  String toString() { title }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Domain Classes')
    tabbedPane(constraints: 'grow', cssClass: 'codeEditor', tabPlacement: JTabbedPane.BOTTOM) {
        widget(title: 'Author', v1.groovyEditorContainer, constraints: 'grow')
        widget(title: 'Book', v2.groovyEditorContainer, constraints: 'grow')
    }
}
