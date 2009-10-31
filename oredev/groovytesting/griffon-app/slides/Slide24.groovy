import net.miginfocom.swing.MigLayout

def script = '''class StringProvider {
   String getString() { "" }
}

class StringDecorator {
   // This is a property declaration, meaning that
   // the Groovy compiler will generate a pair of
   // get/set methods
   StringProvider provider

   def getValue() { provider.string + "Decorated" } 
}

// Here comes the proxy
def provider = [
   getString: { -> "Groovy" }
] as StringProvider
// it looks like JSON, doesn't it?

def decorator = new StringDecorator( provider: provider )
// the following would have worked too
// def decorator = new StringDecorator()
// decorator.setProvider( provider )
assert "GroovyDecorated" == decorator.value
assert decorator.provider instanceof StringProvider'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Dynamic Proxies") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}