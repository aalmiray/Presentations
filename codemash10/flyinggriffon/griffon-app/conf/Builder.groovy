root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'griffon.builder.trident.TridentBuilder'.view = '*'

root.'TransitionsGriffonAddon'.addon=true

root.'griffon.builder.css.CSSBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.controller = ['CSS']

root.'griffon.builder.gfx.GfxBuilder'.view = '*'

root.'griffon.builder.jide.JideBuilder'.view = '*'

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}

root.'JBusyComponentGriffonAddon'.addon=true

root.'SlidewareGriffonAddon'.addon=true

root.'GlazedlistsGriffonAddon'.addon=true
