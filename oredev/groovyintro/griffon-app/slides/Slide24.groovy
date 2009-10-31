import net.miginfocom.swing.MigLayout

def script = '''import javax.swing.table.DefaultTableCellRenderer as DTCR

def myActionListener = { event ->
   // do something cool with event
} as java.awt.event.ActionListener

def renderer = [
   getTableCellRendererComponent = { t, v, s, f, r , c ->
      // cool renderer code goes here
   }
] as DTCR

// note that this technique is like creating objects in
// JavaScript using JSON notation
'''

slide(layout: new MigLayout("fill","3%[center]3%","3%[center]3%"), title: "The 'as' keyword") {
    scrollPane(constraints: "grow") {
        widget(createEditor(text: script, editable: false, runnable: false))
    }
}