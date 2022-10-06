package com.revature.foundational_project.dao;

import com.revature.foundational_project.models.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee getByID(int employee_id);

    Employee createEmployee(int employee_id, String first_name, String last_name, String username, String password);

    List<Employee> getAllEmployees()
}
