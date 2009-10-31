import groovy.swing.factory.ComponentFactory
import griffon.slideware.ui.Slide
import griffon.slideware.factory.SlideHeaderFactory
import griffon.slideware.factory.SlideFooterFactory

class SlidewareGriffonAddon {
    def factories = [
	    slide: new ComponentFactory(Slide, false),
		slideHeader: new SlideHeaderFactory(),
		slideFooter: new SlideFooterFactory()
	]
    def mvcGroups = [
        // MVC Group for "CodeEditor"
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
