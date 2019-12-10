package com.strikers.busbooking.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "bus")
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer busId;
	private String busName;
	private String busNumber;
	private String sourceName;
	private String destinationName;
	private LocalDate date;
	private LocalTime startTime;
	private LocalTime endTime;
	private Double price;
	private Integer availableSeats;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "bus")
	private List<Seat> seats;
}
