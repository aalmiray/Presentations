import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.*
import com.bric.image.transition.spunk.*

slide(id: 'slide6', draw: draw, layout: new MigLayout('fill','5%[left]5%',''), title: 'Automation') {
   bullet(text: 'Commands take care of build tasks')
   bullet(text: '   compile, package, run, test, etc', css: 'code', noicon: true)
   bullet(text: 'New commands can be added via scripts')
   bullet(text: 'Plugins can provide scripts too!')
}
