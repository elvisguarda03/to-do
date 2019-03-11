package br.com.guacom.reminder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guacom.reminder.models.Lembrete;

public interface LembreteRepository extends JpaRepository<Lembrete, Long> {

}
