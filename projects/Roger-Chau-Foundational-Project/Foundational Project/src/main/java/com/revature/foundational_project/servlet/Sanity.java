package com.revature.foundational_project.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class Sanity extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LOG] - Servlet received a request at " + LocalDateTime.now());
        System.out.println("[LOG] - Request URI " + req.getRequestURI());
        System.out.println("[LOG] - Request Method " + req.getMethod());
        System.out.println("[LOG] - Request Header, example " + req.getHeader("example"));
        resp.setStatus(200);
        resp.setHeader("Content-type", "text/plain");
        resp.setHeader("example-response-header", "some-example-value");
        resp.getWriter().write("This is the response payload");


    }
}
