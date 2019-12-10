package com.strikers.busbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strikers.busbooking.dto.BookingRequestDto;
import com.strikers.busbooking.dto.BookingResponseDto;
import com.strikers.busbooking.entity.Booking;
import com.strikers.busbooking.repository.BookingRepository;
import com.strikers.busbooking.entity.BookingDetail;
import com.strikers.busbooking.entity.Bus;
import com.strikers.busbooking.repository.BookingDetailRepository;
import com.strikers.busbooking.repository.BusRepository;
import com.strikers.busbooking.repository.SeatRepository;
import com.strikers.busbooking.service.BookingService;
import com.strikers.busbooking.util.StringConstant;
import com.strikers.busbooking.util.Utils;

/**
 * @author Vasavi
 * @since 2019-12-10
 */
@Service
public class BookingServiceImpl implements BookingService {
	/**
	 * The constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(BookingServiceImpl.class);

	@Autowired
	private BusRepository busRepository;
	
	@Autowired
	private SeatRepository seatRepository;

	/**
	 * The bookingRepository.
	 */
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	private BookingDetailRepository bookingDetailRepository;

	/**
	 * @Description ->this method is used for searching ticket based on mobileNumber
	 *              and ticketNUmber
	 * @param booking
	 * @return searchKey
	 */

	@Override
	public List<BookingResponseDto> searchBooking(String searchKey) {
		logger.info(" Inside searchBooking method");
		List<BookingResponseDto> bookingResponseDtoList = new ArrayList<>();
		List<Booking> booking = bookingRepository.searchBooking(searchKey);
		booking.stream().forEach(b -> {
			BookingResponseDto bookingResponseDto = new BookingResponseDto();
			BeanUtils.copyProperties(b, bookingResponseDto);
			bookingResponseDtoList.add(bookingResponseDto);

		});
		return bookingResponseDtoList;
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
				// bookingDetails1.setBus(bus);
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
