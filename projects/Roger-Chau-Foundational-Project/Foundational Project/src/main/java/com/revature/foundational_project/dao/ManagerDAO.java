package com.revature.foundational_project.dao;

import com.revature.foundational_project.models.Manager;

import java.util.List;

public interface ManagerDAO {
    Manager getByUsername(String manager_username);

    Manager createManager(String first_name, String last_name, String manager_username, String password);

    List<Manager> getAllManagers();
}
