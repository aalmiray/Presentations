import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import java.awt.Font
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

font = new Font("SansSerif", Font.BOLD, 22i)

def script1 = '''application(title: "pivot-app", maximized: true) {
   vbox(styles: "{horizontalAlignment:'center', verticalAlignment:'center'}") {
       label( 'Enter some text below')
       textInput(textChanged: { source -> model.input = source.text })
       button('Click me!', buttonPressed: controller.copyText)
       textInput(id: 'output', enabled: false)
   }
}'''

def script2 = '''import groovy.beans.Bindable

class PivotAppModel {
    @Bindable String input
}'''

def script3 = '''class PivotAppController {
    def model
    def view

    def copyText = { evt = null ->
        view.output.text = "[COPY] ${model.input}"
    }
}'''

slide(id: 'slide10', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'Pivot') {
  tabbedPane(constraints: 'grow', tabPlacement: SwingConstants.BOTTOM, font: font) {
    scrollPane(title: 'App') {
      label(icon: imageIcon('pivot-app.png'), horizontalAlignment: SwingConstants.CENTER)
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
