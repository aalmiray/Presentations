import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","[center]","[bottom]5%[top]"), title: "Scott Davis' 1st Mantra") {
    label("Groovy is Java & Java is Groovy", cssClass: "header", constraints: "wrap")
    label(icon: imageIcon("/scott_davis_2009.jpg"))
}
