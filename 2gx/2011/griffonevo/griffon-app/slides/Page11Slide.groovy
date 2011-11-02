slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Cool stuff', constraints: 'wrap')
    vbox {
        bullet('Application life cycle')
        bullet('Stringly typed event bus')
        bullet('WindowManager DSL')
        bullet('Testing out-of-the-box')
        bullet('Extensible command line tools')
        bullet('Application archetypes')
        bullet('Plugins!')
    }
}
