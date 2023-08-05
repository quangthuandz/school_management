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
import model.Student;
import model.UniversityClass;

/**
 *
 * @author Admin
 */
public class StudentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classchoice = req.getParameter("classchoice");
        Student s = new Student();
        System.out.println(classchoice);
        if (classchoice.equals("All")) {
            Student s1 = new Student();
            ArrayList<Student> dataStudent = s1.getListStudent();
            UniversityClass u = new UniversityClass();
            ArrayList<UniversityClass> classData = u.getListClass();
            HttpSession session = req.getSession();
            session.setAttribute("dataclass", classData);
            req.setAttribute("dataStudent", dataStudent);
            req.setAttribute("classchoice", classchoice);
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        } else {
            ArrayList<Student> dataStudent = s.getStudentInClass(Integer.parseInt(classchoice));
            UniversityClass u = new UniversityClass();
            ArrayList<UniversityClass> classData = u.getListClass();
            HttpSession session = req.getSession();
            session.setAttribute("dataclass", classData);
            req.setAttribute("dataStudent", dataStudent);
            req.setAttribute("classchoice", classchoice);
            req.getRequestDispatcher("Home.jsp").forward(req, resp);
        }
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student();
        ArrayList<Student> dataStudent = s.getListStudent();
        UniversityClass u = new UniversityClass();
        ArrayList<UniversityClass> classData = u.getListClass();
        req.setAttribute("dataClass", classData);
        req.setAttribute("dataStudent", dataStudent);
        req.getRequestDispatcher("Home.jsp").forward(req, resp);
    }
}
