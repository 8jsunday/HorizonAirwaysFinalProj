<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*"%>
<%@ page isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Horizon Airways</title>
	<link rel="stylesheet" href="css/header.css">
</head>

<body>
	<div class="header">
		<div>
			<a href="./index.jsp"><img src="./images/horizonAirwaysLogo.png"
				alt="logo" width="200px" height="100px" /></a>
		</div>
		<div>
			<form action="./logout" method="get">
				<input type="submit" name="logout" value="Log out" />
			</form>
		</div>
	</div> <!-- CLOSING FOR HEADER -->

	
	<br />

	<div>Ooops, something went wrong. :'(</div>
	<br />
	<div>
		<a href="./index.jsp">Back to home page.</a>
	</div>
</body>
</html>