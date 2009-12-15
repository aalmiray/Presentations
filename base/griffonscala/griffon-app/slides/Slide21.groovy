import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

def stats = '''griffon stats

+----------------------+-------+-------+
| Name                 | Files |  LOC  |
+----------------------+-------+-------+
| Lifecycle            |     5 |     8 |
| Slides               |    25 |   539 |
+----------------------+-------+-------+
| Totals               |    30 |   547 |
+----------------------+-------+-------+'''

slide(id: 'slide21', draw: draw, layout: new MigLayout('fill','3%[left]3%',''), transition: new CurtainTransition2D()) {
    stats.split(/\n/).each { line ->
        bullet(noicon: true, text: "<html><pre>$line</pre></html>", cssClass: 'normal')
    }
}
