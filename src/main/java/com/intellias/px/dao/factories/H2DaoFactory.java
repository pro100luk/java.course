package com.intellias.px.dao.factories;

import com.intellias.px.dao.DaoFactory;
import com.intellias.px.dao.H2UserDao;
import com.intellias.px.dao.UserDao;

public class H2DaoFactory implements DaoFactory {

    @Override
    public UserDao createUserDao(){
        return new H2UserDao();
    }

    @Override
    public OrderDao createOrderDao(){
        return new H2UOrderDao();
    }



}


