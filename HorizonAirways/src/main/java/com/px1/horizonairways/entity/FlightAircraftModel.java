package com.px1.horizonairways.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "flightaircraftmodel")
@Table(name = "VwFlightByAircraftModel")
public class FlightAircraftModel {

	private String flightNo;
	private String aircraftTypeId;
	private String desc;
	private Integer firstClassSeats;
	private Integer businessClassSeats;
	private Integer economyClassSeats;
	private String rows;
	private String firstClassArrangement;
	private String businessClassArrangement;
	private String economyClassArrangement;

	public FlightAircraftModel() {
	}

	public FlightAircraftModel(String flightNo, String aircraftTypeId,
			String desc, Integer firstClassSeats, Integer businessClassSeats,
			Integer economyClassSeats, String rows,
			String firstClassArrangement, String businessClassArrangement,
			String economyClassArrangement) {

		this.flightNo = flightNo;
		this.aircraftTypeId = aircraftTypeId;
		this.desc = desc;
		this.firstClassSeats = firstClassSeats;
		this.businessClassSeats = businessClassSeats;
		this.economyClassSeats = economyClassSeats;
		this.rows = rows;
		this.firstClassArrangement = firstClassArrangement;
		this.businessClassArrangement = businessClassArrangement;
		this.economyClassArrangement = economyClassArrangement;
	}

	@Id
	@Column(name = "FlightNo")
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getAircraftTypeId() {
		return aircraftTypeId;
	}

	public void setAircraftTypeId(String aircraftTypeId) {
		this.aircraftTypeId = aircraftTypeId;
	}

	@Column(name = "description")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getFirstClassSeats() {
		return firstClassSeats;
	}

	public void setFirstClassSeats(Integer firstClassSeats) {
		this.firstClassSeats = firstClassSeats;
	}

	public Integer getBusinessClassSeats() {
		return businessClassSeats;
	}

	public void setBusinessClassSeats(Integer businessClassSeats) {
		this.businessClassSeats = businessClassSeats;
	}

	public Integer getEconomyClassSeats() {
		return economyClassSeats;
	}

	public void setEconomyClassSeats(Integer economyClassSeats) {
		this.economyClassSeats = economyClassSeats;
	}

	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	public String getFirstClassArrangement() {
		return firstClassArrangement;
	}

	public void setFirstClassArrangement(String firstClassArrangement) {
		this.firstClassArrangement = firstClassArrangement;
	}

	public String getBusinessClassArrangement() {
		return businessClassArrangement;
	}

	public void setBusinessClassArrangement(String businessClassArrangement) {
		this.businessClassArrangement = businessClassArrangement;
	}

	public String getEconomyClassArrangement() {
		return economyClassArrangement;
	}

	public void setEconomyClassArrangement(String economyClassArrangement) {
		this.economyClassArrangement = economyClassArrangement;
	}

}
