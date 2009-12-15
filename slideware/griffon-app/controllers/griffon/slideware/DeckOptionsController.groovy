package griffon.slideware

import java.awt.GraphicsEnvironment
import java.awt.Dimension
import griffon.builder.css.CSSDecorator
import com.lowagie.text.*
import com.lowagie.text.pdf.*

class DeckOptionsController {
    def model
    def view

    def mvcGroupInit(Map args) {
        app.config.resolution.screen = app.config?.resolution?.screen ?: [width: 1024, height: 768]
        app.config.resolution.print = app.config?.resolution?.print ?: app.config.resolution.screen
        app.config.fullscreen = app.config?.fullscreen != null ? app.config.fullscreen : true
        app.config.pdf.filename = app.config?.pdf?.filename ?: "presentation.pdf"
    }

    def play = { evt = null ->
        showDeck()
    }

    def help = { evt = null ->
        showDialog("help")
    }

    def print = { evt = null ->
        def width = app.config.resolution.print.width as float
        def height = app.config.resolution.print.height as float
        def filename = app.config.pdf.filename

        model.busy = true
        def deck = app.views.DeckPlayer.deck
        deck.layout.skipTransitions = true
        showDeck(app.config.resolution.print)
        doOutside {
            // TODO check app.config.screen.fullscreen
            Rectangle size = new Rectangle(width, height)
            Document document = new Document(size, 0f, 0f, 0f, 0f)
            try {
                PdfWriter.getInstance(document, new FileOutputStream(filename))
                document.open()
                (0..<deck.size()).each { i ->
                    def slide = deck[i]
                    def imageSet = []
                    edt { imageSet = slide.asImageSet() }
                    imageSet.each { image ->
                        def img = Image.getInstance(image, null)
                        img.setDpi(600i, 600i)
                        img.setXYRatio(2.5f)
                        document.add(img)
                    }
                    edt { deck.layout.next(deck) }
                }
            } finally {
                document.close()
                edt {
                    view.optionsFrame.visible = true
                    app.views.DeckPlayer.deckFrame.visible = false
                    deck.layout.skipTransitions = false
                    model.busy = false
                }
            }
        }
    }

    def quit = { evt = null ->
        app.shutdown()
    }

    private void showDeck(size) {
        def graphicsEnvironment = GraphicsEnvironment.localGraphicsEnvironment
        def device = graphicsEnvironment.screenDevices.find{it.fullScreenSupported}
        view.optionsFrame.visible = false
        def deck = app.views.DeckPlayer.deck
        deck.layout.first(deck)
        CSSDecorator.decorate("style", app.views.DeckPlayer.deckFrame)
        app.views.DeckPlayer.deckFrame.pack()
        if(!size && app.config.fullscreen) {
            device?.setFullScreenWindow(app.views.DeckPlayer.deckFrame)
        } else {
            def res = size ?: app.config.resolution.screen
            app.views.DeckPlayer.deckFrame.size = new Dimension(res.width as int, res.height as int)
        }
        app.views.DeckPlayer.deckFrame.visible = true
    }

    private void showDialog(dialogName, pack = true) {
        def dialog = view."${dialogName}Dialog"
        if(dialog.visible) {
            dialog.toFront()
            return
        }
        if(pack) dialog.pack()
        int x = view.optionsFrame.x + (view.optionsFrame.width - dialog.width) / 2
        int y = view.optionsFrame.y + (view.optionsFrame.height - dialog.height) / 2
        dialog.setLocation(x, y)
        dialog.show()
    }

    private void hideDialog(dialogName) {
        def dialog = view."${dialogName}Dialog"
        dialog.hide()
    }
}
