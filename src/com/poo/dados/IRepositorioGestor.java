package com.poo.dados;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Gestor;

public interface IRepositorioGestor {

	public boolean existe(Gestor gestor);
	public void inserirGestor(Gestor gestor) throws NegocioException;
	public Gestor[] listarGestores();
	public Gestor procurar(Gestor gestor)throws NegocioException;
	public void remover(Gestor gestor)throws NegocioException;
	boolean equals(Gestor a, Gestor B);

}
