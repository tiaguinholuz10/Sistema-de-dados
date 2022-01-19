package com.analise.dados.model;

public class Item {

	private Integer id;
	private Integer qtd;
	private Double valor;
	private Double valorTotal;

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public Item(Integer id, Integer qtd, Double valor, Double valorTotal) {
		this.id = id;
		this.qtd = qtd;
		this.valor = valor;
		this.valorTotal=valorTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
