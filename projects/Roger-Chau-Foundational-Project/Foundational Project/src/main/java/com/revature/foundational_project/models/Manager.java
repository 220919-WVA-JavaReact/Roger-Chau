package com.revature.foundational_project.models;

import java.util.Objects;

public class Manager {
    private String first_name;
    private String last_name;
    private String manager_username;
    private String password;

    public Manager(String first_name, String last_name, String manager_username, String password) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.manager_username = manager_username;
        this.password = password;
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

    public String getManager_username() {
        return manager_username;
    }

    public void setManager_username(String manager_username) {
        this.manager_username = manager_username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", manager_username='" + manager_username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return first_name.equals(manager.first_name) && last_name.equals(manager.last_name) && manager_username.equals(manager.manager_username) && password.equals(manager.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first_name, last_name, manager_username, password);
    }
}
