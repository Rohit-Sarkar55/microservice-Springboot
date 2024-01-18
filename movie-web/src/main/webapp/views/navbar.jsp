<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 20px;
        }

        h2 {
            color: #333;
        }

        nav {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            background-color: #fff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            z-index: 1000;
            margin-bottom: 20px;
            padding: 15px; /* Increase the padding for a larger navbar */
        }

        nav a {
            text-decoration: none;
            padding: 10px 20px; /* Increase padding for buttons */
            margin-right: 10px;
            color: #4CAF50;
        }

        nav a:hover {
            background-color: #45a049;
            color: white;
        }

        /* Add padding to the body to account for the fixed navbar */
        body {
            padding-top: 70px; /* Adjust padding to account for larger navbar */
        }
    </style>
</head>
<body>
    <nav>
        <a href="/actors">Actors</a>
        <a href="/movies">Movies</a>
        <a href="/theatres">Theatres</a>
    </nav>

   

    <!-- Your content goes here -->

</body>
</html>
