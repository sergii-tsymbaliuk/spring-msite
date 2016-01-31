package name.tsymbaliuk.msite.test.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import name.tsymbaliuk.msite.web.controller.HelpController;

public class HelpControllerTest extends junit.framework.TestCase {

	@Test
	public void test() throws Exception {
		HelpController helpController = new HelpController ();
		MockMvc mockMvc = standaloneSetup(helpController).build();

		mockMvc.perform(get("/help")).andExpect(view().name("help"));
	}

}
