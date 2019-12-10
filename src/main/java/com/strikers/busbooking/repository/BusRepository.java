package com.strikers.busbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.strikers.busbooking.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {

}
