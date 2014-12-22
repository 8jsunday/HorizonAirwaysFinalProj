package com.px1.horizonairways.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "sector")
public class Sector {

	private String id;
	private String description;
	private String weekDay1;
	private String weekDay2;
	private BigDecimal firstClassFare;
	private BigDecimal businessClassFare;
	private BigDecimal economyClassFare;

	public Sector() {
	}

	public Sector(String id, String description, String weekDay1,
			String weekDay2, BigDecimal firstClassFare,
			BigDecimal businessClassFare, BigDecimal economyClassFare) {

		this.id = id;
		this.description = description;
		this.weekDay1 = weekDay1;
		this.weekDay2 = weekDay2;
		this.firstClassFare = firstClassFare;
		this.businessClassFare = businessClassFare;
		this.economyClassFare = economyClassFare;
	}

	@Id
	@Column(name = "SectorID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeekDay1() {
		return weekDay1;
	}

	public void setWeekDay1(String weekDay1) {
		this.weekDay1 = weekDay1;
	}

	public String getWeekDay2() {
		return weekDay2;
	}

	public void setWeekDay2(String weekDay2) {
		this.weekDay2 = weekDay2;
	}

	public BigDecimal getFirstClassFare() {
		return firstClassFare;
	}

	public void setFirstClassFare(BigDecimal firstClassFare) {
		this.firstClassFare = firstClassFare;
	}

	public BigDecimal getBusinessClassFare() {
		return businessClassFare;
	}

	public void setBusinessClassFare(BigDecimal businessClassFare) {
		this.businessClassFare = businessClassFare;
	}

	public BigDecimal getEconomyClassFare() {
		return economyClassFare;
	}

	public void setEconomyClassFare(BigDecimal economyClassFare) {
		this.economyClassFare = economyClassFare;
	}

}
