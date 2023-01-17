package br.com.ufu.rafael.arvorededecisao.modelo;


import java.util.List;

public interface IDecisaoModelEntity {
	
	public List<Cachorro> fit(List<Cachorro> cachorros);
	
	public List<Cachorro> predict(List<Cachorro> cachorros);
	
	public void avaliaModelo(List<Cachorro> cachorro);
	
	public void imprimeModelo();

}
