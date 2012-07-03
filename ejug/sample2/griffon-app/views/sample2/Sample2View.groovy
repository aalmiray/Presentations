package sample2

import javafx.beans.*

stage(title: 'Griffon + JavaFX + JPA', visible: true, centerOnScreen: true) {
    scene(fill: WHITE, width: 352, height: 300) {
        borderPane {
            top {
                toolBar {
                    button('Load',  onAction: controller.load)
                    button('Clear', onAction: controller.&clear)
                }
            }
            tv = tableView(selectionMode: 'single', cellSelectionEnabled: true, items: model.people) {
                tableColumn(property: 'id', text: 'Id', prefWidth: 50)
                tableColumn(property: 'name', text: 'Name', prefWidth: 150)
                tableColumn(property: 'lastname', text: 'Lastname', prefWidth: 150)
            }
        }
        noparent {
            model.people.addListener({
                tv.items.clear()
                tv.items.addAll(model.people)
            } as InvalidationListener)
        }
    }
}