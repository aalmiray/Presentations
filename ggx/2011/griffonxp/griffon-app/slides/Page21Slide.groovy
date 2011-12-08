slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(icon: imageIcon('/gaelyk-logo.png'), constraints: 'wrap')
    vbox {
        bullet('http://gaelyk.appspot.com', [foreground: Color.BLUE])
        bullet('Lightweight Groovy toolkit for GAE')
        bullet('Apache License 2.0')
        bullet('Started in 2009')
        bullet('Has an emerging plugin system')
    }
}
