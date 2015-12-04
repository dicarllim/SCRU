package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Aluno;


public class RepositorioAluno implements IRepositorioAluno, Serializable{
	private ArrayList<Aluno> listaDeAlunos;
	private static final String nomeArquivo = "cadastroalunos.dat";
	
	
	public RepositorioAluno(){
		this.listaDeAlunos = new ArrayList<Aluno>();
		if(new File(nomeArquivo).canRead() == true){
			this.lerArquivo();
		} else{
			this.salvarArquivo();
		}
	}
	
	private void lerArquivo(){
		FileInputStream fileInput = null;
		ObjectInputStream objectInput = null;
		
		try{
			fileInput = new FileInputStream(nomeArquivo);
			objectInput = new ObjectInputStream (fileInput);
			
			ArrayList<Aluno> alunoAuxiliar = (ArrayList<Aluno>) objectInput.readObject();
				this.listaDeAlunos.addAll(alunoAuxiliar);
		} catch(Exception e){
			e.printStackTrace();		
		} finally{
			try{
				fileInput.close();
				objectInput.close();
			} catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public void salvarArquivo(){
		
		FileOutputStream fileOutput = null;
		ObjectOutputStream objectOutput = null;
		
		try {
			fileOutput = new FileOutputStream(nomeArquivo);
			objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(listaDeAlunos);		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
			fileOutput.close();
			objectOutput.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Verifica se um aluno é realmente da faculdade ou não
	 * 
	 * @param aluno 
	 * @return Verdadeiro se for estudante e falso se não for estudante
	 */
	public boolean existe(Aluno aluno){
		boolean resultado = false;
		for(int i = 0; i < this.listaDeAlunos.size(); i++){
			if(this.listaDeAlunos.get(i).getCpf().equals(aluno.getCpf())){
				resultado = true;
			}
		} return resultado;
	}
	
	/**
	 * Adiciona um novo aluno a lista de alunos
	 * 
	 * @param aluno
	 * @throws IOException
	 * @throws CadastroAlunoExistenteException
	 */
	public void inserirAluno(Aluno aluno) throws NegocioException{
		this.listaDeAlunos.add(aluno);
		salvarArquivo();
	}
	
	
	public ArrayList<Aluno> listarAlunos(){
		return this.listaDeAlunos;
	}
 
	/**
	 * Remove o aluno da listaDeAlunos[]
	 * 
	 * @param aluno
	 * @throws IOException
	 * @throws ProcuraAlunoInexistenteException
	 */
	public void remover(Aluno aluno) throws NegocioException {
		this.listaDeAlunos.remove(aluno);
		salvarArquivo();

	}

	@Override
	public boolean equals(Aluno a, Aluno B) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
