package com.poo.excecoes;

public class CadastroCartaoExistenteException extends Exception{
	public CadastroCartaoExistenteException(){
		super("CART�O J� CADASTRADO");
	}
}
