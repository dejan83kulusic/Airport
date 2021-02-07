package com.dejan.conreoller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dejan.repository.UserRepository;
import com.dejan.model.User;
@Controller
public class UserConroller  implements Serializable {

	
	  /**
	 * 
	 */
	private static final long serialVersionUID = -1826024826289613858L;
	private final UserRepository repository;

	  UserConroller(UserRepository repository) {
	    this.repository = repository;
	  }


	  // Aggregate root
	  // tag::get-aggregate-root[]
	  @GetMapping("/users")
	  public List<User> all() {
	    return repository.findAll();
	  }
	  // end::get-aggregate-root[]

	  @PostMapping("/users")
	  public User newUser(@RequestBody User newUser) {
	    return repository.save(newUser);
	  }

	  // Single item

	  @GetMapping("/users/{id}")
	  public Optional<User> one(@PathVariable Long id) {

	    return repository.findById(id);
	      
	  }

	  @PutMapping("/users/{id}")
	  public User replaceUser(@RequestBody User newUser, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(user -> {
	        user.setFirstName(newUser.getFirstName());
	        user.setLastName(newUser.getLastName());
	        user.setUsername(newUser.getUsername());
	        user.setPassword(newUser.getPassword());
	        user.setRoles(newUser.getRoles());
	        return repository.save(user);
	      })
	      .orElseGet(() -> {
	        newUser.setId(id);
	        return repository.save(newUser);
	      });
	  }

	  @DeleteMapping("/users/{id}")
	  public void deleteUser(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	
	}