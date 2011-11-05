package demo

actions {
    action(hideAction,
       name: 'Ok',
       mnemonic: 'K',
       shortDescription: 'Ok'
    )
}

panel(id: 'content') {
    migLayout(layoutConstraints: 'fill')
    label(text: bind{model.message}, constraints: 'grow, wrap')
    button(hideAction, constraints: 'tag ok')
    
    keyStrokeAction(component: current,
        keyStroke: "ESCAPE",
        condition: "in focused window",
        action: hideAction)
}
