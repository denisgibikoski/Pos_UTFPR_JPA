/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.denis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author denis
 */
public class ConnectionFactory {

    String url = "jdbc:postgresql://localhost:5432/Pos-Java";

    String user = "root";

    String pass = "root";

    Connection db;

    public Connection getConnection() throws SQLException {

        return this.db = DriverManager.getConnection(url, user, pass);
        

    }

}
