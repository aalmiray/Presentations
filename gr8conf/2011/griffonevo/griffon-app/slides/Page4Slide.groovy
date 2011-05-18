import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide4')
m.editable = true
m.code = '''import java.awt.*
import java.awt.event.*
import javax.swing.*

public class HelloSwing {
    public static void main() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                init();
            }
        });
    }
    
    private static void init() {
        JFrame frame = new JFrame("Swing in Java");
        final JTextField input = new JTextField(20);
        final JTextField output = new JTextField(20);
        output.setEditable(false);
        JButton button = new JButton("Click me");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                output.setText(input.getText());
            }
        });
        
        frame.getContentPane().setLayout(new GridLayout(3, 1));
        frame.add(input);
        frame.add(button);
        frame.add(output);
        frame.pack();
        frame.setVisible(true);
    }
}


HelloSwing.main()'''

slide(title: '', backgroundPainter: backgroundPainter, transition: new CollapseTransition2D()) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', 'Swing: the Java way')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
