def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide13')
m.editable = false
m.code = '''class Apple {}

class Basket {
    @Newify(Apple)
    List bushel() {
       [new Apple(), Apple(), Apple.new()]
    }
}

basket = new Basket()
bushel = basket.bushel()
assert bushel*.getClass() == [Apple, Apple, Apple]'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Newify')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
