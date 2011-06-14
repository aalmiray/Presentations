def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide10')
m.editable = true
m.code = '''@Grab('net.sf.json-lib:json-lib:2.4:jdk15')
import net.sf.json.groovy.JsonGroovyBuilder

builder = new JsonGroovyBuilder() 

json = builder.books {
  book(title: 'Groovy in Action',
       name: 'Dierk Koenig')
}

assert json.books.book.name == 'Dierk Koenig'
'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Grab')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
