/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.now.arifikhsanudin.employeemanager.service;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Arif Ikhsanudin
 */
public class DatabaseService {
    public Connection connection;
    public Statement statement;

    public void config() {
        try {
            System.out.println("Congrats - Seems your MySQL JDBC Driver Registered!");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/netbeans_employee_manager", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
