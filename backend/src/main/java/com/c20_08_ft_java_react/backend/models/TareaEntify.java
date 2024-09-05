package com.c20_08_ft_java_react.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tareas")
public class TareaEntify  {

	private Integer etiquetaId;



	@Column(unique = true)
	private String nombreTarea;
	private String asunto;

	private Date fechaexp;

	public Date getFechaexp() {
		return fechaexp;
	}
	public void setFechaexp(Date fechaexp) {
		this.fechaexp = fechaexp;
	}

	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public Integer getEtiquetaId() {
		return etiquetaId;
	}

	public String getNombreTarea() {
		return nombreTarea;
	}

	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
	}


	public void setEtiquetaId(Integer etiquetaId) {
		this.etiquetaId = etiquetaId;
	}


}
