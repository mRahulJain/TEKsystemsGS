package com.springboot.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.pojo.Product;
import com.springboot.pojo.Purchase;
import com.springboot.pojo.Shopper;
import com.springboot.service.ProductService;
import com.springboot.service.PurchaseService;
import com.springboot.service.ShopperService;

@RestController
public class ShopperController {

	@Autowired
	private ShopperService shopperService;
	@Autowired
	private ProductService productService;
	@Autowired
	private PurchaseService purchaseService;
	
	@GetMapping("/login")
	public ModelAndView initLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@GetMapping("/register")
	public ModelAndView initRegister() {
		ModelAndView modelAndView = new ModelAndView("register");
		return modelAndView;
	}
	
	@PostMapping(path = "/home")
	public ModelAndView checkShopperCred(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		List<Shopper> currentShopper = this.shopperService.getShopperByUsername(username);
		if(email == null) {
			if(!this.shopperService.getAndCheckShopper(username, password)) {
				response.setContentType("text/html");
				request.getRequestDispatcher("/views/login.jsp").include(request, response);
				response.getWriter().println("<h4 style=\"color: red; text-align:center;\">Bad Credentials</h4>");
				return null;
			}
		} else {
			try {
				Long phoneNumber = Long.parseLong(request.getParameter("phoneNumber"));
				Shopper shopper = new Shopper(
						username,
						password,
						firstName,
						lastName,
						email,
						phoneNumber,
						address
				);
				System.out.println(shopper.toString());
				this.shopperService.addShopper(shopper);
			} catch(Exception e) {
				response.setContentType("text/html");
				response.getWriter().println("<h5 style=\"color: red; text-align:center;\">Username, Email Or Phone Number already registered</h5>");
				request.getRequestDispatcher("/views/register.jsp").include(request, response);
				return null;
			}
		}
		
		ModelAndView modelAndView = new ModelAndView("home");
		List<Product> products = this.productService.getAllProducts();
		modelAndView.addObject("userId", currentShopper.get(0).getId());
		modelAndView.addObject("products", products);
		return modelAndView;
	}
	
	@PostMapping("/product/buy")
	public ModelAndView buyProduct(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("buyProduct");
		Product product = this.productService.getProductById(Integer.parseInt(request.getParameter("productId")));
		Shopper shopper = this.shopperService.getShopper(Integer.parseInt(request.getParameter("shopperId")));
		modelAndView.addObject("product", product);
		modelAndView.addObject("shopper", shopper);
		return modelAndView;
	}
	
	@PostMapping("/product/dummyPayment")
	public ModelAndView initDummyPayment(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("dummyPayment");
		Product product = this.productService.getProductById(Integer.parseInt(request.getParameter("productId")));
		modelAndView.addObject("productId", Integer.parseInt(request.getParameter("productId")));
		modelAndView.addObject("shopperId", Integer.parseInt(request.getParameter("shopperId")));
		modelAndView.addObject("product", product);
		modelAndView.addObject("productQuantity", Integer.parseInt(request.getParameter("quantity")));
		return modelAndView;
	}
	
	@PostMapping("/home/{shopperId}")
	public ModelAndView getHome(@PathVariable int shopperId) {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Product> products = this.productService.getAllProducts();
		modelAndView.addObject("userId", shopperId);
		modelAndView.addObject("products", products);
		return modelAndView;
	}
	
	@PostMapping("/product/completePayment")
	public ModelAndView completePurchase(HttpServletRequest request) {
		Product product = this.productService.getProductById(Integer.parseInt(request.getParameter("productId")));
		Purchase purchase = new Purchase(
				Integer.parseInt(request.getParameter("shopperId")),
				Integer.parseInt(request.getParameter("productId")),
				product.getCategory(),
				new Date(),
				Integer.parseInt(request.getParameter("productQuantity")),
				Integer.parseInt(request.getParameter("productQuantity"))*product.getProductPrice()
		);
		this.purchaseService.addPurchase(purchase);
		ModelAndView modelAndView = new ModelAndView("finalBuyPage");
		modelAndView.addObject("shopperId", Integer.parseInt(request.getParameter("shopperId")));
		modelAndView.addObject("product", product);
		modelAndView.addObject("purchaseQuantity", Integer.parseInt(request.getParameter("productQuantity")));
		modelAndView.addObject("purchaseAmount", Integer.parseInt(request.getParameter("productQuantity"))*product.getProductPrice());
		return modelAndView;
	}
	
}
