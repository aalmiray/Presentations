slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Release 0.2.0', constraints: 'wrap')
    vbox {
        bullet('Event system makes its debut')
        bullet('Codebase refreshed with Grails 1.2')
        bullet('Crude version of Artifact API')
        bullet('Webstart and Applet improvements')
        bullet('Danno steps down as leader shortly afterwards')
    }
}
