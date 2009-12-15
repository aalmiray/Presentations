import net.miginfocom.swing.MigLayout

slide(id: 'slide2', draw: draw, layout: new MigLayout('fill ','[center][center][center][center][center]','[center]')) {
  label(icon: imageIcon(resource: 'groovy-logo.png'))
  label('+', cssClass: 'header')
  label(icon: imageIcon(resource: 'grails-icon-128x128.png'))
  label('+', cssClass: 'header')
  label(icon: imageIcon(resource: 'SwingingDuke.png'))
}