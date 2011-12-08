slide(footer: createFooter(0), backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[left]5%',
              rowConstraints: '40%[top]5%[bottom]5%[bottom]2%[bottom]10%')
    label(icon: imageIcon('/groovy-logo.png'), constraints: 'center, wrap')
    label('Getting Groovy on the Web and Desktop', cssClass: 'H1', constraints: 'wrap')
    label('Andres Almiray - Canoo Engineering AG', cssClass: 'H2', constraints: 'wrap')
    label('andres.almiray@canoo.com', cssClass: 'H4')
}
