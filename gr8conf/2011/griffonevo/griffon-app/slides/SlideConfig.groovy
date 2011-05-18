import net.miginfocom.swing.MigLayout
import griffon.plugins.slideware.*
import javax.imageio.ImageIO
import java.awt.*

createHeader = { str ->
    panel(opaque: false)
}

createFooter = { idx ->
    def footer
    noparent {
        if(!idx) {
            footer = panel(new BackgroundPanel(), backgroundPaint: Color.WHITE)
        } else {
            footer = panel {
                migLayout(layoutConstraints: 'fill', columnConstraints: '5%[left][left][left]40%[right]1%', rowConstraints: '[bottom]')
                widget(new ImagePanel(), imagePath: 'gr8conf-logo.png', scale: 0.30f, preferredSize: [62,50])
                label('Europe 2011', cssClass: 'footer-text')
                label('Copenhagen, Denmark', cssClass: 'footer-text2', constraints: 'grow')
                label(idx.toString(), cssClass: 'footer')
            }
        }
    }
    footer
}

loadImage = { path ->
    ImageIO.read(Thread.currentThread().getContextClassLoader().getResource(path.toString()))
}

backgroundPainter = { p, g ->
    Rectangle bounds = p.bounds
    g.clearRect(bounds.x as int, bounds.y as int, bounds.width as int, bounds.height as int)
    g.setColor(Color.WHITE)
    g.fillRect(bounds.x as int, bounds.y as int, bounds.width as int, bounds.height as int)
}

GRIFFON_IMG_CONF = [
    past: [
        width: 1024,
        height: 768,
        url: 'http://www.flickr.com/photos/bframe/502492136'
    ],
    present: [
        width: 1200,
        height: 798,
        url: 'http://www.flickr.com/photos/42311564@N00/2553830765'
    ],
    future: [
        width: 825,
        height: 1210,
        url: 'http://www.flickr.com/photos/avenefica/4961195788'
    ]
]

griffonPainter = { type, p, g ->
    Rectangle bounds = p.bounds
    g.clearRect(bounds.x as int, bounds.y as int, bounds.width as int, bounds.height as int)
    g.setColor(Color.BLACK)
    g.fillRect(bounds.x as int, bounds.y as int, bounds.width as int, bounds.height as int)
    Rectangle b = new Rectangle(p.bounds)
    b = GraphicsUtil.scaleBounds(GRIFFON_IMG_CONF[type].width as int, GRIFFON_IMG_CONF[type].height as int, b)
    g.drawImage(loadImage("griffon-${type}.jpg"), b.x as int, b.y as int, b.width as int, b.height as int, Color.BLACK, p)
}

bullet = { text, params = [:] ->
    def attrs = [cssClass: 'normal', border: emptyBorder(12), constraints: 'wrap', icon: imageIcon('/griffon-icon-24x24.png')]
    label([*:attrs, *:params], text)
}
