package demo

import org.fife.ui.autocomplete.*
import org.fife.ui.rsyntaxtextarea.SyntaxConstants

panel {
    migLayout layoutConstraints: 'fill'
    splitPane(resizeWeight: 0.75f, border: emptyBorder(0),
              constraints: 'grow', orientation: JSplitPane.VERTICAL_SPLIT) {
        rtextScrollPane(constraints: 'grow, wrap') {
            editor = rsyntaxTextArea(syntaxEditingStyle: SyntaxConstants.SYNTAX_STYLE_JAVA)
            noparent {
                bean(new AutoCompletion(new MyCodeCompletionProvider()),
                    triggerKey: shortcut('shift SPACE'),
                    showDescWindow: false,
                    autoCompleteSingleChoices: true
                ).install(editor)
            }
        }
        panel {
            migLayout layoutConstraints: 'fill'
            panel(constraints: 'grow, west') {
                gridLayout(cols: 1, rows: 6)
                button('Trace', actionPerformed: controller.trace)
                button('Debug', actionPerformed: controller.debug)
                button('Info',  actionPerformed: controller.info)
                button('Warn',  actionPerformed: controller.warn)
                button('Error', actionPerformed: controller.error)
                button('Bomb',  actionPerformed: controller.bomb)
            }
            scrollPane(constraints: 'grow, center') {
                textPane(editable: false) {
                    bean(model, messages: current.document, console: current)
                }
            }
        }
    }
}
