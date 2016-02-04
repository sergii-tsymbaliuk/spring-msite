package name.tsymbaliuk.msite.web.controller;

import java.util.Collection;

import javax.inject.Inject;

import name.tsymbaliuk.msite.app.service.MSiteService;
import name.tsymbaliuk.msite.app.service.MSiteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import name.tsymbaliuk.msite.app.entity.Product;
import name.tsymbaliuk.msite.app.entity.ProductCategory;

@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController {
	@Inject
	MSiteService service;

	@RequestMapping(method=RequestMethod.GET)
	String adminHome(){
		return "/admin/main";
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	String adminProducts(@RequestParam(required = false) Long categoryId, Model model){
		//TODO: Move business logic to the service
		Collection<Product> products;
		if (categoryId != null) {
			products = service.findProductsByCategoryId(categoryId);
		} else {
			products = service.findAllProducts();
		}
		//products.forEach( p -> p.setCategories(p.getCategories()));
		model.addAttribute("productList",products);
		return "/admin/products";
	}
	
	@RequestMapping(value="/categories",method=RequestMethod.GET)
	Collection<ProductCategory> adminCategories(){
		return service.findAllCategories();
	}
}
