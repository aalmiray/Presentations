import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","[center]","[bottom]5%[top]"), title: "Scott Davis' 2nd Mantra") {
    label("Groovy is Java & Groovy is NOT Java", cssClass: "header", constraints: "wrap")
    label(icon: imageIcon("/scott_davis_2009.jpg"))
}
