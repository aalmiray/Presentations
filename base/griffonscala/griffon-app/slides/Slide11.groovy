import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

slide(id: 'slide11', draw: draw, layout: new MigLayout('fill','3%[left]3%',''), title: 'Scala is useful for...', transition: new RevealTransition2D(Transition2D.LEFT)) {
   bullet(text: 'Defining the application logic')
   bullet(noicon: true, text: '  actors, case classes, pattern matching, type system, etc')
   bullet(text: 'Testing the application in several ways')
   bullet(noicon: true, text: '  ScalaTest 1.0 ready')
   bullet(noicon: true, text: '  ScalaCheck 1.6 ready')
   bullet(text: 'Inspecting the application interactively')
   bullet(noicon: true, text: '  launch Scala REPL then the app')
}