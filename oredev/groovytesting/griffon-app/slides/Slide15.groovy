import net.miginfocom.swing.MigLayout

def script = '''Map map = [:]
assert map instanceof java.util.Map
map["key1"] = "value1"
map.key2 = "value2"
println map
assert map.size() == 2
assert map.key1 == "value1"
assert map["key2"] == "value2"

List list = []
assert list instanceof java.util.List
list.add("One")
list << "Two"
println list
assert list.size() == 2
assert ["One", "Two"] == list'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Native Syntax for Maps/Lists") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}
