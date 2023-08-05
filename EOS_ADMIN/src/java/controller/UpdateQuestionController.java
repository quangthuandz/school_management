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
public class UpdateQuestionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quesNo = req.getParameter("quesNo");
        String ques = req.getParameter("question");
        String a1 = req.getParameter("a1");
        String a2 = req.getParameter("a2");
        String a3 = req.getParameter("a3");
        String a4 = req.getParameter("a4");
        String correctA = req.getParameter("correct");
        PRJ301 p = new PRJ301(Integer.parseInt(quesNo), ques, a1, a2, a3, a4, correctA);
        p.update();
        resp.sendRedirect("PRJ301");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String quesNo = req.getParameter("questionNo");
        PRJ301 p = new PRJ301();
        p.getQuestionByNo(Integer.parseInt(quesNo));
        req.setAttribute("p", p);
        req.getRequestDispatcher("UpdateQuestion.jsp").forward(req, resp);
    }
    
    
}
