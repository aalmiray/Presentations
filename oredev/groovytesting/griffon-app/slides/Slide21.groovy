import net.miginfocom.swing.MigLayout

def script = '''public class MyService {
   public void doSomething() {
      throw new UnsupportedOperationException();
   }
}

public class JavaExceptionTestCase extends TestCase {
   public void testExceptionThrowingCode() {
      try {
         new MyService().doSomething();
         fail("MyService.doSomething has been implemented");
      }catch( UnsupportedOperationException expected ){
         // everything is ok if we reach this block
      }
   }
}'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Testing Exceptions (Java)") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script, runnable: false))
    }
}