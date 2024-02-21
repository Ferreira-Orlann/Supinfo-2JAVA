package com.supinfo.database;

import liquibase.Liquibase;
import liquibase.Scope;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public record H2DatabaseBuilder(String path, String user, String password) implements DatabaseConnectionBuilder {
    @Override
    public Connection buildConnection() throws SQLException {
        Map<String, Object> config = new HashMap<>();
        config.put("liquibase.licenseKey", "YOUR_PRO_KEY");
        Connection connection = DriverManager.getConnection("jdbc:h2:" + path, user, password);

        try {
            Scope.child(config, () -> {
                Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
                Liquibase liquibase = new Liquibase("changelog.xml", new ClassLoaderResourceAccessor(), database);
                liquibase.update();
            });
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
