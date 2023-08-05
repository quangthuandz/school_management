/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class User {

    private int id;
    private String account, password, name;

    public User() {
        connect();
    }
    
    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }

    public User(int id, String account, String password, String name) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    public User checkUser() {
        try {
            String strSelect = "select * from Users "
                    + "where Account = ? and "
                    + "Password = ? ";
            pstm=cnn.prepareStatement(strSelect);
            pstm.setString(1,account);
            pstm.setString(2,password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return null;
    }
}
