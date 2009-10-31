import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "Mocking with Groovy") {
    bullet(text: "Use known (Java) mocking libraries")
    bullet(text: "Easymock - record/replay", noicon: true, css: "code")
    bullet(text: "JMock - write expectations as you go", noicon: true, css: "code")
    bullet(text: "Mockito - new kid on the block", noicon: true, css: "code")
    bullet(text: "Use dynamic proxies as stubs")
    bullet(text: "Use StubFor / MockFor")
    bullet(text: "Inspired by Easymock", noicon: true, css: "code")
    bullet(text: "No external libraries required", noicon: true, css: "code")
}
