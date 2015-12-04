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
			if(aluno.getNome().trim().length() > 2){
				if(Validacoes.validarCPF(aluno.getCpf())){
					if(aluno.getCurso().trim().length() > 2 ){
						if(aluno.getAnoIngresso() > 0){
							if(aluno.getNumeroDoCartao() > 0){
							//	aluno.setSaldo(0);
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
		}else{
			throw new NegocioException(aluno.getNome() + " JA ESTA CADASTRADO!");
		}
		
	}
	
	public ArrayList<Aluno> listarAlunos(){
		return this.repositorio.listarAlunos();
	}
	
	public void creditar(int codigo, double valor) throws NegocioException{
		Aluno aluno = null;
		if(valor>0){
			
			for(int i = 0; i < this.listarAlunos().size() ; i++){
				if(this.listarAlunos().get(i).getNumeroDoCartao() == codigo){
					aluno = this.listarAlunos().get(i);
				}
			}
			if(aluno != null){
				aluno.setSaldo(aluno.getSaldo() + valor);
			}
			else{
				throw new NegocioException("Codigo invalido");
			}	
		}
		else
			throw new NegocioException("Voce nao pode creditar 0 ou um valor negativo");
	}
	
	public void debitar(int codigo, double valor) throws NegocioException{
		Aluno aluno = null;
		if(valor>0){
			
			for(int i = 0; i < this.listarAlunos().size() ; i++){
				if(this.listarAlunos().get(i).getNumeroDoCartao() == codigo){
					aluno = this.listarAlunos().get(i);
				}
			}
			if(aluno != null){
				if(aluno.getSaldo() > 2){
					aluno.setSaldo(aluno.getSaldo() - valor);
				}else{
					throw new NegocioException("Voce nao possui saldo");
				}
			}else{
				throw new NegocioException("Codigo invalido");
			}	
		}else
			throw new NegocioException("Voce nao pode debitar 0 ou um valor negativo");
		
	}
	
	public boolean desativar(String cpf){
		boolean resultado = false;
		for(int i = 0; i< this.listarAlunos().size();i++ ){
			if(this.listarAlunos().get(i).getCpf().equals(cpf)){
				try{	
					this.repositorio.remover(this.repositorio.listarAlunos().get(i));
					resultado = true;
				} catch(NegocioException e){
					
				}
			}

		}
		return resultado;
	}
	
	public static String pegarData(){
		String data = String.valueOf(Calendar.getInstance().getTime().getDate());
		data+="/" + Calendar.getInstance().getTime().getMonth();
		data+="/" + Calendar.getInstance().getTime().getYear();	
		return data;
	}
	
	public void atualizarAluno(Aluno aluno) throws NegocioException{
		if(this.repositorio.existe(aluno) == true){
			this.repositorio.atualizar(aluno);
		}else{
			throw new NegocioException("ALUNO INEXISTENTE");
		}
	}
		
}
