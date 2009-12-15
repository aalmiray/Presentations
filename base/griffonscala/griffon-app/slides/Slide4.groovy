import net.miginfocom.swing.MigLayout

def script = '''import groovy.swing.SwingBuilder
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE
import java.awt.Font

font = new Font("SansSerif", Font.BOLD, 32i)

new SwingBuilder().edt {
  frame(title: "GroovyFrame", pack: true, visible: true,
         defaultCloseOperation: DISPOSE_ON_CLOSE) {
    gridLayout(cols: 1, rows: 3)
    textField(id: "input", columns: 20)
    button("Click me!", actionPerformed: {
       output.text = input.text
    })
    textField(id: "output", columns: 20, editable: false)
    current.contentPane.each{ it.font = font }
  }
}'''

slide(id: 'slide4', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'GroovyFrame.java') {
    scrollPane(constraints: 'grow') {
        widget(createEditor(text: script, editable: true, runnable: true))
    }
}