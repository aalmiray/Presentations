import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.*
import com.bric.image.transition.spunk.*

slide(id: 'slide7', draw: draw, layout: new MigLayout('fill','5%[left]5%',''), title: 'Testing') {
   bullet(text: 'Application can be tested right away')
   bullet(text: '   griffon test-app', css: 'code', noicon: true)
   bullet(text: 'Additional testing plugins available')
   bullet(text: '   FEST, Easyb', css: 'code', noicon: true)
   bullet(text: 'Code metrics avaiable too!')
   bullet(text: '   Cobertura, CodeNarc, JDepend', css: 'code', noicon: true)
}
