import org.springframework.core.io.support.PathMatchingResourcePatternResolver

def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide18')
m.editable = false
m.code = '''panel {
    stackLayout()
    gradientPanel(constraints: BOTTOM)
    imageFlow(id: "flow", constraints: TOP) {
        icons.each { icon ->
            imageFlowItem(resource: "/images/everaldo/${icon}.png",
                          label: icon[0].toUpperCase() + icon[1..-1])
        }
    }
    noparent{ flow.selectedIndex = 5 }
}'''

ClassLoader classLoader = getClass().classLoader
String path = 'classpath*:/images/everaldo/*.png'
List icons = new PathMatchingResourcePatternResolver(classLoader)
                      .getResources(path).collect([]) { r ->
    def (matcher, icon) = (r.getURL().path =~ /.*\/([a-zA-Z0-9_\-]+)\.png/)[0]
    icon
}

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', 'Coverflow')
        tabbedPane(constraints: CENTER, tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer') {
            panel(title: 'Component') {
                stackLayout()
                gradientPanel(constraints: BOTTOM)
                imageFlow(id: "flow", constraints: TOP) {
                    icons.each { icon ->
                    imageFlowItem(resource: "/images/everaldo/${icon}.png",
                                  label: icon[0].toUpperCase() + icon[1..-1])
                    }
                }
                noparent{ flow.selectedIndex = 5 }
            }
            widget(title: 'Source', v.groovyEditorContainer)
        }
    }
}
