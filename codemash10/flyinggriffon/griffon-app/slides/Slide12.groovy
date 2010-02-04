import net.miginfocom.swing.MigLayout

slide(id: 'slide12', draw: draw, layout: new MigLayout('fill','[center]','[bottom]10%[top]10%[top]')) {
    label('Polyglot anyone?', cssClass: 'header', constraints: 'span 2, wrap')
    label(icon: imageIcon('groovy-logo.png'))
    label(icon: imageIcon('javafx-logo.png', constraints: 'wrap'))
    label(icon: imageIcon('clojure-logo.png'))
    label(icon: imageIcon('scala-logo.png'))
}
