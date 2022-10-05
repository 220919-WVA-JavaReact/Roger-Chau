package com.revature.foundational_project.models;

import java.util.Objects;

public class Manager {
    private String manager_username;
    private String password;

    public Manager(String manager_username, String password) {
        this.manager_username = manager_username;
        this.password = password;
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
                "manager_username='" + manager_username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return manager_username.equals(manager.manager_username) && password.equals(manager.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manager_username, password);
    }
}
