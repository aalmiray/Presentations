slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(icon: imageIcon('/groovy-logo.png'), constraints: 'wrap')
    vbox {
        bullet('http://groovy.codehaus.org', [foreground: Color.BLUE])
        bullet('Dynamic and agile language for the JVM')
        bullet('Apache License 2.0')
        bullet('Started in 2003')
        bullet('We just released 1.8.4 a few weeks ago!')
    }
}
