package br.com.guacom.reminder;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
		factory.addErrorPages(new ErrorPage("/errorHaven"));
	}
}
