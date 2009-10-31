package griffon.slideware

import groovy.beans.Bindable
import java.awt.Toolkit
import java.awt.event.KeyEvent
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

class DeckOptionsModel {
	@Bindable boolean busy
	EventList shortcuts = new SortedList(new BasicEventList(),
		{a, b -> a.shortcut <=> b.shortcut} as Comparator)

	DeckOptionsModel() {
		def keyMask = KeyEvent.getKeyModifiersText(Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()).toUpperCase()

		shortcuts.addAll([
				[shortcut: "ESCAPE", description: "Exit the presentation"],
				[shortcut: "SHIFT + $keyMask + F", description: "Change Look & Feel"],
				[shortcut: "$keyMask + UP", description: "Jump to slide"],
				[shortcut: "$keyMask + LEFT", description: "Move backwards"],
				[shortcut: "$keyMask + RIGHT", description: "Move forward"],
				[shortcut: "Mouse Button3 (Right)", description: "Move backwards"],
				[shortcut: "Mouse Button1 (Left)", description: "Move forward"],
				[shortcut: "SHIFT + $keyMask + S", description: "Smaller editor font"],
				[shortcut: "SHIFT + $keyMask + L", description: "Larger editor font"],
				[shortcut: "$keyMask + ENTER", description: "Execute code (on editable Editor)"]
			])
	}
}