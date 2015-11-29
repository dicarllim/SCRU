package com.poo.dados;

import java.io.IOException;

import com.poo.excecoes.CadastroGestorExistenteException;
import com.poo.excecoes.ProcuraGestorInexistenteException;
import com.poo.negocios.beans.Gestor;

public interface IRepositorioGestor {

	public boolean existe(Gestor gestor);
	public void inserirGestor(Gestor gestor) throws IOException, CadastroGestorExistenteException;
	public Gestor[] listarGestores();
	public Gestor procurar(Gestor gestor)throws ProcuraGestorInexistenteException;
	public void remover(Gestor gestor)throws IOException, ProcuraGestorInexistenteException;
	boolean equals(Gestor a, Gestor B);

}
