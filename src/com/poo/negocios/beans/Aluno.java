package com.poo.negocios.beans;

import java.io.Serializable;
import java.text.DecimalFormat;


public class Aluno extends Pessoa implements Serializable{
	private String curso;
	DecimalFormat df = new DecimalFormat("0.0");
	private float anoIngresso;
	private int numeroDoCartao;
	private double saldo;
	private String data;
	
	
	public Aluno(String nome, String cpf, String curso, float anoIngresso, int numeroDoCartao, double saldo, String data){
		super(nome, cpf);
		this.setCurso(curso);
		this.setAnoIngresso(anoIngresso);
		this.setNumeroDoCartao(numeroDoCartao);
		this.setSaldo(0.0);
		this.setData(data);
	}
	
	public String getCurso(){
		return this.curso;
	}
	
	public void setCurso(String curso){
			this.curso = curso;
	}
	
	public float getAnoIngresso(){
		return this.anoIngresso;
	}
	
	public void setAnoIngresso(float anoIngresso){
			this.anoIngresso = anoIngresso;
	}

	public int getNumeroDoCartao(){
		return this.numeroDoCartao;
	}
	
	public void setNumeroDoCartao(int numeroDoCartao){
		this.numeroDoCartao = numeroDoCartao;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Aluno\nNome: " + this.getNome()+ "\nCPF: " + this.getCpf() + 
				"\nCurso: " + this.getCurso() + 
				"\nAno de Ingresso: " + this.getAnoIngresso(); 
	}
	
}
