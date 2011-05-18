slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Release 0.0', constraints: 'wrap')
    vbox {
        bullet('First release: September 10 2008')
        bullet('Started as a fork of the Grails 1.1 codebase')
        label('     (No plugin system though)', cssClass: 'normal')
        bullet('Early feedback was very positive')
    }
}
