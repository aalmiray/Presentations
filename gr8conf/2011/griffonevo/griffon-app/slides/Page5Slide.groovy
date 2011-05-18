import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide5')
m.editable = true
m.code = '''import groovy.swing.SwingBuilder

new SwingBuilder().edt {
    frame(title: 'Swing in Groovy', pack: true, visible: true) {
        gridLayout(cols: 1, rows: 3)
        textField(columns: 20, id: 'input')
        button('Click me', actionPerformed: {
            output.text = input.text
        })
        textField(columns: 20, editable: false, id: 'output')
    }
}'''

slide(title: '', backgroundPainter: backgroundPainter, transition: new LevitateTransition2D()) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', 'Swing: the Groovy way')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
