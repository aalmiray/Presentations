import net.miginfocom.swing.MigLayout

def script = '''greet1 = { name -> println "hello $name" }
greet1("Groovy")

greet2 = { println it }
greet2("Java")

iCanHaveTypedParametersToo = { int x, int y ->
   println "coordinates are ($x, $y)"
}
iCanHaveTypedParametersToo(42, 21)

myActionListener = { event ->
   // do something cool with event here
} as java.awt.event.ActionListener'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Examples of Closures") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
