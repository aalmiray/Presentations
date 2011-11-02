slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Threading', constraints: 'wrap')
    vbox {
        bullet('Standard threading facilities')
        label(cssClass: 'normal', '      edt{} doLater{} doOutside{}')
        label(cssClass: 'normal', '      execSync{} execAsync{} execOutside{}')
        bullet('Additional support via SwingWorker')
        bullet('All controller actions invoked outside EDT')
        bullet('@Threading')
    }
}
