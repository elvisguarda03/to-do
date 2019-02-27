package br.com.guacom.reminder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guacom.reminder.models.Lembrete;
import br.com.guacom.reminder.repository.LembreteRepository;

@Service
public class LembreteService {
	
	@Autowired
	private LembreteRepository repository;
	
	public void save(Lembrete lembrete) {
		repository.save(lembrete);
	}
	
	public Iterable<Lembrete> findAll() {
		return repository.findAll();
	}
}
