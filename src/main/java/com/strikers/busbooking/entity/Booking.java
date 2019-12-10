package com.strikers.busbooking.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingId;
	private Integer ticketNumber;
	private Integer numberOfSeats;
	private Double totalPrice;
	private String bookingStatus;
	
	@JsonManagedReference
	@OneToMany
	private List<BookingDetail> bookingDetaillist;
}
