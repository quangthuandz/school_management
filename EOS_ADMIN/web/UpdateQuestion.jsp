<%-- 
    Document   : UpdateQuestion
    Created on : Mar 15, 2023, 11:50:16 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style>
        /* Thiết lập font chữ và màu sắc cho tiêu đề và nút */
        .create-exam-title {
            font-size: 32px;
            color: #333;
            margin-bottom: 20px;
        }

        .add-button {
            background-color: #008CBA;
            border: none;
            color: white;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            margin-top: 20px;
            cursor: pointer;
            border-radius: 5px;
        }

        /* Thiết lập kiểu chữ và kích thước cho đoạn văn bản */
        .question-textarea, .answer-container textarea, .correct-answer-input {
            font-family: Arial, sans-serif;
            font-size: 18px;
            border: 2px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 10px;
        }

        /* Thiết lập màu sắc và độ rộng cho các hộp câu trả lời */
        .answer-container textarea {
            width: 90%;
            background-color: #f2f2f2;
            resize: none;
        }

        /* Thiết lập kiểu chữ và màu sắc cho số câu trả lời */
        .answer-number {
            font-size: 24px;
            color: #333;
            margin-right: 10px;
        }

        /* Thiết lập độ rộng cho phần tử form */
        .add-question-form {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        /* Thiết lập độ rộng và độ cao cho phần tử textarea */
        textarea {
            width: 100%;
            height: 100%;
            box-sizing: border-box;
        }

        /* Thiết lập độ rộng cho input correct-answer-input */
        .correct-answer-input {
            width: 50px;
        }

    </style>
    <body>
<!--                <form class="update-form" action="update" method="post">
                    <label for="quesNo">Question No:</label>
                    <input type="text" name="quesNo" id="quesNo" value="${p.getQuestionNo()}" class="update-input">
                    <br><br>
                    <label for="question">Question:</label>
                    <input type="text" name="question" id="question" value="${p.getQuestion()}" class="update-input">
                    <br><br>
                    <label for="a1">Answer 1:</label>
                    <input type="text" name="a1" id="a1" value="${p.getA1()}" class="update-input">
                    <br><br>
                    <label for="a2">Answer 2:</label>
                    <input type="text" name="a2" id="a2" value="${p.getA2()}" class="update-input">
                    <br><br>
                    <label for="a3">Answer 3:</label>
                    <input type="text" name="a3" id="a3" value="${p.getA3()}" class="update-input">
                    <br><br>
                    <label for="a4">Answer 4:</label>
                    <input type="text" name="a4" id="a4" value="${p.getA4()}" class="update-input">
                    <br><br>
                    <label for="correct">Correct Answer:</label>
                    <input type="text" name="correct" id="correct" value="${p.getCorrectA()}" class="update-input">
                    <br><br>
                    <input type="submit" value="Update" class="update-button">
                </form>-->

        
        <form class="add-question-form" action="update" method="post">
            <h1 class="create-exam-title">Update Question</h1>
            <h2>Question:</h2>
            <textarea class="question-textarea" name="quesNo" rows="5" cols="50">${p.getQuestionNo()}</textarea>
            <textarea class="question-textarea" name="question" rows="5" cols="50">${p.getQuestion()}</textarea>
            <div class="answer-container">
                <br><h3 class="answer-number">1:</h3>
                <textarea name="a1" rows="3" cols="33">${p.getA1()}</textarea>
                <br><h3 class="answer-number">2:</h3>
                <textarea name="a2" rows="3" cols="33">${p.getA2()}</textarea>
                <br><h3 class="answer-number">3:</h3>
                <textarea name="a3" rows="3" cols="33">${p.getA3()}</textarea>
                <br><h3 class="answer-number">4:</h3>
                <textarea name="a4" rows="3" cols="33">${p.getA4()}</textarea>
            </div>
            <br><h3>Correct Answer</h3><input class="correct-answer-input" type="text" name="correct" value="${p.getCorrectA()}"/>
            <br><input class="add-button" type="submit" value="Update"/>
        </form>

    </body>
</html>
