package com.supinfo.usermanager;

import com.supinfo.common.event.DefaultEventProducer;
import javafx.scene.control.Alert;
import lombok.RequiredArgsConstructor;

import java.util.UUID;


@RequiredArgsConstructor
public class UserController  extends DefaultEventProducer<UserEventListener>{

    private final UserModel userModel;

    protected User currentUser;

    int nextId = 0;

    public void createAccount(String email, String password) {

        String role ;

        User user = getUserByEmail(email);

        if(user !=null)
        {
            showMessage("Email already exists. Please choose another one.");
            return;
        }

        if (userModel.users.isEmpty()) {
            role = "admin";
        }else {
            role = "user";
        }

        if (email.isEmpty() || password.isEmpty()) {
            showMessage("Email and password are required.");
            return;
        }


        if (isValidEmail(email) && isValidPassword(password)) {
            User newUser = new User(UUID.randomUUID(),email, password, role);
            this.userModel.addUsers(newUser);

            showMessage("Account created successfully.");

        } else {
            showMessage("Invalid email,password");
        }

    }

    public void login(String email, String password) {


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
        for (User user : userModel.users) {
            if (user.getEmail().equals(login)) {
                return user;
            }
        }
        return null;
    }




    protected boolean isCurrentUserAdmin() {
        return currentUser != null && currentUser.getRole().equalsIgnoreCase("admin");
    }

    public void deleteUser() {

        if (currentUser == null) {
            showMessage("No user selected.");
            return;
        }

        if (!isCurrentUserAdmin()) {
            showMessage("You do not have permission to delete users.");
            return;
        }

        this.userModel.removeUsers(currentUser);
        showMessage("User deleted successfully.");

    }

    public void updateUser(String pseudo, String password) {
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

    public void listUsers() {
        StringBuilder sb = new StringBuilder();

        for (User user : userModel.users) {
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




    protected boolean isValidEmail(String email) {
        return email.contains("@");
    }



    protected boolean isValidPassword(String password) {
        return  password.length() >= 8 && password.length() <= 32 ;
    }

    protected void showMessage(String message) {
        System.out.println(message);
    }
}
