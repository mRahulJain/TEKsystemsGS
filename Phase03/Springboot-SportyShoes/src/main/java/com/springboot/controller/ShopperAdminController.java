package com.springboot.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.springboot.pojo.Shopper;
import com.springboot.service.ShopperService;

@RestController
public class ShopperAdminController {
	
	@Autowired
	private ShopperService shopperService;

	@GetMapping("/userList")
	public ModelAndView initUserList() {
		ModelAndView modelAndView = new ModelAndView("userList");
		List<Shopper> shoppers = this.shopperService.getShoppers();
		modelAndView.addObject("shoppers", shoppers);
		return modelAndView;
	}
	
	@GetMapping("/filteredUserList")
	public ModelAndView searchResult(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("userList");
		List<Shopper> shoppers = this.shopperService.getShopperByUsername(request.getParameter("like"));
		modelAndView.addObject("shoppers", shoppers);
		return modelAndView;
	}
}
