package com.revature.foundational_project.service;

import com.revature.foundational_project.dao.EmployeeDAO;
import com.revature.foundational_project.dao.EmployeeDAOImpl;
import com.revature.foundational_project.models.Employee;

import java.util.Scanner;

public class EmployeeService {
    EmployeeDAO ed = new EmployeeDAOImpl();

    Scanner sc = new Scanner(System.in);

    public Employee login(){
        System.out.println("Please enter your username");
        String username = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();

        Employee employ = ed.getByUsername(username);

        if(employ.getPassword().equals(password)){
            System.out.println("Login was successful");
            System.out.println("Welcome " + employ.getFirst_name());
            System.out.println("Here is your following info:\n" + employ);

            return employ;
        } else{
            System.out.println("Invalid password");
            return null;
        }
    }

    public Employee register(){
        System.out.println("First name");
        String first_name = sc.nextLine();
        System.out.println("Last name");
        String last_name = sc.nextLine();
        System.out.println("Username");
        String username = sc.nextLine();
        System.out.println("Password");
        String password = sc.nextLine();

        Employee employ = ed.createEmployee(first_name, last_name, username, password);

        return employ;
    }
}
