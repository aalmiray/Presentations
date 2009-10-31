class SlidewareGriffonPlugin {
    def version = 0.1
    def canBeGlobal = false
    def dependsOn = ['transitions':    '0.1.2',
                     'css-builder':    '0.2',
                     'gfx-builder':    '0.2.1',
                     'jide-builder':   '0.2',
                     'swingx-builder': '0.1',
                     'jbusycomponent': '0.1']

    def author = "Andres Almiray"
    def authorEmail = "aalmiray@users.sourceforge.net"
    def title = "Griffon based slideware"
    def description = '''\\
Griffon based slideware
'''

    // URL to the plugin's documentation
    def documentation = "http://griffon.codehaus.org/Slideware+Plugin"
}
