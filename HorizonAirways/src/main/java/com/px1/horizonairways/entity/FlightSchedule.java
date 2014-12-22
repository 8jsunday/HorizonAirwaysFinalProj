package com.px1.horizonairways.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "flightschedule")
@Table(name = "FlightDetailsInDays")
public class FlightSchedule implements Serializable {

	private String flightNo;
	private String sectorId;
	private String weekDay1;
	private String weekDay2;
	private String aircraftType;
	private String departureTime;
	private String arrivalTime;
	private BigDecimal firstClassFare;
	private BigDecimal businessClassFare;
	private BigDecimal economyClassFare;

	public FlightSchedule() {

	}

	public FlightSchedule(String flightNo, String sectorId, String weekDay1,
			String weekDay2, String aircraftType, String departureTime,
			String arrivalTime, BigDecimal firstClassFare,
			BigDecimal businessClassFare, BigDecimal economyClassFare) {
		super();
		this.flightNo = flightNo;
		this.sectorId = sectorId;
		this.weekDay1 = weekDay1;
		this.weekDay2 = weekDay2;
		this.aircraftType = aircraftType;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.firstClassFare = firstClassFare;
		this.businessClassFare = businessClassFare;
		this.economyClassFare = economyClassFare;
	}

	@Id
	@Column(name = "FlightNo")
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	@Column(name = "SectorId")
	public String getSectorId() {
		return sectorId;
	}

	public void setSectorId(String sectorId) {
		this.sectorId = sectorId;
	}

	@Column(name = "WeekDay1")
	public String getWeekDay1() {
		return weekDay1;
	}

	public void setWeekDay1(String weekDay1) {
		this.weekDay1 = weekDay1;
	}

	@Column(name = "WeekDay2")
	public String getWeekDay2() {
		return weekDay2;
	}

	public void setWeekDay2(String weekDay2) {
		this.weekDay2 = weekDay2;
	}

	@Column(name = "Description")
	public String getAircraftType() {
		return aircraftType;
	}

	public void setAircraftType(String aircraftType) {
		this.aircraftType = aircraftType;
	}

	@Column(name = "DepTime")
	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@Column(name = "ArrTime")
	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Column(name = "FirstClassFare")
	public BigDecimal getFirstClassFare() {
		return firstClassFare.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setFirstClassFare(BigDecimal firstClassFare) {
		this.firstClassFare = firstClassFare;
	}

	@Column(name = "BusinessClassFare")
	public BigDecimal getBusinessClassFare() {
		return businessClassFare.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setBusinessClassFare(BigDecimal businessClassFare) {
		this.businessClassFare = businessClassFare;
	}

	@Column(name = "EconomyClassFare")
	public BigDecimal getEconomyClassFare() {
		return economyClassFare.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}

	public void setEconomyClassFare(BigDecimal economyClassFare) {
		this.economyClassFare = economyClassFare;
	}

}
