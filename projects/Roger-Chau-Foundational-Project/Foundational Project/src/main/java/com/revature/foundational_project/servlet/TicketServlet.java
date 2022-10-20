package com.revature.foundational_project.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.models.Manager;
import com.revature.foundational_project.models.Ticket;
import com.revature.foundational_project.service.EmployeeServiceAPI;
import com.revature.foundational_project.service.ManagerServiceAPI;
import com.revature.foundational_project.service.TicketServiceAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ticket")
public class TicketServlet extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    TicketServiceAPI tsp = new TicketServiceAPI();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null){
            resp.setStatus(400);
            resp.setContentType("application/json");
            resp.getWriter().write("Please login to view your tickets!");
        } else {
            if (session.getAttribute("auth-user").getClass().equals(Employee.class)) {
                Employee loggedInEmployee = (Employee) session.getAttribute("auth-user");
                if (req.getParameter("action").equals("get-my-tickets")) {
                    List<Ticket> tickets = tsp.getTicketByID(loggedInEmployee.getEmployee_id());
                    if (tickets != null) {
                        resp.setStatus(200);
                        resp.getWriter().write("Here are all your tickets you have submitted!");
                        resp.getWriter().write("\n");
                        for (Ticket ticket : tickets) {
                            resp.getWriter().write("Ticket ID: " + ticket.getRequest_id() + " " + " | " + " ");
                            resp.getWriter().write("Refund Amount: " + ticket.getRefund_amount() + " " + " | " + " ");
                            resp.getWriter().write("Description: " + ticket.getDescription());
                            resp.getWriter().write("\n");
                        }
                    }
                } else if (req.getParameter("action").equals("get-pending-tickets")){
                    resp.getWriter().write("You must be logged in as a manager!");
                    resp.setStatus(400);
                }
            } else if (session.getAttribute("auth-user").getClass().equals(Manager.class)){
                if (req.getParameter("action").equals("get-pending-tickets")) {
                    List<Ticket> tickets = tsp.getPending();
                    if (tickets != null) {
                        resp.setStatus(200);
                        resp.getWriter().write("Displaying all pending tickets:");
                        resp.getWriter().write("\n");
                        for (Ticket ticket : tickets) {
                            resp.getWriter().write("Ticket ID: " + ticket.getRequest_id() + " " + " | " + " ");
                            resp.getWriter().write("Employee ID: " + ticket.getEmployee_id() + " " + " | " + " ");
                            resp.getWriter().write("Refund Amount: " + ticket.getRefund_amount() + " " + " | " + " ");
                            resp.getWriter().write("Description: " + ticket.getDescription() + " " + " | " + " ");
                            resp.getWriter().write("Status: " + ticket.getStatus() + " " + " | " + " ");
                            resp.getWriter().write("Manager assigned: " + ticket.getManager_username());
                            resp.getWriter().write("\n");
                        }
                    }
                } else if (req.getParameter("action").equals("get-my-tickets")){
                    resp.getWriter().write("Dummy you don't have tickets");
                    resp.setStatus(400);
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null){
            resp.setStatus(400);
            resp.setContentType("application/json");
            resp.getWriter().write("Please login to submit a ticket");
        } else {
            Employee loggedInEmployee = (Employee) session.getAttribute("auth-user");
            Ticket ticket = mapper.readValue(req.getInputStream(), Ticket.class);
            resp.setStatus(201);
            boolean payload = tsp.createTicket(loggedInEmployee, ticket.getRefund_amount(), ticket.getDescription());
            if (payload){
                resp.getWriter().write("Ticket has been successfully created");
            } else{
                resp.getWriter().write("Failed to submit ticket");
            }
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
