

<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<body>
 <div id="main">
  <h1>Welcome ${it.name} to Our website</h1>
  <h2 style="color:blue">Web Site Main Ingredients:</h2>

  <p>Add friends</p>
  <p> create groups </p>
  <p> Register</p>
  <p>Live Data (Files and Databases)</p>
</div>

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
<form method ="get" action="/social/Addfriend/">
<input type ="submit" value = "addfriend">
</form>
<br>
<a href="/social/signout/">Signout</a>
<br>
<form method ="get" action="/social/request/">
<input type ="submit" value ="request">
</form>
</body>
</html>
