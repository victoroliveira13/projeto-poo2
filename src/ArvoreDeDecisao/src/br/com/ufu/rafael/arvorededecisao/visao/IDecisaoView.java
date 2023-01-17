package br.com.ufu.rafael.arvorededecisao.visao;

import java.util.ArrayList;
import java.util.List;

import br.com.ufu.rafael.arvorededecisao.controle.IDecisaoModelContext;
import br.com.ufu.rafael.arvorededecisao.modelo.Cachorro;
import br.com.ufu.rafael.arvorededecisao.modelo.Unfitted;

public class IDecisaoView {

	public static void main(String[] args) {
		
		Cachorro cao = new Cachorro("Pinscher", 0, 'F', 0.15, 8.00);
		Cachorro cao2 = new Cachorro("Pit Bull", 1, 'M', 0.40, 22.00);
		List<Cachorro> cachorros = new ArrayList<>();
		cachorros.add(cao);
		cachorros.add(cao2);
		IDecisaoModelContext arvDec = new IDecisaoModelContext();
		arvDec.setDecMod(new Unfitted(2, 1, 1));
		arvDec.fitContext(cachorros);
		arvDec.predictContext(cachorros);
		arvDec.avaliaModeloContext(cachorros);
		arvDec.imprimirModelContext();

	}

}
