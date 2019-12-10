package com.strikers.busbooking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequestDto {
	
	Integer seatId;
	String email;
	String name;
	String gender;
	Integer age;
	String mobileNumber;
	
}
