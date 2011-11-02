slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(icon: imageIcon('/griffon.png'), constraints: 'wrap')
    vbox {
        bullet('http://griffon.codehaus.org', [foreground: Color.BLUE])
        bullet('Grails inspired desktop development platform')
        bullet('Inspired by JSR 296 and 295 as well')
        bullet('Apache License 2.0')
        bullet('+170 plugins')
        bullet('Started in 2008')
    }
}
