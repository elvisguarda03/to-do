package br.com.guacom.reminder.controllers;

import java.io.BufferedReader;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.guacom.reminder.models.Lembrete;
import br.com.guacom.reminder.service.LembreteService;

@Controller
public class LembreteController {

	@Autowired
	private LembreteService service;

	@RequestMapping("/reminder")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/lembretes")
	public String listaLembretes(Model model) {
		Iterable<Lembrete> lembretes = service.findAll();
		model.addAttribute("listaDeLembretes", lembretes);
		return "lembretes";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}

	@GetMapping("/errorHaven")
	String errorHeaven() {
		return "Você chegou ao paraiso dos erros!!!";
	}

	@SuppressWarnings("deprecation")
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute("lembrete") @Valid Lembrete lembrete, final BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			ModelAndView andView = new ModelAndView("redirect:/cadastro");
			for (ObjectError objectError : result.getAllErrors()) {
				redirect.addFlashAttribute("mensagem", objectError.getDefaultMessage());
			}
			return andView;
		}
		service.save(lembrete);
		ModelAndView modelAndView = new ModelAndView("redirect:/lembretes");
		modelAndView.addObject("Lembrete", new Lembrete());
		return modelAndView;
	}
}