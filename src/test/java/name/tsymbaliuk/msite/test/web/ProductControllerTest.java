package name.tsymbaliuk.msite.test.web;

import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import name.tsymbaliuk.msite.web.controller.HelpController;

import name.tsymbaliuk.msite.app.data.ProductRepository;
import name.tsymbaliuk.msite.app.entity.Product;
import name.tsymbaliuk.msite.app.service.ProductService;
import name.tsymbaliuk.msite.web.controller.ProductController;

public class ProductControllerTest  extends junit.framework.TestCase{

	@Test
	public void test() throws Exception {
		Product expectedProduct = new Product();
		expectedProduct.setName("HDMI Cable");
		expectedProduct.setId(1L);
		expectedProduct.setCategories(new String[]{"Computers","TV"});
				
		ProductService mockProdSvc = mock(ProductService.class);
		when(mockProdSvc.findOne(1L)).thenReturn(expectedProduct );
		
		ProductController prodController = new ProductController();
		ReflectionTestUtils.setField( prodController, "productService", mockProdSvc );
		
		MockMvc mockMvc = standaloneSetup(prodController).build();

		//mockMvc.perform(get("/products")).andExpect(view().name("products"));
		
		mockMvc.perform(get("/product/1"))
			.andExpect(view().name("product/show"))
			.andExpect(model().attributeExists("product"))
			.andExpect(model().attribute("product", expectedProduct));
	
	}

}
