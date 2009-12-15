import net.miginfocom.swing.MigLayout
import ca.odell.glazedlists.*
import ca.odell.glazedlists.gui.*
import ca.odell.glazedlists.swing.*
import java.awt.Font
import com.bric.image.transition.Transition2D
import com.bric.image.transition.spunk.*
import com.bric.image.transition.vanilla.*

methodList = new SortedList(new BasicEventList(),
   {a, b -> a.scala <=> b.scala} as Comparator)

methodList.addAll([
    [operator: '+',  groovy: 'plus()', scala: '$plus()'],
    [operator: '-',  groovy: 'minus()', scala: '$minus()'],
    [operator: '*',  groovy: 'multiply()', scala: '$times()'],
    [operator: '/',  groovy: 'div()', scala: '$div()'],
    [operator: '%',  groovy: 'mod()', scala: '$percent()'],
    [operator: '^',  groovy: 'xor()', scala: '$up()'],
    [operator: '&',  groovy: 'and()', scala: '$amp()'],
    [operator: '|',  groovy: 'or()', scala: '$bar()'],
    [operator: '**', groovy: 'power()', scala: '$times$times()'],
    [operator: '<<', groovy: 'leftShift()', scala: '$less$less()'],
    [operator: '>>', groovy: 'rightShift()', scala: '$greater$greater()'],
    [operator: '-',  groovy: 'negative()', scala: 'unary_$minus()'],
    [operator: '+',  groovy: 'positive()', scala: 'unary_$plus()'],
    [operator: '~',  groovy: 'bitwiseNegate()', scala: 'unary_$tilde()']
])

def createTableModel() {
    def columnNames = ["Operator", "Groovy", "Scala"]
    new EventTableModel(methodList, [
                        getColumnCount: {columnNames.size()},
                        getColumnName: {index -> columnNames[index]},
                        getColumnValue: {object, index ->
                            object."${columnNames[index].toLowerCase()}"
                        }] as TableFormat)
}


slide(id: 'slide14', draw: draw, layout: new MigLayout('fill','3%[center]3%','3%[center]3%'), title: '@Scalify (2)', transition: new LevitateTransition2D()) {
    scrollPane(constraints: 'grow') {
        table(id: "methodsTable", model: createTableModel())
    }
    methodsTable.font = new Font("SansSerif", Font.BOLD, 24i)
    new TableComparatorChooser(methodsTable,
       methodList, AbstractTableComparatorChooser.SINGLE_COLUMN)
}