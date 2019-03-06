package br.com.guacom.reminder.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.guacom.reminder.util.LocalDateUtil;

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

	@NotNull(message = "Data obrigatória!")
	@Column(name = "data", nullable = true)
	private LocalDate data;

	public Lembrete(String titulo, String descricao, LocalDate data) {
		if (titulo.isBlank() || data == null)
			throw new IllegalArgumentException("Os dados não foram preenchidos corretamente!");
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
	}

	public Lembrete(String titulo, String descricao, String data) {
		if(titulo.isBlank() || data == null)
			throw new IllegalArgumentException("Os dados não foram preenchidos corretamente!");
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = LocalDate.parse(data);
	}
	
	public Lembrete(String data, String titulo) {
		this(titulo, null, data);
	}

	@Deprecated
	public Lembrete() {
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if(titulo.isBlank())
			throw new IllegalArgumentException("Título obrigatório!");
		this.titulo = titulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lembrete other = (Lembrete) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String dateToString() {
		return LocalDateUtil.formatDate(data);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(String data) {
		if (data.isBlank())
			throw new IllegalArgumentException("Data obrigatória!");
		this.data = LocalDate.parse(data);
	}
}