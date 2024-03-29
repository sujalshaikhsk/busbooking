package com.strikers.busbooking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.strikers.busbooking.dto.BookingRequestDto;
import com.strikers.busbooking.dto.BookingResponseDto;
import com.strikers.busbooking.service.BookingService;

/**
 * @author Vasavi
 *
 */
@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/bookings")
public class BookingController {
	/**
	 * The Constant log.
	 */
	private static final Logger logger = LoggerFactory.getLogger(BookingController.class);
	/**
	 * The bookingService.
	 */
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/{busId}")
	public ResponseEntity<String> booking(@PathVariable("busId") Integer busId, @RequestBody List<BookingRequestDto> BookingRequests){
		
		Boolean bookingStatus=bookingService.booking(busId, BookingRequests);
		if(bookingStatus)
			new ResponseEntity<String>(HttpStatus.OK);
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);	
	}

	/**
	 * @description ->this method is used for searching ticket based on mobileNumber
	 *              and ticketNumber
	 * @param searchKey
	 * @return bookingResponseDto
	 */
	@GetMapping("")
	public ResponseEntity<List<BookingResponseDto>> searchBooking(@RequestParam("searchKey") String searchKey) {
		logger.info("In BookingController:searchBooking method");
		List<BookingResponseDto> bookingRequestDto = bookingService.searchBooking(searchKey);
		return new ResponseEntity<>(bookingRequestDto, HttpStatus.OK);
	}
}
