package com.strikers.busbooking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "booking_cancel")
public class BookingCancel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookingCancelId;
	
	@OneToOne
    @JoinColumn(name = "booking_id")
	private Booking booking;
	
	@OneToOne
    @JoinColumn(name = "booking_detail_id")
	private BookingDetail bookingDetail;
	
	private Integer cancelStatus;
}
