slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Convention over Configuration', constraints: 'wrap')
    vbox {
        bullet('All application/plugins share the same structure')
        bullet('Artifacts organized by type and responsibilities')
        bullet('Simple dependency injection (by name)')
    }
}
