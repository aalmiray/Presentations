import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

slide(id: 'slide20', draw: draw, layout: new MigLayout("fill","[center]","[bottom]5%[top]"), transition: new SquareRainTransition2D()) {
    label("This presentation made with", constraints: "wrap", cssClass: "header")
    label(icon: imageIcon("griffon-banner.png"))
}