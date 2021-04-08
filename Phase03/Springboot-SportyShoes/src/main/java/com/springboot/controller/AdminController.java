package com.springboot.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.springboot.service.AdminService;
import com.springboot.service.ProductService;

@RestController
public class AdminController {

	@Autowired
	private ProductService productService;
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/adminLogin")
	public ModelAndView initLogin() {
		ModelAndView modelAndView = new ModelAndView("adminLogin");
		return modelAndView;
	}
	
	@PostMapping("/adminPage")
	public ModelAndView configureAdminPage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(!(username.equals("admin") && password.equals(this.adminService.getAdminPassword().getPassword()))) {
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
	
	@GetMapping("/changePassword")
	public ModelAndView changePassword() {
		ModelAndView modelAndView = new ModelAndView("changeAdminPassword");
		return modelAndView;
	}
	
	@PostMapping("/changeAdminPassword")
	public void changeAdminPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String enteredOldPassword = request.getParameter("oldPassword");
		String enteredNewPassword1 = request.getParameter("newPassword1");
		String enteredNewPassword2 = request.getParameter("newPassword2");
		
		PrintWriter writer = response.getWriter();
		String oldPassword = this.adminService.getAdminPassword().getPassword();
		
		if(!oldPassword.equals(enteredOldPassword)) {
			request.getRequestDispatcher("/views/changeAdminPassword.jsp").include(request, response);
			writer.println("<h3 style=\"color: red;\">Wrong Old Password entered!<h3>");
			return;
		}
		
		if(!enteredNewPassword1.equals(enteredNewPassword2)) {
			request.getRequestDispatcher("/views/changeAdminPassword.jsp").include(request, response);
			writer.println("<h3 style=\"color: red;\">New Password's do not match!<h3>");
			return;
		}
		
		
		this.adminService.changePassword(enteredNewPassword1);
		request.getRequestDispatcher("/views/changeAdminPassword.jsp").include(request, response);
		writer.println("<h3 style=\"color: green;\">Password Changed!<h3>");
		return;
	}
}
