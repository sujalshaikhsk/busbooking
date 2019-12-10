package com.strikers.busbooking.service;

import java.util.List;

import com.strikers.busbooking.entity.Booking;

public interface BookingService {
	public List<Booking> searchBooking(String searchKey);
}
