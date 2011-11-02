import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide5')
m.editable = true
m.code = '''public class Greeter {
    private String salutation;
    public String setSalutation(String s) {
        salutation = s;
    }
    public String getSalutation() {
        return salutation;
    }
    public String greet(String who) {
        return salutation +" "+ who;
    }
    public static void main(String[] args) {
        Gretter g = new Greeter();
        g.setSalutation("Hello ");
        System.out.println(g.greet("Groovy"));
    }
}'''

slide(title: '', backgroundPainter: backgroundPainter, transition: new SquareRainTransition2D()) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Greeter in Groovy')
    widget(constraints: 'grow', v.groovyEditorContainer)
}
