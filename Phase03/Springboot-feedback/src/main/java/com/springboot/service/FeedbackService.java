package com.springboot.service;

import java.util.List;
import com.springboot.pojo.Feedback;

public interface FeedbackService {

	public List<Feedback> getAllFeedbacks();
	
	public void addFeedback(Feedback feedback);
	
}
