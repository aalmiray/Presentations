def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide11')
m.editable = true
m.code = '''import groovy.transform.Synchronized

class Worker {
    private myLock = new Object()
    
    @Synchronized
    void doStuff() { /* uses auto-generated lock */ }
    
    @Synchronized('myLock')
    void workSomeMore() { /* uses myLock */ }
    
    @Synchronized
    static void compute() {
        // works with static methods too!    
    }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Synchronized')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
