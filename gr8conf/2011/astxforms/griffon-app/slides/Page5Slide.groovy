def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide5')
m.editable = true
m.code = '''class Event {
  @Delegate Date when
  String title, url
}

df = new java.text.SimpleDateFormat("dd.MM.yyyy")
so2gx = new Event(title: "SpringOne2GX",
   url: "http://springone2gx.com",
   when: df.parse("25.10.2011"))
gr8conf = new Event(title: "Gr8conf",
   url: "http://gr8conf.org",
   when: df.parse("27.06.2011"))
assert gr8conf.before(so2gx.when)'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Delegate')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
