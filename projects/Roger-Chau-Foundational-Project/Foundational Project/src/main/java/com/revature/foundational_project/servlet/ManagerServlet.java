package com.revature.foundational_project.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.foundational_project.models.Manager;
import com.revature.foundational_project.service.ManagerServiceAPI;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/manager")
public class ManagerServlet extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    ManagerServiceAPI msp = new ManagerServiceAPI();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("[LOG] - POST request has been received for ManagerServlet at " + LocalDateTime.now());
        HttpSession session;
        if (req.getParameter("action").equals("login")){
            Manager manage = mapper.readValue(req.getInputStream(), Manager.class);
            Manager man = msp.login(manage.getManager_username(), manage.getPassword());
            String payload = mapper.writeValueAsString(man);
            if (payload.equals("null")){
                resp.setStatus(400);
                resp.getWriter().write("Invalid credentials!");
            } else{
                session = req.getSession();
                session.setAttribute("auth-user", man);
                resp.setStatus(200);
                resp.setContentType("application/json");
                resp.getWriter().write(payload);
            }
        } else if (req.getParameter("action").equals("register")){
            Manager manage = mapper.readValue(req.getInputStream(), Manager.class);
            Manager man = msp.register(manage.getFirst_name(), manage.getLast_name(), manage.getManager_username(), manage.getPassword());
            String payload = mapper.writeValueAsString(man);
            if (payload.equals("null")){
                resp.setStatus(400);
                resp.getWriter().write("That username has already been taken!");
            } else{
                resp.setStatus(201);
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
