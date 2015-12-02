package com.poo.negocios.controladores;

import java.io.IOException;

import com.poo.dados.IRepositorioAluno;
import com.poo.dados.RepositorioAluno;
import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Aluno;
import com.poo.negocios.beans.Cartao;
import com.poo.negocios.beans.Pessoa;
import com.poo.validacoes.Validacoes;

public class ControladorAluno {
	
	private IRepositorioAluno repositorio;
	
	public ControladorAluno(){
		try{
			this.repositorio = RepositorioAluno.getInstance();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void cadastrar(Aluno aluno)throws IOException, NegocioException{
		if(this.repositorio.existe(aluno)){
			//fazer as outras verifica��es aqui, inclusive dos atributos da classe pessoa
			if(aluno.getNome() != null){
				if(Validacoes.validarCPF(aluno.getCpf())){
					if(aluno.getCurso() != null){
						if(aluno.getAnoIngresso() > 0){
							aluno.setCodigo(Validacoes.gerarCodigo(aluno));
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
			throw new NegocioException(aluno.getNome() + "JA ESTA CADASTRADO!");
		}
		
	}
	
	public Aluno[] listarAlunos() throws IOException{
		return this.repositorio.listarAlunos();
	}
	
	private long validarCodigo(Aluno aluno){
		boolean resultado = false;
		int recorrencia = 0;
		long codigo = 0;
		while(resultado == false){
			codigo = aluno.hashCode();
			for(int i = 0; i < this.repositorio.listarAlunos().length; i++){
				if(this.repositorio.listarAlunos()[i].getCodigo() == codigo){
				   recorrencia +=1;	
				}
			}
			if(recorrencia == 0){
			   resultado = true;
			}
			
		}
		return codigo;
		
	}
	
	
	public void remover(Aluno aluno) throws IOException, NegocioException{
		this.repositorio.remover(aluno);
	}
	
	public void creditar(Cartao cartao, double valor){
		if(valor>0){
			cartao.setSaldo(cartao.getSaldo() + valor);
		}
	}
	
	public void debitar(Cartao cartao, double valor){
		if(valor > 0){
			 cartao.setSaldo(cartao.getSaldo() - valor);
		}
		
	}
	
	public void selecionarRefeicao(int opcao, Cartao cartao) throws NegocioException{
		if(opcao == 1 ){
			this.debitar(cartao, 2.0);
		}else if(opcao == 2){
			this.debitar(cartao, 1.5);
		}else{
			throw new NegocioException("REFEICAO INVALIDA!");
		}
	}
		
}
