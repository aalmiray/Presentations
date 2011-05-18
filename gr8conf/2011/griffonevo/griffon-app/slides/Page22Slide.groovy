import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

slide(title: '', backgroundPainter: backgroundPainter, transition: new TossTransition2D(Transition2D.RIGHT)) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'What\'s coming after 1.0?', constraints: 'wrap')
    vbox {
        bullet('Two highly expected plugins:')
        label('       - GORM', cssClass: 'normal')
        label('       - Scaffolding', cssClass: 'normal')
        bullet('Better multi-toolkit support')
        bullet('Have an idea? Let us know!')
    }
}
