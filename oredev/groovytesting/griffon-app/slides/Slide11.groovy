import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[center]5%","[bottom]5%[top]")) {
    textArea("Groovy is what the Java language would look like had it be written in the 21st century", editable: false, cssClass: "header", constraints: "growx, wrap", lineWrap: true, wrapStyleWord: true)
    label(icon: imageIcon("/scott_davis_2009.jpg"))
}
