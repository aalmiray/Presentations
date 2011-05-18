import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

slide(title: '', backgroundPainter: backgroundPainter, transition: new SquareRainTransition2D()) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[center]')
    label(cssClass: 'header', foreground: Color.BLUE, 'http://people.canoo.com/share')
}
