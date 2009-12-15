import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.vanilla.*
import com.bric.image.transition.spunk.*

def script = '''action(id: "countdown", name: "Start Countdown",
   closure: { evt ->
     int count = lengthSlider.value
     status.text = count
     doOutside {
       while ( --count >= 0 ) {
         sleep( 1000 )
         edt { status.text = count }
       }
       doLater {
         status.background = Color.RED
       }
     }
})'''

slide(id: 'slide7', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'Threading', transition: new TossTransition2D(Transition2D.RIGHT)) {
  scrollPane(constraints: "grow") {
    widget(createEditor(text: script, editable: false, runnable: false))
  }
}