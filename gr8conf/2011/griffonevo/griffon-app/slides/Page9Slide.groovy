slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'Release 0.1.1', constraints: 'wrap')
    vbox {
        bullet('Released before JavaOne 2009')
        bullet('Twittersphere helps Groovy win the Scriptbowl')
        bullet('Greet published to Javastore in the next 24hrs')
        bullet('Griffon finds its way into Gr8conf 2009')
        bullet('Plugin system gets the green light')
    }
}
