import griffon.transitions.FadeTransition2D

slide(title: '', backgroundPainter: backgroundPainter, transition: new FadeTransition2D()) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Release 0.3.1', constraints: 'wrap')
    vbox {
        bullet('Released on-stage while at Gr8conf :-)')
        bullet('Plugins! Plugins! Plugins!')
        bullet('Native library support')
        bullet('Better threading facilities')
        bullet('The Griffon Guide ships for the first time!')
    }
}
