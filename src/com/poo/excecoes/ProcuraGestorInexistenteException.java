package com.poo.excecoes;

public class ProcuraGestorInexistenteException extends Exception{
	public ProcuraGestorInexistenteException(){
		super("GESTOR PESQUISADO NAO EXISTE.");
	}
}
