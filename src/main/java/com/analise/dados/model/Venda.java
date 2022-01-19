package com.analise.dados.model;

import java.util.List;

public class Venda {

	private Integer id;
	private Double preco;
	private String vendedor;
	private List<Item> item;
	
	public Venda() {}
	
	public Venda(Integer id, Double preco, String vendedor, List<Item> item) {
		this.id=id;
		this.preco=preco;
		this.vendedor=vendedor;
		this.item=item;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

}
