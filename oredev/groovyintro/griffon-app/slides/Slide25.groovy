import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "New Operators") {
    bullet(text: "?: (elvis) - a refinement on the ternary operator")
    bullet(text: "?. safe dereference - kiss NPEs goodbye!")
    bullet(text: "<=> (spaceship) - compare two values")
    bullet(text: "* (spread) - explodes contents of a list/array")
    bullet(text: ".* (spread-dot) - apply method on all list elements")
}
