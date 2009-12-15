import net.miginfocom.swing.MigLayout
import java.awt.GradientPaint
import java.awt.Color

createFooter = { idx ->
    def footer
    noparent {
        footer = panel(layout: new MigLayout("fill","2%[left]2%[left][][right]2%","[center]")) {
            label('BASE 2009', cssClass: 'footer')
            label(icon: imageIcon('/cc-sa-88x31.png'), cssClass: 'footer')
            label('Andres Almiray - Griffon + Scala', cssClass: 'footer')
            label(idx.toString(), cssClass: 'footer')
        }
    }
    footer
}

createEditor = { params ->
    def editorWidget = null
    def defaults = [editable: true, runnable: true]
    String editorId = "editor" + System.currentTimeMillis()
    noparent {
        def (m, v, c) = controller.createMVCGroup([attrs: defaults + params, containerFrame: deckFrame], "CodeEditor", editorId)
        editorWidget = v.editor
    }
    editorWidget
}

bullet = { params ->
    label(icon: imageIcon(params?.noicon ? "/no-icon.png" : "/groovy-icon.png"), cssClass: "normal",
          constraints: "wrap", text: params.text)
}

draw = { g ->
    def bounds = g.clipBounds
    def height = (4*bounds.height)/3
    def paint = g.paint
    g.paint = new GradientPaint(0f, 0f, Color.BLACK, 0f, height as float, Color.GRAY.darker())
    g.fillRect(0i, 0i, bounds.width as int, height as int)
    g.paint = paint
}
