import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.StarsTransition2D

slide(id: 'slide1', draw: draw, layout: new MigLayout('fill','[center]','[center]'), transition: new StarsTransition2D(Transition2D.LEFT)) {
  label('What is Griffon?', cssClass: 'header')
}