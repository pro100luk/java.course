package com.intellias.px.pgjdbc;

import com.intellias.px.PXConnectionPool;
import com.intellias.px.entitites.Order;
import com.intellias.px.entitites.Status;
import com.intellias.px.entitites.User;
import org.h2.jdbcx.JdbcConnectionPool;
import org.h2.jdbcx.JdbcDataSource;

import javax.naming.Context;
import javax.sql.DataSource;
import java.sql.*;

public class JdbcProgram {
    public static void main(String[] args) throws SQLException {
//        Class.forName()
        //JDBURL =
        //PASS =
        // name - MyDataSource
//        DataSource dataSource = new JdbcConnectionPool();
//        final Connection myConnection = dataSource.getConnection();
//        myConnection.close();
//        //JDNI
//        Context myCurrentContext = null;
//        (DataSource) myCurrentContext.lookup("MyDataSource");

        PXConnectionPool instance = PXConnectionPool.getInstance();
        final Order order = new Order();
        order.setStatus(Status.NEW);

        User user = new User()
                .setId(0)
                .setName("");



        try(Connection connection = DriverManager.getConnection("jdbc:h2:~/test");
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into USERS(id,name,PASSWORD) values  (?,?,?)")){
            for (int i = 0; i<3; i++){
                preparedStatement.setInt(1,2);
                preparedStatement.setString(2,"anbed"+i);
                preparedStatement.setString(3, "qwerty");
                int updatedCount = statement.executeUpdate("create table users (id integer , name varchar (255),password)")
                System.out.println("Updated: " + updatedCount);
            }

            ResultSet resultSet = statement.executeQuery("select id as myId,name, password from users");
        }
        int updatedCount = statement.executeUpdate("create table users (id integer , name varchar (255), password  varchar (255))");
        System.out.println("Updated" + updatedCount);

    }
}
