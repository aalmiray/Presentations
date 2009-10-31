root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}

jx {
    'groovy.swing.SwingXBuilder' {
        controller = ['Threading']
        view = '*'
    }
}

root.'griffon.builder.trident.TridentBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.controller = ['CSS']
root.'griffon.builder.gfx.GfxBuilder'.view = '*'
root.'griffon.builder.jide.JideBuilder'.view = '*'
root.'JBusyComponentGriffonAddon'.addon=true
root.'SlidewareGriffonAddon'.addon=true
