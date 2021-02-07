package com.dejan.conreoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dejan.model.User;
import com.dejan.service.SecurityService;
import com.dejan.service.UserService;



public class RegisterController {
	   @Autowired
	    private UserService userService;

	    @Autowired
	    private SecurityService securityService;

	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    @RequestMapping("/register")
	    public String register(Model model) {

	        model.addAttribute("userForm", new User());

	        return "/";
	    }

	    @RequestMapping(value = "/register", method = RequestMethod.POST)
	    public String register(@ModelAttribute("userForm") @Validated User userForm, BindingResult bindingResult, Model model) {

	        if (bindingResult.hasErrors()) {
	            return "/";
	        }

	        userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
	        userService.save(userForm);

	        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

	        return "/";
	    }

}
