slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', constraints: 'wrap', 'Ratpack')
    vbox {
        bullet('https://github.com/bleedingwolf/Ratpack', [foreground: Color.BLUE])
        bullet('Sinatra inspired web framework')
        bullet('Apache License 2.0')
        bullet('Started in 2010')
        bullet('Still in the early stages')
    }
}
