package com.capgemini.onlinetest.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.onlinetest.entity.Tests;

public interface TestServiceImpl {

	public Tests addTest(Tests test);
	public String deleteTest(int testId);
	public String updateTest(int testId,Tests test);
	public List<Tests> viewAll();
	public Optional<Tests> findTestById(int id);
}
