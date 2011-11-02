def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide6')
m.editable = false
m.code = '''application(title: 'Griffon Baby!', pack: true) {
        gridLayout(cols: 1, rows: 2)
        textField(columns: 20, id: 'input')
        textField(columns: 20, editable: false,
            text: bind{ input.text })
    }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', 'Swing: the Griffon way')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
