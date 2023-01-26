package br.com.ufu.rafael.arvorededecisao.modelo;

import java.util.List;

public class InterFit {
	
	private Integer numeroArvores;
	private Double medidaInformacao;
	private Integer tipoTarefa;  //0-Regressão, 1-Classificação
	private Integer avaliacaoModelo; //1-Insatisfatorio, 2-Regular, 3-Bom, 4-Muito bom
	private char modo;  //U-Unfitted  F-Fitted  I-IterFit
	
	public InterFit(Integer numeroArvores, Integer tipoTarefa, Integer avaliacaoModelo) {

		this.numeroArvores = numeroArvores;
		this.medidaInformacao = 0.0;
		this.tipoTarefa = tipoTarefa;
		this.setAvaliacaoModelo(1);
		this.setModo('U');
	}
			
	public Integer getNumeroArvores() {
		return numeroArvores;
	}
	public void setNumeroArvores(Integer numeroArvores) {
		this.numeroArvores = numeroArvores;
	}
	public Double getMedidaInformacao() {
		return medidaInformacao;
	}
	public void setMedidaInformacao(Double medidaInformacao) {
		this.medidaInformacao = medidaInformacao;
	}
	public Integer getTipoTarefa() {
		return tipoTarefa;
	}
	public void setTipoTarefa(Integer tipoTarefa) {
		this.tipoTarefa = tipoTarefa;
	}
	public Integer getAvaliacaoModelo() {
		return avaliacaoModelo;
	}

	public void setAvaliacaoModelo(Integer avaliacaoModelo) {
		this.avaliacaoModelo = avaliacaoModelo;
	}

	public char getModo() {
		return modo;
	}

	public void setModo(char modo) {
		this.modo = modo;
	}
			
	public void fit(List<Integer> numeros) {
						
		System.out.println("\nAjuste de dados do método fit do modo InterFit.\n");
				
	}
		
	public void predict(Integer novoNumero) {
			
		System.out.println("\nRealizado a predicao desse novo dado pelo modelo InterFit.");
			
	}
		
	public Integer avaliaModelo(List<Integer> numeros) {
		//A arvore de decisao consiste em selecionar pessoas que tiveram uma vida razoavelmente longa.
		Double media = 0.0;
		for(Integer numero: numeros) {
			
			if(numero>40 && numero<110) {
				this.medidaInformacao++;
			}
		}
		
		this.setMedidaInformacao(this.medidaInformacao);
			
			media = this.medidaInformacao/numeros.size();
			
			if(media>0.70) {
				this.setAvaliacaoModelo(4);
			}
			else if(media>0.60 && media<=0.80) {
				this.setAvaliacaoModelo(3);
			}
			else if(media>0.40 && media<=0.60) {
				this.setAvaliacaoModelo(2);
			}
			else {
				this.setAvaliacaoModelo(1);
				 }
		
		this.setModo('F');
		return this.getAvaliacaoModelo();
				
	}
		
	public void imprimeModelo(List<Integer> numeros) {
			
		System.out.println("Modo InterFit\n");
		for(Integer numero: numeros) {
			System.out.println("Valor inteiro = " + numero + "\n");
		}
		
		System.out.println("\nAvaliacao Modelo = " + avaliaModelo(numeros) + "\n" + "Modo = " + this.getModo() + "\n" + "Numero de arvores = " + this.getNumeroArvores() + 
						   "\n" + "Medida informacao = " + this.getMedidaInformacao() + this.getTipoTarefa() + "\n");
		 
	}
		
}
