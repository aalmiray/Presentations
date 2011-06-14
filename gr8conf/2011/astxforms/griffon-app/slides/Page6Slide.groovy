def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide6')
m.editable = true
m.code = '''class Account {
    BigDecimal balance = 0
}

@Singleton
class AccountManager {
    void open(Account account) {
        account.balance = 100
    }
}

account = new Account()
assert account.balance == 0
AccountManager.instance.open(account)
assert account.balance == 100'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', '@Singleton')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
