package com.poo.negocios.controladores;

import com.poo.dados.IRepositorioCartao;
import com.poo.dados.RepositorioCartao;
import com.poo.excecoes.NegocioException;
import com.poo.negocios.beans.Cartao;

public class ControladorCartao {
	
	private IRepositorioCartao repositorio;
	
	public ControladorCartao(){
		this.repositorio = RepositorioCartao.getInstance();
	}
	
	
	public void cadastrar(Cartao cartao) throws NegocioException{
		if(this.repositorio.existe(cartao)){
			if(cartao.getNumeroCartao() > 0){
				if(cartao.getEmissao() != null){
					this.repositorio.inserirCartao(cartao);
				}else{
					throw new NegocioException("CADASTRAR - DATA DE EMISSAO INVALIDA");
				}
			}else{
				throw new NegocioException("CADASTRAR - NUMERO DO CARTAO INVALIDO");
			}
		}else{
			throw new NegocioException(cartao.getNumeroCartao() + " JA CADASTRADO");
		}
		
	}

}
