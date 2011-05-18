/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.slideware.ui

import java.awt.Container
import java.awt.image.BufferedImage
import java.awt.Image
import java.awt.Component
import java.awt.Graphics
import java.awt.GraphicsEnvironment
import java.awt.GraphicsDevice
import java.awt.GraphicsConfiguration

/**
 * @author Andres.Almiray
 */
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
