dataSource {
    pooled = false
    driverClassName = "org.hsqldb.jdbcDriver"
    username = "sa"
    password = ""
    tokenizeddl = false // set this to true if using MySQL or any other
                        // RDBMS that requires execution of DDL statements
                        // on separate calls
}
pool {
    maxWait = 60000
    maxIdle = 5
    maxActive = 8
}
environments {
    development {
        dataSource {
            dbCreate = "create" // one of ['create', 'skip']
            url = "jdbc:hsqldb:mem:devDB"
        }
    }
    test {
        dataSource {
            dbCreate = "create"
            url = "jdbc:hsqldb:mem:testDb"
        }
    }
    production {
        dataSource {
            dbCreate = "skip"
            url = "jdbc:hsqldb:file:prodDb;shutdown=true"
        }
    }
}
