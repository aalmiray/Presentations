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
package griffon.slideware.factory

import javax.swing.JPanel
import javax.swing.JComponent
import groovy.swing.factory.ComponentFactory
import griffon.slideware.ui.Slide

/**
 * @author Andres.Almiray
 */
class SlideHeaderFactory extends ComponentFactory {
    SlideHeaderFactory() {
        super(JPanel, true)
    }

    Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
        if(value instanceof JComponent) return value
        return beanClass.newInstance()
    }

    void setParent(FactoryBuilderSupport build, Object parent, Object node) {
        if(parent instanceof Slide) {
            parent.header = node
        } else {
            super.setParent(build, parent, node)
        }
    }
}
