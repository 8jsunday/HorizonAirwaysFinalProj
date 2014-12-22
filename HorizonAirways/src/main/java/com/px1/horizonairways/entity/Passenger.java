package com.px1.horizonairways.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.px1.horizonairways.util.DateUtil;

@Entity(name = "passenger")
@Table(name = "Passenger")
public class Passenger {

	private String pnr;
	private String lastName;
	private String firstName;
	private Date birthDay;
	private String gender;
	private String mobileNo;
	private String emailAddress;
	private Date reservationDate;

	public Passenger() {
	}

	public Passenger(String pnr, String lastName, String firstName,
			Date birthDay, String gender, String mobileNo, String emailAddress,
			Date reservationDate) {
		super();
		this.pnr = pnr;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.emailAddress = emailAddress;
		this.reservationDate = reservationDate;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PNRNo")
	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	@Column(name = "Lastname")
	public String getLastName() {
		return lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "Firstname")
	public String getFirstName() {
		return firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "Birthdate")
	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	@Column(name = "Gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "MobileNumber")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "EmailAddress")
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "ReservationDate")
	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	@Transient
	public String getFormattedReservationDate() {
		return DateUtil.formatDate(getReservationDate());
	}

	@Transient
	public String getFormattedBirthDay() {
		return DateUtil.formatDate(getBirthDay());
	}

}
