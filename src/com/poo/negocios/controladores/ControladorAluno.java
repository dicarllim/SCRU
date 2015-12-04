package com.poo.negocios.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import com.poo.dados.IRepositorioAluno;
import com.poo.dados.RepositorioAluno;
import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Aluno;
import com.poo.negocios.beans.Pessoa;
import com.poo.validacoes.Validacoes;

public class ControladorAluno {
	
	private IRepositorioAluno repositorio;
	
	public ControladorAluno(){
			this.repositorio = new RepositorioAluno();
	}
	
	public void cadastrar(Aluno aluno)throws NegocioException{
		if(this.repositorio.existe(aluno) == false){
			//fazer as outras verifica��es aqui, inclusive dos atributos da classe pessoa
			if(aluno.getNome() != null){
				if(Validacoes.validarCPF(aluno.getCpf())){
					if(aluno.getCurso() != null){
						if(aluno.getAnoIngresso() > 0){
							if(aluno.getNumeroDoCartao() > 0){
								this.repositorio.inserirAluno(aluno);		
							}else{
								throw new NegocioException("CADASTRAR - CARTAO INVALIDO");
							}
						}else{
							throw new NegocioException("CADASTRAR - ANO DE INGRESSO INVALIDO!");
						}
					}else{
						throw new NegocioException("CADASTRAR - CURSO INVALIDO!");
					}
				}else{
					throw new NegocioException("CADASTRAR - CPF INVALIDO!");
				}
			}else{
				throw new NegocioException("CADASTRAR - NOME INVALIDO!");
			}
			this.repositorio.inserirAluno(aluno);
		}else{
			throw new NegocioException(aluno.getNome() + " JA ESTA CADASTRADO!");
		}
		
	}
	
	public ArrayList<Aluno> listarAlunos(){
		return this.repositorio.listarAlunos();
	}
	
	public void remover(Aluno aluno) throws NegocioException{
		this.repositorio.remover(aluno);
	}
	
	public void creditar(Aluno aluno, double valor){
		if(valor>0){
			aluno.setSaldo(aluno.getSaldo() + valor);
		}
	}
	
	public void debitar(Aluno aluno, double valor){
		if(valor > 0){
			 aluno.setSaldo(aluno.getSaldo() - valor);
		}
		
	}
	
	public void selecionarRefeicao(int opcao, Aluno aluno) throws NegocioException{
		if(opcao == 1 ){
			this.debitar(aluno, 2.0);
		}else if(opcao == 2){
			this.debitar(aluno, 1.5);
		}else{
			throw new NegocioException("REFEICAO INVALIDA!");
		}
	}
	public String pegarData(){
		String data = String.valueOf(Calendar.getInstance().getTime().getDate());
		data+="/" + Calendar.getInstance().getTime().getMonth();
		data+="/" + Calendar.getInstance().getTime().getYear();	
		return data;
	}
		
}
