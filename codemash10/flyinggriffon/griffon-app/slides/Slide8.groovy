import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import java.awt.Font
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

font = new Font("SansSerif", Font.BOLD, 22i)

def script1 = '''application(title:'swing-app',
  size:[320,480],
  pack: true,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    vbox {
        label('Enter some text below')
        textField(text: bind(target: model, targetProperty: 'input'))
        button('Click me!', actionPerformed: controller.copyText)
        textField(text: bind{ model.output }, editable: false)
    }
} '''

def script2 = '''import groovy.beans.Bindable

class SwingAppModel {
    @Bindable String input
    @Bindable String output
}'''

def script3 = '''class SwingAppController {
    def model

    def copyText = { evt = null ->
        model.output = "[COPY] ${model.input}"
    }
}'''

slide(id: 'slide8', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'Swing') {
  tabbedPane(constraints: 'grow', tabPlacement: SwingConstants.BOTTOM, font: font) {
    scrollPane(title: 'App') {
      label(icon: imageIcon('swing-app.png'), horizontalAlignment: SwingConstants.CENTER)
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
