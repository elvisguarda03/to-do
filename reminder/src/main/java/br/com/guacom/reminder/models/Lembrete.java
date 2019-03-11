package br.com.guacom.reminder.models;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@ToString(of = { "titulo", "descricao", "data" })
@EqualsAndHashCode
@Entity
@Table(name = "Lembrete")
public class Lembrete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Título obrigatório!")
	private String titulo;

	@Column(name = "descricao", nullable = false)
	private String descricao;

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	@NotNull(message = "Data obrigatória!")
	@Column(name = "data", nullable = true)
	private LocalDate data;

	public Lembrete(String titulo, String descricao, String data) {
		if (titulo.isEmpty() || data == null)
			throw new IllegalArgumentException("Os dados não foram preenchidos corretamente!");
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = LocalDate.parse(data);
	}

	public Lembrete(String data, String titulo) {
		this(titulo, null, data);
	}

	public Lembrete() {
	}

	public String dateToString() {
		return br.com.guacom.reminder.util.LocalDateUtil.formatDate(data);
	}
}