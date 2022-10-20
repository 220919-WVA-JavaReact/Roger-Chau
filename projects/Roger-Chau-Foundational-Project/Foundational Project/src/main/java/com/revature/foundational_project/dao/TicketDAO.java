package com.revature.foundational_project.dao;

import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.models.Manager;
import com.revature.foundational_project.models.Ticket;

import java.util.List;

public interface TicketDAO {
    boolean createTicket(Employee employee, int refund_amount, String description);

    List<Ticket> getTicketByID(int employee_id);

    List<Ticket> getPending();

    Ticket updateTicket(int request_id, String username, String status);

    Ticket getTicket(int request_id);
}
