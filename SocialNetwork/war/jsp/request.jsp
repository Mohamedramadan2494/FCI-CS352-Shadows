<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%--  import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;--%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

<form action="/social/responsess" method="post">
  Name : <input type="text" name="uname" /> 
  <input type="submit" value="accept">
<br>
</form>
<br>
<br>
<form action="/social/responsesss" method="post">
  Name : <input type="text" name="unamee" /> 
  <input type="submit" value="reject">

</form>
<br>
<br>
  <%--
	   DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

	    Query gaeQuery = new Query("users");
	    PreparedQuery pq = datastore.prepare(gaeQuery);
	    for (Entity entity : pq.asIterable()) {
		out.println(entity.getProperty("name"));
  --%>
</body>
</html>