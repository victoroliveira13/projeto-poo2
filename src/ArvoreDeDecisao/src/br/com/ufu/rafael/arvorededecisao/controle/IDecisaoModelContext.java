package br.com.ufu.rafael.arvorededecisao.controle;

import java.util.List;

import br.com.ufu.rafael.arvorededecisao.modelo.Cachorro;
import br.com.ufu.rafael.arvorededecisao.modelo.IDecisaoModelEntity;

public class IDecisaoModelContext {
	
	private IDecisaoModelEntity decModel;
	
	public void setDecMod(IDecisaoModelEntity decModel) {
		
		this.decModel = decModel;
		
	}
	
	public List<Cachorro> fitContext(List<Cachorro> cachorros){
		
		return this.decModel.fit(cachorros);
		
	}
	
	public List<Cachorro> predictContext(List<Cachorro> cachorros){
		
		return this.decModel.predict(cachorros);
		
	}
	
	public void avaliaModeloContext(List<Cachorro> cachorro) {
		
		this.decModel.avaliaModelo(cachorro);
		
	}
	
	public void imprimirModelContext() {
		
		this.decModel.imprimeModelo();
		
	}

}
