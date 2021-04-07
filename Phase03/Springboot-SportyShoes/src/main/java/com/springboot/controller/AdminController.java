package com.springboot.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.pojo.Product;
import com.springboot.service.ProductService;

@RestController
public class AdminController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/adminLogin")
	public ModelAndView initLogin() {
		ModelAndView modelAndView = new ModelAndView("adminLogin");
		return modelAndView;
	}
	
	@PostMapping("/adminPage")
	public ModelAndView configureAdminPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(!(username.equals("admin") && password.equals("root"))) {
			response.setContentType("text/html");
			request.getRequestDispatcher("/views/adminLogin.jsp").include(request, response);
			response.getWriter().println("<h4 style=\"color: red; text-align:center;\">Bad Credentials</h4>");
			return null;
		}
		ModelAndView modelAndView = new ModelAndView("adminPage");
		return modelAndView;
	}
	
	@GetMapping("/adminPage")
	public ModelAndView configureAdminPage() {
		ModelAndView modelAndView = new ModelAndView("adminPage");
		return modelAndView;
	}
}
