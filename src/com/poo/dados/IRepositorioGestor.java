package com.poo.dados;

import java.util.ArrayList;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Gestor;

public interface IRepositorioGestor {

	public boolean existe(Gestor gestor);
	public void inserirGestor(Gestor gestor) throws NegocioException;
	public ArrayList<Gestor> listarGestores();
	public void remover(Gestor gestor)throws NegocioException;
	boolean equals(Gestor a, Gestor B);

}
