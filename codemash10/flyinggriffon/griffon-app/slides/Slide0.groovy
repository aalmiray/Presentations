import net.miginfocom.swing.MigLayout

slide(id: 'slide0', draw: draw, layout: new MigLayout('fill','[center]','[bottom]10%[top]')) {
    label(icon: imageIcon('/griffon-icon-256x256.png'), constraints: 'wrap')
    label('Flying with Griffon', cssClass: 'header')
}
