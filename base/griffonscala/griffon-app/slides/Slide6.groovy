import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.BlendTransition2D

def script = '''action(id: "countdown", name: "Start Countdown",
   closure: { evt ->
     int count = lengthSlider.value
     status.text = count

       while ( --count >= 0 ) {
         sleep( 1000 )
               status.text = count
       }

         status.background = Color.RED


})'''

slide(id: 'slide6', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'Threading', transition: new BlendTransition2D()) {
  scrollPane(constraints: "grow") {
    widget(createEditor(text: script, editable: false, runnable: false))
  }
}