slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'GContracts', constraints: 'wrap')
    vbox {
        bullet('@Invariant')
        bullet('@Requires')
        bullet('@Ensures')
    }
}
