def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide21')
m.editable = true
m.code = '''class Band {
    @groovy.transform.IndexedProperty
    List members = [] 
}

beatles = new Band()
assert beatles.members == []
beatles.members << 'John'
beatles.setMembers(1, 'Paul')
beatles.members[2] = 'George'
beatles.members.add('Ringo')

assert beatles.members == ['John', 'Paul', 'George', 'Ringo']
assert beatles.getMembers(3) == 'Ringo'
'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@IndexedProperty')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
