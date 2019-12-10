package com.strikers.busbooking.service;
import com.strikers.busbooking.dto.BookingRequestDto;

import java.util.List;

import com.strikers.busbooking.dto.BookingResponseDto;

public interface BookingService {
	/**
	 * @description -> this method is used for searching ticket based on
	 *              mobileNumber and ticketNumber
	 * @param searchKey
	 * @return bookingResponseDto
	 */
	public List<BookingResponseDto> searchBooking(String searchKey);

	/**
	 * @description this method is used for making the bus booking 
	 * @param busId
	 * @param bookingDetails
	 * @return
	 */
	Boolean booking(Integer busId, List<BookingRequestDto> bookingDetails);
}
