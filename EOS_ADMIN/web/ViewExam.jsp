<%-- 
    Document   : ViewExam
    Created on : Mar 15, 2023, 10:53:33 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        .back {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 12px 28px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 20px;
            margin: 0 auto;
            border-radius: 5px;
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            transition: 0.3s;
        }

        .back:hover {
            background-color: #3e8e41;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        }
        h1 {
            font-size: 36px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        h3 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        p {
            font-size: 18px;
            margin-bottom: 5px;
        }

        .exam-container {
            background-color: #f2f2f2;
            border-radius: 10px;
            padding: 20px;
        }

        .question-number {
            background-color: #4CAF50;
            color: white;
            padding: 5px 10px;
            border-radius: 5px;
            margin-right: 10px;
        }

        /* Tùy chỉnh nút submit */
        .submit-button {
            background-color: #4CAF50;
            border: none;
            color: white;
            padding: 12px 28px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 20px;
            margin-top: 100px;
            border-radius: 5px;
            box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);
            transition: 0.3s;
        }

        .submit-button:hover {
            background-color: #3e8e41;
            box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);
        }
    </style>
    <body>
        <div class="exam-container">
            <c:if test="${PRJexam!=null}">
                <h1>Đề FE_01_SP23_123456</h1>
                <c:set var="i" value="0"/>
                <c:forEach items="${PRJexam}" var="item">
                    <c:set var="i" value="${i+1}"/>
                    <h3><span class="question-number">QuestionNo ${i}:</span>${item.getQuestion()}</h3>
                    <p>1.${item.getA1()}</p>
                    <p>2.${item.getA2()}</p>
                    <p>3.${item.getA3()}</p>
                    <p>4.${item.getA4()}</p>
                </c:forEach> 
                <form action="save">
                    <input class="back" type="submit" value="Come back"/>
                </form>
            </c:if>

            <c:if test="${PRJexamRandom!=null}">
                <h1>Đề FE_01_SP23_392833</h1>
                <c:set var="i" value="0"/>
                <c:forEach items="${PRJexamRandom}" var="item">
                    <c:set var="i" value="${i+1}"/>
                    <h3><span class="question-number">QuestionNo ${i}:</span>${item.getQuestion()}</h3>
                    <p>1.${item.getA1()}</p>
                    <p>2.${item.getA2()}</p>
                    <p>3.${item.getA3()}</p>
                    <p>4.${item.getA4()}</p>
                </c:forEach> 
                <form action="save">
                    <input class="back" type="submit" value="Come back"/>
                </form>
            </c:if>

            <c:if test="${MASexam!=null}">
                <h1>Đề FE_01_SP23_123456</h1>
                <c:set var="i" value="0"/>
                <c:forEach items="${MASexam}" var="item">
                    <c:set var="i" value="${i+1}"/>
                    <h3><span class="question-number">QuestionNo ${i}:</span>${item.getQuestion()}</h3>
                    <p>1.${item.getA1()}</p>
                    <p>2.${item.getA2()}</p>
                    <p>3.${item.getA3()}</p>
                    <p>4.${item.getA4()}</p>
                </c:forEach> 
                <form action="save">
                    <input class="back" type="submit" value="Come back"/>
                </form>
            </c:if>

            <c:if test="${IOTexam!=null}">
                <h1>Đề FE_01_SP23_123456</h1>
                <c:set var="i" value="0"/>
                <c:forEach items="${IOTexam}" var="item">
                    <c:set var="i" value="${i+1}"/>
                    <h3><span class="question-number">QuestionNo ${i}:</span>${item.getQuestion()}</h3>
                    <p>1.${item.getA1()}</p>
                    <p>2.${item.getA2()}</p>
                    <p>3.${item.getA3()}</p>
                    <p>4.${item.getA4()}</p>
                </c:forEach> 
                <form action="save">
                    <input class="back" type="submit" value="Come back"/>
                </form>
            </c:if>

        </div>

    </body>
</html>
