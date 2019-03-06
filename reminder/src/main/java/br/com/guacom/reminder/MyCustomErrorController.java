package br.com.guacom.reminder;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;

public class MyCustomErrorController implements ErrorController {

	private static final String PATH ="/error";
	
	@GetMapping(value = PATH)
	public String error() {
		return "Error haven";
	}
	
	public String getErrorPath() {
		return PATH;
	}
}
