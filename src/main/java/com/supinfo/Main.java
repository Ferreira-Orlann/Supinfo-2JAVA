package com.supinfo;

import com.supinfo.database.H2DatabaseBuilder;
import com.supinfo.database.Database;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        try (Database db = new Database(new H2DatabaseBuilder("./data/database", "sa", ""))) {

        }
    }
}