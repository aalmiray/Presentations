import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

slide(footer: createFooter(0), title: '', backgroundPainter: griffonPainter.curry('future'), transition: new DotsTransition2D()) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '5%[top]5%[bottom]5%')
    label('FUTURE', cssClass: 'H1o', constraints: 'wrap')
    label(GRIFFON_IMG_CONF.future.url, constraints: 'right', foreground: Color.WHITE)
}
