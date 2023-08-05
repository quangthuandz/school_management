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
import model.Result;
import model.UniversityClass;

/**
 *
 * @author ADMIN
 */
public class PRJ301ResultController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Result r = new Result();
        UniversityClass u = new UniversityClass();
        ArrayList<Result> data = r.getListResult();
        ArrayList<UniversityClass> dataClass = u.getListClassSE();
        HttpSession session = req.getSession();
        session.setAttribute("PRJ301result", data);
        session.setAttribute("resultClass", dataClass);
        resp.sendRedirect("/EOS_ADMIN/PRJ301_Result.jsp");
    }

    
}
