import net.miginfocom.swing.MigLayout
import griffon.transitions.FadeTransition2D
import java.awt.Color

def script = '''public class HelloWorld {
   String name;

   public void setName(String name)
   { this.name = name; }
   public String getName(){ return name; }

   public String greet()
   { return "Hello "+ name; }

   public static void main(String[] args){
      HelloWorld helloWorld = new HelloWorld();
      helloWorld.setName("Groovy");
      System.out.println(helloWorld.greet());
   }
}'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "HelloWorld.java", transition: new FadeTransition2D(Color.BLACK)) {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script, editable: false))
    }
}
