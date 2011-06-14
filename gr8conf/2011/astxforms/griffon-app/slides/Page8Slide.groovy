def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide8')
m.editable = true
m.code = '''@Category(Integer)
class Pouncer {
    String pounce() {
        (1..this).collect { 'boing!' }.join(' ')
    }
}

use(Pouncer) {
    assert 3.pounce() == 'boing! boing! boing!'
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Category')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
