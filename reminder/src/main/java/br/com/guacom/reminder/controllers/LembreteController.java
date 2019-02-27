package br.com.guacom.reminder.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.guacom.reminder.models.Lembrete;
import br.com.guacom.reminder.service.LembreteService;

@Controller
public class LembreteController {

	@Autowired
	private LembreteService service;

	@RequestMapping("/")
	public String cadastro() {
		return "index";
	}

	@RequestMapping("/lembretes")
	public String listaLembretes(Model model) {
		Iterable<Lembrete> lembretes = service.findAll();
		model.addAttribute("listaDeLembretes", lembretes);
		return "lembretes";
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Lembrete lembrete, final BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			ModelAndView andView = new ModelAndView("redirect:/index");
			Iterable<Lembrete> lembretes = service.findAll();
			andView.addObject("lembretes", lembretes);
			andView.addObject("lembrete", lembrete);
			
			List<String> errors = new ArrayList<String>();			
			for(ObjectError objectError : result.getAllErrors())
				errors.add(objectError.getDefaultMessage());
			andView.addObject("msg", errors);
			return andView;
		}
		service.save(lembrete);
		Iterable<Lembrete> lembretes = service.findAll();
		redirect.addFlashAttribute("msgResultado", "Registro salvo com sucesso!");
		ModelAndView modelAndView = new ModelAndView("redirect:/lembretes");
		modelAndView.addObject("lembretes", lembretes);
		modelAndView.addObject("lembrete", new Lembrete());
		return modelAndView;
	}
}