package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.Task;
import com.hashedin.model.User;
import com.hashedin.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public User find(Long userId) {
		// Returns the User for given UserId.
		return userRepository.find(userId);
	}

	@Transactional
	public User save(User user) {
		// Saves the given User object and returns the same.
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> findAll() {
		// Returns all the Users in our system.
		return userRepository.findAll();
	}

	@Override
	public User update(User user, Long userId) {
		// Updates the User with the given UserId;
		return null;
	}

	@Transactional
	public User delete(Long userId) {
		// Deletes the User with the give UserId and returns the same.
		return userRepository.delete(userId);
	}

	@Override
	public List<Task> findTasksForUser(long userId) {
		return userRepository.find(userId).getTasks();
	}

}
