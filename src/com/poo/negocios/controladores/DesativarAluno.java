package com.poo.negocios.controladores;

import java.io.IOException;

import com.poo.dados.IRepositorioAluno;
import com.poo.dados.RepositorioAluno;
import com.poo.excecoes.ProcuraAlunoInexistenteException;
import com.poo.negocios.beans.Aluno;

public class DesativarAluno {
	private IRepositorioAluno repositorio;
	
	public DesativarAluno(){
		try{
			this.repositorio = RepositorioAluno.getInstance();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void remover(Aluno aluno) throws IOException, ProcuraAlunoInexistenteException{
		this.repositorio.remover(aluno);
	}
	

}
