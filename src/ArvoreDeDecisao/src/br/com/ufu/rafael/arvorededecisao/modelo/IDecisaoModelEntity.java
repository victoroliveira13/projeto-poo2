package br.com.ufu.rafael.arvorededecisao.modelo;


import java.util.List;

public interface IDecisaoModelEntity {
	
	public void fit(List<Integer> numeros);
	
	public void predict(Integer numero);
	
	public Integer avaliaModelo(List<Integer> numeros);
	
	public void imprimeModelo(List<Integer> numeros);

}
