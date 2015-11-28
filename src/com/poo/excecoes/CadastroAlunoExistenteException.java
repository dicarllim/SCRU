package com.poo.excecoes;

public class CadastroAlunoExistenteException extends Exception{
	
	private String nome;
	public CadastroAlunoExistenteException(String nome){
		super(nome + " JA ESTA CADASTRADO!!!");
		this.setNome(nome);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome!= null)
		this.nome = nome;
	}
}
