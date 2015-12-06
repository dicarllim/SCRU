package com.poo.negocios;

import java.util.ArrayList;
import java.util.Collections;

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
	
	public void creditar(int codigo, double valor) throws NegocioException{
		this.aluno.creditar(codigo, valor);
	}
	
	public void debitar(int codigo, double valor)throws NegocioException{
		this.aluno.debitar(codigo, valor);
	}

	public void cadastrar(Gestor gestor) throws NegocioException{
		this.gestor.cadastrar(gestor);
	}
	
	public boolean loginGestor(String login, String senha) throws NegocioException{
		boolean resultado = false;
				for(int i = 0; i < gestor.listarGestores().size(); i++){
						if(gestor.listarGestores().get(i).getCpf().equals(login) && gestor.listarGestores().get(i).getSenha().equals(senha)){
							resultado = true;
						}
				}
		if(resultado == true){
			return true;
		}else{
			throw new NegocioException("LOGIN/SENHA INCORRETOS!");
		}
			
	}
	
	public Aluno loginAluno(int codigo) throws NegocioException{
		Aluno aluno = null;
		for(int i = 0; i <this.aluno.listarAlunos().size(); i++){
			if(this.aluno.listarAlunos().get(i).getNumeroDoCartao()==codigo){
				aluno = this.aluno.listarAlunos().get(i);
			}
		}
		if(aluno != null){
			return aluno;
		}else{
			throw new NegocioException("VOCE NAO ESTA CADASTRADO!");
		}
	}
	
	public void desativar(String cpf) throws NegocioException{
		this.aluno.desativar(cpf);
	}
	
	public void atualizarGestor(Gestor gestor) throws NegocioException{
		this.gestor.atualizarGestor(gestor);
	}
	
	public void atualizarAluno(Aluno aluno) throws NegocioException{
		this.aluno.atualizarAluno(aluno);
	}
	public ArrayList<Aluno> listarAlunos(){
		return this.aluno.listarAlunos();
	}

	public Aluno procurarPorParametro(String parametro) throws NegocioException{
		Aluno resultado = null;
		if(this.aluno.recebenome(parametro) != null){
			return this.aluno.recebenome(parametro);
		}
		if(this.aluno.recebecpf(parametro) != null){
			return this.aluno.recebecpf(parametro);
		}
		if(this.aluno.recebeint((int) Integer.parseInt(parametro)) != null){
				
				return this.aluno.recebeint((int) Integer.parseInt(parametro));
		}
		
		
		if(resultado != null){
			return resultado;
		}
		else
			throw new NegocioException("Nenhum resultado encontrado");
	}
	
	
	
	



}	


