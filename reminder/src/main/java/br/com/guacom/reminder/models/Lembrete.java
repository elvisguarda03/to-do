package br.com.guacom.reminder.models;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import br.com.guacom.reminder.util.DateUtil;

@Entity
@Table(name = "Lembrete")
public class Lembrete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message="Título obrigatório!")
	@NotNull(message="Título obrigatório!")
	private String titulo;
	private String descricao;

	@Temporal(TemporalType.DATE)
	@NotNull(message="Data obrigatória!")
	private Date data;

	public Lembrete(String titulo, String descricao, String data) {
		if (titulo == null || data == null)
			throw new IllegalArgumentException("Os dados não foram cadastrados corretamente!");
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = DateUtil.getDate(data);
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

	public String dataToString() {
		return data.toString();
	}

	public String formatDate() {
		String date = new SimpleDateFormat("yyyy-MM-dd").format(data);
		String formatDate = "";
		StringBuilder sb = new StringBuilder();
		formatDate = date;
		sb.append(formatDate.subSequence(8, 10));
		sb.append("/");
		sb.append(formatDate.subSequence(5, 7));
		sb.append("/");
		sb.append(formatDate.subSequence(0, 4));
		formatDate = sb.toString();
		int value = Integer.parseInt((String)formatDate.subSequence(0, 2));
		int increment = value + 1;
		formatDate = formatDate.replace(String.valueOf(value), String.valueOf(increment));
		formatDate = formatDate.replace("30", "20");
		return formatDate;
	}

	public Date getData() {
		return data;
	}

	public void setData(String data) {
		this.data = DateUtil.getDate(data);
	}
}