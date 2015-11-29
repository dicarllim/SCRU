package com.poo.negocios;

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
		this.repositorio.inserirAluno(aluno);
	}
	
	public Aluno[] listarAlunos() throws IOException{
		return this.repositorio.listarAlunos();
	}
	
}
