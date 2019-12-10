package com.strikers.busbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strikers.busbooking.dto.BookingRequestDto;
import com.strikers.busbooking.entity.Booking;
import com.strikers.busbooking.entity.BookingDetail;
import com.strikers.busbooking.entity.Bus;
import com.strikers.busbooking.repository.BookingDetailRepository;
import com.strikers.busbooking.repository.BookingRepository;
import com.strikers.busbooking.repository.BusRepository;
import com.strikers.busbooking.repository.SeatRepository;
import com.strikers.busbooking.service.BookingService;
import com.strikers.busbooking.util.StringConstant;
import com.strikers.busbooking.util.Utils;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BusRepository busRepository;
	
	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingDetailRepository bookingDetailRepository;

	@Override
	public List<Booking> searchBooking(String searchKey) {
		return null;
	}
	
	/**
	 * @description
	 * @param busId
	 * @param bookingDetails
	 * 
	 */
	@Override
	public Boolean booking(Integer busId, List<BookingRequestDto> bookingRequestDtos) {
		Booking booking = new Booking();
		List<BookingDetail> bookingDetails=new ArrayList<BookingDetail>();
		Double totalPrice = 0.0;
		Optional<Bus> optionalBus = busRepository.findById(busId);
		if (optionalBus.isPresent()) {

			bookingRequestDtos.forEach(bookinRequest -> {
				// totalPrice+=bus.getPrice();
				BookingDetail bookingDetail= new BookingDetail();
				bookingDetail.setBus(optionalBus.get());
				bookingDetail.setSeat(seatRepository.findById(bookinRequest.getSeatId()).get());
				BookingDetail bookingDetail1=saveBookingDetail(bookingDetail);
				bookingDetails.add(bookingDetail1);
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

	/**
	 * @description this method is used to save the booking detail
	 * @param bookingDetail
	 * @return
	 */
	@Transactional
	private synchronized BookingDetail saveBookingDetail(BookingDetail bookingDetail) {
		return bookingDetailRepository.save(bookingDetail);
	}

	/**
	 * @description this method is used to save the booking
	 * @param booking
	 * @return
	 */
	@Transactional
	private synchronized Booking saveBooking(Booking booking) {
		return bookingRepository.save(booking);
	}
}
