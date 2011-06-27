slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[bottom]5%[center]5%[top]')
    label(icon: imageIcon('/griffon.png'), cssClass: 'H1', constraints: 'wrap')
    label(cssClass: 'header', constraints: 'wrap', 'http://bit.ly/mDgXQE', foreground: Color.BLUE)
    panel(opaque: false) {
        vbox {
            label('+----------------------+-------+-------+', cssClass: 'code')
            label('| Name                 | Files |  LOC  |', cssClass: 'code')
            label('+----------------------+-------+-------+', cssClass: 'code')
            label('| Lifecycle            |     5 |     3 |', cssClass: 'code') 
            label('| Slides               |    31 |   584 |', cssClass: 'code') 
            label('+----------------------+-------+-------+', cssClass: 'code')
            label('| Totals               |    36 |   587 |', cssClass: 'code') 
            label('+----------------------+-------+-------+', cssClass: 'code')
        }
    }
}
