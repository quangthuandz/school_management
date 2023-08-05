/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UniversityClass {

    private String id, name, major, numberOfStudents;

    public UniversityClass() {
        connect();
    }

    public UniversityClass(String id, String name, String major, String numberOfStudents) {
        this.id = id;
        this.name = name;
        this.major = major;
        this.numberOfStudents = numberOfStudents;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(String numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
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
    
    public ArrayList<UniversityClass> getListClass() {
        ArrayList<UniversityClass> data = new ArrayList<UniversityClass>();
        try {
            String strSelect = "select * from Class";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String major = rs.getString(3);
                String numberOfStudents = rs.getString(4);
                UniversityClass c = new UniversityClass(id, name, major, numberOfStudents);
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println("getListClass: " + e.getMessage());
        }
        return data;
    }
    
    //SearchClass
    public ArrayList<UniversityClass> getListClassByName(String searchclass) {
        ArrayList<UniversityClass> data = new ArrayList<UniversityClass>();
        try {
            String strSelect = "select * from Class where classname like ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, searchclass+"%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String major = rs.getString(3);
                String numberOfStudents = rs.getString(4);
                UniversityClass c = new UniversityClass(id, name, major, numberOfStudents);
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println("getListClassByName: " + e.getMessage());
        }
        return data;
    }
    
    //chức năng của result ( PRJ301Result)
    public ArrayList<UniversityClass> getListClassSE() {
        ArrayList<UniversityClass> data = new ArrayList<UniversityClass>();
        try {
            String strSelect = "  select * from Class where ClassName like 'SE%'";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String major = rs.getString(3);
                String numberOfStudents = rs.getString(4);
                UniversityClass c = new UniversityClass(id, name, major, numberOfStudents);
                data.add(c);
            }
        } catch (Exception e) {
            System.out.println("getListClassSE: " + e.getMessage());
        }
        return data;
    }

}
