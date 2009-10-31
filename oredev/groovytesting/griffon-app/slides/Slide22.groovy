import net.miginfocom.swing.MigLayout

def script = '''public class MyService {
   public void doSomething() {
      throw new UnsupportedOperationException();
   }
}

class GroovyExceptionTest extends GroovyTestCase {
   void testExceptionThrowingCode() {
      shouldFail( UnsupportedOperationException ){
         new MyService().doSomething()
      }
   }
}'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Testing Exceptions (Groovy)") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script, runnable: false))
    }
}