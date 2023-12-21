<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
 body {
            font-family: Times New Roman, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        form {
            background-color: #f4f4f4;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 12px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
      
    </style>
</head>
<body>

<form action="login" method="post">
        <h2>Railway Crossing</h2>
     <p>User Login</p>
      
         <label for="email">Enter Email</label>
        <input type="email" id="email" name="email" required><br>

        <label for="password">Enter Password</label>
        <input type="password" id="password" name="password" required><br>

   
        <input type="submit" value="Login"><br><br>
        Don't have account?<a href="userRegister.jsp">Create New Account</a>
    </form>
  

</body>
</html>