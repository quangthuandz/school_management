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
import model.Subject;
import model.UniversityClass;

/**
 *
 * @author ADMIN
 */
public class PRJ301Controller extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ques = req.getParameter("question");
        String a1 = req.getParameter("a1");
        String a2 = req.getParameter("a2");
        String a3 = req.getParameter("a3");
        String a4 = req.getParameter("a4");
        String correctA = req.getParameter("correct");
        String subjectChoice = req.getParameter("classtocreate");
        String temp="";
        if(subjectChoice.equals("PRJ301")){
            temp="1";
        }
        else if(subjectChoice.equals("MAS291")){
            temp="2";
        }
        else if(subjectChoice.equals("IOT102")){
            temp="3";
        }
        else if(subjectChoice.equals("PRO192")){
            temp="4";
        }
        System.out.println(subjectChoice);
        System.out.println(temp);
        String error = "";      
        if (a1 == "" || a2 == "" || a3 == "" || a4 == "" || ques == "" || correctA == "") {
            error = "Please input all feild";
        } else {
            PRJ301 p = new PRJ301(ques, a1, a2, a3, a4, correctA,Integer.parseInt(temp));
            p.addQuestion();
        }
        PRJ301 p1 = new PRJ301();
        ArrayList<PRJ301> data = p1.getListQuestion();
        req.setAttribute("errorBlank", error);
        req.setAttribute("data", data);
        req.getRequestDispatcher("CreateExam.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PRJ301 p1 = new PRJ301();
        Subject s = new Subject();
        ArrayList<Subject> dataCl = s.getListSubject();
        ArrayList<PRJ301> data = p1.getListQuestion();
        req.setAttribute("data", data);
        req.setAttribute("dataCl", dataCl);
        req.getRequestDispatcher("CreateExam.jsp").forward(req, resp);
        

    }

}
