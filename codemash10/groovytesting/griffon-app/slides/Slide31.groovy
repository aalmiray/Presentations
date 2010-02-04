import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "Groovy to the rescue!") {
    bullet(text: "Web:")
    bullet(text: "Canoo WebTest - leverages AntBuilder", noicon: true, css: "code")
    bullet(text: "Tellurium - a Groovier Selenium", noicon: true, css: "code")
    bullet(text: "Desktop:")
    bullet(text: "FEST - next generation Swing Testing", noicon: true, css: "code")
    bullet(text: "BDD:")
    bullet(text: "Easyb, Spock, JBehave, Cuke4duke", noicon: true, css: "code")
}
