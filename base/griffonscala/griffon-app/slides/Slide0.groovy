import net.miginfocom.swing.MigLayout

slide(id: 'slide0', draw: draw, layout: new MigLayout('fill','[]10%[]','[bottom]10%[top]')) {
    label(icon: imageIcon('/griffon-icon-128x128.png'), constraints: 'right')
    label(icon: imageIcon('/scala-logo.png'), constraints: 'left, wrap')
    label('Bay Area Scala Enthusiasts', constraints: 'center, span 2', cssClass: 'header')
}