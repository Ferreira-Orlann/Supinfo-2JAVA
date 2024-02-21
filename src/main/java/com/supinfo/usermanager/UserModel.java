package com.supinfo.usermanager;


import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class UserModel {


    public final List<User> users = new ArrayList<>();

    private final List<UserEventListener> listeners = new ArrayList<>();


    public void addUsers(User addusers) {

        users.add(addusers);

    }

    public void updateUsers(User updateUsers){

    }

    public void removeUsers(User removeUsers){

        users.remove(removeUsers);

    }
}


