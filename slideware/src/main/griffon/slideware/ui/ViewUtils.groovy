package griffon.slideware.ui

import java.awt.Container
import java.awt.image.BufferedImage
import java.awt.Image
import java.awt.Component
import java.awt.Graphics
import java.awt.GraphicsEnvironment
import java.awt.GraphicsDevice
import java.awt.GraphicsConfiguration

class ViewUtils {
    static showDialog(String dialogName, owner, view, pack = true) {
        def dialog = view."$dialogName"
        if(pack) dialog.pack()
        int x = owner.x + (owner.width - dialog.width) / 2
        int y = owner.y + (owner.height - dialog.height) / 2
        dialog.setLocation(x, y)
        dialog.show()
    }

    static hideDialog(String dialogName, view) {
        view."$dialogName".hide()
    }

    static findComponentByName(String name, Container where) {
        int size = where.componentCount
        for(int i = 0; i < size; i++) {
            def candidate = where.components[i]
            if(candidate.name == name) {
                return candidate
            }
            if(candidate instanceof Container) {
                candidate = findComponentByName(name, candidate)
                if(candidate != null) return candidate
            }
        }
        return null
    }

    static Image grabSnapshot(Component component) {
        BufferedImage image = null
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment()
        GraphicsDevice gd = genv.getDefaultScreenDevice()
        GraphicsConfiguration gc = gd.getDefaultConfiguration()
        if(gc.getColorModel().hasAlpha()) {
            image = gc.createCompatibleImage(component.getSize().width as int,
                component.getSize().height as int)
        } else {
            image = new BufferedImage(component.getSize().width as int,
                component.getSize().height as int,
                BufferedImage.TYPE_INT_ARGB as int)
        }
        Graphics g = image.getGraphics()
        component.paint(g)
        g.dispose()
        return image
    }
}
