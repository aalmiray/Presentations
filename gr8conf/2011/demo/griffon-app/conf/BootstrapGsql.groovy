import groovy.sql.Sql
import demo.MD5

class BootstrapGsql {
    def init = { Sql sql ->
        def users = sql.dataSet('users')
        users.add(id: 1, username: 'wallace', password: MD5.encode('gromit'))
    }

    def destroy = { Sql sql ->
    }
} 
