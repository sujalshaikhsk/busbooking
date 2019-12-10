package com.strikers.busbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.strikers.busbooking.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query("select b from Booking b inner join BookingDetail bd where bd.mobileNumber=:searchKey or b.ticketNumber=:searchKey")
	List<Booking> searchBooking(@Param("searchKey") String searchKey);

}
