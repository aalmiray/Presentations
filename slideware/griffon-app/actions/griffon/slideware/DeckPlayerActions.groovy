package griffon.slideware

import javax.swing.UIManager
import javax.swing.SwingUtilities
import javax.swing.SwingConstants

action(id: "previousAction",
	closure: {deck.layout.previous(deck)})
action(id: "nextAction",
	closure: {deck.layout.next(deck)})
action(id: "closeAction",
	closure: controller.close)
action(id: "lookupAction",
	closure: {
		input.text = ""
		lookupPopup.showPopup(SwingConstants.SOUTH_EAST, deckFrame)
	})
action(id: "showLafsAction",
	closure: {
		lafsPopup.showPopup(SwingConstants.SOUTH_EAST, deckFrame)
	})
action(id: "jumpAction",
	closure: {
		lookupPopup.hidePopup(true)
		def page = "page${input.text}"
		input.text = ""
		deck.layout.show(deck, page)
	})
action(id: "lafAction",
	closure: {
		lafsPopup.hidePopup(true)
		UIManager.setLookAndFeel(model.lafs[lafList.selectedValue])
		(app.appFrames + [lookupPopup, lafsPopup]).each {c -> SwingUtilities.updateComponentTreeUI(c)}
	})