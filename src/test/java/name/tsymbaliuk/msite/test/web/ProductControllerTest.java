package name.tsymbaliuk.msite.test.web;

import name.tsymbaliuk.msite.app.service.MSiteService;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import name.tsymbaliuk.msite.app.entity.Product;
import name.tsymbaliuk.msite.web.controller.MSiteWebController;

public class ProductControllerTest  extends junit.framework.TestCase{

	@Test
	public void test() throws Exception {
		Product expectedProduct = new Product.Builder()
									.name("HDMI Cable")
									.description("Test product")
									.build();
		expectedProduct.setId(1L);
				
		MSiteService mockProdSvc = mock(MSiteService.class);
		when(mockProdSvc.findProductById(1L)).thenReturn(expectedProduct );
		
		MSiteWebController prodController = new MSiteWebController();
		ReflectionTestUtils.setField( prodController, "productService", mockProdSvc );
		
		MockMvc mockMvc = standaloneSetup(prodController).build();

		//mockMvc.perform(get("/products")).andExpect(view().name("products"));
		
		mockMvc.perform(get("/product/1"))
			.andExpect(view().name("product/show"))
			.andExpect(model().attributeExists("product"))
			.andExpect(model().attribute("product", expectedProduct));
	
	}

}
