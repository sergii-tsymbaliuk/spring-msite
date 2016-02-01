package name.tsymbaliuk.msite.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import name.tsymbaliuk.msite.app.entity.Product;
import name.tsymbaliuk.msite.app.entity.ProductCategory;
import name.tsymbaliuk.msite.app.service.CategoryService;
import name.tsymbaliuk.msite.app.service.ProductService;

@Controller
@RequestMapping("/admin")
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
	List<Product> adminProducts(@RequestParam(required = false) Long categoryId){
		return categoryId == null ? prodSvc.findAll() : new ArrayList<Product> (categorySvc.getOne(categoryId).getProducts());
	}
	
	@RequestMapping(value="/categories",method=RequestMethod.GET)
	List<ProductCategory> adminCategories(){
		return categorySvc.findAll();
	}
}
