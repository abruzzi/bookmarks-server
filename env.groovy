environments {
    dev {
        flywayProperties {
            url = 'jdbc:mysql://localhost:3306'
            user = 'root'
            password = 'password'
            schemas = ['bookmarks']
            locations = ['classpath:db.migration']
        }
    }

    staging {
        flywayProperties {
            driver = "org.postgresql.Driver"
            url = "${JDBC_DATABASE_URL}"
            locations = ['classpath:db.migration']
        }
    }
}