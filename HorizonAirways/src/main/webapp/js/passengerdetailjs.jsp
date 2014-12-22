<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<script>
	$(document).ready(function(){
		var $detailsDiv = $(".detailsDivContainer").html();
		var departureFare = 0;
		var returnFare = 0;
		var passengerDetailNo = 1;
		var prefix = "passengerDetail"
		var passengerDetailNoSelected;
		
		
		updateDetailsDivPassengerDetailNo();
		$("#modalContainer").hide();
		$(".remove").hide();
		
		$( ".available.seat").click(function(){seatClicked($(this));});
		
		
		
		$("form .seatPicker").click(function(){seatPickerClicked($(this))});
		
		$("#seatPlanModal .okButton").click(function(){
			$("#modalContainer").hide();
		});
		
		$(".addPassenger").click(function(){
			$(".detailsDivContainer").append($detailsDiv);
			$(".remove").bind("click",function(){removeDetailsDiv($(this));});
			$("form .seatPicker").bind("click",function(){seatPickerClicked($(this));});
			$(".remove").show();
			
			updateDetailsDivPassengerDetailNo();
		});
		
		$(".remove").click(function(){
			removeDetailsDiv($(this));
		});
		
		
		function removeDetailsDiv(div){
			$(div).parents(".detailsDiv").remove();
			if($(".remove").length == 1){
				$(".remove").hide();
			}
		}
		
		function seatClicked(seat){
		
			if($(seat).parents(".${requestScope.flightId1}").length){
				var $firstSeatNo =  $(".detailsDiv."+prefix+"."+passengerDetailNoSelected+" #firstSeatNo");
				var $firstSeatClass = $(".detailsDiv."+prefix+"."+passengerDetailNoSelected+" #firstSeatClass");
			
				$($firstSeatNo).val($(seat).children("div.seatNo").text());
				$($firstSeatClass).val($(seat).children("div.seatClass").text());
				$(".${requestScope.flightId1} .selected.seat").removeClass("selected");
				
				departureFare = getFare($("#firstSeatClass"));
	
			}else if($(seat).parents(".${requestScope.flightId2}").length){
				var $secondSeatNo =  $(".detailsDiv."+prefix+"."+passengerDetailNoSelected+" #secondSeatNo");
				var $secondSeatClass = $(".detailsDiv."+prefix+"."+passengerDetailNoSelected+" #secondSeatClass");
				
				$($secondSeatNo).val($(seat).children("div.seatNo").text());
				$($secondSeatClass).val($(seat).children("div.seatClass").text());
				$(".${requestScope.flightId2} .selected.seat").removeClass("selected");
				returnFare = getFare($("#secondSeatClass"));
				
			}
			
			function getFare(source){
				<c:set var="dSector" value="${sessionScope.departureFlightSectorObject}" />
				<c:set var="rSector" value="${sessionScope.returnFlightSectorObject}" />
					if($("#firstSeatClass").is(source)){
						switch(source.val()){
							case "First": return ${dSector.firstClassFare};
							case "Business": return ${dSector.businessClassFare};
							case "Economy": return ${dSector.economyClassFare};
							default:
						}
					}if($("#secondSeatClass").is(source)){
						switch(source.val()){
						case "First": return ${rSector.firstClassFare};
						case "Business": return ${rSector.businessClassFare};
						case "Economy": return ${rSector.economyClassFare};
						default:
					}
				}
			}
			
			$(seat).addClass("selected");
			var $totalPrice =  $(".detailsDiv."+prefix+"."+passengerDetailNo+" .totalPrice");
			$($totalPrice).text(departureFare + returnFare);
	
		}
		
		
		function seatPickerClicked(seatPicker){
			passengerDetailNoSelected = $(seatPicker).parents(".detailsDiv").children(".passengerDetailNo").text();
			
			$("#modalContainer").show();
			$("#modalContainer").css("visibility", "visible");
			$("#seatPlanModal > div:not(:last-child)").hide();
			if($(seatPicker).hasClass("first")){
				$("#firstSeatPlan").show();
				
			}else{
				$("#secondSeatPlan").show();
			}
		}
		
		function updateDetailsDivPassengerDetailNo(){
			var $detailDiv = $(".detailsDiv:not(."+prefix+")");
			$($detailDiv).addClass(prefix);
			$($detailDiv).addClass(passengerDetailNo.toString());
			$(".detailsDiv."+prefix+"."+passengerDetailNo+"> .passengerDetailNo").text(passengerDetailNo);
			
			passengerDetailNo++;
		}


});
</script>