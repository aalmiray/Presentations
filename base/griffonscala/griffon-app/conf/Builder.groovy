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
        view = '*'
        controller = ['withWorker']
    }
}

root.'griffon.builder.css.CSSBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.controller = ['CSS']
root.'griffon.builder.jide.JideBuilder'.view = '*'
root.'griffon.builder.trident.TridentBuilder'.view = '*'
root.'TransitionsGriffonAddon'.addon=true
root.'JBusyComponentGriffonAddon'.addon=true
root.'SlidewareGriffonAddon'.addon=true
root.'GlazedlistsGriffonAddon'.addon=true
root.'JxlayerGriffonAddon'.addon=true
root.'MiglayoutGriffonAddon'.addon=true
root.'LookandfeelGriffonAddon'.addon=true

root.'LookandfeelSubstanceGriffonAddon'.addon=true
