package com.poo.negocios.beans;

import java.io.Serializable;


public class Cartao implements Serializable{
	private String validade;
	private String emissao;
	private int via;
	private double saldo;
	private Aluno aluno;
	private long numeroCartao;
	
	
	public Cartao(String validade, String emissao, int via, double saldo, Aluno aluno, long numeroConta){
		this.setEmissao(emissao);
		this.setValidade(validade);
		this.setVia(via);
		this.setSaldo(saldo);
		this.setAluno(aluno);
		this.setNumeroCartao(numeroConta);
	}
	/**
	 * Credita(soma um valor) a uma conta
	 * 
	 * @param valor define um valor que ser� somado ao saldo do cliente
	 */
	

	public double getSaldo(){
		return this.saldo;
	}
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}
 
	public String getValidade() {
		return this.validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getEmissao() {
		return this.emissao;
	}

	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}

	public int getVia() {
		return this.via;
	}

	public void setVia(int via) {
		this.via = via;
	}
	
	public Aluno getAluno(){
		return this.aluno;
	}
	
	public void setAluno(Aluno aluno){
		if(!aluno.equals(null)){
			this.aluno = aluno;
		}
	}
	
	public long getNumeroCartao(){
		return this.numeroCartao;
	}

	public void setNumeroCartao(long numeroCartao){
		this.numeroCartao = aluno.getCodigo();
	}

	@Override
	public String toString(){
		return "Numero do cart�o: " + this.getNumeroCartao() + "\nValidade: " + this.getValidade() + "\nEmissao: " + this.getEmissao() + "\nVia: " + this.getVia() + "\nSaldo: " + this.getSaldo() + "\nAluno: " + this.aluno;
	}
}
