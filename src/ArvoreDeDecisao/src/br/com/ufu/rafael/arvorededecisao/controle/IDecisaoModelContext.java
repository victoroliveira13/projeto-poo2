package br.com.ufu.rafael.arvorededecisao.controle;

import java.util.List;

import br.com.ufu.rafael.arvorededecisao.modelo.IDecisaoModelEntity;

public class IDecisaoModelContext {
	
	private IDecisaoModelEntity decModel;
	
	public void setDecMod(IDecisaoModelEntity decModel) {
		
		this.decModel = decModel;
		
	}
	
	public void fitContext(List<Integer> numeros){
		
		this.decModel.fit(numeros);
		
	}
	
	public void predictContext(Integer numero){
		
		this.decModel.predict(numero);
		
	}
	
	public void avaliaModeloContext(List<Integer> numeros) {
		
		this.decModel.avaliaModelo(numeros);
		
	}
	
	public void imprimirModelContext(List<Integer> numeros) {
		
		this.decModel.imprimeModelo(numeros);
		
	}

}
