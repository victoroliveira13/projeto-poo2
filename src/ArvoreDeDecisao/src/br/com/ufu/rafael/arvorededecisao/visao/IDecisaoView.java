package br.com.ufu.rafael.arvorededecisao.visao;

import java.util.ArrayList;
import java.util.List;

import br.com.ufu.rafael.arvorededecisao.controle.IDecisaoModelContext;
import br.com.ufu.rafael.arvorededecisao.modelo.Unfitted;

public class IDecisaoView {

	public static void main(String[] args) {
		
		List<Integer> numeros = new ArrayList<>();
		numeros.add(100);
		numeros.add(90);
		numeros.add(15);
		numeros.add(76);
		IDecisaoModelContext arvDec = new IDecisaoModelContext();
		arvDec.setDecMod(new Unfitted(5, 0, 1));
		arvDec.imprimirModelContext(numeros);
		

	}

}
