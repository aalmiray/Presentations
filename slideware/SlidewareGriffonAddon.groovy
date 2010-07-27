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

import groovy.swing.factory.ComponentFactory
import griffon.slideware.ui.Slide
import griffon.slideware.factory.SlideHeaderFactory
import griffon.slideware.factory.SlideFooterFactory

/**
 * @author Andres.Almiray
 */
class SlidewareGriffonAddon {
    def factories = [
        slide: new ComponentFactory(Slide, false),
        slideHeader: new SlideHeaderFactory(),
        slideFooter: new SlideFooterFactory()
    ]

    def mvcGroups = [
        'CodeEditor' : [
            model :      'griffon.slideware.CodeEditorModel',
            actions:     'griffon.slideware.CodeEditorActions',
            view :       'griffon.slideware.CodeEditorView',
            controller : 'griffon.slideware.CodeEditorController'
        ],
        'DeckPlayer' : [
            model :      'griffon.slideware.DeckPlayerModel',
            actions:     'griffon.slideware.DeckPlayerActions',
            view :       'griffon.slideware.DeckPlayerView',
            controller : 'griffon.slideware.DeckPlayerController'
        ],
        "DeckOptions": [
            model:      'griffon.slideware.DeckOptionsModel',
            actions:    'griffon.slideware.DeckOptionsActions',
            dialogs:    'griffon.slideware.DeckOptionsDialogs',
            view:       'griffon.slideware.DeckOptionsView',
            controller: 'griffon.slideware.DeckOptionsController'
        ]
    ]
}
