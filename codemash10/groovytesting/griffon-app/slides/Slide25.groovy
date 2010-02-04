import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "StubFor/MockFor") {
    bullet(text: "Caller - Collaborator")
    bullet(text: "Mocks/Stubs define expectations on collaborators")
    bullet(text: "Mocks are strict", noicon: true, css: "code")
    bullet(text: "Stubs are relaxed", noicon: true, css: "code")
    bullet(text: "CAVEAT - caller must be Groovy")
}
