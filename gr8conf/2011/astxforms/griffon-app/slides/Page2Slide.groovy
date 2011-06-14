import griffon.transitions.FadeTransition2D

slide(title: '', backgroundPainter: backgroundPainter, transition: new FadeTransition2D()) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top]5%[top]')
    label(cssClass: 'header', 'About the speaker', constraints: 'wrap')
    panel(opaque: false, constraints: 'grow') {
        borderLayout()
        vbox(constraints: CENTER) {
            bullet('Java developer since \'95')
            bullet('Open Source believer')
            bullet('Groovy dev team member since \'07')
            bullet('Griffon co-founder and project lead')
            label(' ', cssClass: 'normal')
            label(' ', cssClass: 'normal')
            label('http://jroller.com/aalmiray', foreground: Color.BLUE, cssClass: 'normal')
            label('@aalmiray', foreground: Color.BLUE, cssClass: 'normal')
        }
        panel(constraints: EAST, opaque: false) {
            migLayout(columnConstraints: '2%[center]2%', rowConstraints: '2%[top]5%[top]5%[top]5%[top]2%')
            label(icon: imageIcon('/mexico-flag.jpg'), border: emptyBorder(10), constraints: 'wrap')
            label(icon: imageIcon('/swiss-flag.jpg'), border: emptyBorder(10), constraints: 'wrap')
            label(icon: imageIcon('/canoo.jpg'), border: emptyBorder(10), constraints: 'wrap')
            label(icon: imageIcon('/javachampion.jpg'), border: emptyBorder(10))
        }
    }
}
