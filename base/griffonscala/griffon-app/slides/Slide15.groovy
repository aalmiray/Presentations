import net.miginfocom.swing.MigLayout
import javax.swing.SwingConstants
import java.awt.Font

font = new Font("SansSerif", Font.BOLD, 22i)

def script1 = '''object ScalaBean {
  def ilist = List(1,2,3)
  def slist = List("1","2","3")
  def ifun = {x:Int => x+x}
  def sfun = {x:String => x+x}
}
'''

def script2 = '''class ScalaClasses {
  static enhance() {
    scala.List.metaClass.iterator = {->
      def scalaIter = delegate.elements()
      return [hasNext: {-> scalaIter.hasNext() },
        next: {-> scalaIter.next() },
        remove: {-> throw UnsupportedOperationException("$delegate is immutable!") }
      ] as Iterator
    }
  }

  static cls2fun(Closure closure) {
    String classname = "scala.Function" + closure.getMaximumNumberOfParameters()
    return [apply: closure,
      toString: closure.toString(),
      curry: { null }
    ].asType(classname as Class)
  }

  static fun2cls(function) {
    return { Object... args -> function.apply(*args) }
  }
}'''

def script3 = '''ScalaClasses.enhance()
def listOfInts = ScalaBean.ilist()
assert [1,2,3] == listOfInts.collect([]){it}
def listOfStrs = ScalaBean.slist()
assert ["1","2","3"] == listOfStrs.collect([]){it}
'''

def script4 = '''import static ScalaClasses.*
enhance()

def ifun = ScalaBean.ifun()
def listOfInts2 = listOfInts.map(ifun)
assert [2,4,6] == listOfInts2.collect([]){it}
def sfun = ScalaBean.sfun()
def listOfStrs2 = listOfStrs.map(sfun)
assert ["11","22","33"] == listOfStrs2.collect([]){it}

def mapper = {it+it}
def listOfInts3 = listOfInts.map(cls2fun(mapper))
def listOfStrs3 = listOfStrs.map(cls2fun(mapper))
assert listOfInts2 == listOfInts3
assert listOfStrs2 == listOfStrs3
assert listOfInts.collect([],mapper) == listOfInts.collect([],fun2cls(ifun))
assert listOfStrs.collect([],mapper) == listOfStrs.collect([],fun2cls(sfun))
'''

slide(id: 'slide15', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: 'Type Conversions') {
  tabbedPane(constraints: 'grow', tabPlacement: SwingConstants.BOTTOM, font: font) {
    scrollPane(title: 'Scala (Source)') {
      widget(createEditor(text: script1, editable: false, runnable: false))
    }
    scrollPane(title: 'Enhancer') {
      widget(createEditor(text: script2, editable: false, runnable: false))
    }
    scrollPane(title: 'Groovy (Lists)') {
      widget(createEditor(text: script3, editable: false, runnable: false))
    }
    scrollPane(title: 'Groovy (Functions)') {
      widget(createEditor(text: script4, editable: false, runnable: false))
    }
  }
}