package com.example.curso.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "curso")
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long curso_id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="profesor_id")
	private Long profesor_id;
	
	
	public Curso() {
		
	}

	public Long getCurso_id() {
		return curso_id;
	}

	public void setCurso_id(Long curso_id) {
		this.curso_id = curso_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getProfesor_id() {
		return profesor_id;
	}

	public void setProfesor_id(Long profesor_id) {
		this.profesor_id = profesor_id;
	}
	
}
