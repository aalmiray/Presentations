def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide16')
m.editable = true
m.code = '''@groovy.util.logging.Log
class User {
    String username
    void login() {
        log.info("$username has logged into the system")
    }
}

user = new User(username: 'Duke')
user.login()'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Log (@Commons, @Log4j, @Slf4j)')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
