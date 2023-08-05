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
 * @author Admin
 */
public class Student {

    private int id;
    private String code, name;
    private Date dob;
    private String gender, number;
    private UniversityClass cid;

    public Student() {
        connect();
    }

    public Student(int id, String code, String name, Date dob, String gender, String number, UniversityClass cid) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.number = number;
        this.cid = cid;
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UniversityClass getCid() {
        return cid;
    }

    public void setCid(UniversityClass cid) {
        this.cid = cid;
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
    
    // chức năng của student
    public ArrayList<Student> getListStudent() {
        ArrayList<Student> data = new ArrayList<Student>();
        try {
            String strSelect = "select * from Students";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            int count = 0;
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                Date d = rs.getDate(4);
                String gender = rs.getString(5);
                String number = rs.getString(6);
                Student s = new Student();
                UniversityClass c = s.getClassByCid(String.valueOf(rs.getInt(7)));
                Student p = new Student(id, code, name, d, gender, number, c);
                data.add(p);
                count++;
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("getListStudent: " + e.getMessage());
        }
        return data;
    }

    // chức năng phụ trợ cho getListStudent()
    public UniversityClass getClassByCid(String cid) {
        try {
            String strSelect = "select * from Class where ClassID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, cid);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String major = rs.getString(3);
                String numberOfStudents = rs.getString(4);
                UniversityClass c = new UniversityClass(id, name, major, numberOfStudents);
                return c;
            }
        } catch (Exception e) {
            System.out.println("getClassByCid: " + e.getMessage());
        }
        return null;
    }
    
    // Tìm kiếm Student bằng Code
    public ArrayList<Student> getStudentByCode(String searchstudent) {
        ArrayList<Student> data = new ArrayList<Student>();
        try {
            String strSelect = "select * from Students where StudentCode like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, searchstudent + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                Date d = rs.getDate(4);
                String gender = rs.getString(5);
                String number = rs.getString(6);
                Student s = new Student();
                UniversityClass c = s.getClassByCid(String.valueOf(rs.getInt(7)));
                Student p = new Student(id, code, name, d, gender, number, c);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getStudentByCode: " + e.getMessage());
        }
        return data;
    }
    
    
    public Student getStudentById(int sid) {
        try {
            String strSelect = "select * from Students where StudentID = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, sid);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                Date d = rs.getDate(4);
                String gender = rs.getString(5);
                String number = rs.getString(6);
                Student s = new Student();
                UniversityClass c = s.getClassByCid(String.valueOf(rs.getInt(7)));
                Student p = new Student(id, code, name, d, gender, number, c);
                return p;
            }
        } catch (Exception e) {
            System.out.println("getStudentById: " + e.getMessage());
        }
        return null;
    }
    
    //list ra danh sách Student trong lớp của /student
    public ArrayList<Student> getStudentInClass(int searchClass) {
        ArrayList<Student> data = new ArrayList<Student>();
        try {
            String strSelect = "SELECT [StudentID]\n"
                    + "      ,[StudentCode]\n"
                    + "      ,[StudentName]\n"
                    + "      ,[Date_of_Birth]\n"
                    + "      ,[Gender]\n"
                    + "      ,[PhoneNumber]\n"
                    + "      ,[class_id]\n"
                    + "  FROM [dbo].[Students],Class where class_id=ClassID and class_id=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, searchClass);
            rs = pstm.executeQuery();
            int count = 0;
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                Date d = rs.getDate(4);
                String gender = rs.getString(5);
                String number = rs.getString(6);
                Student s = new Student();
                UniversityClass c = s.getClassByCid(String.valueOf(rs.getInt(7)));
                Student p = new Student(id, code, name, d, gender, number, c);
                count++;
                data.add(p);
            }
            System.out.println(count);
        } catch (Exception e) {
            System.out.println("getStudentInClass: " + e.getMessage());
        }
        return data;
    }
    
//    public ArrayList<Student> getListStudentInClass() {
//        ArrayList<Student> data = new ArrayList<Student>();
//        try {
//            String strSelect = "select TOP 10 * from Students";
//            pstm = cnn.prepareStatement(strSelect);
//            rs = pstm.executeQuery();
//            int count = 0;
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String code = rs.getString(2);
//                String name = rs.getString(3);
//                Date d = rs.getDate(4);
//                String gender = rs.getString(5);
//                String number = rs.getString(6);
//                Student s = new Student();
//                UniversityClass c = s.getClassByCid(String.valueOf(rs.getInt(7)));
//                Student p = new Student(id, code, name, d, gender, number, c);
//                data.add(p);
//                count++;
//            }
//            System.out.println(count);
//        } catch (Exception e) {
//            System.out.println("getListStudent: " + e.getMessage());
//        }
//        return data;
//    }
}
