package demo

import javax.swing.JOptionPane

class LoginController {
    def model
    def loginService
    
    def cancel = {
        app.shutdown() 
    }

    def login = {
        if(model.validate()) {
            if(loginService.doLogin(model.username, model.password)) {
                app.windowManager.show('mainWindow')
                app.windowManager.hide('loginWindow')
            } else {
                execAsync {
                    JOptionPane.showMessageDialog(
                        app.windowManager.findWindow('loginWindow'),
                        'Invalid login credentials\nPlease try again.',
                        'Login Error',
                        JOptionPane.ERROR_MESSAGE)
                    model.username = ''
                    model.password = ''
                }
            }
        }
    }
}
