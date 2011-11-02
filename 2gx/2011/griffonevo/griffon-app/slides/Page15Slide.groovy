def g = buildMVCGroup('charts')
def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide17')
m.editable = false
m.code = '''// imports elided
class SecondChart3D {
    void mvcGroupInit(Map<String, Object> args) {
        initChart()
    }

    void initChart(){
        Mapper mapper = new Mapper(){
            double f(double x, double y) {
                exp(-(x*x+y*y)/10) * abs(cos(2*PI*(x*x + y*y)))
            }
        }

        Range range = new Range(-0.5, 0.5)
        
        Shape surface = Builder.buildOrthonormal(
            new OrthonormalGrid(range, 50, range, 50), mapper)
        surface.colorMapper = new ColorMapper(new ColorMapRainbow(), 
            surface.bounds.zmin, surface.bounds.zmax)
        surface.faceDisplayed = true
        surface.wireframeDisplayed = true
        surface.wireframeColor = Color.BLACK
        
        chart.scene.graph.add(surface)
        ColorbarLegend cbar = new ColorbarLegend(
            surface, chart.view.axe.layout)
        surface.legend = cbar
    }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', 'Charts')
        tabbedPane(constraints: CENTER, tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer') {
            widget(title: 'Jzy3D', g.getMember('chart3d').chart.canvas)
            widget(title: 'Source', v.groovyEditorContainer)
        }
    }
}
