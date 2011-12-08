import griffon.transitions.FadeTransition2D

def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide4')
m.editable = false
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
        Greeter g = new Greeter();
        g.setSalutation("Hello ");
        System.out.println(g.greet("Groovy"));
    }
}'''

slide(title: '', backgroundPainter: backgroundPainter, transition: new FadeTransition2D()) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Greeter in Java')
    widget(v.groovyEditorContainer, constraints: 'grow')
}
