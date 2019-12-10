package com.strikers.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strikers.busbooking.entity.BookingDetail;

public interface BookingDetailRepository extends JpaRepository<BookingDetail, Integer> {

}
