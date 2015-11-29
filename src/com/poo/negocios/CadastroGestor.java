package com.poo.negocios;

import java.io.IOException;

import com.poo.dados.IRepositorioGestor;
import com.poo.dados.RepositorioGestor;
import com.poo.excecoes.CadastroGestorExistenteException;
import com.poo.negocios.beans.Gestor;

public class CadastroGestor {
	
	private IRepositorioGestor repositorio;
	
	public CadastroGestor(){
		try{
			this.repositorio = RepositorioGestor.getInstance();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void cadastrar(Gestor gestor) throws IOException, CadastroGestorExistenteException{
		this.repositorio.inserirGestor(gestor);
	}
	
	public Gestor[] listarGestores() throws IOException{
		return this.repositorio.listarGestores();
	}

}
