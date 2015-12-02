package com.poo.negocios.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;


public class Pessoa implements Serializable{
	private String nome;
	private String cpf;

	public Pessoa(String nome, String cpf){
		this.setCpf(cpf);
		this.setNome(nome);
	}

	public void setNome(String nome){
			this.nome = nome;
	}
	
	public void setCpf(String cpf){
				this.cpf = cpf;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getCpf(){
		return this.cpf;
	}	
	
}
