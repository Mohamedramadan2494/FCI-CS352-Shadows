<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
</head>
<style>
body{
font-family: verdina;
background-color: #ABC;
padding: 50px;
}
form {
    text-align: center;
    color: black;
}
</style>
<body>
<br>
<br>
<br>
<br>
<br>
<form action="/social/home" method="post">
  Name : <input type="text" name="uname" /> <br><br>
  Password : <input type="password" name="password" /> <br><br>
  <input type="submit" value="Login">
  
  </form>
</body>
</html>