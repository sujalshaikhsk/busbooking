package com.strikers.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strikers.busbooking.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {

}
