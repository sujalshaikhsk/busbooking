package com.strikers.busbooking.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking_detail")
public class BookingDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingDetailId;
	
	@OneToOne
	@JoinColumn(name="bus_id")
	private Bus bus;
	
	@OneToOne
	@JoinColumn(name="seat_id")
	private Seat seat;
	
	private LocalDate bookingDate;
	private String name;
	private String gender;
	private Long mobileNumber;
	private String email;
	private Integer age;
	private String status;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;

}
