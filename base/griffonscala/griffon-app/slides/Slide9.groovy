import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.*
import com.bric.image.transition.spunk.*

slide(id: 'slide9', draw: draw, layout: new MigLayout('fill','[center]',''), title: 'Griffon is...', transition: new DotsTransition2D()) {
 label('Convention over Configuration', cssClass: 'normal', constraints: 'wrap')
 label('Don\'t repeat yourself (DRY)', cssClass: 'normal', constraints: 'wrap')
 label('MVC Pattern', cssClass: 'normal', constraints: 'wrap')
 label('Automate repetitive tasks', cssClass: 'normal', constraints: 'wrap')
 label('Testing supported "out of the box"', cssClass: 'normal')
}