package com.intellias.px.commands;

import com.intellias.px.dao.DaoFactory;
import com.intellias.px.dao.UserDao;
import com.intellias.px.entitites.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class RegisterCommand implements Command {

    private final DaoFactory daoFactory;

    public RegisterCommand(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public String  execute(HttpServletRequest request, HttpServletResponse response){
        UserDao userDao = daoFactory.createUserDao();
        Optional<User> user = userDao.create(null);
        return "main.jsp";
    }
}
