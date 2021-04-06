package com.springboot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.pojo.Feedback;
import com.springboot.service.FeedbackService;

@RestController
public class Controller {
	
	@Autowired
	private FeedbackService feedbackService;
	
	@GetMapping(path = "/feedbacks")
	public ModelAndView getAllFeedbacks(Model model) {
		List<Feedback> feedbacks = this.feedbackService.getAllFeedbacks();
		ModelAndView mav = new ModelAndView("feedbacks");
		mav.addObject("feedbacks", feedbacks);
		return mav;
	}
	
	@PostMapping(path = "/feedback")
	public void addFeedback(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		Feedback feedback = new Feedback();
		feedback.setFeedback(request.getParameter("myFeedback"));
		feedback.setFrom(request.getParameter("myFeedbackName"));
		feedback.setDate(new Date());
		this.feedbackService.addFeedback(feedback);
		response.setContentType("text/html");
		response.getWriter().println("<h5 style=\"color: green;\">Added Feedback Successfully</h5>");
		request.getRequestDispatcher("/views/index.jsp").include(request, response);
	}
	
	@GetMapping(path = "/")
	public ModelAndView init() {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
}
