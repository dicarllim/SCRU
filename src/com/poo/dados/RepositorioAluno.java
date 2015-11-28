package com.poo.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.poo.excecoes.AlunoInexistenteException;
import com.poo.excecoes.CadastroAlunoExistenteException;
import com.poo.excecoes.ProcuraAlunoInexistenteException;
import com.poo.negocios.beans.Aluno;
import com.poo.negocios.beans.Aluno;
import com.poo.excecoes.CPFCadastradoExeception;


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
		File in = new File("DADOS\\CADASTRO CLIENTES\\cadastroclientes.bin");
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(in);
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			instanciaLocal = (RepositorioAluno) o;
		} catch (Exception e) {

			instanciaLocal = new RepositorioAluno(100);

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

		File dir = new File("ARQUIVOS\\CADASTRO CLIENTES");
		dir.mkdirs();
		File out = new File(dir,"cadastroclientes.bin");

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

	public void cadastra(Aluno a) throws IOException, CadastroAlunoExistenteException, CPFCadastradoExeception{
	
			if (a != null)
			if (this.existe(a.getNome())) {
				throw new CadastroAlunoExistenteException(
						a.getNome());

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

	}

	public Aluno procurar(String nome)	throws ProcuraAlunoInexistenteException{

		int i = this.procurarIndice(nome);
		Aluno resultado = null;
		if (i != this.proxima)
			resultado = this.listaDeAlunos[i];
		else throw new ProcuraAlunoInexistenteException(); 

		return  resultado;

	}



	public boolean existe(String nome) {

		boolean existe = false;
		int indice = this.procurarIndice(nome);
		if (indice != proxima) {

			existe = true;

		}

		return existe;
	}

	public void remover(String nome) throws IOException, ProcuraAlunoInexistenteException {

		int i = this.procurarIndice(nome);
		if (i != this.proxima) {
			this.listaDeAlunos[i] = this.listaDeAlunos[this.proxima - 1];
			this.listaDeAlunos[this.proxima - 1] = null;
			this.proxima = this.proxima - 1;
		}else throw new ProcuraAlunoInexistenteException(); 

		salvarArquivo();

	}

	private int procurarIndice(String nome){

		int i = 0;
		boolean achou = false;

		while ((!achou) && (i < this.proxima)) {
			if (nome.equals(this.listaDeAlunos[i].getNome()) || nome.equals(this.listaDeAlunos[i].getCpf())) {
				achou = true;
			} else {
				i = i + 1;
			}
		}
		return i;
	}

	private void duplicaArrayCliente(){

		if (this.listaDeAlunos != null && this.listaDeAlunos.length > 0) {
			Aluno[] arrayDuplicado = new Aluno[this.listaDeAlunos.length * 2];
			for (int i = 0; i < this.listaDeAlunos.length; i++) {
				arrayDuplicado[i] = this.listaDeAlunos[i];
			}
			this.listaDeAlunos = arrayDuplicado;
		}
	}

	public Aluno[] imprimiAluno() {

		Aluno[] aluno = new Aluno[this.listaDeAlunos.length];
		int cont = 0;
		for (Aluno c : aluno) {

			if(c!= null & (c instanceof Aluno)){
				aluno[cont] = (Aluno) c;
				cont++;
			}
		}

		return aluno;

	}

	@Override
	public boolean equals(Aluno a, Aluno B) {
		// TODO Auto-generated method stub
		return false;
	}	
}
