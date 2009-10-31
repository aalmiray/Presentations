import net.miginfocom.swing.MigLayout

slide(id: "slide32", layout: new MigLayout("fill","5%[center]5%","[center][center][center]"), title: "Books") {
    label(icon: imageIcon("book_groovy_in_action.png"))
    label(icon: imageIcon("book_grails_in_action.png"))
    label(icon: imageIcon("book_griffon_in_action.png"), constraints: "wrap")
    label(icon: imageIcon("book_groovy_recipes.png"))
    label(icon: imageIcon("book_programming_groovy.png"))
    label(icon: imageIcon("book_grails_quick_guide.png"))
}
