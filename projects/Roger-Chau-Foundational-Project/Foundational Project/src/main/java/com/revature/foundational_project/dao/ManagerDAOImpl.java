package com.revature.foundational_project.dao;

import com.revature.foundational_project.models.Manager;
import com.revature.foundational_project.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAOImpl implements ManagerDAO{
    @Override
    public Manager getByUsername(String manager_username) {
        Manager manage = new Manager();

        try (Connection conn = ConnectionUtil.getConnection()){
            String sql = "SELECT * FROM manager WHERE manager_username = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, manager_username);

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null){
                rs.next();

                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String receivedUsername = rs.getString("manager_username");
                String password = rs.getString("password");

                manage = new Manager(first,last,receivedUsername,password);
            }
        } catch(SQLException e){
            System.out.println("Sorry! Something went wrong!");
            e.printStackTrace();
        }
        return manage;
    }

    @Override
    public Manager createManager(String first_name, String last_name, String manager_username, String password) {
        Manager manage = new Manager();

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO manager (first_name, last_name, manager_username, password) VALUES (?,?,?,?) RETURNING *";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setString(3, manager_username);
            stmt.setString(4, password);

            ResultSet rs;

            if ((rs = stmt.executeQuery()) != null){
                rs.next();

                String receivedFirst = rs.getString("first_name");
                String receivedLast = rs.getString("last_name");
                String receivedUsername = rs.getString("manager_username");
                String receivedPassword = rs.getString("password");

                manage = new Manager(receivedFirst, receivedLast, receivedUsername, receivedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong! We couldn't register you to the database!");
        }
        return manage;
    }
}
