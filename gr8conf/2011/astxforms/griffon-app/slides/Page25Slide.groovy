slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', icon: imageIcon('/griffon.png'), constraints: 'wrap')
    vbox {
        bullet('@EventPublisher')
        bullet('@PropertyListener')
        bullet('@Threading')
        bullet('@MVCAware')
        bullet('@ThreadingAware')
        bullet('@Validatable')
        bullet('alpha stage: @Entity - @Scaffold')
    }
}
