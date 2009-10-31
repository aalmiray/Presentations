import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "Groovy loves Java") {
    bullet(text: "A Java class is a Groovy and viceversa")
    bullet(text: "No artifical bridge between languages")
    bullet(text: "Full JDK5 support: annotations, generics, varargs, enums")
    bullet(text: "98% of Java code is valid Groovy code")
    bullet(text: "Rename *.java to *.groovy and compile!")
}
