import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

def plugins = '''Swing: Abeille Forms, CSS, Flamingo, Gfx, Jide, MacWidgets, SwingX, Swingxtras, SystemTray, Trident, Coverflow, JGoodies Forms, JBusyComponent + JXLayer, Swingx-ws, Transitions2D, JUNG

Testing: Cobertura, CodeNarc, Easyb, FEST, JDepend

Network: hessian/burlap, jabber, mail, protobuf, REST, RMI, xml-rpc, ws

General: font-jiggler, splash, fast-translate, gpars, wizard, GSQL

DI: Spring, Spring

3D: JOGL, LWJGL, NASA WorldWind, JMonkeyEngine
'''

slide(id: 'slide13', draw: draw, layout: new MigLayout('fill','3%[left]3%',''), title: 'Plugins', transition: new GooTransition2D()) {
    scrollPane(constraints: 'grow, wrap') {
        textArea(plugins, editable: false, cssClass: 'normal', lineWrap: true, wrapStyleWord: true)
    }
}
