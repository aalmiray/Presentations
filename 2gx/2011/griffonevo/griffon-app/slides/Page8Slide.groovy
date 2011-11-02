def (m1, v1, c1) = createMVCGroup('GroovyCodeEditor', 'editor-slide8-1')
m1.editable = true
m1.code = '''import groovy.swing.SwingBuilder

new SwingBuilder().edt {
    frame(title: 'Binding: Standard', pack: true, visible: true) {
        gridLayout(cols: 1, rows: 2)
        textField(columns: 20, id: 'input')
        textField(columns: 20, editable: false, id: 'output')
        
        bind(source: input:  sourceProperty: 'text',
             target: output, targetProperty: 'text')
    }
}'''

def (m2, v2, c2) = createMVCGroup('GroovyCodeEditor', 'editor-slide8-2')
m2.editable = true
m2.code = '''import groovy.swing.SwingBuilder

new SwingBuilder().edt {
    frame(title: 'Binding: Contextual', pack: true, visible: true) {
        gridLayout(cols: 1, rows: 2)
        textField(columns: 20, id: 'input')
        textField(columns: 20, editable: false,
            text: bind(source: input, 'text'))
    }
}'''

def (m3, v3, c3) = createMVCGroup('GroovyCodeEditor', 'editor-slide8-3')
m3.editable = true
m3.code = '''import groovy.swing.SwingBuilder

new SwingBuilder().edt {
    frame(title: 'Binding: Short', pack: true, visible: true) {
        gridLayout(cols: 1, rows: 2)
        textField(columns: 20, id: 'input')
        textField(columns: 20, editable: false,
            text: bind{ input.text })
    }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Binding', constraints: 'wrap')
    tabbedPane(constraints: 'grow', cssClass: 'codeEditor', tabPlacement: JTabbedPane.BOTTOM) {
        widget(title: 'Standard',   v1.groovyEditorContainer, constraints: 'grow')
        widget(title: 'Contextual', v2.groovyEditorContainer, constraints: 'grow')
        widget(title: 'Short',      v3.groovyEditorContainer, constraints: 'grow')
    }
}
