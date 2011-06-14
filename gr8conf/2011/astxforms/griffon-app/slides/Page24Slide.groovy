slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', icon: imageIcon('/grails-logo.png'), constraints: 'wrap')
    vbox{
        bullet('@Entity')
        bullet('Grails 1.4 has more coming!')
    }
}
