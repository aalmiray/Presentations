import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.*
import com.bric.image.transition.spunk.*

slide(id: 'slide4', draw: draw, layout: new MigLayout('fill','5%[left]5%',''), title: 'Don\'t Repeat Yourself') {
   bullet(text: 'How? Use a dynamic language!')
   bullet(text: 'With Closures/Blocks')
   bullet(text: 'With terse property syntax')
   bullet(text: '   myJTextArea.text = "Fires Property Change"', css: 'code', noicon: true)
   bullet(text: 'With terse eventing syntax')
   bullet(text: '   button.actionPerformed = { println \'hi\'}', css: 'code', noicon: true)
   bullet(text: 'With rich annotation support')
   bullet(text: '   @Bindable String aBoundProperty', css: 'code', noicon: true)
}
