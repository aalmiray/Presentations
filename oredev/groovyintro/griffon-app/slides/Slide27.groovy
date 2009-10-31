import net.miginfocom.swing.MigLayout

def script = '''class Person {
   String name
   int id

   String toString() {
      "name: $name, id: $id"
   }
}

def persons = [
   new Person(name: "Duke", id: 1),
   [name: "Tux", id: 2] as Person
]

println persons
assert [1, 2] == persons.id
assert ["Duke", "Tux"] == persons*.getName()
assert null == persons[2]?.name
assert "Duke" == persons[0].name ?: "Groovy"
assert "Groovy" == persons[2]?.name ?: "Groovy"
'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "Sample GPath Expressions") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script))
    }
}