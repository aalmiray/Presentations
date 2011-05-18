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
