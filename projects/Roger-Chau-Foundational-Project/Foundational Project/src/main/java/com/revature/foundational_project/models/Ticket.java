package com.revature.foundational_project.models;

import java.util.Objects;

public class Ticket {

    private int request_id;
    private int employee_id;
    private int refund_amount;
    private String description;

    private String status;

    private String manager_username;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManager_username() {
        return manager_username;
    }

    public void setManager_username(String manager_username) {
        this.manager_username = manager_username;
    }

    public Ticket(int request_id, int employee_id, int refund_amount, String description) {
        this.request_id = request_id;
        this.employee_id = employee_id;
        this.refund_amount = refund_amount;
        this.description = description;
    }

    public Ticket(int employee_id, int refund_amount, String description) {
        this.employee_id = employee_id;
        this.refund_amount = refund_amount;
        this.description = description;
    }

    public Ticket() {

    }

    public Ticket(int request_id, int employee_id, int refund_amount, String description, String status, String manager_username) {
        this.request_id = request_id;
        this.employee_id = employee_id;
        this.refund_amount = refund_amount;
        this.description = description;
        this.status = status;
        this.manager_username = manager_username;
    }

    public Ticket(int request_id, String manager_username, String status) {
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

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getRefund_amount() {
        return refund_amount;
    }

    public void setRefund_amount(int refund_amount) {
        this.refund_amount = refund_amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "request_id=" + request_id +
                ", employee_id=" + employee_id +
                ", refund_amount=" + refund_amount +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return request_id == ticket.request_id && employee_id == ticket.employee_id && refund_amount == ticket.refund_amount && description.equals(ticket.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(request_id, employee_id, refund_amount, description);
    }
}
