root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'I18nGriffonAddon'.addon = true

root.'griffon.builder.jide.JideBuilder'.view = '*'

root.'MiglayoutGriffonAddon'.addon = true

root.'GsqlGriffonAddon'.addon = true

root.'ValidationGriffonAddon'.addon = true

root.'GlazedlistsGriffonAddon'.addon = true

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
    }
}
root.'SyntaxtextGriffonAddon'.addon = true

