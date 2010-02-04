import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "How Groovy Helps") {
    bullet(text: "Write less with optional keywords")
    bullet(text: "public, return, arg types & return types", noicon: true, css: "code")
    bullet(text: "Terser syntax for property access")
    bullet(text: "Native syntax for Lists and Maps")
    bullet(text: "Closures")
    bullet(text: "AST Transformations - compile time metaprogramming")
}
