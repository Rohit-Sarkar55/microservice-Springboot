<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Theatre</title>
<style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h2, h4 {
            color: #333;
        }

        h4 {
            margin-top: 20px;
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

        form {
            max-width: 400px;
            margin: 20px 0;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        select, input {
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
	<c:set var="theatre" value="${theatre}"></c:set>
	<h2><c:out value="${theatre.name}"></c:out> </h2>
	
	<h4> <c:out value="${theatre.address}"></c:out>  </h4>
	
	<h2>Movies Running...</h2>
	
	<table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>ActorId</th>
            <th>Delete</th>
            <!--
            <th>Password</th>
            <th>Edit Profile</th>
            <th>Delete</th> -->
        </tr>
 
        <c:forEach var="movie" items="${movies}">
            <tr>
                <td><c:out value="${movie.movieId}" /></td>
                <td><c:out value="${movie.name}" /></td>
                <td><c:out value="${movie.actorId}" /></td>
                <td> <a href="/theatres/${theatre.theatreId}/deletemovie/${movie.movieId}"> Delete </a>  </td>
             
            </tr>
        </c:forEach>
    </table>
    
    <h4>Add New Movie</h4><br>
    
    	<form action="/theatres/${theatre.theatreId}/addmovie" method="post">
			<%-- <input name="theatreId" type="hidden" value="${}"> --%>
			Movie :
			<label for="movieDropdown">Select a Movie:</label>
		<select name="movieId" id="movieDropdown">
		
		<c:forEach var="movie" items="${restmovies}">
			  <option value="${movie.movieId}">  
			  	<c:out value="${movie.name}"></c:out> 
			  </option>
		</c:forEach>
		</select>
			
		<input type="submit" value="Add Movie"><br><br>
		
	</form>
</body>
</html>