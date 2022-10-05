package com.revature.foundational_project.models;

import java.util.Objects;

public class Employee {

    private int employee_id;
    private String employee_username;
    private String password;

    public Employee(int employee_id, String employee_username, String password) {
        this.employee_id = employee_id;
        this.employee_username = employee_username;
        this.password = password;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_username() {
        return employee_username;
    }

    public void setEmployee_username(String employee_username) {
        this.employee_username = employee_username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", employee_username='" + employee_username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employee_id == employee.employee_id && employee_username.equals(employee.employee_username) && password.equals(employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, employee_username, password);
    }
}
