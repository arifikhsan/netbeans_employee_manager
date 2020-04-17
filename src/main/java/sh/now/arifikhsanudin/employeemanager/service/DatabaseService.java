/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sh.now.arifikhsanudin.employeemanager.service;

import javax.swing.*;
import java.sql.*;

/**
 * @author Arif Ikhsanudin
 */
public class DatabaseService {
    public Connection connection;
    public Statement statement;

    public void config() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/netbeans_employee_manager", "root", "");
            statement = connection.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public Boolean addEmployee(String identityNumber, String name, Integer roleId, Integer salary) {
        try {
            String query = String.format("INSERT INTO employees (`id_number`, `name`, `role`, `salary`) " +
                    "VALUES ('%s', '%s', %d, %d)", identityNumber, name, roleId, salary);
            return statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Boolean removeEmployee(Integer id) {
        try {
            String query = String.format("DELETE FROM employees WHERE id = %d", id);
            return statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public ResultSet showAll() {
        try {
            return statement.executeQuery("SELECT * from employees");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Boolean updateEmployee(Integer id, String idNumber, String name, Integer roleId, Integer salary) {
        try {
            String query = String.format("UPDATE `employees` SET " +
                    "`id_number` = '%s', `name` = '%s', `role` = %d, `salary` = %d " +
                    "WHERE id = %d", idNumber, name, roleId, salary, id);
            System.out.println(query);
            return statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
