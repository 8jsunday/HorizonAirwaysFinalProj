package com.px1.horizonairways.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.px1.horizonairways.util.DateUtil;

@IdClass(FlightDetailsId.class)
@Entity(name = "flightDetails")
@Table(name = "VwFlightSchedules")
public class FlightDetails implements Serializable {

	private static final long serialVersionUID = 1L;
	private String flightNo;
	private String sectorId;
	private Date flightDate;
	private String aircraftType;
	private String departureTime;
	private String arrivalTime;
	private int firstClassSeatsAvailable;
	private int businessClassSeatsAvailable;
	private int economyClassSeatsAvailable;

	public FlightDetails() {
	}

	public FlightDetails(String flightNo, String sectorId, Date flightDate,
			String aircraftType, String departureTime, String arrivalTime,
			int firstClassSeatsAvailable, int businessClassSeatsAvailable,
			int economyClassSeatsAvailable) {

		this.flightNo = flightNo;
		this.sectorId = sectorId;
		this.flightDate = flightDate;
		this.aircraftType = aircraftType;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.firstClassSeatsAvailable = firstClassSeatsAvailable;
		this.businessClassSeatsAvailable = businessClassSeatsAvailable;
		this.economyClassSeatsAvailable = economyClassSeatsAvailable;
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

	@Id
	@Column(name = "FlightDate")
	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
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

	@Column(name = "AvailableFirstClassSeats")
	public int getFirstClassSeatsAvailable() {
		return firstClassSeatsAvailable;
	}

	public void setFirstClassSeatsAvailable(int firstClassSeatsAvailable) {
		this.firstClassSeatsAvailable = firstClassSeatsAvailable;
	}

	@Column(name = "AvailableBusinessClassSeats")
	public int getBusinessClassSeatsAvailable() {
		return businessClassSeatsAvailable;
	}

	public void setBusinessClassSeatsAvailable(int businessClassSeatsAvailable) {
		this.businessClassSeatsAvailable = businessClassSeatsAvailable;
	}

	@Column(name = "AvailableEconomyClassSeats")
	public int getEconomyClassSeatsAvailable() {
		return economyClassSeatsAvailable;
	}

	public void setEconomyClassSeatsAvailable(int economyClassSeatsAvailable) {
		this.economyClassSeatsAvailable = economyClassSeatsAvailable;
	}

	@Transient
	public String getFormattedFlightDate() {
		return DateUtil.formatDate(getFlightDate());
	}

}
