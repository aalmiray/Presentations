import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

def plugins = '''languages: Scala, Clojure, JavaFX

Swing: Abeille Forms, CSS, Flamingo, Gfx, Jide, MacWidgets, SwingX, Swingxtras, SystemTray, Trident, Coverflow, JGoodies Forms, JBusyComponent + JXLayer, Swingx-ws, Transitions2D, JUNG

testing: cobertura, codenarc, easyb, FEST, JDepend

network: hessian/burlap, jabber, mail, protobuf, REST, RMI, xml-rpc, ws

general: font-jiggler, splash, fast-translate, gpars, wizard, GSQL

DI: Guice, Spring (soon)

coming soon: GORM, jogl, lwjgl, NASA WorlWind ... SWT?
'''

slide(id: 'slide18', draw: draw, layout: new MigLayout('fill','3%[left]3%',''), title: 'Plugins', transition: new GooTransition2D()) {
    scrollPane(constraints: 'grow, wrap') {
        textArea(plugins, editable: false, cssClass: 'normal', lineWrap: true, wrapStyleWord: true)
    }
}