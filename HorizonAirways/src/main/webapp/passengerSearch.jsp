<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.px1.horizonairways.entity.ReservedFlight"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/cancel.css">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/tableDesign.css">
	<title>Horizon Airways</title>
</head>

<body>
	<font face="Arial, Helvetica, sans-serif" size="-1">
	
	<c:if test="${ empty sessionScope.user}">
		<c:redirect url="/index.jsp" />
	</c:if>
	
	<div class="header">
		<div><a href="./index.jsp"><img src="./images/horizonAirwaysLogo.png" alt="logo" width="200px" height="100px"/></a></div>
		<div>
			<form action="./logout" method="get">
				<input type="submit" name="logout" value="Log out" />
			</form>
		</div>
	</div> <!-- CLOSING FOR HEADER -->
	
	<div class="passengerDiv">
		<div class="formDiv">
			<form action="./SearchPassenger" method="post">
				<br />
				<label for="pnrNo">Please input PNR No: </label><input type="text" name="pnrNo"/>
				<input type="submit" value="Search"/>
				
				<div>
					<h3>Personal Details Form</h3>
						<div>
						<label for="pnrNo">PNR Number: </label>
						<input type="text"  name="pnrNo" id="pnrNo" disabled value="${requestScope.passenger.pnr}">
					</div>
					<div>
						<label for="firstName">First Name: </label>
						<input type="text"  name="firstName" id="firstName" disabled value="${requestScope.passenger.firstName}">
					</div>
					<div>
						<label for="lastName">Last Name: </label>
						<input type="text" name="lastName" id="lastName" disabled value="${requestScope.passenger.lastName}" >
					</div>
					<div>
						<label for="gender">Gender </label>
						<input type="text" name="gender" id="gender" disabled value="${requestScope.passenger.gender}" >
					</div>
					<div>
						<label for="birthDay">Birth Day: </label>
						<input type="text" name="birthDay" id="birthDay" disabled value="${requestScope.passenger.formattedBirthDay}">
					</div>
					<div>
						<label for="mobileNo">Mobile Number: </label>
						<input type="text" name="mobileNo" id="mobileNo" disabled value="${requestScope.passenger.mobileNo}">
					</div>
					<div>
						<label for="emailAddress">Email Address: </label>
						<input type="email" name="emailAddress" id="emailAddress" disabled value="${requestScope.passenger.emailAddress}">
					</div>
				</div>
			</form>
		</div>
		
		<% if((request.getAttribute("reservedFlights")!=null) && (((List<ReservedFlight>)request.getAttribute("reservedFlights")).size() != 0)){ %>
		<div class="tableContainer">
			<h2>Passenger Flight Info:</h2>
			<table class="tblDesign">
				<tr>
					<th scope="col">Flight No.</th>
					<th scope="col">Flight Date</th>
					<th scope="col">Seat No</th>
					<th scope="col">Class</th>
					<th scope="col">Meal</th>
					<th scope="col">SSR</th>
				</tr>
				
				<c:forEach items="${requestScope.reservedFlights}" var="reservedFlight">
				<tr>
					<td>${reservedFlight.flightNo}</td>
					<td>${reservedFlight.formattedFlightDate}</td>
					<td>${reservedFlight.seatNo}</td>
					<td>${reservedFlight.seatClass}</td>
					<td>${reservedFlight.mealPreference}</td>
					<td>${reservedFlight.SSR}</td>
				</tr>
				</c:forEach>
			</table>
			<br>
			<a href="./SearchPassenger?flightNo=${reservedFlight.flightNo}&amp;pnrNo=${requestScope.passenger.pnr}">
				<h3>Cancel Reservation</h3>
			</a>
		</div>

		<%
			} else if(request.getAttribute("passenger")!=null) {
		%>
		<br />
		<h3>There are no scheduled flights for this passenger. 
			<br/><a href="./index.jsp">Back to home page.</a>
		</h3>
			
		<%
			} else if(request.getAttribute("pnrNo")!=null) {
		%>
		<h3>No passenger with the indicated PNR number is found. 
			<br/><a href="./index.jsp">Back to home page.</a>
		</h3>
			
		<%
			}
		%>
		
	</div>
	</font>
</body>
</html>
