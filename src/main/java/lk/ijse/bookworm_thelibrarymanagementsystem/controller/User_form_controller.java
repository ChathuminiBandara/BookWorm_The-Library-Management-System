package lk.ijse.bookworm_thelibrarymanagementsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import lk.ijse.bookworm_thelibrarymanagementsystem.dao.UserDAO;

public class User_form_controller {
    private final UserDAO userDAO;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    public User_form_controller(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

   /* @FXML
    private void addUser() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Validate input fields (e.g., check for empty fields)
        if (username.isEmpty() || password.isEmpty()) {
            // Handle empty fields
            return;
        }

        // Call a method from your DAO class to add the user to the database
        User user = new User(username, password); // Assuming User class has a constructor
        userDAO.addUser(user);

        // Optionally, you can display a success message or update the UI
        System.out.println("User added successfully!");
    }

    @FXML
    private void updateUser() {
        int userId = getUserIdFromUI(); // Implement method to get user ID from UI
        User userToUpdate = userDAO.getUserById(userId);
        if (userToUpdate != null) {
            userToUpdate.setUsername(usernameField.getText());
            userToUpdate.setPassword(passwordField.getText());
            userDAO.updateUser(userToUpdate);
            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    @FXML
    private void deleteUser() {
        int userId = getUserIdFromUI(); // Implement method to get user ID from UI
        User userToDelete = userDAO.getUserById(userId);
        if (userToDelete != null) {
            userDAO.deleteUser(userId);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    private int getUserIdFromUI() {
        // Assuming userIdTextField is the TextField where the user enters the ID
        String userIdString = userIdTextField.getText();
        // Parse the input string to an integer
        try {
            return Integer.parseInt(userIdString);
        } catch (NumberFormatException e) {
            // Handle the case where the input is not a valid integer
            return -1; // Return a default value or handle the error as appropriate
        }
    }


    @FXML
    private void getUserById() {
        int userId = getUserIdFromUI(); // Implement method to get user ID from UI
        User user = userDAO.getUserById(userId);
        if (user != null) {
            System.out.println("User found: " + user);
            // Optionally, update UI to display user information
        } else {
            System.out.println("User not found!");
        }
    }

    @FXML
    private void getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        if (!users.isEmpty()) {
            System.out.println("All users:");
            for (User user : users) {
                System.out.println(user);
                // Optionally, update UI to display user information
            }
        } else {
            System.out.println("No users found!");
        }
    }
*/
}
