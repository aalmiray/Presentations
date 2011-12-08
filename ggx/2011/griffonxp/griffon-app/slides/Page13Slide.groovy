import griffon.transitions.FadeTransition2D

def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide13')
m.editable = false
m.code = '''curl http://localhost:8080/bookstore/author

[
   { "class": "Author", "id": 1,
     "books": [{"class": "Book", "id": 1}],
     "lastname": "Paz",
     "name": "Octavio"},
   { "class": "Author", "id": 2,
     "books": [ {"class": "Book", "id": 4},
                {"class": "Book", "id": 2}],
     "lastname": "Garcia Marquez",
     "name": "Gabriel"},
   { "class": "Author", "id": 3,
     "books": [ {"class": "Book","id": 3}],
     "lastname": "Hofstadter",
     "name": "Douglas R."
    }
]'''

slide(title: '', backgroundPainter: backgroundPainter, transition: new FadeTransition2D()) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Sample REST query')
    widget(v.groovyEditorContainer, constraints: 'grow')
}
