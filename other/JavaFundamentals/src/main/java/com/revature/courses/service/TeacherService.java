package com.revature.courses.service;

import com.revature.courses.dao.TeacherDAO;
import com.revature.courses.dao.TeacherDAOImpl;
import com.revature.courses.models.Teacher;

public class TeacherService {

    // So the role of this class is to provide the logic for options and eventually call upon the DAO to persist the information we request

    // WE have logic for logging in and registering so we should have methods to handle that

    // Whenever we want to make a call to the database we need to provide a TeacherDAO implementation so I'll create one at the class level
    TeacherDAO td = new TeacherDAOImpl(); // <--- Can change the implementation whenever I want

    public void login(String username, String password){
        // The object of this method is to call upon the DAO to get the account associated with our username, then we'll verify the password and "log" the user in


        // Step 1.
        // Call the database and find info based on the submitted username
        Teacher teach = td.getByUsername(username);

        // Step 2.
        // Check the returned password of the username and verify it matches the entered password
        if(teach.getPassword().equals(password)){
            System.out.println("Congratulations after everything you have been logged in!");
            System.out.println(teach);
        } else {
            System.out.println("Invalid login");
        }

    }
}
