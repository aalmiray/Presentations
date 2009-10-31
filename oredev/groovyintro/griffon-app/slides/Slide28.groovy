import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "Metaprogramming") {
    bullet(text: "Groovy does not support open classes like Ruby does")
    bullet(text: "Change a class' behavior at runtime")
    bullet(text: "Since 1.6 change them at buildtime too (AST xforms)")
    bullet(text: "Intercept method calls and property access")
}
