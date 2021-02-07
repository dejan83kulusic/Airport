package com.dejan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dejan.model.RoutDestination;

public interface RoutDestinationRepository extends JpaRepository<RoutDestination, Long> {

	List<RoutDestination> findAllById(int id);
}
