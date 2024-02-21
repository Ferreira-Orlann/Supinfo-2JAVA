package com.supinfo.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
public class Database implements AutoCloseable {
    private final Connection conn;
    private final DatabaseConnectionBuilder connBuilder;

    public Database(DatabaseConnectionBuilder connBuilder) throws SQLException {
        this.connBuilder = connBuilder;
        this.conn = connBuilder.buildConnection();
    }

    public PreparedStatement query(String query) throws SQLException {
        return this.conn.prepareStatement(query);
    }

    @Override
    public void close() throws Exception {
        this.conn.close();
    }
}
