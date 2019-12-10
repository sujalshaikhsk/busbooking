package com.strikers.busbooking.controller;

import java.util.List;

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
import com.strikers.busbooking.service.BookingService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/{busId}")
	public ResponseEntity<String> booking(@PathVariable("busId") Integer busId, @RequestBody List<BookingRequestDto> BookingRequests){
		
		Boolean bookingStatus=bookingService.booking(busId, BookingRequests);
		if(bookingStatus)
			new ResponseEntity<String>(HttpStatus.OK);
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);	
	}
	
	@GetMapping("/{busId}")
	public ResponseEntity<String> searchBoon(@RequestParam("searchKey") String searchKey){
		
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);	
	}
}
