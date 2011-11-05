package demo

build(DemoActions)

application(title: GriffonNameUtils.capitalize(app.getMessage('application.title', app.config.application.title)),
    pack: true,
    preferredSize: [640, 540],
    name: 'mainWindow',
    locationByPlatform:true,
    iconImage: imageIcon('/griffon-icon-48x48.png').image,
    iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
   widget(build(DemoMenuBar))
   migLayout(layoutConstraints: 'fill')
   widget(build(DemoContent), constraints: 'center, grow')
   widget(build(DemoStatusBar), constraints: 'south, grow')
}