package com.px1.horizonairways.entity;

import java.io.Serializable;
import java.util.Date;

public class FlightDetailsId implements Serializable {

	public FlightDetailsId() {

	}

	private String flightNo;
	private Date flightDate;

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

		return flightDate.hashCode() + flightNo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof ReservedFlightId) {

			ReservedFlightId reservedFlightId = (ReservedFlightId) obj;

			return this.flightDate.equals(reservedFlightId.getFlightDate())
					&& this.flightNo.equals(reservedFlightId.getFlightNo());
		}

		return false;

	}

}
