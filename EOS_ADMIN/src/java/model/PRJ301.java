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
 * @author ADMIN
 */
public class PRJ301 {

    private int questionNo;
    private String question, a1, a2, a3, a4, correctA;
    private int sid;

    public PRJ301() {
        connect();
    }

    public PRJ301(String question, String a1, String a2, String a3, String a4, String correctA,int sid) {
        this.question = question;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.correctA = correctA;
        this.sid = sid;
        connect();
    }

    public PRJ301(int questionNo, String question, String a1, String a2, String a3, String a4) {
        this.questionNo = questionNo;
        this.question = question;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        connect();
    }

    public PRJ301(int questionNo, String question, String a1, String a2, String a3, String a4, String correctA) {
        this.questionNo = questionNo;
        this.question = question;
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.correctA = correctA;
        connect();
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getA3() {
        return a3;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    public String getA4() {
        return a4;
    }

    public void setA4(String a4) {
        this.a4 = a4;
    }

    public String getCorrectA() {
        return correctA;
    }

    public void setCorrectA(String correctA) {
        this.correctA = correctA;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
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

    //PRJ301Controller
    public void addQuestion() {
        try {
            String strAdd = "INSERT INTO [dbo].[Question]\n"
                    + "           ([Question]\n"
                    + "           ,[Answer1]\n"
                    + "           ,[Answer2]\n"
                    + "           ,[Answer3]\n"
                    + "           ,[Answer4]\n"
                    + "           ,[CorrectAnswer]\n"
                    + "           ,[SubjectID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?,?)";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, question);
            pstm.setString(2, a1);
            pstm.setString(3, a2);
            pstm.setString(4, a3);
            pstm.setString(5, a4);
            pstm.setString(6, correctA);
            pstm.setInt(7, sid);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("addQuestion: " + e.getMessage());
        }
    }

    public ArrayList<PRJ301> getListQuestion() {
        ArrayList<PRJ301> data = new ArrayList<PRJ301>();
        try {
            String strSelect = "SELECT [QuestionNO]\n"
                    + "      ,[Question]\n"
                    + "      ,[Answer1]\n"
                    + "      ,[Answer2]\n"
                    + "      ,[Answer3]\n"
                    + "      ,[Answer4]\n"
                    + "  FROM [dbo].[Question]";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String question = rs.getString(2);
                String a1 = rs.getString(3);
                String a2 = rs.getString(4);
                String a3 = rs.getString(5);
                String a4 = rs.getString(6);
                PRJ301 p = new PRJ301(id, question, a1, a2, a3, a4);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListQuestion: " + e.getMessage());
        }
        return data;
    }
    
    public ArrayList<PRJ301> getListQuestionReverse() {
        ArrayList<PRJ301> data = new ArrayList<PRJ301>();
        try {
            String strSelect = "SELECT [QuestionNO]\n"
                    + "      ,[Question]\n"
                    + "      ,[Answer1]\n"
                    + "      ,[Answer2]\n"
                    + "      ,[Answer3]\n"
                    + "      ,[Answer4]\n"
                    + "  FROM [dbo].[Question] order by QuestionNO desc";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String question = rs.getString(2);
                String a1 = rs.getString(3);
                String a2 = rs.getString(4);
                String a3 = rs.getString(5);
                String a4 = rs.getString(6);
                PRJ301 p = new PRJ301(id, question, a1, a2, a3, a4);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListQuestion: " + e.getMessage());
        }
        return data;
    }
    
    public ArrayList<PRJ301> getListQuestionPRJ() {
        ArrayList<PRJ301> data = new ArrayList<PRJ301>();
        try {
            String strSelect = "SELECT [QuestionNO]\n"
                    + "      ,[Question]\n"
                    + "      ,[Answer1]\n"
                    + "      ,[Answer2]\n"
                    + "      ,[Answer3]\n"
                    + "      ,[Answer4]\n"
                    + "  FROM [dbo].[Question] where SubjectID=1";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String question = rs.getString(2);
                String a1 = rs.getString(3);
                String a2 = rs.getString(4);
                String a3 = rs.getString(5);
                String a4 = rs.getString(6);
                PRJ301 p = new PRJ301(id, question, a1, a2, a3, a4);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListQuestion: " + e.getMessage());
        }
        return data;
    }

    //SavePRJ301Controller
    public ArrayList<PRJ301> getListQuestionRandomPRJ() {
        ArrayList<PRJ301> data = new ArrayList<PRJ301>();
        try {
            String strSelect = "SELECT [QuestionNO]\n"
                    + "      ,[Question]\n"
                    + "      ,[Answer1]\n"
                    + "      ,[Answer2]\n"
                    + "      ,[Answer3]\n"
                    + "      ,[Answer4]\n"
                    + "  FROM [dbo].[Question] where SubjectID = 1 ORDER BY NEWID()";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String question = rs.getString(2);
                String a1 = rs.getString(3);
                String a2 = rs.getString(4);
                String a3 = rs.getString(5);
                String a4 = rs.getString(6);
                PRJ301 p = new PRJ301(id, question, a1, a2, a3, a4);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListQuestionRandom: " + e.getMessage());
        }
        return data;
    }
    
    public ArrayList<PRJ301> getListQuestionMAS() {
        ArrayList<PRJ301> data = new ArrayList<PRJ301>();
        try {
            String strSelect = "SELECT [QuestionNO]\n"
                    + "      ,[Question]\n"
                    + "      ,[Answer1]\n"
                    + "      ,[Answer2]\n"
                    + "      ,[Answer3]\n"
                    + "      ,[Answer4]\n"
                    + "  FROM [dbo].[Question] where SubjectID=2";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String question = rs.getString(2);
                String a1 = rs.getString(3);
                String a2 = rs.getString(4);
                String a3 = rs.getString(5);
                String a4 = rs.getString(6);
                PRJ301 p = new PRJ301(id, question, a1, a2, a3, a4);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListQuestion: " + e.getMessage());
        }
        return data;
    }

    //SavePRJ301Controller
    public ArrayList<PRJ301> getListQuestionRandomMAS() {
        ArrayList<PRJ301> data = new ArrayList<PRJ301>();
        try {
            String strSelect = "SELECT [QuestionNO]\n"
                    + "      ,[Question]\n"
                    + "      ,[Answer1]\n"
                    + "      ,[Answer2]\n"
                    + "      ,[Answer3]\n"
                    + "      ,[Answer4]\n"
                    + "  FROM [dbo].[Question] where SubjectID = 2 ORDER BY NEWID()";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String question = rs.getString(2);
                String a1 = rs.getString(3);
                String a2 = rs.getString(4);
                String a3 = rs.getString(5);
                String a4 = rs.getString(6);
                PRJ301 p = new PRJ301(id, question, a1, a2, a3, a4);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListQuestionRandom: " + e.getMessage());
        }
        return data;
    }
    
    public ArrayList<PRJ301> getListQuestionIOT() {
        ArrayList<PRJ301> data = new ArrayList<PRJ301>();
        try {
            String strSelect = "SELECT [QuestionNO]\n"
                    + "      ,[Question]\n"
                    + "      ,[Answer1]\n"
                    + "      ,[Answer2]\n"
                    + "      ,[Answer3]\n"
                    + "      ,[Answer4]\n"
                    + "  FROM [dbo].[Question] where SubjectID=3";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String question = rs.getString(2);
                String a1 = rs.getString(3);
                String a2 = rs.getString(4);
                String a3 = rs.getString(5);
                String a4 = rs.getString(6);
                PRJ301 p = new PRJ301(id, question, a1, a2, a3, a4);
                data.add(p);
            }
        } catch (Exception e) {
            System.out.println("getListQuestion: " + e.getMessage());
        }
        return data;
    }

    //DeletePRJ301Controller
    public void deleteAll() {
        try {
            String strDelete = "DELETE FROM [dbo].[Question]";
            pstm = cnn.prepareStatement(strDelete);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteAll: " + e.getMessage());
        }
    }

    //DeletePRJ301Controller
    public void delete(int id) {
        try {
            String strDelete = "DELETE FROM [dbo].[Question]\n"
                    + "      WHERE QuestionNO=?";
            pstm = cnn.prepareStatement(strDelete);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("deleteByID: " + e.getMessage());
        }
    }

    //UpdateController
    public void update() {
        try {
            String strUpdate = "UPDATE [dbo].[Question]\n"
                    + "   SET [Question] = ?\n"
                    + "      ,[Answer1] = ?\n"
                    + "      ,[Answer2] = ?\n"
                    + "      ,[Answer3] = ?\n"
                    + "      ,[Answer4] = ?\n"
                    + "      ,[CorrectAnswer] = ?\n"
                    + " WHERE QuestionNO = ?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, question);
            pstm.setString(2, a1);
            pstm.setString(3, a2);
            pstm.setString(4, a3);
            pstm.setString(5, a4);
            pstm.setString(6, correctA);
            pstm.setInt(7, questionNo);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("updateQuestion: " + e.getMessage());
        }
    }

    //UpdateController ( lấy câu hỏi đẻ update)
    public void getQuestionByNo(int id) {
        try {
            String strSelect = "select * from Question where QuestionNO=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                questionNo = rs.getInt(1);
                question = rs.getString(2);
                a1 = rs.getString(3);
                a2 = rs.getString(4);
                a3 = rs.getString(5);
                a4 = rs.getString(6);
                correctA = rs.getString(7);
            }
        } catch (Exception e) {
            System.out.println("getQuestionByNo: " + e.getMessage());
        }
    }

}
