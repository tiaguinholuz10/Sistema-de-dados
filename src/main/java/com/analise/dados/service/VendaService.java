package com.analise.dados.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.analise.dados.model.Item;
import com.analise.dados.model.Venda;

public class VendaService {
	
	private static final Log LOG = LogFactory.getLog(VendaService.class);
	
	
	private static List<Item> item;

	public static List<Venda> gerarRelatorio(List<String> dadosRelatorio) {
		
		LOG.info(">>>>>Processando VendaService:: Gerar Relatorio.....");
		
		List<Venda> listaVendas = new ArrayList<Venda>();
		
		for (String dados : dadosRelatorio) {
			String[] resultado = dados.split("ç");
			item = new ArrayList<Item>();
			listaVendas.add(new Venda(Integer.valueOf(resultado[1]), calcularVendas(resultado[2]), resultado[3], item));			
		}		
		return listaVendas;
	}
	
	public static Integer obterIdMaiorVenda(List<Venda> relatorioVendas) {
		
		relatorioVendas.sort(Comparator.comparingDouble(Venda::getPreco).reversed());
		return relatorioVendas.get(0).getId();
	}
	
	public static String obterPiorVendador(List<Venda> relatorioVendas) {
		
		relatorioVendas.sort(Comparator.comparingDouble(Venda::getPreco));
		return relatorioVendas.get(0).getVendedor();
	}

	private static Double calcularVendas(String itensVenda) {		
		
		Double valor = 0.0;
		String[] spt = itensVenda.replace("[", "").replace("]", "").split(",");
		for (int i = 0; i < spt.length; i++) {
			String[] s = spt[i].split("-");
			valor = valor + (Integer.valueOf(s[1]) * Double.valueOf(s[2]));
			item.add(new Item(Integer.valueOf(s[0]), Integer.valueOf(s[1]), Double.valueOf(s[2]), (Integer.valueOf(s[1]) * Double.valueOf(s[2])) ));
		}
		return valor;
	}

}
