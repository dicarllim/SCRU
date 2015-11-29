package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.poo.excecoes.AlunoInexistenteException;
import com.poo.excecoes.CadastroAlunoExistenteException;
import com.poo.excecoes.ProcuraAlunoInexistenteException;
import com.poo.negocios.beans.Aluno;


public class RepositorioAluno implements IRepositorioAluno, Serializable{
	private Aluno[] listaDeAlunos;
	private int proxima;
	
	private static RepositorioAluno instance;
	
	public RepositorioAluno(int tamanho){
		this.listaDeAlunos = new Aluno[tamanho];
		this.proxima = 0;
	}
	
	public static IRepositorioAluno getInstance() throws IOException {
		if (instance == null) {
			instance = abrirArquivo();
		}
		return instance;
	}
	
	private static RepositorioAluno abrirArquivo() throws IOException {

		RepositorioAluno instanciaLocal = null;
		File in = new File("ARQUIVOS\\CADASTRO ALUNOS\\cadastroalunos.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioAluno) o;
		} catch (Exception e) {
			
			instanciaLocal = new RepositorioAluno(50);
			
		} finally {

			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {/* Silent exception */
				}
			}
		}

		return instanciaLocal;

	}
	
	public static void salvarArquivo() throws IOException {

		if (instance == null) {
			return;
		}

		File dir = new File("ARQUIVOS\\CADASTRO ALUNOS");
		dir.mkdirs();
		File out = new File(dir,"cadastroalunos.bin");
        
		if (!out.exists()){
			
			out.createNewFile();
        }
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;

		try {
			fos = new FileOutputStream(out);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(instance);

		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {/* Silent */
				}
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
		boolean achou = false;
		for(int i = 0; i <= (this.listaDeAlunos.length-1);i++){
			if(this.listaDeAlunos[i].getCpf().equals(aluno.getCpf())){
				achou = true;
			}
		}
		return achou;
	}
	
	/**
	 * Adiciona um novo aluno a lista de alunos
	 * 
	 * @param aluno
	 * @throws IOException
	 * @throws CadastroAlunoExistenteException
	 */
	public void inserirAluno(Aluno aluno) throws IOException, CadastroAlunoExistenteException{
		if(!this.existe(aluno)){
			this.listaDeAlunos[this.proxima] = aluno;
			this.proxima++;
			salvarArquivo();
		}else{
			throw new CadastroAlunoExistenteException(aluno.getNome());
		}
		if(this.proxima == this.listaDeAlunos.length){
			this.duplicaArrayAluno();
		}
		salvarArquivo();
	}
	
	/*public void cadastra(Aluno a) throws IOException, CadastroAlunoExistenteException, CPFCadastradoExeception{
		
		if (a != null)
		if (this.existe(a.getNome())) {
			throw new CadastroAlunoExistenteException(a.getNome());

		}else if(this.existe(a.getCpf())){
			throw new CPFCadastradoExeception();
		}else{
			this.listaDeAlunos[proxima] = (Aluno) a;
			this.proxima = this.proxima+1;
		}
	if (this.proxima == this.listaDeAlunos.length) {

		this.duplicaArrayCliente();
	}
	salvarArquivo();

	}*/
	
	public Aluno[] listarAlunos(){
		return this.listaDeAlunos;
	}
	/**
	 * Duplica o array caso seja necessário mais espaço para o vetor
	 */
	private void duplicaArrayAluno() {

		if (this.listaDeAlunos != null && this.listaDeAlunos.length > 0) {
		    Aluno[] arrayDuplicado = new Aluno[this.listaDeAlunos.length * 2];
			for (int i = 0; i < this.listaDeAlunos.length; i++) {
				arrayDuplicado[i] = this.listaDeAlunos[i];
			}
			this.listaDeAlunos = arrayDuplicado;
		}
	}
	
	/** 
	 *  Procura no Vetor/Array de Lista de Alunos o índice de um aluno específico
	 *	dentro do if, faz a comparação se o nome do aluno que foi dado é igual ao do nome na listaDeAlunos[i]
	 *	ou seu CPF é igual ao do listaDeAlunos[] 
	 *  
	 *  @param aluno
	 *  @return
	 */
	private int procurarIndice(Aluno aluno){
		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if (aluno.equals(this.listaDeAlunos[i].getNome()) || aluno.equals(this.listaDeAlunos[i].getCpf())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}
	/**
	 * Procura um aluno no vetor listaDeAlunos
	 * 
	 * @param aluno
	 * @return dados do aluno no índice i ou null
	 * @throws ProcuraAlunoInexistenteException
	 */
	public Aluno procurar(Aluno aluno)throws ProcuraAlunoInexistenteException {
		int i = this.procurarIndice(aluno);
		Aluno resultado = null;
		if (i != this.proxima)
			resultado = this.listaDeAlunos[i];
		else
			throw new ProcuraAlunoInexistenteException();

		return resultado;
	} 
	/**
	 * Remove o aluno da listaDeAlunos[]
	 * 
	 * @param aluno
	 * @throws IOException
	 * @throws ProcuraAlunoInexistenteException
	 */
	public void remover(Aluno aluno) throws IOException, ProcuraAlunoInexistenteException {
		int i = this.procurarIndice(aluno);
		if (i != this.proxima) {
			this.listaDeAlunos[i] = this.listaDeAlunos[this.proxima - 1];
			this.listaDeAlunos[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcuraAlunoInexistenteException(); 

		salvarArquivo();

	}

	@Override
	public boolean equals(Aluno a, Aluno B) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
