slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(icon: imageIcon('/grailslogo.png'), constraints: 'wrap')
    vbox {
        bullet('http://grails.org', [foreground: Color.BLUE])
        bullet('Full stack Web development platform')
        bullet('Spring, Hibernate, Sitemesh ...')
        bullet('Apache License 2.0')
        bullet('Started in 2005')
        bullet('+500 plugins')
    }
}
