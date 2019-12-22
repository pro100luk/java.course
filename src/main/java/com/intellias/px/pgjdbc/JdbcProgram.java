package com.intellias.px.pgjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcProgram {
    public static void main(String[] args) throws SQLException {
//        Class.forName()
        Connection connection = DriverManager.getConnection("jdbc:h2:~/test");
        Statement statement = connection.createStatement();
        int updatedCount = statement.executeUpdate("create table users (id integer , name varchar (255), password  varchar (255))");
        System.out.println("Updated" + updatedCount);

    }
}
