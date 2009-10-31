package griffon.slideware.factory

import javax.swing.JPanel
import javax.swing.JComponent
import groovy.swing.factory.ComponentFactory
import griffon.slideware.ui.Slide

class SlideHeaderFactory extends ComponentFactory {
    SlideHeaderFactory() {
		super(JPanel, true)
	}

	public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
		if(value instanceof JComponent) return value
        return beanClass.newInstance()
    }

	public void setParent(FactoryBuilderSupport build, Object parent, Object node) {
		println parent
		println node
		println parent instanceof Slide
		if(parent instanceof Slide) {
			parent.header = node
		} else {
            super.setParent(build, parent, node)
        }
    }
}

class SlideFooterFactory extends ComponentFactory {
    SlideFooterFactory() {
		super(JPanel, true)
	}

	public Object newInstance(FactoryBuilderSupport builder, Object name, Object value, Map attributes) throws InstantiationException, IllegalAccessException {
		if(value instanceof JComponent) return value
        return beanClass.newInstance()
    }

	public void setParent(FactoryBuilderSupport build, Object parent, Object node) {
		if(parent instanceof Slide) {
			parent.footer = node
		} else {
            super.setParent(build, parent, node)
        }
    }
}