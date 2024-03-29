<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Movie</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        h3 {
            color: #555;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

        a {
            text-decoration: none;
            color: #0066cc;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>





</head>
<body>
<%@include file="navbar.jsp"%>
	<c:set var="movie" value="${movie}"></c:set>
	<h2><c:out value="${movie.name}"></c:out> </h2>
	
	<h3> <c:out value="${movie.actorId}"></c:out>  </h3>
	<br>
	<h2>Premiering Now In....</h2>
	<table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Address</th>
            
             <th> Show Movies </th>
          
        </tr>
 
        <c:forEach var="theatre" items="${theatres}">
            <tr>
                <td><c:out value="${theatre.theatreId}" /></td>
                <td><c:out value="${theatre.name}" /></td>
                <td><c:out value="${theatre.address}" /></td>
             	<td> <a href="/theatres/${theatre.theatreId}"> View </a>  </td>
            </tr>
        </c:forEach>
    </table>
	
</body>
</html>