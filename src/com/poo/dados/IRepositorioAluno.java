package com.poo.dados;

import java.io.IOException;

import com.poo.excecoes.CadastroAlunoExistenteException;
import com.poo.excecoes.ProcuraAlunoInexistenteException;
import com.poo.negocios.beans.Aluno;

public interface IRepositorioAluno {

	public boolean existe(Aluno aluno);
	public void inserirAluno(Aluno aluno) throws IOException, CadastroAlunoExistenteException;
	public Aluno[] listarAlunos();
	public Aluno procurar(Aluno aluno)throws ProcuraAlunoInexistenteException;
	public void remover(Aluno aluno) throws IOException, ProcuraAlunoInexistenteException;
	boolean equals(Aluno a, Aluno B);
	
}

