package com.dejan.conreoller;

import java.io.Serializable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController implements Serializable {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 7327076055966131773L;

	@RequestMapping(value = {"/"})
	    public String home(){
	        return "/";
	    }

	    @RequestMapping(value = {"/login"})
	    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
	                       @RequestParam(value = "logout", required = false) String logout) {

	        ModelAndView model = new ModelAndView();
	        if (error != null) {
	            model.addObject("error", "Invalid username and password!");
	        }

	        if (logout != null) {
	            model.addObject("msg", "You've been logged out successfully.");
	        }
	        model.setViewName("/");

	        return model;
	    }

	}