class SlidewareGriffonPlugin {
    def version = "0.2"
    def canBeGlobal = false
    def dependsOn = ['transitions':    '0.1.3',
                     'css-builder':    '0.4',
                     'gfx-builder':    '0.2.3',
                     'jide-builder':   '0.2',
                     'swingx-builder': '0.1',
                     'jbusycomponent': '0.2',
                     'glazedlists':    '0.2']

    def author = "Andres Almiray"
    def authorEmail = "aalmiray@users.sourceforge.net"
    def title = "Griffon based slideware"
    def description = '''\\
Griffon based slideware
'''

    // URL to the plugin's documentation
    def documentation = "http://griffon.codehaus.org/Slideware+Plugin"
}
