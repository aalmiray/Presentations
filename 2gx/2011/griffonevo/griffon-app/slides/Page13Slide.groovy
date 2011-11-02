slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Polyglot Support', constraints: 'wrap')
    panel(opaque: false) {
        gridLayout(cols: 3, rows: 3)
        label(icon: imageIcon('/groovy-logo.png'), cssClass: 'normal')
        label(icon: imageIcon('/java-logo.png'), cssClass: 'normal')
        label(icon: imageIcon('/mirah-logo.png'), cssClass: 'normal')
        label('')
        label(icon: imageIcon('/scala-logo2.png'), cssClass: 'normal')
        label('')
        label(icon: imageIcon('/clojure-logo.png'), cssClass: 'normal')
        label(icon: imageIcon('/erlang-logo.png'), cssClass: 'normal')
        label(icon: imageIcon('/jython-logo.png'), cssClass: 'normal')
    }
}
