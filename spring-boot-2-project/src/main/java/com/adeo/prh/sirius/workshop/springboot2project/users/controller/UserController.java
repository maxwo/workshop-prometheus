package com.adeo.prh.sirius.workshop.springboot2project.users.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adeo.prh.sirius.workshop.springboot2project.users.entity.User;
import com.adeo.prh.sirius.workshop.springboot2project.users.service.UserService;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Metrics;

@RestController
public class UserController {

	private static final String SEARCH_COUNTER = "user_api_search";
	
	@Autowired
	private UserService userService;

	@Timed("user_search")
	@RequestMapping("/users")
    public Collection<User> search(
    		@RequestParam(value="firstName", required=false) String firstName,
    		@RequestParam(value="lastName", required=false) String lastName,
    		@RequestParam(value="city", required=false) String city) {
		Metrics.counter(SEARCH_COUNTER, "search", "all");
        return userService.getUsers();
    }

	@RequestMapping("/users/{userId}")
    public User index(@PathVariable long userId) {
        return userService.getUser(userId);
    }

}
