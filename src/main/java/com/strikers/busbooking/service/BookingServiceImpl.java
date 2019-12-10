package com.strikers.busbooking.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strikers.busbooking.entity.Booking;
import com.strikers.busbooking.entity.BookingDetail;
import com.strikers.busbooking.entity.Bus;
import com.strikers.busbooking.repository.BookingDetailRepository;
import com.strikers.busbooking.repository.BookingRepository;
import com.strikers.busbooking.repository.BusRepository;
import com.strikers.busbooking.service.BookingService;
import com.strikers.busbooking.util.StringConstant;
import com.strikers.busbooking.util.Utils;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BusRepository busRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingDetailRepository bookingDetailRepository;

	/**
	 * @description
	 * @param busId
	 * 
	 */
	@Override
	public Boolean booking(Integer busId, List<BookingDetail> bookingDetails) {
		Booking booking = new Booking();
		Double totalPrice = 0.0;
		Bus bus = null;
		Optional<Bus> optionalBus = busRepository.findById(busId);
		if (optionalBus.isPresent()) {

			bus = optionalBus.get();

			bookingDetails.forEach(bookingDetails1 -> {
				// totalPrice+=bus.getPrice();
				saveBookingDetail(bookingDetails1);
			});

			booking.setBookingDetaillist(bookingDetails);
			booking.setBookingStatus(StringConstant.BOOKED_STATUS);
			booking.setTotalPrice(totalPrice);
			booking.setTicketNumber(Utils.getTicketNumber());
			saveBooking(booking);
			return true;
		}
		return false;
	}

	@Transactional
	private synchronized BookingDetail saveBookingDetail(BookingDetail bookingDetail) {
		return bookingDetailRepository.save(bookingDetail);
	}

	@Transactional
	private synchronized Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
}
