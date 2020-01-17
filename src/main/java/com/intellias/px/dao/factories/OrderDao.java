package com.intellias.px.dao.factories;

import com.intellias.px.dao.Dao;
import com.intellias.px.entitites.User;

import java.util.Optional;

public interface OrderDao extends Dao<User, Integer> {


    Optional<Order> findByLogin(String login);

}
