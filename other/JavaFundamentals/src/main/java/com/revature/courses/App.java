package com.revature.courses;

import com.revature.courses.models.Teacher;
import com.revature.courses.service.TeacherService;

import java.util.Scanner;

public class App {

    // Inside of my App class is all of the information and logic to start and run the application
    // Menu logic should be here and this should call upon the SERVICE layer to do any logic for us

    // Very similarly to our service layer, when we want logic done we will need an instance of our service layer so let's create it here

    public static TeacherService ts = new TeacherService();

    public static void main(String[] args) {
        // In this app this will be the ONLY main method I have
        // So let's create a teacher object and print it

//        Teacher teach = new Teacher(1,"Bryan","Serfozo","bserf","password");
//
//        System.out.println(teach);

        /*
        Coming down here we can actually start the application with some sort of menu and loop
         */

        // We'll want to prompt the user to either login or to register

        System.out.println("Press 1 to Login. Press 2 to register");

        Scanner sc = new Scanner(System.in);

        String choice = sc.nextLine();

        // Now we use some control flow to map options to their choices

        if (choice.equals("1")){
            // This is where we get login credentials

            // We need to get the username and password
            System.out.println("Please enter your username");
            String username = sc.nextLine();
            System.out.println("Please enter your password");
            String password = sc.nextLine();

            // Just for testing let's print it out
            // System.out.println("Username: " + username + " Password: " + password);


            // AT THIS POINT we would call our TeacherService Class to handle the logic for signing in!

            ts.login(username, password);


        } else if (choice.equals("2")){
            // This is where we get registration information
            System.out.println("Please enter your First Name");
            String first = sc.nextLine();
            System.out.println("Please enter your Last Name");
            String last = sc.nextLine();
            System.out.println("Please enter your username");
            String username = sc.nextLine();
            System.out.println("Please enter your password");
            String password = sc.nextLine();

            // Now that we have all the information we need we can start talking to our TeacherService class to handle this info


        }
    }
}
