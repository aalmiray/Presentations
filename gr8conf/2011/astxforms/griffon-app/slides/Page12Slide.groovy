def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide12')
m.editable = true
m.code = '''class Sneaky {
    @Lazy List values = {[1,2,3]}()
    // thread - safe
    @Lazy volatile String id
}

sneaky = new Sneaky()
assert !sneaky.@$values
assert sneaky.values == [1,2,3]
assert sneaky.@$values == [1,2,3]'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Lazy')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
