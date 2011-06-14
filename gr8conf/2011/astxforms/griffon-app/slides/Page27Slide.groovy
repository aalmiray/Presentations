def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide27')
m.editable = true
m.code = '''import org.gcontracts.annotations.*

@Invariant({this.@balance >= 0})
class Account {
    private BigDecimal balance = 0
    
    BigDecimal getBalance() { balance }
    
    Account() {}
    
    @Requires({amount > 0})
    @Ensures({balance == amount})
    Account(BigDecimal amount) {
        balance = amount
    }
    
    @Requires({amount > 0})
    @Ensures({balance == old.balance + amount})
    BigDecimal deposit(BigDecimal amount) {
        balance += amount
        balance
    }
    
    @Requires({amount > 0 && amount <= balance})
    @Ensures({balance == old.balance - amount})
    BigDecimal withdraw(BigDecimal amount) {
        balance -= amount
        balance
    }
}

account = new Account()
println "Balance is ${account.deposit(1000)}"
println "Balance is ${account.withdraw(10)}"'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill')
    panel(constraints: 'grow', opaque: false) {
        borderLayout(vgap: 20, hgap: 20)
        label(constraints: NORTH, cssClass: 'header', 'GContracts')
        widget(constraints: CENTER, v.groovyEditorContainer)
    }
}
