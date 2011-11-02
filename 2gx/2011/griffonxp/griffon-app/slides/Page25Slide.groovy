slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[bottom]5%[center]5%[top]')
    label(cssClass: 'header', constraints: 'wrap', 'Thank you!')
    label(icon: imageIcon('/griffon-in-action.jpg'), constraints: 'wrap')
    label(cssClass: 'header', '@aalmiray', foreground: Color.BLUE)
}
