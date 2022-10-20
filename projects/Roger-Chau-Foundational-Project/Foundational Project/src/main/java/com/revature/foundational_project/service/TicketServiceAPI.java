package com.revature.foundational_project.service;

import com.revature.foundational_project.dao.TicketDAO;
import com.revature.foundational_project.dao.TicketDAOImpl;
import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.models.Ticket;

import java.util.List;

public class TicketServiceAPI {
    TicketDAO td = new TicketDAOImpl();
    public boolean createTicket(Employee employee, int refund_amount, String description){
         return td.createTicket(employee, refund_amount, description);
    }

    public List<Ticket> getTicketByID(int employee_id){

        List<Ticket> ticketList = td.getTicketByID(employee_id);

        for(Ticket ticket: ticketList){
            System.out.println("Ticket ID: " + ticket.getRequest_id() + " | Employee ID: " + ticket.getEmployee_id() + " | Amount: $" + ticket.getRefund_amount() + " | Description: " + ticket.getDescription());
        }

        return ticketList;
    }
}
