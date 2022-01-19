package com.analise.dados.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.analise.dados.model.Vendedor;

public class VendedorService {
	private static final Log LOG = LogFactory.getLog(VendedorService.class);

	public static List<Vendedor> gerarRelatorio(List<String> dadosRelatorio) {
		
		LOG.info(">>>>>Processando VendedorService:: Gerar Relatorio");
		List<Vendedor> lista = new ArrayList<Vendedor>();

		for (String dados : dadosRelatorio) {
			String[] resultado = dados.split("ç");
			lista.add(new Vendedor(resultado[1], resultado[2], Double.valueOf(resultado[3])));
		}
		return lista;
	}

}
