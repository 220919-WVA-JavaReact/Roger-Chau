package com.revature.foundational_project.service;

import com.revature.foundational_project.dao.ManagerDAO;
import com.revature.foundational_project.dao.ManagerDAOImpl;
import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.models.Manager;

import java.util.Scanner;

public class ManagerService {
    ManagerDAO md = new ManagerDAOImpl();

    Scanner sc = new Scanner(System.in);

    public Manager login(){
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();

        Manager manage = md.getByUsername(username);

        if(manage.getPassword().equals(password)){
            System.out.println("Login was successful");
            System.out.println("Welcome " + manage.getFirst_name());

            return manage;
        } else{
            System.out.println("Invalid password");
            return null;
        }
    }

    public Manager register(){
        System.out.println("First name");
        String first_name = sc.nextLine();
        System.out.println("Last name");
        String last_name = sc.nextLine();
        System.out.println("Username");
        String manager_username = sc.nextLine();
        System.out.println("Password");
        String password = sc.nextLine();

        Manager manage = md.createManager(first_name, last_name, manager_username, password);

        return manage;
    }
}
