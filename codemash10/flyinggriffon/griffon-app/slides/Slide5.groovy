import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.*
import com.bric.image.transition.spunk.*

slide(id: 'slide5', draw: draw, layout: new MigLayout('fill','5%[left]5%',''), title: 'MVC') {
   bullet(text: 'MVC pattern is engrained in Griffon\'s DNA')
   bullet(text: 'MVC members can be reused')
   bullet(text: 'Flexibility: add/remove members at will')
   bullet(text: 'Open: add non-mvc members -> actions, etc')
}
