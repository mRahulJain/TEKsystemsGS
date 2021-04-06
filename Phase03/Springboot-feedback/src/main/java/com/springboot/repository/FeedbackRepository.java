package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.pojo.Feedback;

@Repository(value = "feedbackRepository")
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
	
}
