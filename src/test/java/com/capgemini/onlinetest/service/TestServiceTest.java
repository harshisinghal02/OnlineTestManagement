package com.capgemini.onlinetest.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.onlinetest.entity.Tests;

class TestServiceTest {

	static Logger logger=LoggerFactory.getLogger(TestServiceTest.class);

	RestTemplate template;
	
	@BeforeEach
	public void setUp()
	{
	  template = new RestTemplate();		
	}
	
	@Test
	void testAddTest() {
		Tests Tests=new Tests();
		Tests.setTestId(1101);
		Tests.setTestTitle("Evaluation");
		Tests.setTestTotalMarks(100);
		
		Tests test=template.postForObject("http://localhost:9092/test/addTest", 
					Tests, Tests.class);
		Assertions.assertNotNull(test);
		logger.info("Add Test Working..."+test);
	
	}


	@Test
	void testDeleteTest() {
		Tests Tests = new Tests();
		Tests.setTestId(122);
		
		template.delete("http://localhost:9092/test/deleteTest/122", Tests);
		logger.info("Delete Test works ");
	}
	
	
	@Test
	void testgetTestById() {
			
		Tests Tests = new Tests();
		Tests.setTestId(123);
		
		ResponseEntity<Tests> test=template.getForEntity("http://localhost:9092/test/findTestById/123", Tests.class);
		Assertions.assertNotNull(test);
		logger.info(" Search Test By Id Works "+ test.getStatusCode());
	}

}
