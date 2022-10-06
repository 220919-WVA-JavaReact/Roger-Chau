package com.revature.foundational_project.dao;

import com.revature.foundational_project.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getByUsername(String username);

    Employee createEmployee(String first_name, String last_name, String username, String password);
}
