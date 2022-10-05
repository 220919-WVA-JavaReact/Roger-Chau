package com.revature.foundational_project.models;

import java.util.Objects;

public class Status {

    private int request_id;
    private String manager_username;
    private String status;

    public Status(int request_id, String manager_username, String status) {
        this.request_id = request_id;
        this.manager_username = manager_username;
        this.status = status;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getManager_username() {
        return manager_username;
    }

    public void setManager_username(String manager_username) {
        this.manager_username = manager_username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Status{" +
                "request_id=" + request_id +
                ", manager_username='" + manager_username + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status1 = (Status) o;
        return request_id == status1.request_id && manager_username.equals(status1.manager_username) && status.equals(status1.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request_id, manager_username, status);
    }
}
