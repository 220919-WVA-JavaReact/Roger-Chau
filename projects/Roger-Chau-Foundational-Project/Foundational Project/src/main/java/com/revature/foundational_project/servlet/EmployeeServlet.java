package com.revature.foundational_project.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundational_project.dao.EmployeeDAO;
import com.revature.foundational_project.dao.EmployeeDAOImpl;
import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.service.EmployeeServiceAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.time.LocalDateTime;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

    ObjectMapper mapper = new ObjectMapper();
    EmployeeDAO ed = new EmployeeDAOImpl();
    EmployeeServiceAPI esp = new EmployeeServiceAPI();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee receivedEmployee = new Employee();

        String empPayload = mapper.writeValueAsString(receivedEmployee);

        resp.setStatus(200);
        resp.setContentType("application/json");
        resp.getWriter().write(empPayload);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG] - POST request has been received for EmployeeServlet at " + LocalDateTime.now());
        HttpSession session;
        if (req.getParameter("action").equals("login")){
            Employee employ = mapper.readValue(req.getInputStream(), Employee.class);
            Employee empl = esp.login(employ.getUsername(), employ.getPassword());
            String payload = mapper.writeValueAsString(empl);
            if (payload.equals("null")){
                resp.setStatus(400);
                resp.getWriter().write("Invalid credentials!");
            } else{
                session = req.getSession();
                session.setAttribute("auth-user", payload);
                resp.setStatus(200);
                resp.setContentType("application/json");
                resp.getWriter().write(payload);
            }
        } else if (req.getParameter("action").equals("register")){
            Employee employ = mapper.readValue(req.getInputStream(), Employee.class);
            Employee empl = esp.register(employ.getFirst_name(), employ.getLast_name(), employ.getUsername(), employ.getPassword());
            String payload = mapper.writeValueAsString(empl);
            if (payload.equals("null")){
                resp.setStatus(400);
                resp.getWriter().write("That username has already been taken!");
            } else{

                resp.setStatus(200);
                resp.getWriter().write("You have successfully registered!");
            }
        }

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null){
            session.invalidate();
            resp.getWriter().write("Logged Out");
        }
    }
}
