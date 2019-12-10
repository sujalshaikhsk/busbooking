package com.strikers.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.strikers.busbooking.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
