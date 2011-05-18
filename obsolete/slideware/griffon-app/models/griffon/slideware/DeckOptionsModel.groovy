/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package griffon.slideware

import groovy.beans.Bindable
import java.awt.Toolkit
import java.awt.event.KeyEvent
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList

/**
 * @author Andres.Almiray
 */
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
