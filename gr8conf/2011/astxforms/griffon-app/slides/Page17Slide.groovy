def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide17')
m.editable = true
m.code = '''@groovy.transform.InheritConstructors
class MyException extends RuntimeException {}

msg = 'Error message'
x1 = new MyException(msg)
x2 = new MyException(x1)
x3 = new MyException(msg, x1)
assert x1.message == msg
assert x2.cause == x1
assert x3.message == msg
assert x3.cause == x1'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@InheritConstructors')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
