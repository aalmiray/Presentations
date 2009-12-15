package griffon.slideware

import groovy.beans.Bindable

class CodeEditorModel {
    @Bindable String script = ""
    @Bindable boolean busy = false
    @Bindable def document

    def outputWindow
    Map styles = [:]
}