import net.miginfocom.swing.MigLayout

slide(id: 'slide12', draw: draw, layout: new MigLayout('fill','3%[left]3%',''), title: 'What about compatibility?') {
   bullet(text: 'Groovy can call Scala as Scala can call Groovy')
   bullet(noicon: true, text: '  use Java as an IDL if needed')
   bullet(text: 'Enhance Groovy classes with @Scalify')
   bullet(text: 'Translate values with Groovy\'s meta-programming')
   bullet(text: 'Use Scala\'s structural types')
}