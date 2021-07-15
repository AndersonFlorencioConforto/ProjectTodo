package com.anderson.todo.DTO;

import java.io.Serializable;
import java.util.Date;

import com.anderson.todo.Model.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class TodoDTO implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String titulo;
	private String descricao;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataParaFinalizar;
	private Boolean finalizado = false;
	
	public TodoDTO() {
		
	}
	
	public TodoDTO(Todo obj) {
		super();
		this.id = obj.getId();
		this.titulo = obj.getTitulo();
		this.descricao = obj.getDescricao();
		this.dataParaFinalizar = obj.getDataParaFinalizar();
		this.finalizado = obj.getFinalizado();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDataParaFinalizar() {
		return dataParaFinalizar;
	}
	public void setDataParaFinalizar(Date dataParaFinalizar) {
		this.dataParaFinalizar = dataParaFinalizar;
	}
	public Boolean getFinalizado() {
		return finalizado;
	}
	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}
	
	

}
