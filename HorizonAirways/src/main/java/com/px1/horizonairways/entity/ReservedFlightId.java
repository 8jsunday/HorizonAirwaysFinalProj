package com.px1.horizonairways.entity;

import java.io.Serializable;
import java.util.Date;

public class ReservedFlightId implements Serializable {

	public ReservedFlightId() {

	}

	private String passenger;
	private String flightNo;
	private Date flightDate;

	public String getPassenger() {
		return passenger;
	}

	public void setPassenger(String passenger) {
		this.passenger = passenger;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Date getFlightDate() {
		return flightDate;
	}

	public void setFlightDate(Date flightDate) {
		this.flightDate = flightDate;
	}

	@Override
	public int hashCode() {

		return passenger.hashCode() + flightDate.hashCode()
				+ flightNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof ReservedFlightId) {

			ReservedFlightId reservedFlightId = (ReservedFlightId) obj;

			return this.passenger.equals(
					reservedFlightId.getPassenger())
					&& this.flightDate.equals(reservedFlightId.getFlightDate())
					&& this.flightNo.equals(reservedFlightId.getFlightNo());
		}

		return false;

	}

}
