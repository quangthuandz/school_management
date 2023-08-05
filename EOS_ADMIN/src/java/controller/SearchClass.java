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
import java.util.ArrayList;
import model.UniversityClass;

/**
 *
 * @author Admin
 */
public class SearchClass extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchclass = req.getParameter("searchclass");
        UniversityClass c = new UniversityClass();
        ArrayList<UniversityClass> data = c.getListClassByName(searchclass);
        String error="";
        if(data.isEmpty()){
            error="No data :(";
        }
        req.setAttribute("error", error);
        req.setAttribute("data", data);
        req.getRequestDispatcher("Home.jsp").forward(req, resp);
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    
    
}
