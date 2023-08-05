/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class Result {

    private int rid;
    private Student s;
    private String studentClass;
    private String startTime, endTime;
    private int point;
    private String description;

    public Result() {
        connect();
    }

    public Result(int rid, Student s, String studentClass, String startTime, String endTime, int point, String description) {
        this.rid = rid;
        this.s = s;
        this.studentClass = studentClass;
        this.startTime = startTime;
        this.endTime = endTime;
        this.point = point;
        this.description = description;
        connect();
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Student getS() {
        return s;
    }

    public void setS(Student s) {
        this.s = s;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<Result> getListResult() {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResult: " + e.getMessage());
        }
        return data;
    }

    // lấy result theo lớp ( ManageResult)
    public ArrayList<Result> getListResultByClass(String c) {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result where StudentClass = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, c);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultByClass: " + e.getMessage());
        }
        return data;
    }

    
    
    public ArrayList<Result> getListResultOrderByIncreasePoint() {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result order by Point asc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultOrderByIncreasePoint: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Result> getListResultOrderByDecreasePoint() {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result order by Point desc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultOrderByIncreasePoint: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Result> getListResultOfPointZero() {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result where Point = 0";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultOfPointZero: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Result> getListResultOrderByTime() {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result order by DATEDIFF(SECOND, CONVERT(datetime, '00:00:00'), CONVERT(datetime, endTime)) - \n"
                    + "       DATEDIFF(SECOND, CONVERT(datetime, '00:00:00'), CONVERT(datetime, startTime)) asc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultOrderByTime: " + e.getMessage());
        }
        return data;
    }
    
    public ArrayList<Result> getListResultOrderByIncreasePoint(String str) {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result where StudentClass = ? order by Point asc";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,str);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultOrderByIncreasePoint: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Result> getListResultOrderByDecreasePoint(String str) {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result where StudentClass = ? order by Point desc";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,str);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultOrderByIncreasePoint: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Result> getListResultOfPointZero(String str) {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result where Point = 0 and StudentClass = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,str);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultOfPointZero: " + e.getMessage());
        }
        return data;
    }

    public ArrayList<Result> getListResultOrderByTime(String str) {
        ArrayList<Result> data = new ArrayList<Result>();
        try {
            String strSelect = "select * from Result where StudentClass = ? order by DATEDIFF(SECOND, CONVERT(datetime, '00:00:00'), CONVERT(datetime, endTime)) - \n"
                    + "       DATEDIFF(SECOND, CONVERT(datetime, '00:00:00'), CONVERT(datetime, startTime)) asc";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1,str);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                Student s = new Student();
                Student s1 = s.getStudentById(rs.getInt(2));
                String studentClass = rs.getString(3);
                String start = rs.getString(4);
                String end = rs.getString(5);
                int point = rs.getInt(6);
                String description = rs.getString(7);
                Result r = new Result(id, s1, studentClass, start, end, point, description);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListResultOrderByTime: " + e.getMessage());
        }
        return data;
    }
}
