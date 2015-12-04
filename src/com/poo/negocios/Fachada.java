package com.poo.negocios;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Aluno;
import com.poo.negocios.beans.Gestor;
import com.poo.negocios.controladores.ControladorAluno;
import com.poo.negocios.controladores.ControladorGestor;

public class Fachada {

	private static Fachada instance = null;
	private ControladorAluno aluno;
	private ControladorGestor gestor;
	
	
	
	private Fachada(){
		this.aluno = new ControladorAluno();
		this.gestor = new ControladorGestor();
	}

	public static Fachada getInstance(){
		if (instance == null){
			instance = new Fachada();
		}
		return instance;
	}
	
	public void cadastrar(Aluno aluno) throws NegocioException{
		this.aluno.cadastrar(aluno);
	}
	
	public void remover(Aluno aluno) throws NegocioException{
		this.aluno.remover(aluno);
	}
	
	public void creditar(Aluno aluno, double valor){
		this.aluno.creditar(aluno, valor);
	}
	
	public void debitar(Aluno aluno, double valor){
		this.aluno.debitar(aluno, valor);
	}
	
	public void selecionarRefeicao(int opcao, Aluno aluno) throws NegocioException{
		this.aluno.selecionarRefeicao(opcao, aluno);
	}
	

	public void cadastrar(Gestor gestor) throws NegocioException{
		this.gestor.cadastrar(gestor);
	}
	
	public boolean loginGestor(String login, String senha) throws NegocioException{
		boolean resultado = false;
				for(int i = 0; i < gestor.listarGestores().size(); i++){
						if(gestor.listarGestores().get(i).getCpf().equals(login) /*&& gestor.listarGestores().get(i).getSenha().equals(senha)*/){
							resultado = true;
						}
				}
		if(resultado == true){
			return true;
		}else{
			throw new NegocioException("LOGIN/SENHA INCORRETOS!");
		}
			
	}
	
}

