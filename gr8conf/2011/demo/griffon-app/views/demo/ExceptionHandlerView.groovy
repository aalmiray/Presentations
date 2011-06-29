package demo

actions {
    action(id: 'okAction',
       name: 'Ok',
       closure: controller.hide,
       mnemonic: 'K',
       shortDescription: 'Ok'
    )
}

panel(id: 'content') {
    migLayout(layoutConstraints: 'fill')
    label(text: bind{model.message}, constraints: 'grow, wrap')
    button(okAction, constraints: 'tag ok')
    
    keyStrokeAction(component: current,
        keyStroke: "ESCAPE",
        condition: "in focused window",
        action: okAction)
}
