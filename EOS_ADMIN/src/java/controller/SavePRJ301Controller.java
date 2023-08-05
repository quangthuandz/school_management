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
import java.util.ArrayList;
import model.PRJ301;

/**
 *
 * @author ADMIN
 */
public class SavePRJ301Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PRJ301 p1 = new PRJ301();
        ArrayList<PRJ301> data = p1.getListQuestion();
        String error = "";
        HttpSession session = req.getSession();
        if (data.size() < 10) {
            error = "Number of questions must be greater than 10";
            session.setAttribute("error", error);
            resp.sendRedirect("PRJ301");
        } else {
            session.removeAttribute("error");
//            req.setAttribute("dataPRJ301", data);
            session.setAttribute("examDetail", data);
            resp.sendRedirect("createexam");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("createexam");
    }

}
