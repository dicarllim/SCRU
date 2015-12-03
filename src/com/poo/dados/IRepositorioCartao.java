package com.poo.dados;


import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Cartao;

public interface IRepositorioCartao {

	boolean equals(Cartao a, Cartao B);
	public boolean existe(Cartao cartao);
	public void inserirCartao(Cartao cartao)throws NegocioException;
	public Cartao[] listarCartoes();

}
