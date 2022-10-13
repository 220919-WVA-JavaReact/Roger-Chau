package com.revature.foundational_project.dao;

import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.models.Ticket;
import com.revature.foundational_project.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDAOImpl implements TicketDAO{
    @Override
    public boolean createTicket(Employee employee, int refund_amount, String description) {

        try(Connection conn = ConnectionUtil.getConnection()){
            String sql = "INSERT INTO reimbursement (employee_id, refund_amount, description) VALUES (?,?,?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, employee.getEmployee_id());
            stmt.setInt(2, refund_amount);
            stmt.setString(3, description);

            int rowsUpdated = stmt.executeUpdate();

            try{
                String sql2 = "SELECT request_id FROM reimbursement ORDER BY request_id DESC LIMIT 1";
                PreparedStatement stmt2 = conn.prepareStatement(sql2);
                ResultSet rs;
                if ((rs = stmt2.executeQuery()) != null){
                    rs.next();
                    int request_ID = rs.getInt("request_id");
                    System.out.println(request_ID);

                    String sql3 = "INSERT INTO pending (request_id) VALUES (?)";
                    PreparedStatement stmt3 = conn.prepareStatement(sql3);
                    stmt3.setInt(1, request_ID);

                    stmt3.executeUpdate();
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

            if (rowsUpdated == 1){
                return true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Ticket> getTicketByID(int employee_id) {
        Connection conn = ConnectionUtil.getConnection();

        List<Ticket> tickets = new ArrayList<>();

        try{
            String sql = "SELECT * FROM reimbursement WHERE employee_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, employee_id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                int request_id = rs.getInt("request_id");
                int employeeid = rs.getInt("employee_id");
                int refund_amount = rs.getInt("refund_amount");
                String description = rs.getString("description");

                Ticket ticket = new Ticket(request_id,employeeid,refund_amount,description);

                tickets.add(ticket);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return tickets;
    }
}
