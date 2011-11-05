package demo

panel(id: 'content') {
    migLayout layoutConstraints: 'fill'
    panel(constraints: 'grow, wrap')
    button(hideAction, constraints: 'right')

    keyStrokeAction(component: current,
        keyStroke: 'ESCAPE',
        condition: 'in focused window',
        action: hideAction)
}
