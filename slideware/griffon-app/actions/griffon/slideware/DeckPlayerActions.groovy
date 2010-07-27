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

/**
 * @author Andres.Almiray
 */

package griffon.slideware

import javax.swing.UIManager
import javax.swing.SwingUtilities
import javax.swing.SwingConstants
import griffon.lookandfeel.LookAndFeelManager

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
        if(lafList.selectedValue) LookAndFeelManager.instance.apply(model.lafs[lafList.selectedValue], app)
    })
