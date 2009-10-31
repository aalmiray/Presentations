import net.miginfocom.swing.MigLayout

def script = '''getSlope = { x, y, b = 0 ->
   println "x: $x, y: $y, b: $b"
   (y - b) / x
}

assert 1 == getSlope(2, 2)
getSlopeX = getSlope.curry(5)

assert 1 == getSlopeX(5)
assert 0 == getSlopeX(2.5, 2.5)'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Curried Closures") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
