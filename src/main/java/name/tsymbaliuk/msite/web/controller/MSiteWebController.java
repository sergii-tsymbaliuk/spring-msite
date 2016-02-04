package name.tsymbaliuk.msite.web.controller;

import javax.inject.Inject;

import name.tsymbaliuk.msite.app.service.MSiteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MSiteWebController {
	
	@Inject
	private MSiteService service;
	
	@RequestMapping("/products")
	String listProducts(Model model){
		// byDefault ViewResolver will search for the view name listProduct
		model.addAttribute("productList", service.findAllProducts());
		return "products";
	}
	
	@RequestMapping({"/product/{productId}"})
	String listProducts(@PathVariable Long productId, Model model){
		// byDefault ViewResolver will search for the view name listProduct
		model.addAttribute(service.findProductById(productId));
		return "product/show";
	}
}
