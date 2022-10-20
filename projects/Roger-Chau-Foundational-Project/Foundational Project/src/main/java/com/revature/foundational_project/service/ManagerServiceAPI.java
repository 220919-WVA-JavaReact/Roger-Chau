package com.revature.foundational_project.service;

import com.revature.foundational_project.dao.ManagerDAO;
import com.revature.foundational_project.dao.ManagerDAOImpl;
import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.models.Manager;

public class ManagerServiceAPI {
    ManagerDAO md = new ManagerDAOImpl();

    public Manager login(String username, String password){
        Manager manage = md.getByUsername(username);
        if (manage.getPassword().equals(password)){
            System.out.println("Welcome " + manage.getFirst_name());
            return manage;
        } else {
            System.out.println("The password you provided does not match your credentials.");
            return null;
        }
    }

    public Manager register(String first_name, String last_name, String username, String password){
        Manager manage = md.createManager(first_name, last_name, username, password);
        if (manage.getManager_username() == null) {
            return null;
        } else {
            System.out.println("You have successfully registered!");
            return manage;
        }
    }
}
