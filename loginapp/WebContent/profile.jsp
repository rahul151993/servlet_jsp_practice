<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>profile</title>
</head>
<body>
<div align="center">
<table>
<tr>
<td>UserName</td><td><%= request.getSession().getAttribute("userName")%></td>
</tr>
<tr>
<td>Password</td><td><%= request.getSession().getAttribute("password")%></td>
</tr>
</table>
</div>
</body>
</html>