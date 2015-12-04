package com.poo.negocios.controladores;

import java.io.IOException;
import java.util.ArrayList;

import com.poo.dados.IRepositorioGestor;
import com.poo.dados.RepositorioGestor;
import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Gestor;
import com.poo.negocios.beans.Pessoa;
import com.poo.validacoes.Validacoes;

public class ControladorGestor {
	
	private IRepositorioGestor repositorio;
	
	public ControladorGestor(){
			this.repositorio = new RepositorioGestor();
	}
	
	public void cadastrar(Gestor gestor) throws NegocioException{
		if(this.repositorio.existe(gestor) == false){
			if(gestor.getNome() != null){
				if(Validacoes.validarCPF(gestor.getCpf())){
					if(gestor.getSenha() != null){
						this.repositorio.inserirGestor(gestor);
					}else{
						throw new NegocioException("SENHA INVALIDA!");
					}
				}else{
					throw new NegocioException("CPF INVALIDO!");
				}
			}else{
				throw new NegocioException("NOME INVALIDO!");
			}			
			this.repositorio.inserirGestor(gestor);
		}else{
			throw new NegocioException(gestor.getNome() + "JA CADASTRADO!");
		}
	}
	
	public ArrayList<Gestor> listarGestores() {
		return this.repositorio.listarGestores();
	}


}
