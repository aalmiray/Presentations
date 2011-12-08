def (m, v, c) = createMVCGroup('Bookstore')

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Client view')
    widget(v.content, constraints: 'grow')
}
