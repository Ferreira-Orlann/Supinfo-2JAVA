package com.supinfo.usermanager;


import com.supinfo.database.Database;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UserModel {
    private final Database db;

    public final List<User> users = new ArrayList<>();

    private final List<UserEventListener> listeners = new ArrayList<>();


    public void addUsers(User addusers) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("INSERT INTO users(id, pseudo, email, password, role) VALUES (?,?,?,?,?)");
            ps.setString(1, addusers.getId().toString());
            ps.setString(2, addusers.getPseudo());
            ps.setString(3, addusers.getEmail());
            ps.setString(4, addusers.getPassword());
            ps.setString(5, addusers.getRole());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
        }
    }

    public void updateUsers(User updateUsers){

    }

    public void removeUsers(User removeUsers){
        PreparedStatement ps = null;
        try {
            ps = this.db.query("DELETE FROM stores_users WHERE user_id = ?");
            ps.setString(1, removeUsers.getId().toString());
            ResultSet rs = ps.executeQuery();

            ps = this.db.query("DELETE FROM users WHERE id = ?");
            ps.setString(1, removeUsers.getId().toString());
            rs = ps.executeQuery();
        } catch (SQLException e) {
        }
    }

    public boolean whitelistEmail(String email) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("INSERT INTO whitelisted_emails(email) VALUES (?)");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean unwhitelistEmail(String email) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("DELETE FROM whitelisted_emails WHERE email = ?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}


