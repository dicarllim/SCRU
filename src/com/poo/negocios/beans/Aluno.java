package com.poo.negocios.beans;

import java.io.Serializable;
import java.text.DecimalFormat;


public class Aluno extends Pessoa implements Serializable{
	private long codigo;
	private String curso;
	DecimalFormat df = new DecimalFormat("0.0");
	private float anoIngresso;
	
	
	public Aluno(long codigo, String nome, String cpf, String curso, float anoIngresso){
		super(nome, cpf);
		this.setCodigo(codigo);
		this.setCurso(curso);
		this.setAnoIngresso(anoIngresso);
	}
	
	public long getCodigo(){
		return this.codigo;
	}
	public void setCodigo(long codigo){
		this.codigo = codigo;
	}
	public String getCurso(){
		return this.curso;
	}
	
	public void setCurso(String curso){
			this.curso = curso;
	}
	
	public float getAnoIngresso(){
		return this.anoIngresso;
	}
	
	public void setAnoIngresso(float anoIngresso){
			this.anoIngresso = anoIngresso;
	}

	@Override
	public String toString() {
		return "Aluno\nNome: " + this.getNome()+ "\nCPF: " + this.getCpf() + 
				"\nCurso: " + this.getCurso() + 
				"\nAno de Ingresso: " + this.getAnoIngresso() + 
				"\nCodigo do Aluno:" + this.getCodigo();
	}
}
