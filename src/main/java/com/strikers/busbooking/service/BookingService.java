package com.strikers.busbooking.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.strikers.busbooking.entity.Booking;

public interface BookingService {
	public List<Booking> searchBooking(@Param("searchKey") String searchKey);

}
