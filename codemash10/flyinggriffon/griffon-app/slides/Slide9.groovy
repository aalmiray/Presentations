import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import java.awt.Font
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

font = new Font("SansSerif", Font.BOLD, 22i)

def script1 = '''application(title: 'gtk-app', width: 320, height: 240,
            icon: pixbuf('griffon-icon-24x24.png')) {
    vbox {
        label(label: 'Enter some text below')
        entry(onChanged: { source -> model.input = source.text })
        button(label: 'Click me!', onClicked: controller.copyText)
        entry(id: 'output', editable: false)
    }
}'''

def script2 = '''import groovy.beans.Bindable

class GtkAppModel {
    @Bindable String input
}'''

def script3 = '''class GtkAppController {
    def model
    def view

    def copyText = { evt = null ->
        view.output.text = "[COPY] ${model.input}"
    }
}'''

slide(id: 'slide9', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'Gtk') {
  tabbedPane(constraints: 'grow', tabPlacement: SwingConstants.BOTTOM, font: font) {
    scrollPane(title: 'App') {
      label(icon: imageIcon('gtk-app.png'), horizontalAlignment: SwingConstants.CENTER)
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
