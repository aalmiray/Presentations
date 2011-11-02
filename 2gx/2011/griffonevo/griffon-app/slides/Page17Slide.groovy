import griffon.transitions.FadeTransition2D
import org.springframework.core.io.support.PathMatchingResourcePatternResolver

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
