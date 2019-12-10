package com.strikers.busbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.strikers.busbooking.dto.BookingResponseDto;
import com.strikers.busbooking.entity.Booking;
import com.strikers.busbooking.repository.BookingRepository;

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
	/**
	 * The bookingRepository.
	 */
	@Autowired
	BookingRepository bookingRepository;

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

}
