package br.com.guacom.reminder.service;

import java.util.NoSuchElementException;
import java.util.Optional;

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

	public Lembrete getById(Integer id) {
		try {
			Optional<Lembrete> lembrete = repository.findById(Long.valueOf(id));
			if (lembrete.isPresent())
				return lembrete.get();
		} catch (IllegalArgumentException ex) {
			throw new NoSuchElementException(ex.getMessage());
		}
		return null;
	}

	public void exists(Long id) {
		try {
			repository.existsById(id);
		} catch (IllegalArgumentException ex) {
			throw new NoSuchElementException(ex.getMessage());
		}
	}
	
	public void delete(Lembrete lembrete) {
		try {
			repository.delete(lembrete);
		} catch (IllegalArgumentException ex) {
			throw new NoSuchElementException(ex.getMessage());
		}
	}

	public void deleteById(Long id) {
		try {
			repository.deleteById(id);
		} catch (IllegalArgumentException ex) {
			throw new NoSuchElementException(ex.getMessage());
		}
	}
}