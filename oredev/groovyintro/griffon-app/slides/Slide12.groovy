import net.miginfocom.swing.MigLayout

def script = '''class Calculator {
   def addAllGroovy(Object[} args) {
      int total = 0
      for(i in args) { total += i }
      total
   }

   def addAllJava(int... args) {
      int total = 0
      for(int i : args) { total += i }
      total
   }
}

Calculator c = new Calculator()
assert c.addAllGroovy(1,2,3,4,5) == 15
assert c.addAllJava(1,2,3,4,5) == 15'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Varargs in action") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
