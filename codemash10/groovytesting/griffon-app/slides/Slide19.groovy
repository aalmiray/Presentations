import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "AST Transformations") {
    bullet(text: "@Singleton")
    bullet(text: "@Lazy")
    bullet(text: "@Immutable")
    bullet(text: "@Bindable")
    bullet(text: "@Newify")
    bullet(text: "@Delegate")
    bullet(text: "And a few more...")
}
