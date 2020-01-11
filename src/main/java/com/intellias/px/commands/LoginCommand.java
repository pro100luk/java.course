package com.intellias.px.commands;

import com.intellias.px.dao.DaoFactory;
import com.intellias.px.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    private final DaoFactory daoFactory;
    public LoginCommand(DaoFactory daoFactory){
        this.daoFactory = daoFactory;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserDao userDao = daoFactory.createUserDao();

        if ("admin".equals(login) && "admin".equals(password)) {

            HttpSession session = request.getSession();
            System.out.println("session" +  session.getId());
            request.setAttribute("user", login);
            return "WEB-INF/main.jsp";
        } else {
            return "oops.html";
        }
    }
}
