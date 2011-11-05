package demo

import net.sourceforge.gvalidation.annotation.Validatable
import griffon.transform.PropertyListener
import static griffon.util.GriffonNameUtils.isBlank

@Validatable
@PropertyListener(enabler)
class LoginModel {
    @Bindable String username
    @Bindable String password
    @Bindable boolean enabled
    
    static constraints = {
        username(size: 6..15)
        password(size: 6..15)
    }
    
    private enabler = { e ->
        if(e.propertyName == 'username' || e.propertyName == 'password') {
            enabled = !isBlank(username) && !isBlank(password)
        }
    }
}
