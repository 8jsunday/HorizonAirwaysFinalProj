package com.px1.horizonairways.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.px1.horizonairways.util.DateUtil;


@IdClass(ReservedFlightId.class)
@Entity(name = "reservedFlight")
@Table(name = "ReservedFlights")
public class ReservedFlight implements Serializable {

	private Passenger passenger;
	private String flightNo;
	private Date flightDate;
	private String seatNo;
	private String seatClass;
	private String mealPreference;
	private String SSR;
	private Integer cancelFlag;

	public ReservedFlight() {

	}

	public ReservedFlight(Passenger passenger, String flightNo,
			Date flightDate, String seatNo, String seatClass,
			String mealPreference, String sSR, Integer cancelFlag) {

		this.passenger = passenger;
		this.flightNo = flightNo;
		this.flightDate = flightDate;
		this.seatNo = seatNo;
		this.seatClass = seatClass;
		this.mealPreference = mealPreference;
		SSR = sSR;
		this.cancelFlag = cancelFlag;
	}

	@Id
	@OneToOne
	@JoinColumn(name = "PNRNo", referencedColumnName = "PNRNo", insertable = false, updatable = false)
	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@Id
	@Column(name = "FlightNo")
	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	@Id
	@Column(name = "FlightDate")
	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	@Column(name = "SeatNo")
	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	@Column(name = "Class")
	public String getSeatClass() {
		return seatClass;
	}

	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}

	@Column(name = "Meal")
	public String getMealPreference() {
		return mealPreference;
	}

	public void setMealPreference(String mealPreference) {
		this.mealPreference = mealPreference;
	}

	@Column(name = "SSR")
	public String getSSR() {
		return SSR;
	}

	public void setSSR(String sSR) {
		SSR = sSR;
	}

	@Column(name = "CancelFlag")
	public Integer getCancelFlag() {
		return cancelFlag;
	}

	public void setCancelFlag(Integer cancelFlag) {
		this.cancelFlag = cancelFlag;
	}

	@Transient
	public String getFormattedFlightDate() {
		return DateUtil.formatDate(getFlightDate());
	}

}
