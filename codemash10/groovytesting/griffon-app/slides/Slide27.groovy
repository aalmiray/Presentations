import net.miginfocom.swing.MigLayout

slide(layout: new MigLayout("fill","5%[left]5%",""), title: "XML Processing") {
    bullet(text: "DbUnit: a JUnit extension for testing databases")
    bullet(text: "Several options at your disposal")
    bullet(text: "Old school - extend DatabaseTestCase", noicon: true, css: "code")
    bullet(text: "Flexible - use an IDatabaseTester impl", noicon: true, css: "code")
    bullet(text: "Roll your own Database testcase", noicon: true, css: "code")
}
