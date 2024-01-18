<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    
    isELIgnored="false"
    
    %>
    
     <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie Page</title>
<style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h1 {
            color: #333;
            text-align: center;
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

        form {
            max-width: 400px;
            margin: 20px 0;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>






</head>
<body>
<%@include file="navbar.jsp"%>
	<h1>Details of Theatres</h1>
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
	
	<form action="/theatres/add" method="post">
		Name: <input name="name" type="text"> <br><br>
		Address :<input name="address" type="text"> <br><br>
		<input type="submit" value="Add Theatre"><br><br>
		
	</form>
	
</body>
</html>