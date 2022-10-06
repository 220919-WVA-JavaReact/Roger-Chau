package com.revature.foundational_project;

import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.models.Manager;
import com.revature.foundational_project.service.EmployeeService;
import com.revature.foundational_project.service.TicketService;

import java.util.Scanner;

public class App {

    public static EmployeeService es = new EmployeeService();

    public static TicketService ts = new TicketService();

    public static void main(String[] args) {
        System.out.println("Press 1 if you are an employee. Press 2 if you are a manager.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();

        if (choice.equals("1")){
            System.out.println("Press 1 to login. Press 2 to register.");
            String c2 = sc.nextLine();
            Employee loggedInEmployee = null;

            if (c2.equals("1")){
                loggedInEmployee = es.login();

                if (loggedInEmployee != null){
                    System.out.println("Press 1 to create a ticket. Press 2 to view all your tickets.");
                    String c3 = sc.nextLine();

                    switch (c3){
                        case "1":
                            ts.createTicket(loggedInEmployee);
                            break;
                        case "2":
                            ts.getTicketByID();
                    }
                }

            } else if(c2.equals("2")){
                loggedInEmployee = es.register();
            }

        } else if (choice.equals("2")){
//            System.out.println("Press 1 to login. Press 2 to register.");
//            String c2 = sc.nextLine();
//            Manager loggedInManager = null;
//
//            if (c2.equals("1")){
//                loggedInManager = ms.login();
//            } else if(c2.equals("2")){
//                loggedInManager = ms.register;
//            }

        }
    }
}
