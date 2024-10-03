package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
    public User[] readUsersFromFile() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("data.txt"))) {
            User[] userList = new User[4];
            String line;
            int i = 0;

            while ((line = fileReader.readLine()) != null) {
                String[] userData = line.split(",");

                String username = userData[0];
                String password = userData[1];
                String name = userData[2];

                User user = new User(username, password, name);
                userList[i] = user;
                i++;
            }
            return userList;
        }catch (IOException e) {
            System.out.println("Error: unable to read data from 'data.txt' ");
        }
        return null;
    }

}
