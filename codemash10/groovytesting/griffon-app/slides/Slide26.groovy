import net.miginfocom.swing.MigLayout

def script = '''import groovy.mock.interceptor.StubFor

class StringProvider {
   String getString() { "" }
}

class StringDecorator {
   StringProvider provider = new StringProvider()
   String getValue(){
      provider.string + "Decorated"
   }
}

def providerStub = new StubFor(StringProvider)
providerStub.demand.getString() { "Groovy" }
providerStub.use {
   def decorator = new StringDecorator()
   assert "GroovyDecorated" == decorator.value
}'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "StubFor Example") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}