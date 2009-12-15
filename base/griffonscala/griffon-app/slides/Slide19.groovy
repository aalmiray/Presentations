import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.StarsTransition2D

slide(id: 'slide19', draw: draw, layout: new MigLayout("fill","5%[left]5%",""), title: "Resources", transition: new StarsTransition2D(Transition2D.LEFT)) {
    bullet(text: "http://griffon.codehaus.org")
    bullet(text: "http://groovyblogs.org")
    bullet(text: "http://groovy.dzone.org")
    bullet(noicon: true, text: "")
    bullet(text: "http://jroller.com/aalmiray")
    bullet(text: "@aalmiray")
}