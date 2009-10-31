package griffon.slideware
import java.awt.Font

modifyFont = { target, sizeFilter, sizeMod ->
	def currentFont = target.font
	if(sizeFilter(currentFont.size)) return
	target.font = new Font('Monospaced', currentFont.style, currentFont.size + sizeMod)
}

action(id: "hideAction",
	closure: {it.source.visible = false})
action(id: "runAction",
	keyStroke: shortcut("ENTER"),
	closure: controller.runScript)
action(id: "biggerFontAction",
	closure: {modifyFont(it.source.textEditor, {it > 40}, +2)})
action(id: "smallerFontAction",
	closure: {modifyFont(it.source.textEditor, {it < 5}, -2)})