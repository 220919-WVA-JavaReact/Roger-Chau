package com.revature.foundational_project.dao;

import com.revature.foundational_project.models.Employee;
import com.revature.foundational_project.util.ConnectionUtil;

import java.sql.*;

public class EmployeeDAOImpl implements EmployeeDAO{
    @Override
    public Employee getByUsername(String username) {
        Employee employ = new Employee();

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM employee WHERE username = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, username);

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null){
                rs.next();

                int id = rs.getInt("employee_id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String receivedUsername = rs.getString("username");
                String password = rs.getString("password");

                employ = new Employee(id,first,last,receivedUsername,password);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return employ;
    }

    @Override
    public Employee createEmployee(String first_name, String last_name, String username, String password) {
        Employee employ = new Employee();

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO employee (first_name, last_name, username, password) VALUES (?,?,?,?) RETURNING *";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, username);
            stmt.setString(4, password);

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null){
                rs.next();

                int id = rs.getInt("employee_id");
                String receivedFirst = rs.getString("first_name");
                String receivedLast = rs.getString("last_name");
                String receivedUsername = rs.getString("username");
                String receivedPassword = rs.getString("password");

                employ = new Employee(id, receivedFirst, receivedLast, receivedUsername, receivedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong! We couldn't register you to the database!");
        }
        return employ;
    }
}
