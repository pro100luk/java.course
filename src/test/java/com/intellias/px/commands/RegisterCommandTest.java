package com.intellias.px.commands;

import com.intellias.px.dao.DaoFactory;
import com.intellias.px.dao.UserDao;
import com.intellias.px.entitites.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class RegisterCommandTest {

    @Test
    public void shouldRegisterUser(){


       //Mock dao factory and DAOs
        DaoFactory daoFactory = PowerMockito.mock(DaoFactory.class);
        UserDao userDao = PowerMockito.mock(UserDao.class);

        Mockito.when(daoFactory.createUserDao()).thenReturn(userDao);

        Command registerCommand = new RegisterCommand(daoFactory);


        HttpServletRequest httpServletRequest = PowerMockito.mock(HttpServletRequest.class);
        HttpServletResponse httpServletResponse = PowerMockito.mock(HttpServletResponse.class);


        //execute logic
        String pageToRedirect = registerCommand.execute(httpServletRequest, httpServletResponse);


        //test
        Assert.assertEquals("main.jsp", pageToRedirect);
        Mockito.verify(daoFactory).createUserDao();
        Mockito.verify(userDao).create(Mockito.notNull(User.class));

        Mockito.verify(httpServletRequest).getParameter("username");
    }
}
