import net.miginfocom.swing.MigLayout

slide(id: 'slide18', draw: draw, layout: new MigLayout('fill','[center]','[bottom]10%[top]')) {
    label('Thank you!', cssClass: 'header', constraints: 'wrap')
    label(icon: imageIcon('codemash-logo.png'))
}
