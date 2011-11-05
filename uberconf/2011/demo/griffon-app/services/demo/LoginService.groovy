package demo

class LoginService {
    boolean doLogin(String username, String password) {
        withSql { dataSourceName, sql ->
            sql.firstRow('SELECT id FROM users WHERE username = ? AND password = ?',
                [username, MD5.encode(password)]) != null 
        }
    }
}