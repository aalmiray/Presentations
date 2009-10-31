import net.miginfocom.swing.MigLayout

def script = '''Integer.metaClass.pounce = {
   def s = "Boing!"
   1.upto(delegate - 1) { s += " boing!" }
   s
}

assert 3.pounce() == "Boing! boing! boing!"
println 4.pounce()
'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Metaclass Example") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}