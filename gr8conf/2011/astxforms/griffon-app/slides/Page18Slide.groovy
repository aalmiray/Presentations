def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide18')
m.editable = true
m.code = '''@groovy.transform.ToString(includeNames=true)
class Customer {
    String first, last
    Address address
}

@groovy.transform.ToString
class Address {
    String street, country
}

customer = new Customer(first: 'Andres', last: 'Almiray',
    address: new Address(street: 'Kirschgartenstrasse 5', 
                         country: 'Schweiz'))
println customer'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@ToString')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
