import net.miginfocom.swing.MigLayout

def script = '''// Java
public class Bean {
   private String name;
   private void setName(String n) { name = n; }
   private String getName() { return name; }
}

// Groovy
Bean bean = new Bean(name: "Duke")
assert bean.name == "Duke"
bean.name = "Tux"
assert bean.name == "Tux"
assert bean.name == bean.getName()'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Acessing Properties") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
