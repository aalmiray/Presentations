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

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}

root.'JxlayerGriffonAddon'.addon=true

root.'JbusyComponentGriffonAddon'.addon=true

root.'griffon.builder.jide.JideBuilder'.view = '*'

root.'griffon.builder.css.CSSBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.controller = ['CSS']

root.'GlazedlistsGriffonAddon'.addon=true

root.'I18nGriffonAddon'.addon=true

root.'MiglayoutGriffonAddon'.addon=true

root.'LookandfeelGriffonAddon'.addon=true

root.'SyntaxtextGriffonAddon'.addon=true

root.'SlidewareGriffonAddon'.addon=true

root.'ChartsGriffonAddon'.addon=true

root.'JoglCompatGriffonAddon'.addon=true

root.'Jzy3dGriffonAddon'.addon=true

root.'CoverflowGriffonAddon'.addon=true

root.'SteelGriffonAddon'.addon=true
