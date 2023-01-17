package br.com.ufu.rafael.arvorededecisao.modelo;

public class Cachorro {
	
	private String raca;
	private Integer atestrado;
	private char sexo;
	private Double tamanho;
	private Double peso;
	
	public Cachorro(String raca, Integer atestrado, char sexo, Double tamanho, Double peso) {
		
		this.raca = raca;
		this.atestrado = atestrado;
		this.sexo = sexo;
		this.tamanho = tamanho;
		this.peso = peso;
		
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public Integer getAtestrado() {
		return atestrado;
	}

	public void setAtestrado(Integer atestrado) {
		this.atestrado = atestrado;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Double getTamanho() {
		return tamanho;
	}

	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	

}
