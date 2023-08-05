<%-- 
    Document   : PRJ301_Result
    Created on : Mar 20, 2023, 6:04:18 PM
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
        .first-choice, .second-choice {
            display: inline-block;
            margin-top: 50px;
            margin-right: 20px;
            background-color: #f9f9f9;
            border: 1px solid #ddd;
            padding: 10px;
            font-size: 16px;
            font-weight: bold;
            color: #333;
        }

        .second-choice{
            margin-left:1100px;
        }

        .first-choice select, .second-choice select {
            border: none;
            background-color: transparent;
            font-size: 16px;
            font-weight: normal;
            color: #333;
        }


        table, th, td {
            border:2px solid black;
            font-size: 20px;
            padding: 2px;
        }

        table {
            margin-top: 20px;
            max-width: 100%;
            width: 100%;
        }

        th{
            background-color: #006666;
            color: white;
        }

        td, th {
            border: 2px solid black;
        }

        table tr td:nth-child(-n+3) {
            width: 50px;
        }


        table tr td:nth-child(6) {
            font-weight: bold;
        }

        table tr td:nth-child(7) {
            color:red;
        }

        .back {
            margin-top: 20px;
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            transition: all 0.3s ease;
        }

        .back:hover {
            background-color: #0062cc;
            color: #fff;
        }

    </style>
    <body>
        <div class="all">
            <h1>PRJ301_RESULT_PE_SP23</h1>
            <div class="first-choice">
                <form action="manageresult" method="post">
                    Class
                    <select name="classchoice">
                        <option>All</option>
                        <c:forEach items="${resultClass}" var="item">
                            <option ${hello == item.getId()?"selected":""} value=${item.getId()}>${item.getName()}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Search"/> 
                </form>

            </div>
            <div class="second-choice">
                <form id="mySelect" action="manageresult" method="">
                    Sort by
                    <select name="manage" onchange="submitForm()">
                        <option></option>
                        <option>Normal</option> 
                        <option>IncreasePoint</option>                                   
                        <option>DecreasePoint</option>
                        <option>Fastesttime</option>
                        <option>BannedStudent</option>
                    </select>
                </form>
            </div>
            <c:if test="${PRJ301result != null}">
                <table>
                    <tr>
                        <th>ResultID</th>
                        <th>StudentCode</th>
                        <th>StudentClass</th>
                        <th>StartTime</th>
                        <th>EndTime</th>
                        <th>Point</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${PRJ301result}" var="item">
                        <tr>
                            <td>${item.getRid()}</td>
                            <td>${item.getS().getCode()}</td>
                            <td>${item.getStudentClass()}</td>
                            <td>${item.getStartTime()}</td>
                            <td>${item.getEndTime()}</td>
                            <td>${item.getPoint()}</td>
                            <td>${item.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${resultInClass != null}">
                <table>
                    <tr>
                        <th>ResultID</th>
                        <th>StudentCode</th>
                        <th>StudentClass</th>
                        <th>StartTime</th>
                        <th>EndTime</th>
                        <th>Point</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${resultInClass}" var="item">
                        <tr>
                            <td>${item.getRid()}</td>
                            <td>${item.getS().getCode()}</td>
                            <td>${item.getStudentClass()}</td>
                            <td>${item.getStartTime()}</td>
                            <td>${item.getEndTime()}</td>
                            <td>${item.getPoint()}</td>
                            <td>${item.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>


            <c:if test="${resultNormal!= null}">
                <table>
                    <tr>
                        <th>ResultID</th>
                        <th>StudentCode</th>
                        <th>StudentClass</th>
                        <th>StartTime</th>
                        <th>EndTime</th>
                        <th>Point</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${resultNormal}" var="item">
                        <tr>
                            <td>${item.getRid()}</td>
                            <td>${item.getS().getCode()}</td>
                            <td>${item.getStudentClass()}</td>
                            <td>${item.getStartTime()}</td>
                            <td>${item.getEndTime()}</td>
                            <td>${item.getPoint()}</td>
                            <td>${item.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${resultIncrease!= null}">
                <table>
                    <tr>
                        <th>ResultID</th>
                        <th>StudentCode</th>
                        <th>StudentClass</th>
                        <th>StartTime</th>
                        <th>EndTime</th>
                        <th>Point</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${resultIncrease}" var="item">
                        <tr>
                            <td>${item.getRid()}</td>
                            <td>${item.getS().getCode()}</td>
                            <td>${item.getStudentClass()}</td>
                            <td>${item.getStartTime()}</td>
                            <td>${item.getEndTime()}</td>
                            <td>${item.getPoint()}</td>
                            <td>${item.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${resultDecrease!= null}">
                <table>
                    <tr>
                        <th>ResultID</th>
                        <th>StudentCode</th>
                        <th>StudentClass</th>
                        <th>StartTime</th>
                        <th>EndTime</th>
                        <th>Point</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${resultDecrease}" var="item">
                        <tr>
                            <td>${item.getRid()}</td>
                            <td>${item.getS().getCode()}</td>
                            <td>${item.getStudentClass()}</td>
                            <td>${item.getStartTime()}</td>
                            <td>${item.getEndTime()}</td>
                            <td>${item.getPoint()}</td>
                            <td>${item.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${resultTime!= null}">
                <table>
                    <tr>
                        <th>ResultID</th>
                        <th>StudentCode</th>
                        <th>StudentClass</th>
                        <th>StartTime</th>
                        <th>EndTime</th>
                        <th>Point</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${resultTime}" var="item">
                        <tr>
                            <td>${item.getRid()}</td>
                            <td>${item.getS().getCode()}</td>
                            <td>${item.getStudentClass()}</td>
                            <td>${item.getStartTime()}</td>
                            <td>${item.getEndTime()}</td>
                            <td>${item.getPoint()}</td>
                            <td>${item.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>

            <c:if test="${resultBanned!= null}">
                <table>
                    <tr>
                        <th>ResultID</th>
                        <th>StudentCode</th>
                        <th>StudentClass</th>
                        <th>StartTime</th>
                        <th>EndTime</th>
                        <th>Point</th>
                        <th>Description</th>
                    </tr>
                    <c:forEach items="${resultBanned}" var="item">
                        <tr>
                            <td>${item.getRid()}</td>
                            <td>${item.getS().getCode()}</td>
                            <td>${item.getStudentClass()}</td>
                            <td>${item.getStartTime()}</td>
                            <td>${item.getEndTime()}</td>
                            <td>${item.getPoint()}</td>
                            <td>${item.getDescription()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <div class="back">
                <form action="result">
                    <input type="submit" value="Back"/>
                </form>
            </div>
        </div>
    </body>

    <script>
        function submitForm() {
            document.getElementById("mySelect").submit();

        }
    </script>
</html>
