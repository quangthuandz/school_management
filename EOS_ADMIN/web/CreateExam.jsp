<%-- 
    Document   : CreateExam.jsp
    Created on : Mar 14, 2023, 10:30:26 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="createstyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
        <style>
            table, th, td {
                border:2px solid black;
            }
        </style>
    </head>
    <body>
        <h1 class="create-exam-title">Create Exam</h1>
        <form class="add-question-form" action="PRJ301" method="post">
            <h2>Question:</h2>
            <textarea class="question-textarea" name="question" rows="5" cols="50"></textarea>
            <div class="answer-container">
                <br><h3 class="answer-number">1:</h3>
                <textarea name="a1" rows="3" cols="33"></textarea>
                <br><h3 class="answer-number">2:</h3>
                <textarea name="a2" rows="3" cols="33"></textarea>
                <br><h3 class="answer-number">3:</h3>
                <textarea name="a3" rows="3" cols="33"></textarea>
                <br><h3 class="answer-number">4:</h3>
                <textarea name="a4" rows="3" cols="33"></textarea>
            </div>
            <br><h3>Correct Answer</h3><input class="correct-answer-input" type="text" name="correct"/>
            <br>SubjectID 
            <select name="classtocreate">
                <c:forEach items="${dataCl}" var="item">
                    <option>${item.getCode()}</option>
                </c:forEach>
            </select>
            <br><input class="add-button" type="submit" value="Add"/>
            <h2 class="error-message" style="color: red">${errorBlank}</h2>
        </form>
        <table class="question-table">
            <tr>
                <th class="question-number"><a href="order">QuestionNO</a></th>
                <th class="question-text">Question</th>
                <th>Answer 1</th>
                <th>Answer 2</th>
                <th>Answer 3</th>
                <th>Answer 4</th>
                <th class="edit">Edit</th>
                <th class="delete">Delete</th>
            </tr>

            <c:if test="${dataOrder!=null}">
                <c:forEach items="${dataOrder}" var="item">
                    <tr>
                        <td class="question-number">${item.getQuestionNo()}</td>
                        <td class="question">${item.getQuestion()}</td>
                        <td class="answer">${item.getA1()}</td>
                        <td class="answer">${item.getA2()}</td>
                        <td class="answer">${item.getA3()}</td>
                        <td class="answer">${item.getA4()}</td>
                        <td><a href="update?questionNo=${item.getQuestionNo()}"><i style="color: black" class="fas fa-edit"></i></a></td>
                        <td><a href="PRJ301/delete?questionNo=${item.getQuestionNo()}" onclick="return confirm('Bạn có chắc chắn muốn xóa câu hỏi này không?')"><i style="color: black" class="fas fa-trash-alt"></i></a></td>
                    </tr>
                </c:forEach>
            </c:if>

            <c:if test="${dataOrder==null}">
                <c:forEach items="${data}" var="item">
                    <tr>
                        <td class="question-number">${item.getQuestionNo()}</td>
                        <td class="question">${item.getQuestion()}</td>
                        <td class="answer">${item.getA1()}</td>
                        <td class="answer">${item.getA2()}</td>
                        <td class="answer">${item.getA3()}</td>
                        <td class="answer">${item.getA4()}</td>
                        <td><a href="update?questionNo=${item.getQuestionNo()}"><i style="color: black" class="fas fa-edit"></i></a></td>
                        <td><a href="PRJ301/delete?questionNo=${item.getQuestionNo()}" onclick="return confirm('Bạn có chắc chắn muốn xóa câu hỏi này không?')"><i style="color: black" class="fas fa-trash-alt"></i></a></td>
                    </tr>
                </c:forEach>
            </c:if>

        </table>
        <form class="delete-all-form" action="PRJ301/delete" method="post">
            <input class="delete-all-button" type="submit" value="Delete All" onclick="return confirm('Bạn có chắc chắn muốn xóa tất cả không?')"/>
        </form>

        <form class="save-form" action="save" method="post">
            <input class="save-button" type="submit" value="Save"/>
        </form>

        <h2 class="error-message" style="color: red">${sessionScope.error}</h2>
    </body>
</html>
