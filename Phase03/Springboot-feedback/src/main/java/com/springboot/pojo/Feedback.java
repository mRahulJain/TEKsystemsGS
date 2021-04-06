package com.springboot.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FEEDBACK_ID")
	private int id;
	
	@Column(name = "FEEDBACK")
	@NotEmpty
	private String feedback;
	
	@Column(name = "FEEDBACK_FROM")
	@NotEmpty
	private String from;
	
	@Column(name = "FEEDBACK_DATE")
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", feedback=" + feedback + ", from=" + from + ", date=" + date + "]";
	}

	public Feedback(String feedback, String from) {
		super();
		this.feedback = feedback;
		this.from = from;
	}
	
	public Feedback() {
		super();
	}
	
}
