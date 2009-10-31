import net.miginfocom.swing.MigLayout
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.StarsTransition2D

slide(id: "slide32", layout: new MigLayout("fill","5%[center]5%","[center][center]"), title: "More Books", transition: new StarsTransition2D(Transition2D.LEFT)) {
    label(icon: imageIcon("book_beginning_groovy_grails.png"))
    label(icon: imageIcon("book_definitive_guide_grails.png"), constraints: "wrap")
    label(icon: imageIcon("book_groovy_grails_recipes.png"))
    label(icon: imageIcon("book_gorm_gsql.png"))
}
