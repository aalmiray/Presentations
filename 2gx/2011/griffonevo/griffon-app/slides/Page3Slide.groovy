import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

slide(footer: createFooter(0), title: '', backgroundPainter: griffonPainter.curry('past'), transition: new FlurryTransition2D(Transition2D.OUT)) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '5%[top]5%[bottom]5%')
    label('PAST', cssClass: 'H1o', constraints: 'wrap')
    label(GRIFFON_IMG_CONF.past.url, constraints: 'right', foreground: Color.WHITE)
}
