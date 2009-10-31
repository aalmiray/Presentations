import net.miginfocom.swing.MigLayout

def script = '''class HelloWorld {
   String name
   def greet() { "Hello $name" }
}

def helloWorld = new HelloWorld(name:"Groovy")
println helloWorld.greet()'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "GroovierHelloWorld.groovy") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
