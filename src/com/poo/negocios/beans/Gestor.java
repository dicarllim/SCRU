package com.poo.negocios.beans;

public class Gestor extends Pessoa{
	private String senha;

	public Gestor(String nome, String cpf, String senha){
		super(nome, cpf);
		this.setSenha(senha);
	}

	public String getSenha(){
		return this.senha;
	}
	
	public void setSenha(String senha){
			this.senha = senha;
	}
}
