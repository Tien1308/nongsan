package com.webbanhang.connectionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    //node76977-nongsan.in1.cloudjiffy.net
    //PCGefg09448
    private static final String URL = "jdbc:mysql://localhost:3306/ttcn?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASS = "13082000";

    public static Connection openConnectionDB() {
        Connection conn = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  conn ;
    }

    public static void closeConnection (Connection conn , PreparedStatement ps){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }

}
