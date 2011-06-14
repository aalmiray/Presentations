slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', "Somewhere else in the 'net", constraints: 'wrap')
    vbox {
        bullet('@Scalify')
        label('      http://groovy.codehaus.org/Scalify', cssClass: 'normal', foreground: Color.BLUE)
        bullet('@ByteCode')
        label('      http://bit.ly/fLanEH', cssClass: 'normal', foreground: Color.BLUE)
    }
}
