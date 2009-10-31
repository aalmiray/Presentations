import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "Groovy + Testing Frameworks") {
    bullet(text: "Any Groovy script may become a testcase")
    bullet(text: "assert keyword enabled by default", noicon: true, css: "code")
    bullet(text: "Groovy provides a GroovyTestCase as base class")
    bullet(text: "Easier to test exception throwing code", noicon: true, css: "code")
    bullet(text: "JUnit 4.x and TestNG ready. Groovy supports JDK5")
    bullet(text: "Annotations, generics, static imports", noicon: true, css: "code")
}
