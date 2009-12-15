import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants

def script = '''action(id: "countdown", name: "Start Countdown",
   closure: { evt ->
     int count = lengthSlider.value
     status.text = count
     jxwithWorker(start: true) {
       work {
         while ( --count >= 0 ) {
           sleep( 1000 )
           publish(count)
         }
       }
       onUpdate { chunks ->
         status.text = chunks[0]
       }
       onDone {
         status.background = Color.RED
       }
     }
})'''

slide(id: 'slide8', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'Threading - SwingWorker') {
  scrollPane(constraints: "grow") {
    widget(createEditor(text: script, editable: false, runnable: false))
  }
}