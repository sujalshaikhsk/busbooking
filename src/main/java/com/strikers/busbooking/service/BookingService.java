package com.strikers.busbooking.service;
import com.strikers.busbooking.dto.BookingRequestDto;
import com.strikers.busbooking.entity.Booking;

import java.util.List;

public interface BookingService {

	public List<Booking> searchBooking(String searchKey);

	Boolean booking(Integer busId, List<BookingRequestDto> bookingDetails);
}
