package com.strikers.busbooking.service;
import com.strikers.busbooking.entity.Booking;

import java.util.List;

import com.strikers.busbooking.entity.BookingDetail;

public interface BookingService {

	public List<Booking> searchBooking(String searchKey);

	Boolean booking(Integer busId, List<BookingDetail> bookingDetails);
}
