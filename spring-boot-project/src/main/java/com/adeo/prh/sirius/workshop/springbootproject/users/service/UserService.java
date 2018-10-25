package com.adeo.prh.sirius.workshop.springbootproject.users.service;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.adeo.prh.sirius.workshop.springbootproject.users.entity.User;

@Component
public class UserService {

	private Map<Long, User> users = Map.of(1l, new User(1, "Alison", "Conrad"), 2l, new User(2, "Trace", "Pham"), 3l,
			new User(3, "Karma", "Sosa"), 4l, new User(4, "Jake", "Riggs"), 5l, new User(5, "Estrella", "Burns"), 6l,
			new User(6, "Abbigail", "Dickson"), 7l, new User(7, "Marley", "Compton"));

	public Collection<User> getUsers(String firstName, String lastName, String city) {
		return users.values();
	}

	public User getUser(long userId) {
		return users.get(userId);
	}
}
