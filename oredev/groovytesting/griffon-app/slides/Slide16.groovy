import net.miginfocom.swing.MigLayout

def script = '''int count = 0
closure = { k ->
   0.upto(k) { count += it }
}

closure(10)
assert count == (10*11)/2

runnable = closure.curry(20) as Runnable
assert runnable instanceof java.lang.Runnable
count = 0
runnable.run()
assert count == (20*21)/2'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Closures (1)") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
