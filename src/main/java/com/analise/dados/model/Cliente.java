package com.analise.dados.model;

public class Cliente {

	private String name;
	private String cnpj;
	private String businessArea;
	
	public Cliente() {}

	public Cliente(String name, String cnpj, String businessArea) {
		this.name = name;
		this.cnpj = cnpj;
		this.businessArea = businessArea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getBusinessArea() {
		return businessArea;
	}

	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

}
