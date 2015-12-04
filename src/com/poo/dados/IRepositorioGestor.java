package com.poo.dados;

import java.util.ArrayList;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Gestor;

public interface IRepositorioGestor {

	public boolean existe(Gestor gestor);
	public void inserirGestor(Gestor gestor);
	public ArrayList<Gestor> listarGestores();
	public void remover(Gestor gestor);
	public void atualizar(Gestor gestor);
	boolean equals(Gestor a, Gestor B);

}
