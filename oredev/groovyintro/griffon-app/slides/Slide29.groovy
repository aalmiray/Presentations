import net.miginfocom.swing.MigLayout

def script = '''class Pouncer {
   static pounce(Integer self) {
      def s = "Boing!"
      1.upto(self - 1) { s += " boing!" }
      s
   }
}

use(Pouncer) {
   assert 3.pounce() == "Boing! boing! boing!"
   println 4.pounce()
}
'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Category Example") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}