package br.com.ufu.rafael.arvorededecisao.modelo;

import java.text.DecimalFormat;
import java.util.List;

public class InterFit {
	
	private Integer numeroArvores;
	private Double medidaInformacao;
	private Integer tipoTarefa;  //0-Regressão, 1-Classificação
	private Integer avaliacaoModelo; //1-Insatisfatorio, 2-Ruim, 3-Bom, 4-Muito bom
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
			
	public Cachorro fit(Cachorro cachorro) {
						
		try {
					
			DecimalFormat df = new DecimalFormat("#.##");
			cachorro.setPeso(Double.valueOf(df.format(cachorro.getPeso())));
					
		} catch(Exception e) {
					
			System.out.println("Valor do peso nao pode ser normalizado.");
					
		}
				
		try {
					
			cachorro.setSexo(Character.toUpperCase(cachorro.getSexo()));
					
		} catch(Exception e) {
					
			System.out.println("Valor para a variavel sexo nao pode ser normalizado.");
					
		}
				
		return cachorro;
				
	}
		
	public Cachorro predict(Cachorro cachorro) {
			
		return cachorro;
			
	}
		
	public void avaliaModelo(List<Cachorro> cachorro) {
		
		Integer ind = 0;
		for(Cachorro cao: cachorro) {
			
			ind++;
			if(cao.getTamanho()>0.40 && cao.getTamanho()<0.50) {
				if(cao.getPeso()>25 && cao.getPeso()<35) {
					
					this.medidaInformacao++; 
					
				}
			}
		}	
		
		if((medidaInformacao/ind)<0.2)	{
			
			this.setAvaliacaoModelo(1);
			this.setModo('U');
			
		} else if((medidaInformacao/ind)>=0.2 && (medidaInformacao/ind)<0.4){
			
			this.setAvaliacaoModelo(2);
			this.setModo('I');
			
		} else if((medidaInformacao/ind)>=0.4 && (medidaInformacao/ind)<0.65){
			
			this.setAvaliacaoModelo(3);
			this.setModo('F');
			
		} else if((medidaInformacao/ind)>=0.65){
			
			this.setAvaliacaoModelo(4);
			this.setModo('F');
			
		}
				
	}
		
	public void imprimeModelo() {
			
		System.out.println("Numero de arvores = " + this.getNumeroArvores() + "\n" + this.getMedidaInformacao() +
				"\n" + this.getTipoTarefa() +  "\n" + this.getAvaliacaoModelo() + "\n" + this.getModo());
			
	}
		

}
