<%-- 
    Document   : Home
    Created on : Mar 6, 2023, 11:25:27 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.UniversityClass" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="homestyle.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <style>
            table, th, td {
                border:2px solid black;
            }
        </style>
    </head>
    <body>
        <%
            
            HttpSession session2 = request.getSession();
            ArrayList<UniversityClass> dataClass = (ArrayList<UniversityClass>) session2.getAttribute("dataclass");
            
            String error="";
            if(request.getAttribute("error")!= null){
                error = (String)request.getAttribute("error");
            }
        %>
        <header>
            <a href="Home.jsp"><img src="https://scontent.fhan2-4.fna.fbcdn.net/v/t1.15752-9/336094277_5897817150315244_4306344032914287954_n.webp?stp=dst-webp&_nc_cat=105&ccb=1-7&_nc_sid=ae9488&_nc_ohc=nEnCr-oZDbAAX9jhgzc&_nc_ht=scontent.fhan2-4.fna&oh=03_AdQmItykdKfMIBjb6B7UCqY59MQmCZubEKSsWzLCVw4TJg&oe=6435EC0A" alt="alt"/></a>
            <div>
                <i style="color: red; margin-right: 10px" class="fas fa-sign-out-alt"></i><a href="login" style="color: red">LOG OUT</a>
            </div>

        </header>
        <div class="row content">
            <div  class="left col-md-2">
                <div class="info">
                    <img class="avatar" src="images/z4199951793929_57929c10c4507b849c07664a39a7c799.jpg" alt="alt"/>
                    <h3 class="">Welcome</h3>
                    <h3 class="">${sessionScope.user.getName()}</h3>
                </div>
                <div class="menu">
                    <ul class="navbar__left">
                        <li class="navbar__left__link">
                            <i class="fas fa-plus-square"></i><a href="createexam">Create Exam</a>
                        </li>
                        <li class="navbar__left__link">
                            <i class="fas fa-graduation-cap"></i><a href="class">Class</a>
                        </li>
                        <li class="navbar__left__link">
                            <i class="fas fa-user-graduate"></i><a href="student">Student</a>
                        </li>
                        <li class="navbar__left__link">
                            <i class="fas fa-book"></i><a href="subject">Subject</a>
                        </li>
                        <li class="navbar__left__link">
                            <i class="fas fa-chart-bar"></i><a href="result">Result</a>
                        </li>
                    </ul>
                </div>
            </div>
            <c:if test="${dataExamSubject == null && dataExamResult == null && dataSubject == null && dataStudent == null && data == null}">
                <div  class="hello col-md-10">
                    <img src="images/z4199950603298_83c23b0a4570d862627c0591486c1649.jpg" alt="alt"/>
                    <div class="introduction">
                        <h1>FPT University Education</h1>
                        <h2>EOS_ADMIN</h2>
                    </div>
                </div>
            </c:if>


            <c:if test="${data != null}">
                <div class="middle col-md-10">
                    <div class="middle-one">
                        <div class="middle-two">

                            <div class="content-header">
                                <h4>View Classes Info</h4>
                                <div class="searchclass">
                                    <form action="searchclass" method="post">
                                        Search By Classname<input class="hihi" type="text" name="searchclass"/>
                                        <input type="submit" value="Search"/>
                                    </form>
                                </div>
                            </div>
                            <div class="classerror">
                                <%=error%>
                            </div>
                            <div class="tablecontent">
                                <table>
                                    <tr>
                                        <th>ClassID</th>
                                        <th>Name</th>
                                        <th>ClassMajor</th>
                                        <th>NumberOfStudents</th>
                                    </tr>
                                    <c:forEach items="${data}" var="item">
                                        <tr>
                                            <td>${item.getId()}</td>
                                            <td>${item.getName()}</td>
                                            <td>${item.getMajor()}</td>
                                            <td>${item.getNumberOfStudents()}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${dataStudent != null}">
                <div class="middle col-md-10">
                    <div class="middle-one-student">
                        <div class="middle-two-student">
                            <div class="content-header">
                                <h4>View Students Info</h4>
                                <form action="student" method="post">
                                    <select class="filter-option" name="classchoice">
                                        <option class="all-option">All</option>
                                        <c:forEach items="<%=dataClass%>" var="item">
                                            <option class="item-option" ${classchoice == item.getId()?"selected":""} value=${item.getId()}>${item.getName()}</option>
                                        </c:forEach>
                                        <input type="submit" value="search">
                                    </select>
                                </form>
                                <div class="searchclass">                                        
                                    <form action="searchstudent" method="post">
                                        Search By StudentCode<input class="hihi" type="text" name="searchstudent"/>
                                        <input type="submit" value="Search"/>
                                    </form>
                                </div>
                            </div>
                            <div class="classerror">
                                <%=error%>
                            </div>
                            <div class="tablecontent">
                                <table>
                                    <tr>
                                        <th>StudentID</th>
                                        <th>StudentCode</th>
                                        <th>Name</th>
                                        <th>Date Of Birth</th>
                                        <th>Gender</th>
                                        <th>Phone Number</th>
                                        <th>ClassName</th>
                                    </tr>
                                    <c:forEach items="${dataStudent}" var="item">
                                        <tr>
                                            <td>${item.getId()}</td>
                                            <td>${item.getCode()}</td>
                                            <td>${item.getName()}</td>
                                            <td>${item.getDob()}</td>
                                            <td>${item.getGender()}</td>
                                            <td>${item.getNumber()}</td>
                                            <td>${item.getCid().getName()}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>

                    </div>
                </div>
            </c:if>

            <c:if test="${dataSubject != null}">
                <div class="middle col-md-10">
                    <div class="middle-one">
                        <div class="middle-two">

                            <div class="content-header">
                                <h4>View Students Info</h4>
                                <div class="searchclass">
                                    <form action="searchclass" method="post">
                                        Search By Subject<input class="hihi" type="text" name="searchclass"/>
                                        <input type="submit" value="Tim"/>
                                    </form>
                                </div>
                            </div>
                            <div class="tablecontent">
                                <table>
                                    <tr>
                                        <th>SubjectID</th>
                                        <th>SubjectCode</th>
                                        <th>Name</th>
                                    </tr>
                                    <c:forEach items="${dataSubject}" var="item">
                                        <tr>
                                            <td>${item.getId()}</td>
                                            <td>${item.getCode()}</td>
                                            <td>${item.getName()}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </c:if>

            <c:if test="${dataExamSubject != null}">
                <div class="middle row col-md-10">
                    <div class="examsubject1 col-md-4">
                        <h2>Choose subject for exam</h2>

                        <c:forEach items="${dataExamSubject}" var="item">
                            <div class="div_a">
                                <h3>${item.getCode()}</h3>
                                <a href="${item.getCode()}">Create & Edit</a>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="examsubject2 col-md-8">
                        <h2>Exam Information</h2>

                        Đề thi môn PRJ301 kỳ SP23
                            <br>Đề 1: <a href="showPRJ"/>Đề FE_PRJ301_01_SP23_211403</a>
                            <br>Đề 2: <a href="showPRJrandom"/>Đề FE_PRJ301_02_SP23_392721</a>                
                        <br>Đề thi môn MAS291 kỳ SP23
                            <br>Đề 1: <a href="showMAS"/>Đề FE_MAS291_01_SP23_211403</a>
                            <br>Đề 2: <a href="showMASrandom"/>Đề FE_MAS291_02_SP23_392721</a>
                        <br>Đề thi môn IOT102 kỳ SP23
                            <br>Đề 1: <a href="showIOT"/>Đề FE_IOT102_01_SP23_211403</a>
                            <br>Đề 2: <a href="showIOTrandom"/>Đề FE_IOT102_02_SP23_392721</a>
                        <br>Đề thi môn PRO192 kỳ SP23
                            <br>Đề 1: <a href="showPRO"/>Đề FE_PRO192_01_SP23_211403</a>
                            <br>Đề 2: <a href="showPROrandom"/>Đề FE_PRO192_02_SP23_392721</a>

                    </div>
                </div>
            </c:if>


            <c:if test="${dataExamResult != null}">
                <div class="middle row col-md-10">
                    <h1>View Exam Result SPRING23</h1>
                    <c:forEach items="${dataExamResult}" var="item">                           
                        <div class="subject-result">
                            <h3 class="hoho"><a href="result/PRJ301">${item.getCode()}</a></h3>
                        </div> 
                    </c:forEach>
                </div>
            </c:if>
        </div>
    </body>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous">


    </script>

</html>
