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
public class Subject  {
    
    private int id;
    private String code,name;

    public Subject() {
        connect();
    }

    public Subject(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
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

    public Connection getCnn() {
        return cnn;
    }

    public void setCnn(Connection cnn) {
        this.cnn = cnn;
    }

    public Statement getStm() {
        return stm;
    }

    public void setStm(Statement stm) {
        this.stm = stm;
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    public void setPstm(PreparedStatement pstm) {
        this.pstm = pstm;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
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
    
    
    // chức năng của subject
    public ArrayList<Subject> getListSubject() {
        ArrayList<Subject> data = new ArrayList<Subject>();
        try {
            String strSelect = "select * from Subjects";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String code = rs.getString(2);
                String name = rs.getString(3);
                Subject s = new Subject(id,code, name);
                data.add(s);
            }
        } catch (Exception e) {
            System.out.println("getListSubject: " + e.getMessage());
        }
        return data;
    }
}
