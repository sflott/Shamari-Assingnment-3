package com.coderscampus;

import java.util.Scanner;

public class UserLoginApplication {
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        System.out.println("Welcome, please login...");
        int loginAttempts = 0;
        User validUser;

        while (true) {
            System.out.println("Enter your email: ");
            String username = scanner.nextLine();

            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            validUser = userService.getUserCredential(username, password);

            if (validUser != null) {
                System.out.println("Welcome: " + validUser.getName());
                break;
            } else if (loginAttempts == 4) {
                System.out.println("Too many invalid logins. You are now locked out.");
                break;
            } else {
                System.out.println("Invalid login, try again.");
                loginAttempts++;
            }
        }
    }
}
