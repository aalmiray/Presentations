slide(footer: createFooter(0), backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '30%[bottom]5%[top]10%[bottom]5%[bottom]20%')
    label(icon: imageIcon('/griffon.png'), cssClass: 'H1', constraints: 'wrap')
    label('Past, Present & Future', cssClass: 'H1o', constraints: 'wrap')
    label('Andres Almiray - Canoo Engineering AG', cssClass: 'H2', constraints: 'left, wrap')
    label('andres.almiray@canoo.com', cssClass: 'H4', constraints: 'left')
}
