package com.poo.negocios.beans;

import com.poo.excecoes.CpfInvalidoException;
import com.poo.excecoes.SenhaInvalidaException;

public class Gestor extends Pessoa{
	private int permissao;
	private Cartao cartaoGestor;
	private String senha;

	public Gestor(String nome, String cpf, int permissao, Cartao cartaoGestor, String senha) throws CpfInvalidoException, SenhaInvalidaException{
		super(nome, cpf);
		this.setPermissao(permissao);
		this.setCartaoGestor(cartaoGestor);
		this.setSenha(senha);
	}

	public int getPermissao() {
		return permissao;
	}

	public void setPermissao(int permissao) {
		if(permissao >= 1){
			this.permissao = permissao;
		}
	}

	public Cartao getCartaoGestor() {
		return cartaoGestor;
	}

	public void setCartaoGestor(Cartao cartaoGestor) {
		if(!cartaoGestor.equals(null)){
			this.cartaoGestor = cartaoGestor;
		}
	}
	public String getSenha(){
		return this.senha;
	}
	
	public void setSenha(String senha) throws SenhaInvalidaException{
		if(!senha.equals(null)){
			this.senha = senha;
		}else{
			throw new SenhaInvalidaException();
		}
	}




}
