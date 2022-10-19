package com.revature.foundational_project.service;

import com.revature.foundational_project.dao.EmployeeDAO;
import com.revature.foundational_project.dao.EmployeeDAOImpl;
import com.revature.foundational_project.models.Employee;

public class EmployeeServiceAPI {
    EmployeeDAO ed = new EmployeeDAOImpl();

    public Employee login(String username, String password){
        Employee employ = ed.getByUsername(username);
        if (employ.getPassword().equals(password)){
            System.out.println("Welcome " + employ.getFirst_name());
            return employ;
        } else {
            System.out.println("The password you provided does not match your credentials.");
            return null;
        }
    }

    public Employee register(String first_name, String last_name, String username, String password){
        Employee employ = ed.createEmployee(first_name, last_name, username, password);
        if (employ.getEmployee_id() != 0) {
            System.out.println("You have successfully registered!");
            return employ;
        } else {
            return null;
        }
    }
}
