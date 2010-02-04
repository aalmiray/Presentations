import net.miginfocom.swing.MigLayout

def script = '''import java.text.SimpleDateFormat
class Event {
   @Delegate Date when
   String title, url

   String toString() {
      "title: $title, url: $url\nwhen: $when"
   }
}

df = new SimpleDateFormat("MM/dd/yyyy")
so2gx = new Event(title: "SpringOne2GX",
   url: "http://springone2gx.com",
   when: df.parse("10/19/2009"))
oredev = new Event(title: "Oredev",
   url: "http://oredev.org",
   when: df.parse("11/02/2009"))
println so2gx
println oredev
assert oredev.after(so2gx.when)'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "AST Transformations") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}