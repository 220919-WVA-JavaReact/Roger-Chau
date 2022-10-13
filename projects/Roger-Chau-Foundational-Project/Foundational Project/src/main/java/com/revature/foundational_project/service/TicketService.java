package com.revature.foundational_project.service;

import com.revature.foundational_project.dao.TicketDAO;
import com.revature.foundational_project.dao.TicketDAOImpl;
import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.models.Ticket;

import java.util.List;
import java.util.Scanner;

public class TicketService {
    Scanner sc = new Scanner(System.in);

    TicketDAO td = new TicketDAOImpl();

    public void createTicket(Employee employee){
        System.out.println("Please provide the reimbursement amount");
        int refund_amount = Integer.parseInt(sc.nextLine());
        System.out.println("What is the reimbursement for?");
        String description = sc.nextLine();

        boolean successful = td.createTicket(employee, refund_amount, description);

        if (successful){
            System.out.println("Ticket has been submitted");
        } else{
            System.out.println("Ticket failed to submit");
        }
    }

    public void getTicketByID(int employee_id){

        List<Ticket> ticketList = td.getTicketByID(employee_id);

        for(Ticket ticket: ticketList){
            System.out.println("Ticket ID: " + ticket.getRequest_id() + " | Employee ID: " + ticket.getEmployee_id() + " | Amount: $" + ticket.getRefund_amount() + " | Description: " + ticket.getDescription());
        }

    }
}
