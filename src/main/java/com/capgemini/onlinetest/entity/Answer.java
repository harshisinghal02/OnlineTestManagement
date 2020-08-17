package com.capgemini.onlinetest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
/*
 * pojo class for answer
 */
public class Answer {

	@Id
	private int id;
	private String value;

	/**
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return
	 */

	public String getValue() {
		return value;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 
	 * @param id
	 * @param value
	 */

	public Answer(int id, String value) {

		this.id = id;
		this.value = value;
	}

	public Answer() {

	}

}
