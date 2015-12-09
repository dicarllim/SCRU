package com.poo.negocios.beans;

import java.io.Serializable;
import java.text.DecimalFormat;

import com.poo.excecoes.AnoIngressoInvalidoException;
import com.poo.excecoes.CpfInvalidoException;
import com.poo.excecoes.StatusInvalidoException;
import com.poo.excecoes.CursoInvalidoException;
import com.poo.excecoes.StatusInvalidoException;

public class Aluno extends Pessoa implements Serializable{
	private long codigo;
	private int status;//1- Aluno Ativo || 0 - Aluno Desativado
	private String curso;
	DecimalFormat df = new DecimalFormat("0.0");
	private float anoIngresso;
	private boolean residente;
	
	//implementar foto
	public Aluno(long codigo, String nome, String cpf, int status, String curso, float anoIngresso) throws CpfInvalidoException, StatusInvalidoException, CursoInvalidoException, AnoIngressoInvalidoException{
		super(nome, cpf);
		this.setCodigo(codigo);
		this.setStatus(status);
		this.setCurso(curso);
		this.setAnoIngresso(anoIngresso);
	}
	
	public int getStatus(){ 
		return this.status;
	}
	/**
	 * Verifica o estado do estudante
	 * 
	 * @param status define se o estudante é regular(1) ou desativado (0)	
	 * 
	 */
	
	public long getCodigo(){
		return this.codigo;
	}
	public void setCodigo(long codigo){
		this.codigo = codigo;
	}
	public void setStatus(int status) throws StatusInvalidoException{
		if(status == 0 || status == 1){
			this.status = status;
		}else{
			throw new StatusInvalidoException();
		}
	}
	
	public boolean getResidente(){
		return this.residente;
	}
	 
	public void setResidente(boolean residente){
		if(residente == true){
			
		}else{
			
		}
	}
	public String getCurso(){
		return this.curso;
	}
	
	public void setCurso(String curso) throws CursoInvalidoException{
		if(!curso.equals(null)){
			this.curso = curso;
		}else{
			throw new CursoInvalidoException();
		}
	}
	
	public float getAnoIngresso(){
		return this.anoIngresso;
	}
	
	public void setAnoIngresso(float anoIngresso) throws AnoIngressoInvalidoException{
		if(anoIngresso > 0){
			this.anoIngresso = anoIngresso;
		} else{
			throw new AnoIngressoInvalidoException();
		}
	}

	@Override
	public String toString() {
		return "Aluno\nNome: " + this.getNome()+ "\nCPF: " + this.getCpf() + 
				"\nStatus: " + this.getStatus() + "\nCurso: " + this.getCurso() + "\nAno de Ingresso: " + this.getAnoIngresso() + "\nResidente: "
				+ this.getResidente()+ "";
	}
}
