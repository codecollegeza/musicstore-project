package com.compuways.controller;

import com.compuways.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;


	private void getProducts(Model model) {
		model.addAttribute("products", productService.selectProducts());
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal, Model model) {
		getProducts(model);
		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
