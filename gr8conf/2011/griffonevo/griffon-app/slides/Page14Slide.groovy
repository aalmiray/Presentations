slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Release 0.9.2', constraints: 'wrap')
    vbox {
        bullet('AST injections for')
        label('    - proper threading in controller actions', cssClass: 'normal')
        label('    - default imports', cssClass: 'normal')
        label('    - artifact contracts', cssClass: 'normal')
        bullet('Application archetypes')
        bullet('Uncaught exception handler')
    }
}
