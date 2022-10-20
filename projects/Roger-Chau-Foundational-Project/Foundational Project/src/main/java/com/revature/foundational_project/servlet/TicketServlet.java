package com.revature.foundational_project.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundational_project.models.Employee;
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
            Employee loggedInEmployee = (Employee) session.getAttribute("auth-user");
            List<Ticket> tickets =  tsp.getTicketByID(loggedInEmployee.getEmployee_id());
            if (tickets != null){
                resp.setStatus(200);
                resp.getWriter().write("Here are all your tickets you have submitted!");
                resp.getWriter().write("\n");
                for (Ticket ticket: tickets){
                    resp.getWriter().write("Ticket ID: " + ticket.getRequest_id() + " " + " | " + " ");
                    resp.getWriter().write("Refund Amount: " + ticket.getRefund_amount() + " " + " | " + " ");
                    resp.getWriter().write("Description: " + ticket.getDescription());
                    resp.getWriter().write("\n");
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
