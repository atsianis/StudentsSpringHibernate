<%-- 
    Document   : students
    Created on : 8 Ιουλ 2019, 1:36:36 μμ
    Author     : samsung np350
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.mycompany.studentsspringhibernate.models.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>   
        <script type="text/javascript">
             $(document).ready(function() {
                $('#myTable').DataTable();
            });
        </script>
    </head>
    <body>
        <table border="1" id="myTable">
            <tr><td>First Name</td><td>Last Name</td><td>Section</td></tr>
            <c:forEach var="s" items="${students}">
                <tr><td>${s.firstName}</td><td>${s.lastName}</td><td>${s.section}</td><td><a href="/StudentsSpringHibernate/studentupdate/${s.id}">Edit</a></td><td><a href="/StudentsSpringHibernate/studentdelete/${s.id}">Delete</a></td></tr>
            </c:forEach>
        </table>
        <p>${message}</p><br>
        <p><a href="/StudentsSpringHibernate/">Home Page</a>
    </body>
</html>
