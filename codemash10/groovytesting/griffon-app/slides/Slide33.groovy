import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","[center]","[bottom]5%[top]")) {
    label("This presentation made with", constraints: "wrap", cssClass: "header")
    label(icon: imageIcon("griffon-banner.png"))
}