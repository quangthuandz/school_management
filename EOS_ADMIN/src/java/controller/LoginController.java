/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.User;

/**
 *
 * @author ADMIN
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String val="";
        if(username=="" || password==""){
            val = "Please input username or password";
        }
        User u = new User(username, password);
        User u1 = u.checkUser();
        String error = "Wrong username or password";
        if (u1 != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", u1);
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        } else {
            req.setAttribute("val", val);
            req.setAttribute("error", error);
            req.getRequestDispatcher("Login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("user");
        req.getRequestDispatcher("Login.jsp").forward(req, resp);
    }

}
