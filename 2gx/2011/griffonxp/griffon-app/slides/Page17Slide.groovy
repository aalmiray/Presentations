def (m, v, c) = createMVCGroup('GroovyCodeEditor', 'editor-slide17')
m.editable = false
m.code = '''package bookclient

import groovy.beans.Bindable
import griffon.transform.PropertyListener
import ca.odell.glazedlists.EventList
import ca.odell.glazedlists.BasicEventList
import ca.odell.glazedlists.SortedList
import static griffon.util.GriffonNameUtils.isBlank

class BookstoreModel {
  @PropertyListener(enabler)
  @Bindable String query
  @Bindable String status = ''
  @Bindable boolean busy
  @Bindable boolean enabled = false

  static final AUTHORS = 'author'
  static final BOOKS = 'book'

  EventList authors = new SortedList(new BasicEventList(),
       {a, b -> a.lastname <=> b.lastname} as Comparator)
  EventList books = new SortedList(new BasicEventList(),
       {a, b -> a.title <=> b.title} as Comparator)
  EventList results = new SortedList(new BasicEventList(),
       {a, b -> a.title <=> b.title} as Comparator)

  private enabler = { evt ->
    enabled = isBlank(evt.newValue) ? false : true
  }
}'''

slide(title: '', backgroundPainter: backgroundPainter) {
    migLayout(layoutConstraints: 'fill',
              columnConstraints: '5%[center]5%',
              rowConstraints: '[top][top]')
    label(cssClass: 'header', constraints: 'wrap', 'Model')
    widget(v.groovyEditorContainer, constraints: 'grow')
}
