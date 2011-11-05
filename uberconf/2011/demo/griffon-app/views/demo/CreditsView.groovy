package demo

panel(id: 'content') {
    migLayout layoutConstraints: 'fill'
    tabbedPane(constraints: 'grow, wrap') {
        scrollPane(title: app.getMessage('application.dialog.Credits.writtenby', 'Written by'), constraints: 'grow') {
            textArea(editable: false, text: bind{ model.credits },
                caretPosition: bind('credits', source: model, converter: {0i}))
        }
    }   
    button(hideAction, constraints: 'right')

    keyStrokeAction(component: current,
        keyStroke: 'ESCAPE',
        condition: 'in focused window',
        action: hideAction)
}
