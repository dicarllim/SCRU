package com.poo.dados;

import java.util.ArrayList;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Aluno;

public interface IRepositorioAluno {

	public boolean existe(Aluno aluno);
	public void inserirAluno(Aluno aluno);
	public ArrayList<Aluno> listarAlunos();
	public void remover(Aluno aluno);
	boolean equals(Aluno a, Aluno B);
	public void atualizar(Aluno aluno);
	
}

