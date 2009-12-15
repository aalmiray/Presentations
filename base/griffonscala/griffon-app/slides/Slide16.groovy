import net.miginfocom.swing.MigLayout

slide(id: 'slide16', draw: draw, layout: new MigLayout('fill','3%[left]3%',''), title: 'ScalaTest') {
   bullet(text: 'Execute all type of tests supported by ScalaTest')
   bullet(noicon: true, text: '  junit, specs, funsuites, etc')
   bullet(text: 'Almost all options are configurable')
   bullet(noicon: true, text: '  can\'t configure tags at the moment')
   bullet(noicon: true, text: '  some options can be set on the cmd line')
   bullet(text: 'Wish: Junit report integration (XML)')
}