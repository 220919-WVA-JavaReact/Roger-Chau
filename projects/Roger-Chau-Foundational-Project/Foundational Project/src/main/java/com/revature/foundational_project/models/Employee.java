package com.revature.foundational_project.models;

import java.util.Objects;

public class Employee {

    private int employee_id;
    private String first_name;
    private String last_name;
    private String username;
    private String password;

    public Employee(int employee_id, String first_name, String last_name, String username, String password) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.username = username;
        this.password = password;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employee_id == employee.employee_id && first_name.equals(employee.first_name) && last_name.equals(employee.last_name) && username.equals(employee.username) && password.equals(employee.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, first_name, last_name, username, password);
    }
}
