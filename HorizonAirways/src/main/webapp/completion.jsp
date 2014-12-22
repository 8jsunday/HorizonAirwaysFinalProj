<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/header.css">
	<link rel="stylesheet" href="css/button.css">
	<link rel="stylesheet" href="css/ticket.css">
	<title>Reservation Success!</title>
</head>

<body>
	<c:if test="${ empty sessionScope.user}">
		<jsp:forward page="/index" />
	</c:if>
	
	<div class="header">
		<div><a href="./index">
			<img src="./images/horizonAirwaysLogo.png" alt="logo" width="200px"
				height="100px" /></a>
		</div>
		<div>
			<form action="./logout" method="get">
				<input type="submit" name="logout" value="Log out" />
			</form>
		</div>
	</div> <!-- CLOSING FOR HEADER -->

	<h2>
		The flight is successfully scheduled. Passenger's PNR Number: <u><c:out value="${passenger.pnr}"></c:out></u>.
	</h2>
	<br />

	<div id="passengerTicket">
		<div id="header">
			<p>
				Horizon Airways<br />Passenger Ticket
			</p>
		</div>
		<div>
			<p id="dateOfIssue">Date of Issue: ${passenger.formattedReservationDate }</p>
			<p class="ticketDetails">NOT TRANSFERRABLE<br/>Passenger Name:
				${passenger.firstName }&nbsp; ${passenger.lastName }<p><p class="ticketDetails"></p>
			
			
			<div class="flightDetails">
			<p class="ticketDetails">Sector: ${firstFlight.sectorId }</p>
			<table>
				
				<tr class="tableHeader">
					<th>Flight #:</th>
					<th>Class:</th>
					<th>Date:</th>
					<th>Dep. Time:</th>
					<th>Arr. Time:</th>
					<th>Status:</th>
				</tr>
				
				<tr>
					<td>${reservedFlight1.flightNo }</td>
					<td>${reservedFlight1.seatClass }</td>
					<td>${reservedFlight1.formattedFlightDate }</td>
					<td>${firstFlight.departureTime }</td>
					<td>${firstFlight.arrivalTime }</td>
					<td>Confirmed</td>
				</tr>
			</table>
			</div>
			
			<%
				if (session.getAttribute("secondFlight") != null) {
			%>
			<div class="flightDetails">
				<p class="ticketDetails">Sector: ${secondFlight.sectorId }</p>
				<table>
					<tr class="tableHeader">
						<th>Flight #:</th>
						<th>Class:</th>
						<th>Date:</th>
						<th>Dep. Time:</th>
						<th>Arr. Time:</th>
						<th>Status:</th>
					</tr>
					<tr>
						<td>${reservedFlight2.flightNo }</td>
						<td>${reservedFlight2.seatClass }</td>
						<td>${reservedFlight2.formattedFlightDate }</td>
						<td>${secondFlight.departureTime }</td>
						<td>${secondFlight.arrivalTime }</td>
						<td>Confirmed</td>
					</tr>
				</table>
			<%
				}
			%>
			</div>
		</div>
	</div>
	
	
	<div class="footer">
		<input type="submit" id="print" value="Print ticket" class="horizonButton"/>
	</div>
	
	<a href="./index"><b>Back to Home Page</b></a>
	
	<script src="js/ticket.js"></script>
</body>
</html>
