package br.com.guacom.reminder.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.guacom.reminder.models.Lembrete;

public interface LembreteRepository extends CrudRepository<Lembrete, Long> {

}
