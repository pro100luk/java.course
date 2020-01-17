package com.intellias.px.dao.factories;

import com.intellias.px.dao.UserDao;
import com.intellias.px.dao.factories.H2DaoFactory;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

public class H2DaoFactoryTest {

    @Test
    public void shouldCreateNotNullUserDao() {
       H2DaoFactory daoFactory =  new H2DaoFactory();
        UserDao userDao = daoFactory.createUserDao();
        assertNotNull(userDao);
    }
}