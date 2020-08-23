package br.edu.pattertproject.fireman.part3.flyweight;

public class Edificacao {
	private Double area;
	private Bloco bloco;
	
	public Edificacao(Double area, Bloco bloco) {
		this.area = area;
		this.bloco = bloco;
	}

	public Bloco getBloco() {
		return bloco;
	}

	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		if (area <= 0) {
			throw new IllegalArgumentException("A área não pode ser negativa ou zero !");
		}
		this.area = area;
	}

}
