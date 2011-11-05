package demo

import java.awt.Color
import javax.swing.text.*

class DemoModel {
    @Bindable String status

    private static final Map<String, Color> COLORS = [
        TRACE: Color.BLACK,
        DEBUG: new Color(0, 160, 0),
        INFO:  Color.BLUE,
        WARN: new Color(255, 0, 255),
        ERROR: Color.RED
    ]

    Document messages
    def console
    
    void appendMessage(String level, String message) {
        if(!messages) return
        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
                                            StyleConstants.Foreground,
                                            COLORS[level.toUpperCase()])
        messages.insertString(messages.length, message, aset)
        console.setCharacterAttributes(aset, false)
    }

    void mvcGroupInit(Map args) {
         status = "Welcome to ${GriffonNameUtils.capitalize(app.getMessage('application.title'))}"
    }
}
