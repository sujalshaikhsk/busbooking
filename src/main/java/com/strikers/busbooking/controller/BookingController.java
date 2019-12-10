package com.strikers.busbooking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.strikers.busbooking.entity.Booking;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/bookings")
public class BookingController {
	
	@PostMapping("/{busId}")
	public ResponseEntity<String> booking(@PathVariable("busId") Integer busId, @RequestBody Booking booking){
		
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);	
	}
}
