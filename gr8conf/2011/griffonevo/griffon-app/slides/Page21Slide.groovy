slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'What\'s coming for 1.0?', constraints: 'wrap')
    vbox {
        bullet('Rework of the plugin system')
        bullet('More documentation')
        bullet('Additional application archetypes')
        label(' ', cssClass: 'normal')
        label(' ', cssClass: 'normal')
        label('            (bug fixes)', cssClass: 'normal')
    }
}
