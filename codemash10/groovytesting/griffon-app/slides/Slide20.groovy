import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "But how do I run it?") {
    bullet(text: "Pick your favorite IDE!")
    bullet(text: "IDEA", noicon: true, css: "code")
    bullet(text: "Eclipse", noicon: true, css: "code")
    bullet(text: "NetBeans", noicon: true, css: "code")
    bullet(text: "Command line tools")
    bullet(text: "Ant / Gant", noicon: true, css: "code")
    bullet(text: "Maven / GMaven", noicon: true, css: "code")
    bullet(text: "Gradle", noicon: true, css: "code")
    bullet(text: "Good ol' Groovy shell/console", noicon: true, css: "code")
}
