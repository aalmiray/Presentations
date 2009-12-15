import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import java.awt.Font
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

font = new Font("SansSerif", Font.BOLD, 22i)

def script1 = '''import scala.reflect.BeanProperty

trait ResultCollector {
    @BeanProperty var output:String
}
'''

def script2 = '''public interface ResultCollector{
    public abstract void setOutput(java.lang.String);
    public abstract java.lang.String getOutput();
    public abstract void output_$eq(java.lang.String);
    public abstract java.lang.String output();
}
'''

def script3 = '''import groovyx.transform.Scalify

@Scalify
class GroovyResultCollector implements ResultCollector {
   String output
}
'''

def script4 = '''public class GroovyResultCollector extends java.lang.Object
  implements ResultCollector, scala.ScalaObject, groovy.lang.GroovyObject {
    public GroovyResultCollector();

    public java.lang.String getOutput();
    public void setOutput(java.lang.String);
    public void output_$eq(java.lang.String);
    public java.lang.String output();
    public int $tag();

    public groovy.lang.MetaClass getMetaClass();
    public void setMetaClass(groovy.lang.MetaClass);
    public java.lang.Object invokeMethod(java.lang.String, java.lang.Object);
    public java.lang.Object getProperty(java.lang.String);
    public void setProperty(java.lang.String, java.lang.Object);
    // ... snip
}
'''

slide(id: 'slide13', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: '@Scalify (1)', transition: new PushTransition2D(Transition2D.LEFT)) {
  tabbedPane(constraints: 'grow', tabPlacement: SwingConstants.BOTTOM, font: font) {
    scrollPane(title: 'Scala (Source)') {
      widget(createEditor(text: script1, editable: false, runnable: false))
    }
    scrollPane(title: 'Scala (Class)') {
      widget(createEditor(text: script2, editable: false, runnable: false))
    }
    scrollPane(title: 'Groovy (Source)') {
      widget(createEditor(text: script3, editable: false, runnable: false))
    }
    scrollPane(title: 'Groovy (Class)') {
      widget(createEditor(text: script4, editable: false, runnable: false))
    }
  }
}