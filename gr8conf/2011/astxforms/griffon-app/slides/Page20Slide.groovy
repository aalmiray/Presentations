def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide20')
m.editable = true
m.code = '''@groovy.transform.TupleConstructor
class Animal {
    String species = 'goldfish'
    String name = 'Bubbles'
    int age = 2
}

animals = [
    new Animal(species: 'dog', name: 'Wolfie', age: 4),
    new Animal('cat', 'Mr. Whiskers', 3),
    new Animal()]

assert animals.species == ['dog', 'cat', 'goldfish']
assert animals.name == ['Wolfie', 'Mr. Whiskers', 'Bubbles']
assert animals.age == [4, 3, 2]'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@TupleConstructor')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
