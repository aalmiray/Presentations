import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","[center]","[bottom]5%[top]")) {
    label(icon: imageIcon("/groovy-logo.png"), constraints: "wrap")
    label("Introduction to Groovy", cssClass: "header")
}
