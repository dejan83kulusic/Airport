package com.dejan.conreoller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dejan.model.Airport;
import com.dejan.repository.AirportRepository;
import com.dejan.repository.UserRepository;

@Controller
public class AirportController {
	private final AirportRepository repository;

	  public AirportController(AirportRepository repository) {
		super();
		this.repository = repository;
	}




	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/airports")
	  public List<Airport> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/airports")
	  public Airport newAirport(@RequestBody Airport newAirport) {
	    return repository.save(newAirport);
	  }

	  // Single item

	  @GetMapping("/airports/{id}")
	  public Optional<Airport> one(@PathVariable Long id) {

	    return repository.findById(id);
	      
	  }

	  @PutMapping("/airports/{id}")
	  public Airport replaceAirport(@RequestBody Airport newAirport, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(airport -> {
	        airport.setCity(newAirport.getCity());
	        airport.setCountry(newAirport.getCountry());
	        airport.setDate(newAirport.getDate());
	        airport.setLatitude(newAirport.getLatitude());
	        airport.setLongitude(newAirport.getLongitude());
	        airport.setOlsonTime(newAirport.getOlsonTime());
	        airport.setAltitude(newAirport.getAltitude());
	        return repository.save(airport);
	      })
	      .orElseGet(() -> {
	        newAirport.setId(id);
	        return repository.save(newAirport);
	      });
	  }

	 
	

}
