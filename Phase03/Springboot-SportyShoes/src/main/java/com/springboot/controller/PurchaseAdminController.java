package com.springboot.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.pojo.Purchase;
import com.springboot.repository.PurchaseRepository;
import com.springboot.service.PurchaseService;

@RestController
public class PurchaseAdminController {

	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping("/purchaseList")
	public ModelAndView initPurchaseList() {
		ModelAndView modelAndView = new ModelAndView("purchaseList");
		List<Purchase> purchases = this.purchaseService.getAllPurchase();
		modelAndView.addObject("purchases", purchases);
		return modelAndView;
	}
	
	@GetMapping("/filteredPurchaseListDate")
	public ModelAndView purchaseListByDate(HttpServletRequest request) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("purchaseList");
		Date date = Date.valueOf(request.getParameter("date"));
		String[] datePart = date.toString().split("-");
		String[] month = {"", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEPT", "OCT", "NOV", "DEC"};
		String dateString = "";
		dateString += datePart[2]+"-";
		dateString += month[Integer.parseInt(datePart[1])]+"-";
		dateString += datePart[0].substring(2, 4);
		List<Purchase> purchases = this.purchaseService.filterByDate(dateString);
		modelAndView.addObject("purchases", purchases);
		return modelAndView;
	}
	
	@GetMapping("/filteredPurchaseListCategory")
	public ModelAndView purchaseListByCategory(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("purchaseList");
		String category = request.getParameter("productCategory");
		List<Purchase> purchases = this.purchaseService.filterByCategory(category);
		modelAndView.addObject("purchases", purchases);
		return modelAndView;
	}
	
}
