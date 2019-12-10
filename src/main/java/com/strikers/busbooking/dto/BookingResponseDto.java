package com.strikers.busbooking.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BookingResponseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer bookingId;
	private Integer ticketNumber;
	private String busName;
	private String name;
	private Integer age;
	private String gender;
	private String mobileNumber;
	private String email;
	private Integer seatNumber;

}
