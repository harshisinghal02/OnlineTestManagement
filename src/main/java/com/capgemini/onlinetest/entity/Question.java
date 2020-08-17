package com.capgemini.onlinetest.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Question")
/**
 * 
 * question pojo
 *
 */
public class Question {

	@Id

	private Integer questionId;
	private String questionTitle;
	private int questionAnswer;
	private int questionMarks;
	private int chosenAnswer;
	private int marksScored;
	@OneToMany(targetEntity = Answer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "qp_id", referencedColumnName = "questionId")
	private List<Answer> questionOptions;

	/**
	 * 
	 * @return
	 */
	public Integer getQuestionId() {
		return questionId;
	}

	/**
	 * 
	 * @param questionId
	 */
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	/**
	 * 
	 * @return
	 */
	public String getQuestionTitle() {
		return questionTitle;
	}

	/**
	 * 
	 * @param questionTitle
	 */
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	/**
	 * 
	 * @return
	 */
	public int getQuestionAnswer() {
		return questionAnswer;
	}

	/**
	 * 
	 * @param questionAnswer
	 */
	public void setQuestionAnswer(int questionAnswer) {
		this.questionAnswer = questionAnswer;
	}

	/**
	 * 
	 * @return
	 */
	public int getQuestionMarks() {
		return questionMarks;
	}

	/**
	 * 
	 * @param questionMarks
	 */
	public void setQuestionMarks(int questionMarks) {
		this.questionMarks = questionMarks;
	}

	/**
	 * 
	 * @return
	 */
	public int getChosenAnswer() {
		return chosenAnswer;
	}

	/**
	 * 
	 * @param chosenAnswer
	 */
	public void setChosenAnswer(int chosenAnswer) {
		this.chosenAnswer = chosenAnswer;
	}

	/**
	 * 
	 * @return
	 */
	public int getMarksScored() {
		return marksScored;
	}

	/**
	 * 
	 * @param marksScored
	 */
	public void setMarksScored(int marksScored) {
		this.marksScored = marksScored;
	}

	/**
	 * 
	 * @return
	 */
	public List<Answer> getQuestionOptions() {
		return questionOptions;
	}

	/**
	 * 
	 * @param questionOptions
	 */
	public void setQuestionOptions(List<Answer> questionOptions) {
		this.questionOptions = questionOptions;
	}

	/**
	 * 
	 * @param questionId
	 * @param questionTitle
	 * @param questionAnswer
	 * @param questionMarks
	 * @param chosenAnswer
	 * @param marksScored
	 * @param questionOptions
	 */
	public Question(Integer questionId, String questionTitle, int questionAnswer, int questionMarks, int chosenAnswer,
			int marksScored, List<Answer> questionOptions) {
		super();
		this.questionId = questionId;
		this.questionTitle = questionTitle;
		this.questionAnswer = questionAnswer;
		this.questionMarks = questionMarks;
		this.chosenAnswer = chosenAnswer;
		this.marksScored = marksScored;
		this.questionOptions = questionOptions;
	}

	public Question() {
	}

}
