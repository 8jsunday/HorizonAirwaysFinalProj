<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.px1.horizonairways.da.FlightDetailsDA"%>
<%@page import="com.px1.horizonairways.entity.FlightSchedule"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.math.BigDecimal" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Horizon Airways</title>
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/tableDesign.css">
</head>

<body>
	<div class="header">
		<div><a href="./index.jsp"><img src="./images/horizonAirwaysLogo.png" alt="logo" width="200px" height="100px"/></a></div>
		<div>
			<c:choose>
				<c:when test="${ empty sessionScope.user}">
					<form action="./login" method="post">
						<table>
							<tr>
								<td><p>User Name</p></td>
								<td><input type="text" name="userName" /></td>
								<td><p>Password</p></td>
								<td><input type="password" name="password" /></td>
								<td><input type="submit" name="submit" value="Log in" /></td>
							</tr>
						</table>
					</form>
				</c:when>
			
				<c:otherwise>
					<div>
						<form action="./logout" method="get">
							<input type="submit" name="logout" value="Log out"/>
						</form>
					</div>
				</c:otherwise>
			
			</c:choose>
		</div>
	</div> <!-- CLOSING FOR HEADER -->

	<div>
	   	<table class="tblDesign">
	         <tr>
	           <th rowspan="2" scope="col">Flight No.</th>
	           <th rowspan="2" scope="col">Sector</th>
	           <th rowspan="2" scope="col">Flight Date</th>
	           <th rowspan="2" scope="col">Aircraft Type</th>
	           <th rowspan="2" scope="col">Departure Time</th>
	           <th rowspan="2" scope="col">Arrival Time</th>
	           <th colspan="3" scope="col">Remaining Seats</th>
	           <th rowspan="2" scope="col"></th>
	         </tr>
	         <tr class="flightClasses">
	           <th scope="col">First Class</th>
	           <th scope="col">Business Class</th>
	           <th scope="col">Economy Class</th>
	         </tr>
	         
	         <c:forEach items="${flightDetailsList}" var="flightDetails">
	         <tr>
	           <td>${flightDetails.flightNo}</td>
	           <td>${flightDetails.sectorId}</td>
	           <td>${flightDetails.formattedFlightDate}</td>
	           <td>${flightDetails.aircraftType}</td>
	           <td>${flightDetails.departureTime}</td>
	           <td>${flightDetails.arrivalTime}</td>
	           <td>${flightDetails.firstClassSeatsAvailable}</td>
	           <td>${flightDetails.businessClassSeatsAvailable}</td>
	           <td>${flightDetails.economyClassSeatsAvailable}</td>
	           <td><a href="./PassengerManifest?flightNo=${flightDetails.flightNo}&amp;flightDate=${flightDetails.flightDate}"><b>View Passenger Manifest</b></a></td>
	         </tr>
	         </c:forEach>
	   	</table>
   	</div>
</body>
</html>