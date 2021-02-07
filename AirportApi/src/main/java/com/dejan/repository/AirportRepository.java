package com.dejan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dejan.model.Airport;

public interface AirportRepository extends JpaRepository<Airport, Long>{

	
}
