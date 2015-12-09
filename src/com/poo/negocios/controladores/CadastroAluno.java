package com.poo.negocios.controladores;

import java.io.IOException;

import com.poo.dados.IRepositorioAluno;
import com.poo.dados.RepositorioAluno;
import com.poo.excecoes.CadastroAlunoExistenteException;
import com.poo.negocios.beans.Aluno;

public class CadastroAluno {
	
	private IRepositorioAluno repositorio;
	
	public CadastroAluno(){
		try{
			this.repositorio = RepositorioAluno.getInstance();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void cadastrar(Aluno aluno)throws IOException, CadastroAlunoExistenteException{
		if(this.repositorio.existe(aluno)){
			//fazer as outras verificações aqui, inclusive dos atributos da classe pessoa
		      this.repositorio.inserirAluno(aluno);
		}
		else
		  throw new CadastroAlunoExistenteException(aluno.getNome());
	}
	
	public Aluno[] listarAlunos() throws IOException{
		return this.repositorio.listarAlunos();
	}
	private static long gerarCodigo(Aluno aluno ){
		return aluno.hashCode();
	}
}
