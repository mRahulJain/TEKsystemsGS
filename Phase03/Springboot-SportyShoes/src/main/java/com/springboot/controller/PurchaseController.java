package com.springboot.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.pojo.Purchase;
import com.springboot.repository.PurchaseRepository;
import com.springboot.service.PurchaseService;

@Controller
public class PurchaseController {

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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(request.getParameter("date"));
		List<Purchase> purchases = this.purchaseService.filterByDate(date);
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
