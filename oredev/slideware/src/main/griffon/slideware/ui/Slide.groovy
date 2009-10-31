package griffon.slideware.ui

import java.awt.LayoutManager
import java.awt.BorderLayout
import java.awt.Component
import java.awt.Image
import javax.swing.JComponent
import javax.swing.JPanel
import com.bric.image.transition.Transition2D

class Slide extends JPanel {
	private final JPanel _content
	Transition2D transition
	String title
	Closure snapshot

	Slide() {
		super.setLayout(new BorderLayout())
		_content = new JPanel()
		super.add(_content, BorderLayout.CENTER)
	}

	void setHeader(JComponent header) {
		super.add(header, BorderLayout.NORTH)
	}

	void setFooter(JComponent footer) {
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

	Image[] asImageSet() {
		if(snapshot) {
			snapshot.resolveStrategy = Closure.DELEGATE_FIRST
			snapshot.delegate = this
			return snapshot()
		}
        [ViewUtils.grabSnapshot(this)] as Image[]
	}
}