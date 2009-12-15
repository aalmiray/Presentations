package griffon.slideware

application(title: app.config.application.title,
	pack: true, id: 'optionsFrame',
	locationByPlatform: true,
	iconImage: imageIcon('/griffon-icon-48x48.png').image,
	iconImages: [imageIcon('/griffon-icon-48x48.png').image,
		imageIcon('/griffon-icon-32x32.png').image,
		imageIcon('/griffon-icon-16x16.png').image]) {
	busyComponent(busy: bind{model.busy}) {
		panel {
			gridLayout(cols: 1, rows: 4)
			button(playAction)
			button(printAction)
			button(helpAction)
			button(quitAction)
		}
	}
}
