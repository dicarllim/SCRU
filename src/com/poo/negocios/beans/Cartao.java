package com.poo.negocios.beans;

import java.io.Serializable;

import com.poo.excecoes.RefeicaoInvalidaException;


public class Cartao implements Serializable{
	private String numero;
	private String validade;
	private String emissao;
	private int via;
	private double saldo;
	private Aluno aluno;
	
	public Cartao(String validade, String emissao, int via, double saldo, Aluno aluno){
		this.setEmissao(emissao);
		this.setValidade(validade);
		this.setVia(via);
		this.setSaldo(saldo);
		this.setAluno(aluno);
	}
	/**
	 * Credita(soma um valor) a uma conta
	 * 
	 * @param valor define um valor que será somado ao saldo do cliente
	 */
	public void creditar(double valor){
		if(valor>0){
			this.saldo += valor;
		}
	}
	
	public void debitar(double valor){
		if(valor > 0){
			this.saldo -= valor;
		}
		
	}
	public String selecionarRefeicão(int opcao) throws RefeicaoInvalidaException{
		String resultado = "";
		if(opcao ==1 ){
			this.debitar(2.0);
			resultado = "ALMOÇO";
		}else if(opcao == 2){
			this.debitar(1.5);
			resultado = "JANTAR";
		}else{
			throw new RefeicaoInvalidaException();
		}
		return resultado;
	}
	

	public double getSaldo(){
		return this.saldo;
	}
	public void setSaldo(double saldo){
		this.saldo = saldo;
	}
 
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
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
	
	


	@Override
	public String toString(){
		return "Numero do cartão: " + this.getNumero() + "\nValidade: " + this.getValidade() + "\nEmissao: " + this.getEmissao() + "\nVia: " + this.getVia() + "\nSaldo: " + this.getSaldo() + "\nAluno: " + this.aluno;
	}
}
