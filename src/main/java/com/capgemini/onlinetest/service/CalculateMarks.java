package com.capgemini.onlinetest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinetest.dao.TestDao;
import com.capgemini.onlinetest.entity.Question;
import com.capgemini.onlinetest.entity.Tests;

@Service
/**
 * 
 * service layer for calculate marks
 *
 */
public class CalculateMarks {
	@Autowired
	TestDao tdao;

	/**
	 * 
	 * @param test
	 * @return
	 */
	public int getResults(Tests test) {
		int marks = 0;

		int id = test.getTestId();

		Optional<Tests> tst = tdao.findById(id);

		if (tst.isPresent()) {
			Tests test1 = tst.get();

			List<Question> questions = test1.getTestQuestions();
			List<Question> questions1 = test.getTestQuestions();
			for (Question q : questions) {
				for (Question q1 : questions1) {
					if ((q.getQuestionId().equals(q1.getQuestionId())) && (q.getQuestionAnswer() == q1.getChosenAnswer())) {
						q.setMarksScored(q.getQuestionMarks());
						marks = marks + q.getQuestionMarks();
						continue;
					}
				}

			}
			return marks;
		} else
			return 0;

	}
}
