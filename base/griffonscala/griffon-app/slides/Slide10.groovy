import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.*
import com.bric.image.transition.spunk.*

slide(id: 'slide10', draw: draw, layout: new MigLayout('fill','[right][center][left]','[center]'), transition: new HalftoneTransition2D(Transition2D.OUT)) {
    label('¿', cssClass: 'header')
    label(icon: imageIcon('/scala-logo.png'))
    label('?', cssClass: 'header')
}