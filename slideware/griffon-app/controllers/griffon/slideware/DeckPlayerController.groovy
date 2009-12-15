package griffon.slideware

import java.util.logging.Level
import org.jdesktop.swingx.JXErrorPane
import org.jdesktop.swingx.error.ErrorInfo
import org.codehaus.groovy.runtime.StackTraceUtils

class DeckPlayerController {
    def model
    def view

	def close = { evt = null ->
		view.deckFrame.visible = false
		app.views.DeckOptions.optionsFrame.visible = true
	}

	def runScript = { script, boolean displayOutput = false ->
		doOutside {
			try {
				def output = new GroovyShell().evaluate(script)
				if(displayOutput) {
					println output
				}
			} catch(x) {
				StackTraceUtils.deepSanitize(x)
                edt {
					ErrorInfo errorInfo = new ErrorInfo("Error", "Oops! something went wrong while executing your script",
						null, null, exception, Level.WARNING, null)
					JXErrorPane.showDialog(view.deckFrame, errorInfo)
                }

			}
		}
	}
}