package com.capgemini.onlinetest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetest.dao.TestDao;
import com.capgemini.onlinetest.dao.UserDao;
import com.capgemini.onlinetest.entity.Tests;
import com.capgemini.onlinetest.entity.User;
import com.capgemini.onlinetest.exception.EntityAlreadyExists;
import com.capgemini.onlinetest.exception.EntityNotFoundException;

@Service

public class UserService implements UserServiceImpl {

	@Autowired
	UserDao dao;
	@Autowired
	TestDao tdao;

	/*
	 * Add user into database
	 */
	@Override
	/**
	 * to add new user
	 */
	public String addUser(User user) {
		Long id = dao.getIdByEmail(user.getEmail());
		if (id != null)
			throw new EntityAlreadyExists("Email already present");
		dao.save(user);
		return "User Created!!";

	}

	/*
	 * Deletes User from database
	 */
	@Override
	/**
	 * for deleting an user
	 */
	public String deleteUser(String email) {
		long userId = dao.getIdByEmail(email);
		Optional<User> findById = dao.findById(userId);
		if (findById.isPresent()) {
			dao.deleteById(userId);
			return "User Removed";
		} else {
			throw new EntityNotFoundException("User does not exist");
		}

	}

	/*
	 * Update User Details
	 */
	@Override
	/**
	 * to update user by his/her email
	 */
	public String updateUser(String email, User userDetails) {
		Long userId = dao.getIdByEmail(email);
		if (userId != null) {
			Optional<User> findById = dao.findById(userId);
			User usr = findById.get();
			usr.setUserName(userDetails.getUserName());
			usr.setUserPassword(userDetails.getUserPassword());
			dao.save(usr);
			return "User Updated";
		} else {
			throw new EntityNotFoundException("User does not exist");
		}
	}

	/*
	 * Gives list Of all Users
	 */
	@Override
	/**
	 * to see all users except admin
	 */
	public List<User> viewAll() {
		List<User> returnUsers = new ArrayList<User>();
		List<User> userList = dao.findAll();
		for (User user : userList) {
			if (!(user.getIsAdmin().equals("True"))) {
				returnUsers.add(user);
			}
		}
		return returnUsers;
	}

	/*
	 * Finds user Object by Id
	 */
	@Override
	/**
	 * to find user by id
	 */
	public Optional<User> findById(long userId) {
		Optional<User> findById = dao.findById(userId);
		if (findById.isPresent()) {
			return findById;
		} else {
			throw new EntityNotFoundException("User of user id" + userId + "does not exist");
		}
	}

	/*
	 * Assigns Test To User
	 */
	@Override
	/**
	 * to assign test to user
	 */
	public String assignTest(String email, int testId) {
		Long userId = dao.getIdByEmail(email);
		Optional<User> findById = dao.findById(userId);
		Optional<Tests> test = tdao.findById(testId);
		if (findById.isPresent() && test.isPresent()) {
			User usr = findById.get();
			usr.setTestId(testId);
			dao.save(usr);
			return "Test Assigned to user";
		} else {
			throw new EntityNotFoundException("Test with id " + testId +  " does not exist");
		}

	}

	/*
	 * Finds User Object By Email
	 */
	@Override
	/**
	 * to find user by email
	 */
	public User findUserByEmail(String email) {
		Long userId = dao.getIdByEmail(email);
		Optional<User> findById = dao.findById(userId);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			throw new EntityNotFoundException("User not found");
		}

	}
}
