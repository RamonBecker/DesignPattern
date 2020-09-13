package br.edu.pattertproject.fireman.part3.flyweight;

public class Bloco {
	private Empresa empresa;
	private Double area;

	public Bloco(Double area) {
		this.area = area;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

}
