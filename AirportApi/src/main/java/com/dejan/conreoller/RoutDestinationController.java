package com.dejan.conreoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dejan.model.Airport;
import com.dejan.model.RoutDestination;
import com.dejan.repository.RoutDestinationRepository;
import com.dejan.service.Solucija;

public class RoutDestinationController {

	
	
	@Autowired
    private RoutDestinationRepository repository;
	
	
	@Autowired
	private Solucija solucija;
	
	private int flight;
	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/routs")
	  public List<RoutDestination> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/routs")
	  public RoutDestination newRoutDestinatiob(@RequestBody RoutDestination newRoutDestination) {
	    return repository.save(newRoutDestination);
	  }

	  // Single item

	  @GetMapping("/routs/{id}")
	  public Optional<RoutDestination> one(@PathVariable Long id) {

	    return repository.findById(id);
	      
	  }

	 
	private int findCheepestprice() {
		return flight=solucija.findCheapestPrice(0, null, 0, 0, 0);
	}
	
}
