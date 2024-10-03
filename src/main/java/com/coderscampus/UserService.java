package com.coderscampus;

import java.util.Scanner;

public class UserService {
    private User[] userList = new User[4];

    public UserService () {
        loadUsers();

        //Uncomment to see the different users
       // System.out.println(Arrays.toString(userList));
    }
    private void loadUsers() {
        FileService fileService = new FileService();
        userList = fileService.readUsersFromFile();
    }
    public User validateUsers(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {

                return user;
            }
        }
        return null;
    }

    public void handleUserLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, please login...");
        int loginAttempts = 0;
        int maxAttempts = 5;

        while (loginAttempts < maxAttempts) {
            System.out.println("Enter your email: ");
            String username = scanner.nextLine();

            System.out.println("Enter your password: ");
            String password = scanner.nextLine();
           User validUser = validateUsers(username, password);
            if (validUser != null) {
                System.out.println("Welcome: " + validUser.getName());
                break;
            } else{
                loginAttempts++;
                if (loginAttempts == maxAttempts) {
                    System.out.println("Too many invalid logins. You are now locked out.");
                    break;
                } else {
                    System.out.println("Invalid login, try again.");

                }
            }
        }
        scanner.close();
    }
}
