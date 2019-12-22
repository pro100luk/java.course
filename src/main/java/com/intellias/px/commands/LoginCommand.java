package com.intellias.px.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

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
