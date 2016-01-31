package name.tsymbaliuk.msite.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import java.util.List;

import name.tsymbaliuk.msite.app.entity.Product;
import name.tsymbaliuk.msite.app.service.ProductService;

@Controller
public class ProductController {
	
	@Inject
	private ProductService productService;
	
	@RequestMapping("/products")
	String listProducts(Model model){
		// byDefault ViewResolver will search for the view name listProduct
		model.addAttribute("productList", productService.findAll());
		return "products";
	}
	
	@RequestMapping({"/product/{productId}"})
	String listProducts(@PathVariable Long productId, Model model){
		// byDefault ViewResolver will search for the view name listProduct
		model.addAttribute(productService.findOne(productId));
		return "product/show";
	}
}
