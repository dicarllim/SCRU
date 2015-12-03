package com.poo.negocios.beans;

import java.io.Serializable;
import java.text.DecimalFormat;


public class Aluno extends Pessoa implements Serializable{
	private String curso;
	DecimalFormat df = new DecimalFormat("0.0");
	private float anoIngresso;
	private Cartao cartao;
	
	
	public Aluno(String nome, String cpf, String curso, float anoIngresso, Cartao cartao){
		super(nome, cpf);
		this.setCurso(curso);
		this.setAnoIngresso(anoIngresso);
		this.setCartao(cartao);
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

	public Cartao getCartao(){
		return this.cartao;
	}
	
	public void setCartao(Cartao cartao){
		this.cartao = cartao;
	}
	@Override
	public String toString() {
		return "Aluno\nNome: " + this.getNome()+ "\nCPF: " + this.getCpf() + 
				"\nCurso: " + this.getCurso() + 
				"\nAno de Ingresso: " + this.getAnoIngresso(); 
	}
}
