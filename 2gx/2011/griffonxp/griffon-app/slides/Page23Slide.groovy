slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', constraints: 'wrap', 'Canoo RIA Suite')
    vbox {
        bullet('http://canoo.com/ulc', [foreground: Color.BLUE])
        bullet('Java based RIA solution')
        bullet('There\'s a Grails plugin available')
        bullet('Combine Groovy & Java as you see fit')
    }
}
