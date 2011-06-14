def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide9')
m.editable = true
m.code = '''class Bouncer {
    int times
    
    String bounce() {
        (1..this.times).collect { 'boing!' }.join(' ')
    }
}

@Mixin(Bouncer) class Cat { }
@Mixin(Bouncer) class Dog { }

cat = new Cat(times: 2)
assert cat.bounce() == 'boing! boing!'
dog = new Dog(times: 3)
assert dog.bounce() == 'boing! boing! boing!'
'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Mixin')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
