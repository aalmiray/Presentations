package demo

actions {
    action(loginAction,
       enabled: bind{ model.enabled }
    )
}

application(title: 'Login',
  name: 'loginWindow',
  pack: true,
  resizable: false,
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   migLayout(layoutConstraints: 'fill')

   bannerPanel(constraints: 'span 3, growx, wrap',
      title: 'Login',
      subtitle: 'Please enter your credentials',
      titleIcon: imageIcon('/griffon-icon-48x48.png'),
      border: lineBorder(color: Color.BLACK, thickness: 1),
      subTitleColor: Color.WHITE,
      background: new Color(0,0,0,1),
      startColor: Color.WHITE,
      endColor: Color.BLACK,
      vertical: true)

    label 'Username:', constraints: 'left'
    textField columns: 20, constraints: 'right', text: bind(target: model, 'username', mutual: true)
    errorIcon(constraints: 'wrap', errorRenderer: 'for: username, styles: [popup, onWithError]')
    label 'Password:', constraints: 'left'
    passwordField columns: 20, constraints: 'right', text: bind(target: model, 'password', mutual: true)
    errorIcon(constraints: 'wrap', errorRenderer: 'for: password, styles: [popup, onWithError]')

    button(cancelAction, constraints: 'tag cancel')
    button(loginAction, constraints: 'span 2, tag ok')
    
    keyStrokeAction(component: current.rootPane,
        keyStroke: "ESCAPE",
        condition: "in focused window",
        action: cancelAction)
}
