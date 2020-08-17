package com.capgemini.onlinetest.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.capgemini.onlinetest.dao.TestDao;
import com.capgemini.onlinetest.entity.Tests;
import com.capgemini.onlinetest.exception.EntityNotFoundException;

/*************************************************************************************************************************************
- File Name        : TestService.java
- Author           : Capgemini
- Creation Date    : 13-08-2020
- Description      : This Service class is provide all the business logic for test.
 ************************************************************************************************************************************/

@Service
public class TestService implements TestServiceImpl {
	
	static Logger logger=LoggerFactory.getLogger(TestService.class);

	@Autowired
	TestDao dao;

	/**************************************************
	  Add test with auto-generated test id
	 **************************************************/

	@Override
	public Tests addTest(@Validated Tests test) {
		return dao.save(test);
	}

	/******************************************************
	 * Delete test by test id.
	 * Test must be present to be deleted
	 *****************************************************/

	@Override
	public String deleteTest(int testId) {

		Optional<Tests> findById = dao.findById(testId);
		
		if (findById.isPresent()) {
			dao.deleteById(testId);
			logger.info("Test deleted successfully");
			return "Test deleted";
		} 
		
		else {
			logger.info("No test found with test id ");
			throw new EntityNotFoundException("No test found with test id " + testId);
		}

	}

	/**********************************************
	 * Update test by test id.
	 * Test must be present to be updated
	 *********************************************/

	@Override
	public String updateTest(int testId, @Validated Tests test) {
	
		Optional<Tests> tst = dao.findById(testId);
		
		if (tst.isPresent()) {
			Tests t = tst.get();
			t.setStartTime(test.getStartTime());
			t.setEndTime(test.getEndTime());
			t.setTestDuration(test.getTestDuration());
			t.setTestTitle(test.getTestTitle());
			t.setTestTotalMarks(test.getTestTotalMarks());
			dao.save(t);
			logger.info("Test Updated Successfully");
			return "Test Updated";
		} 
		
		else {
			logger.info("No test found with test id ");
			throw new EntityNotFoundException("No test found with test id " + testId);
		}

	}

	/**********************************************
	 * View all tests
	 *********************************************/

	@Override
	public List<Tests> viewAll() {
		
		logger.info("All tests available are: ");
		return dao.findAll();
	}

/*************************************************************************************************************************************
	 * Find test by id.
	 * Test must be present.
*************************************************************************************************************************************/

	@Override
	public Optional<Tests> findTestById(int id) {

		Optional<Tests> findById = dao.findById(id);
		
		if (findById.isPresent()) {
			return findById;
		} 
		
		else {
			logger.info("No test found with test id ");
			throw new EntityNotFoundException("No test found with test id " + id);
		}

	}

}
