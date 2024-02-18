package com.supinfo.usermanager;


import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
    private final List<User> users;

    private User currentUser;

    //  private List<Store> stores;

    // private List<InventoryItem> inventoryItems;

    public UserModel() {
        users = new ArrayList<>();
        int nextId = 1;
    }

    protected void createAccount(String email, String password) {

        String role ;

        User user = getUserByEmail(email);

        if(user !=null)
        {
            showMessage("Email already exists. Please choose another one.");
            return;
        }

        if (users.isEmpty()) {
            role = "admin";
        }else {
            role = "user";
        }

        if (email.isEmpty() || password.isEmpty()) {
            showMessage("Email and password are required.");
            return;
        }


        if (isValidEmail(email) && isValidPassword(password)) {
            User newUser = new User(email, password, role);
            users.add(newUser);
            showMessage("Account created successfully.");

        } else {
            showMessage("Invalid email,password");
        }



    }


    protected void login(String email, String password) {


        if (email.isEmpty() || password.isEmpty()) {
            showMessage("Email and password are required.");
            return;
        }

        User user = getUserByEmail(email);

        if (user == null) {
            showMessage(" Email or password is invalid ");
            return;
        }

        if (!user.getPassword().equals(password)) {
            showMessage(" Email or password is invalid ");
            return;
        }

        currentUser = user;

        showMessage("Login successful.");
    }

    protected User getUserByEmail(String login) {
        for (User user : users) {
            if (user.getEmail().equals(login)) {
                return user;
            }
        }
        return null;
    }




    protected boolean isCurrentUserAdmin() {
        return currentUser != null && currentUser.getRole().equalsIgnoreCase("admin");
    }

    protected void deleteUser() {

        if (currentUser == null) {
            showMessage("No user selected.");
            return;
        }

        if (!isCurrentUserAdmin()) {
            showMessage("You do not have permission to delete users.");
            return;
        }

        users.remove(currentUser);
        showMessage("User deleted successfully.");

    }

    protected void updateUser(String pseudo, String password) {
        if (currentUser == null) {
            showMessage("No user selected.");
            return;
        }

        if (!isCurrentUserAdmin()) {
            showMessage("You do not have permission to update users.");
            return;
        }

        currentUser.setPseudo(pseudo);
        currentUser.setPassword(password);
        showMessage("User updated successfully.");
    }

    protected void listUsers() {
        StringBuilder sb = new StringBuilder();

        for (User user : users) {
            sb.append(user.getId()).append(": ").append(user.getEmail()).append(" (").append(user.getRole()).append(")\n");
            if (isCurrentUserAdmin()) {
                sb.append("Password: ").append(user.getPassword()).append("\n");
            }
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("List of Users");
        alert.setHeaderText("Here are the current users:");
        alert.setContentText(sb.toString());
        alert.showAndWait();
    }

    private void createStore() {
        if (currentUser == null) {
            showMessage("No user selected.");
            return;
        }

        if (!isCurrentUserAdmin()) {
            showMessage("You do not have permission to create store.");
            return;
        }


        //  Store newStore = new Store();
        //  stores.add(newStore);
        showMessage("Store created successfully.");

    }

    private void createInventoryItem() {
        if (currentUser == null) {
            showMessage("No user selected.");
            return;
        }

        if (!isCurrentUserAdmin()) {
            showMessage("You do not have permission to create store.");
            return;
        }
        // InventoryItem newInventoryItem = new InventoryItem();
        //  inventoryItems.add(newInventoryItem);
        showMessage("Inventory item created successfully.");

    }


    protected boolean isValidEmail(String email) {
        return email.contains("@");
    }



    protected boolean isValidPassword(String password) {
        return  password.length() >= 8 && password.length() <= 32 ;
    }



    protected void showMessage(String message) {
        //messageLabel.setText(message);
    }

   /* private void clearForm() {
        emailField.clear();
        pseudoField.clear();
        passwordField.clear();
        roleField.clear();
        currentUser = null;
        showMessage("");
    }*/
}


