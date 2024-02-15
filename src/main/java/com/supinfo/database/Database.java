package com.supinfo.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Getter
public class Database {
    private final Connection conn;
    private final DatabaseConnectionBuilder connBuilder;

    Database(DatabaseConnectionBuilder connBuilder) throws SQLException {
        this.connBuilder = connBuilder;
        this.conn = connBuilder.buildConnection();
    }

    public PreparedStatement query(String query, Object... data) throws SQLException {
        return this.conn.prepareStatement(query);
    }
}
