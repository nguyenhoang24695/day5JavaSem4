<%@ page import="com.fpt.edu.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.fpt.edu.controller.ListStudentController" %><%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 6/6/2019
  Time: 7:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Student> list = (List<Student>) request.getAttribute("studentList");
%>
<html>
<head>
    <title>LIST</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center"> List Student </h1>
<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">RollNumber</th>
        <th scope="col">Full Name</th>
        <th scope="col">Email</th>
        <th scope="col">Phone</th>
        <th scope="col">Status</th>
    </tr>
    </thead>
    <tbody>

        <%
            for (Student s: list)
            {
        %>
            <tr>
                <th scope="row"><%=s.getRollNumber()%></th>
                <td><%=s.getFullName()%></td>
                <td><%=s.getEmail()%></td>
                <td><%=s.getPhone()%></td>
                <td><%=s.getStatus()%></td>
            </tr>
        <%
          }
        %>



    </tbody>
</table>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
