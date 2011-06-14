def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide19')
m.editable = true
m.code = '''@groovy.transform.EqualsAndHashCode
class Thing {
    String name
    int id
}

thing1 = new Thing(name: 'One', id: 1)
thing2 = new Thing(name: 'One', id: 1)
thing3 = new Thing(name: 'Two', id: 2)

assert thing1 == thing2
assert thing1 != thing3
assert thing1.hashCode() == thing2.hashCode()
assert thing1.hashCode() != thing3.hashCode()'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@EqualsAndHashCode')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
