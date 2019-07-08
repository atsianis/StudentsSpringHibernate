<%-- 
    Document   : addedit
    Created on : 8 Ιουλ 2019, 1:58:54 μμ
    Author     : samsung np350
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>xxx</title>
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
        <h1>${title} Student</h1>
        <form:form method="POST" modelAttribute="student" action="/StudentsSpringHibernate/student${what}">
            <table border="1" id="myTable">
                <tr><td>First Name</td><td>Last Name</td><td>Section</td></tr>
                <tr><td><form:input path="firstName"/></td><td><form:input path="lastName"/></td><td><form:input path="section"/></td></tr>
            </table>
                <form:input type="hidden" path="id"/>
            <input type="submit" value="${title} student"/>
        </form:form>
    </body>
</html>
