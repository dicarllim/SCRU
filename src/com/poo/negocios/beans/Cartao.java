package com.poo.negocios.beans;

import java.io.Serializable;


public class Cartao implements Serializable{
	private String emissao;
	private double saldo;
	private long numeroCartao;
	
	
	public Cartao(String emissao, double saldo, long numeroConta){
		this.setEmissao(emissao);
		this.setSaldo(0.0);
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

	public String getEmissao() {
		return this.emissao;
	}

	public void setEmissao(String emissao) {
		this.emissao = emissao;
	}	
	
	public long getNumeroCartao(){
		return this.numeroCartao;
	}

	public void setNumeroCartao(long numeroCartao){
		this.numeroCartao = numeroCartao;
	}

	@Override
	public String toString(){
		return "Numero do cart�o: " + this.getNumeroCartao() + "\nEmissao: " + this.getEmissao() + "\nSaldo: " + this.getSaldo();
	}
}
