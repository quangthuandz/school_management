/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.PRJ301;

/**
 *
 * @author ADMIN
 */
public class DeletePRJ301Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PRJ301 p = new PRJ301();
        p.deleteAll();
        resp.sendRedirect("/EOS_ADMIN/CreateExam.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ques = req.getParameter("questionNo");
        System.out.println(ques);
        PRJ301 p = new PRJ301();
        p.delete(Integer.parseInt(ques));
        resp.sendRedirect("/EOS_ADMIN/PRJ301");
    }

}
