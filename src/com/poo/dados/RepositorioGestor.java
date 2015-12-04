package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.poo.excecoes.NegocioException;
import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Gestor;
import com.poo.negocios.beans.Gestor;
import com.poo.negocios.beans.Gestor;


public class RepositorioGestor implements IRepositorioGestor, Serializable{
	private ArrayList<Gestor> listaDeGestores;
	private static final String nomeArquivo = "cadastrogestor.dat";
	
	
	public RepositorioGestor(){
		this.listaDeGestores = new ArrayList<Gestor>();
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
			
			ArrayList<Gestor> gestorAuxiliar = (ArrayList<Gestor>) objectInput.readObject();
				this.listaDeGestores.addAll(gestorAuxiliar);
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
			objectOutput.writeObject(listaDeGestores);		
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
	 * Checa se o gestor existe
	 */
	public boolean existe(Gestor gestor){
		boolean resultado = false;
		for(int i = 0; i < this.listaDeGestores.size(); i++){
			if(this.listaDeGestores.get(i).getCpf().equals(gestor.getCpf())){
				resultado = true;
			}
		} return resultado;
	}
	
	/**
	 * Adiciona um novo gestor a lista de gestores
	 * 
	 * @param gestor
	 * @throws IOException
	 * @throws CadastroAlunoExistenteException
	 */
	public void inserirGestor(Gestor gestor){
		this.listaDeGestores.add(gestor);
		salvarArquivo();
	}
	
	
	public ArrayList<Gestor> listarGestores(){
		return this.listaDeGestores;
	}
 
	/**
	 * Remove o gestor da listaDeAlunos[]
	 * 
	 * @param gestor
	 * @throws IOException
	 * @throws ProcuraAlunoInexistenteException
	 */
	public void remover(Gestor gestor){
		this.listaDeGestores.remove(gestor);
		salvarArquivo();

	}
	private int procurarIndice(Gestor gestor){
		int resultado =-1;
		for(int i = 0; i < this.listaDeGestores.size(); i++){
			if(listaDeGestores.get(i).getCpf().equals(gestor.getCpf())){
				resultado = i;
			}
		}
		return resultado;
	}
	
	public void atualizar(Gestor gestor){
		this.listaDeGestores.set(procurarIndice(gestor), gestor);
		salvarArquivo();
	}

	@Override
	public boolean equals(Gestor a, Gestor B) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
