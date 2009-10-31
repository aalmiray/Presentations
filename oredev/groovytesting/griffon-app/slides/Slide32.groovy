import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.StarsTransition2D

slide(id: "slide32", layout: new MigLayout("fill","5%[left]5%",""), title: "Resources", transition: new StarsTransition2D(Transition2D.LEFT)) {
    bullet(text: "http://groovy.codehaus.org")
    bullet(text: "http://groovy.dzone.org")
    bullet(text: "http://easytesting.org")
    bullet(text: "http://easyb.org")
}
