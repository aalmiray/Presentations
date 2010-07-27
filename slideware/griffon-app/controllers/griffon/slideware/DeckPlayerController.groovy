/*
 * Copyright 2009-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.slideware

import java.util.logging.Level
import org.jdesktop.swingx.JXErrorPane
import org.jdesktop.swingx.error.ErrorInfo
import org.codehaus.groovy.runtime.StackTraceUtils

/**
 * @author Andres.Almiray
 */
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
