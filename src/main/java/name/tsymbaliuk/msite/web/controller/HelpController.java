package name.tsymbaliuk.msite.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/help")
public class HelpController {
	
	
	@RequestMapping(method=RequestMethod.GET)
	String help(){
		
		return "help";
	}

}
