import griffon.transitions.FadeTransition2D
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
    noparent{ flow.selectedIndex = 0 }
}'''

ClassLoader classLoader = getClass().classLoader
String path = 'classpath*:/images/everaldo/*.png'
List icons = new PathMatchingResourcePatternResolver(classLoader)
                      .getResources(path).collect([]) { r ->
    def (matcher, icon) = (r.getURL().path =~ /.*\/([a-zA-Z0-9_\-]+)\.png/)[0]
    icon
}

slide(title: '', backgroundPainter: backgroundPainter, transition: new FadeTransition2D()) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Some fun components', constraints: 'wrap')
    panel(constraints: 'grow', opaque: false) {
        gridLayout(cols: 4, rows: 1, hgap: 20, vgap: 20)
            clock(automatic: true)
            r = radar()
            compass()
            altimeter()
            r.animate(true)
    }
}
