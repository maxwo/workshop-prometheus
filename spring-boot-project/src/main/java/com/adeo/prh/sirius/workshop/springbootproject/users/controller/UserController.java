package com.adeo.prh.sirius.workshop.springbootproject.users.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adeo.prh.sirius.workshop.springbootproject.users.entity.User;
import com.adeo.prh.sirius.workshop.springbootproject.users.service.UserService;

@RestController
public class UserController {
	
	private static final String ALL_SEARCH_COUNTER = "user_api.search.search.all";
	
	@Autowired
	private UserService userService;

	@Autowired
	private CounterService counterService;

	@RequestMapping("/users")
    public Collection<User> search(
    		@RequestParam(value="firstName", required=false) String firstName,
    		@RequestParam(value="lastName", required=false) String lastName,
    		@RequestParam(value="city", required=false) String city) {
		counterService.increment(ALL_SEARCH_COUNTER);
        return userService.getUsers(firstName, lastName, city);
    }

	@RequestMapping("/users/{userId}")
    public User index(@PathVariable long userId) {
        return userService.getUser(userId);
    }

}
