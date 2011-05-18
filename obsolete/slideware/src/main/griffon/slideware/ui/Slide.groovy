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

import java.awt.Graphics
import java.awt.LayoutManager
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Image
import javax.swing.JComponent
import javax.swing.JPanel
import com.bric.image.transition.Transition2D

/**
 * @author Andres.Almiray
 */
class Slide extends JPanel {
    private final JPanel _content
    Transition2D transition
    String title
    Closure snapshot
    Closure draw

    Slide() {
        super.setLayout(new BorderLayout())
        _content = new JPanel()
        _content.opaque = false
        super.add(_content, BorderLayout.CENTER)
    }

    void setHeader(JComponent header) {
        header.opaque = false
        super.add(header, BorderLayout.NORTH)
    }

    void setFooter(JComponent footer) {
        footer.opaque = false
        super.add(footer, BorderLayout.SOUTH)
    }

    void setLayout(LayoutManager layout) {
        if(_content) _content.layout = layout
    }

    Component add(Component component) {
        return _content.add(component)
    }

    void add(Component component, Object constraints) {
        _content.add(component, constraints)
    }

    void paintComponent(Graphics g) {
        super.paintComponent(g)
        if(draw) draw(g)
    }

    Image[] asImageSet() {
        if(snapshot) {
            snapshot.resolveStrategy = Closure.DELEGATE_FIRST
            snapshot.delegate = this
            return snapshot()
        }
        [ViewUtils.grabSnapshot(this)] as Image[]
    }
}
