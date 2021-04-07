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
import org.springframework.web.servlet.ModelAndView;

import com.springboot.pojo.Product;
import com.springboot.service.ProductService;

@Controller
public class ProductAdminController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(path = "/product/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		this.productService.deleteProduct(id);
		return "redirect:/productList";
	}
	
	@GetMapping("/productList")
	public ModelAndView initProductList() {
		ModelAndView modelAndView = new ModelAndView("productList");
		List<Product> list = this.productService.getAllProducts();
		modelAndView.addObject("products", list);
		return modelAndView;
	}
	
	@GetMapping("/addProduct")
	public ModelAndView initAddProduct() {
		ModelAndView modelAndView = new ModelAndView("addProduct");
		return modelAndView;
	}
	
	@PostMapping("/productAdd")
	public String addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		String productImage = request.getParameter("productImage");
		String productCompany = request.getParameter("productCompany");
		String productIsAvailable = request.getParameter("productIsAvailable");
		String productCategory = request.getParameter("productCategory");
		
		if(productCategory.equals("Select")) {
			response.setContentType("text/html");
			request.getRequestDispatcher("/views/addProduct.jsp").include(request, response);
			response.getWriter().println("<h4 style=\"color: red; text-align:center;\">Please Select A Category</h4>");
			return null;
		}
		
		Product product = new Product(
				productName,
				Double.parseDouble(productPrice),
				productImage,
				productCompany,
				Integer.parseInt(productIsAvailable),
				productCategory
		);
		try {
			this.productService.addProduct(product);
			return "redirect:/productList";
		} catch (Exception e) {
			response.setContentType("text/html");
			request.getRequestDispatcher("/views/addProduct.jsp").include(request, response);
			response.getWriter().println("<h4 style=\"color: red; text-align:center;\">Product Already Present!</h4>");
			return null;
		}
	}
	
	@GetMapping("/product/update/{id}")
	public ModelAndView initUpdateProduct(@PathVariable int id) {
		ModelAndView modelAndView = new ModelAndView("updateProduct");
		Product product = this.productService.getProductById(id);
		modelAndView.addObject("product", product);
		return modelAndView;
	}
	
	@PostMapping("product/update/productUpdate")
	public String updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String productId = request.getParameter("productId");
		String productName = request.getParameter("productName");
		String productPrice = request.getParameter("productPrice");
		String productImage = request.getParameter("productImage");
		String productCompany = request.getParameter("productCompany");
		String productIsAvailable = request.getParameter("productIsAvailable");
		String productCategory = request.getParameter("productCategory");
		
		Product product = new Product(
				productName,
				Double.parseDouble(productPrice),
				productImage,
				productCompany,
				Integer.parseInt(productIsAvailable),
				productCategory
		);
		product.setId(Integer.parseInt(productId));
		try {
			this.productService.deleteProduct(Integer.parseInt(productId));
			this.productService.addProduct(product);
			return "redirect:/productList";
		} catch (Exception e) {
			response.setContentType("text/html");
			request.getRequestDispatcher("/views/updateProduct.jsp").include(request, response);
			response.getWriter().println("<h4 style=\"color: red; text-align:center;\">Oops!! Something went wrong.</h4>");
			return null;
		}
	}
	
}
