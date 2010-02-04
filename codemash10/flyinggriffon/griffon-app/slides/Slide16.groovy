import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

def stats = '''griffon stats

+----------------------+-------+-------+
| Name                 | Files |  LOC  |
+----------------------+-------+-------+
| Lifecycle            |     5 |     4 | 
| Slides               |    20 |   368 | 
+----------------------+-------+-------+
| Totals               |    25 |   372 | 
+----------------------+-------+-------+'''

slide(id: 'slide16', draw: draw, layout: new MigLayout('fill','3%[left]3%',''), transition: new CurtainTransition2D()) {
    stats.split(/\n/).each { line ->
        bullet(noicon: true, text: "<html><pre>$line</pre></html>", cssClass: 'normal')
    }
}
