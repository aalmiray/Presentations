def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide6')
m.editable = true
m.code = '''class Greeter {
    String salutation
    String greet(String who) {
        "$salutation $who"
    }
}

g = new Greeter(salutation: 'Hello')
println g.greet('Groovy')'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Groovier Greeter')
    widget(v.groovyEditorContainer, constraints: 'grow')
}
