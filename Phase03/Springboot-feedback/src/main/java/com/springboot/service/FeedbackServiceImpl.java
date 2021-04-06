package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.pojo.Feedback;
import com.springboot.repository.FeedbackRepository;

@Service(value = "feedbackService")
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@Override
	public void addFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}

}
