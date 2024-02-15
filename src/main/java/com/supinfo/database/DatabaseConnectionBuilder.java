package com.supinfo.database;

import java.sql.Connection;
import java.sql.SQLException;

public interface DatabaseConnectionBuilder {
    public Connection buildConnection() throws SQLException;
}
