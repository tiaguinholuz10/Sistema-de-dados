package com.analise.dados.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.analise.dados.model.Cliente;

public class ClienteService {
	
	private static final Log LOG = LogFactory.getLog(ClienteService.class);

	public static List<Cliente> gerarRelatorio(List<String> dadosRelatorio) {

		LOG.info(">>>>>Processando ClienteService:: Gerar Relatorio.....");
		List<Cliente> lista = new ArrayList<Cliente>();

		for (String dados : dadosRelatorio) {
			String[] resultado = dados.split("ç");
			lista.add(new Cliente(resultado[1], resultado[2], resultado[3]));
		}
		return lista;
	}

}
