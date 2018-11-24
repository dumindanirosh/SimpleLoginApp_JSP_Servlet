<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Home Page</title>
</head>
<body>

	<h1>Welcome To Simple Login Application with JSP/Servlet</h1>
	<center>
		<font color="red"> 
		<%
 			String errorMessage = (String) request.getAttribute("errorMessage");

 			if (errorMessage != null) {
 				out.println(errorMessage);
 			}
 		%>
		</font>
	</center>
	<form action="login" method="post">
		<table bgcolor="yellow" align="center">


			<tr>
				<td width="100">User Name :</td>
				<td><input type="text" name="username" size="35" /></td>

			</tr>

			<tr>
				<td width="100">Password :</td>
				<td><input type="password" name="password" size="35" /></td>

			</tr>

			<td width="100"></td>
			<td><input type="submit" value="Login" /></td>

			</tr>


		</table>

	</form>
</body>
</html>