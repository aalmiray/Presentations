import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.*
import com.bric.image.transition.spunk.*

slide(id: 'slide3', draw: draw, layout: new MigLayout('fill','5%[left]5%',''), title: 'Convention over Configuration') {
   bullet(text: 'Every artifact has a place and purpose')
   bullet(text: 'Artifacts follows a naming convention')
   bullet(text: 'Common directory structure')
   bullet(text: 'Sensible defaults for configurable options')
   bullet(text: 'Configuration is still available if needed')
}
