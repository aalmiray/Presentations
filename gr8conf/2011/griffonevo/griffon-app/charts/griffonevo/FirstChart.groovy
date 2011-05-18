package griffonevo

import java.awt.Color
import java.awt.Font
import org.jfree.chart.labels.PieToolTipGenerator

def largeFont = new Font("Arial", Font.BOLD, 15);

piechart3d(title: '', antiAlias: true) {
    defaultPieDataset {
        Series1(40.0f)
        Series2(30.0f)
        Series3(30.0f)
    }
    backgroundPaint(Color.WHITE)

    pieplot(labelFont: largeFont, labelGap: 0.02) {
        sectionOutlinesVisible false
        toolTipGenerator({ dataset, key ->
            "[${dataset} ${key}]" as String
        } as PieToolTipGenerator)

        sectionPaint('Series1', paint: Color.RED)
        sectionPaint('Series2', paint: Color.GREEN)
        sectionPaint('Series3', paint: Color.BLUE)
    }
}
