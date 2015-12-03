package com.poo.negocios;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Aluno;
import com.poo.negocios.beans.Cartao;
import com.poo.negocios.beans.Gestor;
import com.poo.negocios.controladores.ControladorAluno;
import com.poo.negocios.controladores.ControladorCartao;
import com.poo.negocios.controladores.ControladorGestor;

public class Fachada {

	private static Fachada instance = null;
	private ControladorAluno aluno;
	private ControladorGestor gestor;
	private ControladorCartao cartao;
	
	
	
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
	
	public void creditar(Cartao cartao, double valor){
		this.aluno.creditar(cartao, valor);
	}
	
	public void debitar(Cartao cartao, double valor){
		this.aluno.debitar(cartao, valor);
	}
	
	public void selecionarRefeicao(int opcao, Cartao cartao) throws NegocioException{
		this.aluno.selecionarRefeicao(opcao, cartao);
	}
	

	public void cadastrar(Gestor gestor) throws NegocioException{
		this.gestor.cadastrar(gestor);
	}
	
	public boolean loginGestor(String login, String senha) throws NegocioException{
		if (gestor.listarGestores().length < 1) {
			throw new NegocioException("teste");
		}else {
				for(int i = 0; i < gestor.listarGestores().length; i++){
						if(gestor.listarGestores()[i].getCpf().equals(login) && gestor.listarGestores()[i].getSenha().equals(senha)){
							return true;
						}
				}
				return false;
			}
	}
	
	public void cadastrar(Cartao cartao) throws NegocioException{
		this.cartao.cadastrar(cartao);
	}
	
}

