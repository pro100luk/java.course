package com.intellias.px.dao;


import com.intellias.px.PXConnectionPool;
import com.intellias.px.entitites.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class H2UserDao implements UserDao  {

    private final PXConnectionPool connectionPool = PXConnectionPool.getInstance();



    @Override
    public Optional<User> findByLogin(String login) {
        try(Connection connection = connectionPool.getConnection();
            PreparedStatement ps  = connection.prepareStatement("select * from USERS where NAME = ?")){
            ps.setString(1,login);
            ResultSet resultSet  = ps.executeQuery();

            while (resultSet.next()){
                int userId  = resultSet.getInt("ID");
                String name = resultSet.getInt("NAME");
                String password = resultSet.getInt("PASSWORD");

                User user = new User();
                user.setId(userId);
                user.setName(name);
                user.setPassword(password);

                return Optional.of(user);
            }

        }catch (SQLException e){
            // todo
        }

        return Optional.empty();
    }

    @Override
    public Optional<User> find(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> create(User entity) {
        return Optional.empty();
    }

    @Override
    public Optional<User> update(User entity) {
        return Optional.empty();
    }

    @Override
    public Optional<User> delete(User entity) {
        return Optional.empty();
    }
}
