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

/**
 *
 * @author ADMIN
 */
public class ManageResult extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c = req.getParameter("classchoice");
        String str = "";
        if (c.equals("1")) {
            str = "SE1708";
        } else if (c.equals("2")) {
            str = "SE1721";
        } else if (c.equals("8")) {
            str = "SE1532";
        }
        getServletContext().setAttribute("strValue", str);
        Result r = new Result();
        if (c.equals("All")) {
            ArrayList<Result> data = r.getListResult();
            req.setAttribute("resultInClass", data);
            HttpSession session = req.getSession();
            session.removeAttribute("PRJ301result");
            session.removeAttribute("hello");
            req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
        } else {
            ArrayList<Result> data = r.getListResultByClass(str);
            req.setAttribute("resultInClass", data);
            HttpSession session = req.getSession();
            session.removeAttribute("PRJ301result");
            session.setAttribute("hello", c);
            req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String manage = req.getParameter("manage");
        Result r = new Result();
        HttpSession session = req.getSession();
        String c = req.getParameter("classchoice");
        String str = (String) getServletContext().getAttribute("strValue");
        System.out.println(str);
        if (str != "") {
            if (manage.equals("Normal")) {
                ArrayList<Result> dataNormal = r.getListResult();
                req.setAttribute("resultNormal", dataNormal);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            } else if (manage.equals("IncreasePoint")) {
                ArrayList<Result> dataIncrease = r.getListResultOrderByIncreasePoint(str);
                req.setAttribute("resultIncrease", dataIncrease);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            } else if (manage.equals("DecreasePoint")) {
                ArrayList<Result> dataDecrease = r.getListResultOrderByDecreasePoint(str);
                req.setAttribute("resultDecrease", dataDecrease);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            } else if (manage.equals("Fastesttime")) {
                ArrayList<Result> dataTime = r.getListResultOrderByTime(str);
                req.setAttribute("resultTime", dataTime);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            } else if (manage.equals("BannedStudent")) {
                ArrayList<Result> dataBanned = r.getListResultOfPointZero(str);
                req.setAttribute("resultBanned", dataBanned);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            }
        } else {
            if (manage.equals("Normal")) {
                ArrayList<Result> dataNormal = r.getListResult();
                req.setAttribute("resultNormal", dataNormal);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            } else if (manage.equals("IncreasePoint")) {
                ArrayList<Result> dataIncrease = r.getListResultOrderByIncreasePoint();
                req.setAttribute("resultIncrease", dataIncrease);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            } else if (manage.equals("DecreasePoint")) {
                ArrayList<Result> dataDecrease = r.getListResultOrderByDecreasePoint();
                req.setAttribute("resultDecrease", dataDecrease);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            } else if (manage.equals("Fastesttime")) {
                ArrayList<Result> dataTime = r.getListResultOrderByTime();
                req.setAttribute("resultTime", dataTime);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            } else if (manage.equals("BannedStudent")) {
                ArrayList<Result> dataBanned = r.getListResultOfPointZero();
                req.setAttribute("resultBanned", dataBanned);
                session.removeAttribute("PRJ301result");
                req.setAttribute("choie", manage);
                req.getRequestDispatcher("PRJ301_Result.jsp").forward(req, resp);
            }
        }

    }

}




