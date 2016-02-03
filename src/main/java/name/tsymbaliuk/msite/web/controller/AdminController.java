package name.tsymbaliuk.msite.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import name.tsymbaliuk.msite.app.entity.Product;
import name.tsymbaliuk.msite.app.entity.ProductCategory;
import name.tsymbaliuk.msite.app.service.CategoryService;
import name.tsymbaliuk.msite.app.service.ProductService;

@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController {
	@Inject
	ProductService prodSvc;
	@Inject
	CategoryService categorySvc;
	
	@RequestMapping(method=RequestMethod.GET)
	String adminHome(){
		return "/admin/main";
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	String adminProducts(@RequestParam(required = false) Long categoryId, Model model){
		List<Product> products;
		if (categoryId != null) {
			products = prodSvc.findByCategoryId (categoryId);
		} else {
			products = prodSvc.findAll();
		}
		products.forEach(p -> {
			p.setCategories(p.getCategories());
		});
		model.addAttribute("productList",products);
//		model.addAttribute("categoryList",categorySvc.findAll());
		///products.forEach(Product::getCategories);
		return "/admin/products";
	}
	
	@RequestMapping(value="/categories",method=RequestMethod.GET)
	List<ProductCategory> adminCategories(){
		return categorySvc.findAll();
	}
}
