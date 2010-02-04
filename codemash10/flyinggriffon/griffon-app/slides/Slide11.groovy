import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import java.awt.Font
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

font = new Font("SansSerif", Font.BOLD, 22i)

def script1 = '''import org.eclipse.swt.layout.GridData

gd = gridData(horizontalAlignment: GridData.FILL,
              grabExcessHorizontalSpace: true,
              verticalAlignment: GridData.FILL,
              grabExcessVerticalSpace: true)

application(text: "swt-app", location:[100,100], size:[320, 240]) {
    gridLayout(numColumns:1)
    label('Enter some text below', layoutData: gd)
    text(id: 'input', layoutData: gd)
    button('Click me!', layoutData: gd) {
        onEvent('Selection', controller.copyText)
    }
    text(id: 'output', editable: false, layoutData: gd)
}'''

def script2 = '''import groovy.beans.Bindable

class SwtAppModel {
   // @Bindable String input
   // @Bindable String output
}'''

def script3 = '''class SwtAppController {
    def model
    def view

    def copyText = { evt = null ->
        view.output.text = "[COPY] ${view.input.text}"
    }
}'''

slide(id: 'slide11', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'Swt') {
  tabbedPane(constraints: 'grow', tabPlacement: SwingConstants.BOTTOM, font: font) {
    scrollPane(title: 'App') {
      label(icon: imageIcon('swt-app.png'), horizontalAlignment: SwingConstants.CENTER)
    }
    scrollPane(title: 'View') {
      widget(createEditor(text: script1, editable: false, runnable: false))
    }
    scrollPane(title: 'Model') {
      widget(createEditor(text: script2, editable: false, runnable: false))
    }
    scrollPane(title: 'Controller') {
      widget(createEditor(text: script3, editable: false, runnable: false))
    }
  }
}
