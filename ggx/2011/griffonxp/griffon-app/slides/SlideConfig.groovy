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
                migLayout(layoutConstraints: 'fill', columnConstraints: '5%[left][left][right]1%', rowConstraints: '[bottom]')
                label('Groovy/Grails eXchange 2011', cssClass: 'footer-text')
                label('London', cssClass: 'footer-text2', constraints: 'grow')
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

bullet = { text, params = [:] ->
    Map attrs = [cssClass: 'normal', border: emptyBorder(12), constraints: 'wrap', icon: imageIcon('/groovy-icon.png')]
    label([*:attrs, *:params], text)
}
