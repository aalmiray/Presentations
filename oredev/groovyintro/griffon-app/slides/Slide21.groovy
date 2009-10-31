import net.miginfocom.swing.MigLayout

def script = '''printIt = { println it }
// 3 ways to iterate from 1 to 5, there are more!
[1,2,3,4,5].each printIt
1.upto 5, printIt
(1..5).each printIt

// compare to a regular loop
for(i in [1,2,3,4,5]) printIt(i)

[1,2,3,4,5].eachWithIndex { v, i -> println "list[$i] => $v" }
'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Iterators in Action") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
