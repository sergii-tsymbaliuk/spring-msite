package name.tsymbaliuk.msite.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("name.tsymbaliuk.msite.web")
public class WebConfig extends WebMvcConfigurerAdapter {
	@Bean
	ViewResolver viewResolver(){
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setSuffix(".jsp");
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setExposeContextBeansAsAttributes(true);
		return irvr;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}
