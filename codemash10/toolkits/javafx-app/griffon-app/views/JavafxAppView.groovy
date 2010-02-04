import javafx.geometry.HPos

application(title:'javafx-app',
  size: [320, 240],
  locationByPlatform:true,
  iconImage: imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
  fxswingScene {
    fxvbox(spacing: 8, nodeHPos: HPos.CENTER, hpos: HPos.CENTER) {
        fxlabel('Enter some text below')
        fxtextBox(id: 'input', columns: 30)
        fxbutton(text: 'Click me!', action: controller.copyText)
        fxtextBox(id: 'output', columns: 30, editable: false)
    }
  }
}
