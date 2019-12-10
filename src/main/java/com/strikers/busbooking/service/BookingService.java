package com.strikers.busbooking.service;

import java.util.List;

import com.strikers.busbooking.dto.BookingResponseDto;
import com.strikers.busbooking.entity.BookingDetail;

/**
 * @author Vasavi
 *
 */
public interface BookingService {
	/**
	 * @description -> this method is used for searching ticket based on
	 *              mobileNumber and ticketNumber
	 * @param searchKey
	 * @return bookingResponseDto
	 */
	public List<BookingResponseDto> searchBooking(String searchKey);

	Boolean booking(Integer busId, List<BookingDetail> bookingDetails);
}
