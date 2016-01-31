package name.tsymbaliuk.msite;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import name.tsymbaliuk.msite.app.RootConfig;
import name.tsymbaliuk.msite.web.WebConfig;

public class MSiteDispatcehrServletInitializer 
			extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{WebConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
