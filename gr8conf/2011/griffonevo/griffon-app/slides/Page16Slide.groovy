def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide16')
m.editable = false
m.code = '''piechart3d(title: '', antiAlias: true) {
    defaultPieDataset {
        Series1(40.0f)
        Series2(30.0f)
        Series3(30.0f)
    }
    backgroundPaint(Color.WHITE)

    pieplot(labelFont: new Font("Arial", Font.BOLD, 15), labelGap: 0.02) {
        sectionOutlinesVisible false
        toolTipGenerator({ dataset, key ->
            "[${dataset} ${key}]" as String
        } as PieToolTipGenerator)

        sectionPaint('Series1', paint: Color.RED)
        sectionPaint('Series2', paint: Color.GREEN)
        sectionPaint('Series3', paint: Color.BLUE)
    }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', 'Charts')
        tabbedPane(constraints: CENTER, tabPlacement: JTabbedPane.BOTTOM, cssClass: 'footer') {
            chart(title: 'JFreeChart', griffonevo.FirstChart)
            widget(title: 'Source', v.groovyEditorContainer)
        }
    }
}
