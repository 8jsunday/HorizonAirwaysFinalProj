<%@page import="com.px1.horizonairways.entity.Sector"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/passenger.css">
<link rel="stylesheet" href="css/header.css">
<title>Passenger Details</title>
<script src="js/jquery.min.js"></script>
<jsp:include page="./js/passengerdetailjs.jsp"></jsp:include>
<link rel="stylesheet" href="css/horizonairways.css"> 

</head>

<body>

	

	<div class="header">
		<div><a href="./index"><img src="./images/horizonAirwaysLogo.png" alt="logo" width="200px" height="100px"/></a></div>
		<div>
			<form>
				<input type="submit" name="logout" value="Log out" />
			</form>
		</div>
	</div>

	<div class="passengerDetails">
		<form action="./PassengerDetailsCapture" method="post">
		

		<div class="fieldsContainer">
				<div class="headerDiv">
					<div>Personal Details Form</div><div class="addPassenger">Add passenger</div> 
				</div>
				<div class="detailsDivContainer">
						
						<div class="detailsDiv">
								<div class="passengerDetailNo"></div>
								<div>
										<div>
											<label for="firstName">First Name: </label>
											<input type="text"  name="firstName" id="firstName">
										</div>
										<div>
											<label for="gender">Gender: </label>
											<select name="gender">
												<option value="M">Male</option>
												<option value="F">Female</option>
											</select>
										</div>
										<div>
											<label for="mobileNo">Mobile Number: </label>
											<input type="text" name="mobileNo" id="mobileNo" >
										</div>		
										<div>
											<label for="mealPreference">Meal Preference: </label>
											<select name="mealPreference" id="mealPreference">
												<option value="Non-Vegetarian">Non-Vegetarian</option>
												<option value="Vegetarian">Vegetarian</option>
											</select>
										</div>						
			
								</div>
								
								<div>
										<div>
											<label for="lastName">Last Name: </label>
											<input type="text" name="lastName" id="lastName" >
										</div>
			
										<div>
											<label for="birthDay">Birth Day: </label>
											<input type="date" name="birthDay" id="birthDay">
										</div>
			
										<div>
											<label for="emailAddress">Email Address: </label>
											<input type="email" name="emailAddress" id="emailAddress">
										</div>
			
										<div>
											<label for="SSR">SSR: </label>
											<input type="text" name="SSR" id="SSR" >
										</div>
								</div>
								
								<div class="flightPickerDivContainer">
										<div>
												<div class="flightPickerDiv">
														<div>Departure: ${firstFlight.flightNo} - ${firstFlight.sectorId}</div>
														<div>
															<label for="firstSeatNo">Seat No: </label>
															<input type="text" name="firstSeatNo" id="firstSeatNo" class="${requestScope.flightId1} seatPicker first" required readonly>
														</div>
														<div>
															<label for="firstSeatClass">Seat Class: </label>
															<input type="text" name="firstSeatClass" id="firstSeatClass" class="${requestScope.flightId1} seatClass" required readonly>
														</div>
												</div>
							
												<c:if test="${not empty sessionScope.secondFlight}">
												
												<div class="flightPickerDiv">
														<div>Return: ${secondFlight.flightNo} - ${secondFlight.sectorId}</div>
														<div>
															<label for="secondSeatNo">Seat No: </label>
															<input type="text" name="secondSeatNo" id="secondSeatNo" class="${requestScope.flightId2} seatPicker second" required readonly>
														</div>
														<div>
															<label for="secondSeatClass">Seat Class: </label>
															<input type="text" name="secondSeatClass" id="secondSeatClass" class="${requestScope.flightId2} seatClass" required readonly>
														</div>
												</div>
												</c:if>
										</div>
					
										<div>Price:<div class="totalPrice"></div><input type="hidden" class="totalPrice" name="totalPrice"/></div>
								</div>
								<div class="removeDiv"><div class="remove"> X </div></div>
						
							</div>
					</div>
		
				<div class="submitDiv">
					<input type="submit" value="Submit" class="submit"/>
				</div>
		</div>
		</form>
	</div>	
		
	<div id="modalContainer">
		<div id="seatPlanModal">
			<div id="firstSeatPlan">
				<c:set var="firstSeatPlan" value="${requestScope.firstPassengerSeatPlan}"/>
					<div>
						<div class="area">
							${firstSeatPlan.firstClassHTML}
						</div>
						<div class="area">
							${firstSeatPlan.businessClassHTML}
						</div>
						<div class="area">
							${firstSeatPlan.economyClassHTML}
						</div>
					</div>
			</div>
			<div id="secondSeatPlan">	
				<c:if test="${not empty requestScope.secondPassengerSeatPlan}">
					<c:set var="secondSeatPlan" value="${requestScope.secondPassengerSeatPlan}" />
					<div>
						<div class="area">
						${secondSeatPlan.firstClassHTML}
						</div>
						<div class="area">
						${secondSeatPlan.businessClassHTML}
						</div>
						<div class="area">
						${secondSeatPlan.economyClassHTML}
						</div>
				
					</div>
				</c:if>
			</div>
			<div class="buttonDiv">
				<input type="button" value="Ok" class="okButton horizonButton" />
			</div>
		</div>	
	</div>
</font>
</body>
</html>
