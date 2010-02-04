package griffon.slideware

// import ca.odell.glazedlists.*
// import ca.odell.glazedlists.gui.*
// import ca.odell.glazedlists.swing.*

/*
def createTableModel() {
    def columnNames = ["Shortcut","Description"]
    new EventTableModel(model.shortcuts, [
            getColumnCount: {columnNames.size()},
            getColumnName: {index -> columnNames[index]},
            getColumnValue: {object, index ->
                object."${columnNames[index].toLowerCase()}"
            }] as TableFormat)
}
*/

edt {
    dialog(title: "Help", id: "helpDialog", modal: false,
        size: [460,200], pack: true,
        iconImage: imageIcon('/griffon-icon-48x48.png').image,
        iconImages: [imageIcon('/griffon-icon-48x48.png').image,
            imageIcon('/griffon-icon-32x32.png').image,
            imageIcon('/griffon-icon-16x16.png').image]) {
        borderLayout()
/*
        scrollPane(constraints: CENTER) {
            table(id: "shortcutsTable", model: createTableModel())
        }
        new TableComparatorChooser(shortcutsTable,
            model.shortcuts, AbstractTableComparatorChooser.SINGLE_COLUMN)
*/
        scrollPane(constraints: CENTER) {
            table(id: 'shortcutsTable') {
                eventTableModel(source: model.shortcuts,
                                format: defaultTableFormat(columnNames: ['Shortcut', 'Description']))
                installTableComparatorChooser(source: model.shortcuts)
            }
        }
    }
}
