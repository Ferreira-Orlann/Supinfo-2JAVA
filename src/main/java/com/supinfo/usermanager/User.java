package com.supinfo.usermanager;

import lombok.Getter;
import lombok.Setter;
import org.owasp.encoder.Encode;

@Getter
@Setter
class User {
    private  int id;
    private final String email;
    private String pseudo;
    private String password;
    private String role;

    public User(int id, String email, String password, String role) {
        this.id = id;
        this.email = Encode.forHtml(email);
        this.password = Encode.forHtml(password);
        this.role = role.toUpperCase();
    }




    public void setPseudo(String pseudo) {
        this.pseudo = Encode.forHtml(pseudo);
    }

    public void setPassword(String password) {
        this.password = Encode.forHtml(password);
    }

    public void setRole(String role) {
        this.role = role.toUpperCase();
    }
}
