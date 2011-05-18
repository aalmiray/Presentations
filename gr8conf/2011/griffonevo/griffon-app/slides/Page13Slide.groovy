slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Release 0.9.0', constraints: 'wrap')
    vbox {
        bullet('*HUGE* codebase rework (Grails 1.3 refresh)')
        bullet('Artifact API receives a face-lift')
        bullet('Overhaul of the plugin/addon system')
        bullet('New AST transformations added to buildtime')
        bullet('A huge number of plugins are added to the repo')
    }
}
