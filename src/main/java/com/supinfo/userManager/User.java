package com.supinfo.userManager;

import org.owasp.encoder.Encode;

class User {
    private  int id;
    private final String email;
    private String pseudo;
    private String password;
    private String role;

    public User(String email, String pseudo, String password, String role) {
        this.id = id;
        this.email = Encode.forHtml(email);
        this.pseudo = Encode.forHtml(pseudo);
        this.password = Encode.forHtml(password);
        this.role = role.toUpperCase();
    }

    public User(String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role.toUpperCase();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = Encode.forHtml(pseudo);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Encode.forHtml(password);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role.toUpperCase();
    }
}
