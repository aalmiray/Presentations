import net.miginfocom.swing.MigLayout

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

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "HelloWorld.groovy") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
