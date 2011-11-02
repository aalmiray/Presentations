/*
 * This script is executed inside the UI thread, so be sure to  call 
 * long running code in another thread.
 *
 * You have the following options
 * - execOutside { // your code }
 * - execFuture { // your code }
 * - Thread.start { // your code }
 *
 * You have the following options to run code again inside the UI thread
 * - execAsync { // your code }
 * - execSync { // your code }
 */

import groovy.swing.SwingBuilder
import static griffon.util.GriffonApplicationUtils.isMacOSX

SwingBuilder.lookAndFeel((isMacOSX ? 'system' : 'nimbus'), 'gtk', ['metal', [boldFonts: false]])

execSync { 
    println "inside sync"
    println "uiThread ${isUIThread()}"
}
execSync { 
    println "inside async"
    println "uiThread ${isUIThread()}"
}
execOutside { 
    println "inside outside"
    println "uiThread ${isUIThread()}"
}
execFuture { 
    println "inside future"
    println "uiThread ${isUIThread()}"
}
