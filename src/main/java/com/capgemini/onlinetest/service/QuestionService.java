package com.capgemini.onlinetest.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetest.controller.TestController;
import com.capgemini.onlinetest.dao.QuestionDao;
import com.capgemini.onlinetest.dao.TestDao;
import com.capgemini.onlinetest.entity.Question;
import com.capgemini.onlinetest.entity.Tests;
import com.capgemini.onlinetest.exception.EntityNotFoundException;

@Service
/**
 * 
 * service for Question
 *
 */
public class QuestionService implements QuestionServiceImpl {
	@Autowired
	QuestionDao dao;

	@Autowired
	TestDao testDao;


	Logger logger = LoggerFactory.getLogger(QuestionService.class);
	@Override
	/*
	 * method to add questions
	 */
	public String addQuestion(int testId, Question question) {
		
		Optional<Tests> findById = testDao.findById(testId);
		if (findById.isPresent()) {
			Tests test = findById.get();
			test.setTestTotalMarks(test.getTestTotalMarks() + question.getQuestionMarks());
			List<Question> ques = test.getTestQuestions();
			ques.add(question);
			test.setTestQuestions(ques);
			testDao.save(test);
			return "question added";
		} else {
			throw new EntityNotFoundException("Test Not Found and Question Not Added");
		}

	}

	@Override
	/**
	 * method to delete question
	 */
	public String deleteQuestion(int questionId) {
		Optional<Question> findById = dao.findById(questionId);
		if (findById.isPresent()) {
			dao.deleteById(questionId);
			return "Question deleted";
		} else {
			throw new EntityNotFoundException("Question Not Found for Id" + questionId);
		}
	}

	@Override
	/**
	 * method to update question
	 * 
	 */
	public String updateQuestion(int questionId, Question ques) {

		Optional<Question> findById = dao.findById(questionId);
		if (findById.isPresent()) {
			Question q = findById.get();
			q.setQuestionTitle(ques.getQuestionTitle());
			q.setQuestionOptions(ques.getQuestionOptions());
			q.setQuestionAnswer(ques.getQuestionAnswer());
			q.setQuestionMarks(ques.getQuestionMarks());
			dao.save(q);
			return "Question Updated";
		} else {
			throw new EntityNotFoundException("Question Not Found for Id" + questionId);
		}

	}

	@Override
	/**
	 * to view allquestion
	 */

	public List<Question> viewAll() {
		
		return dao.findAll();
	}

	@Override
	/**
	 * to find question by id
	 */
	public Optional<Question> findById(int id) {

		Optional<Question> findById = dao.findById(id);
		if (findById.isPresent()) {
			return findById;
		} else {
			throw new EntityNotFoundException("Question Not Found for Id" + id);
		}

	}

}
