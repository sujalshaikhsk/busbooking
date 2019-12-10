package com.strikers.busbooking.service;

import java.util.List;

import com.strikers.busbooking.entity.BookingDetail;

public interface BookingService {

	Boolean booking(Integer busId, List<BookingDetail> bookingDetails);

}
