def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide14')
m.editable = true
m.code = '''@groovy.beans.Bindable
class Model {
    String name
}

counter = 0
model = new Model()
model.addPropertyChangeListener({
    counter++
} as java.beans.PropertyChangeListener)

model.name = 'Duke'
model.name = 'Tux'
assert counter == 2'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Bindable (@Vetoable)')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
