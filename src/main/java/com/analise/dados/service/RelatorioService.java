package com.analise.dados.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.analise.dados.model.Cliente;
import com.analise.dados.model.Venda;
import com.analise.dados.model.Vendedor;

public class RelatorioService {
	
	private static final Log LOG = LogFactory.getLog(VendaService.class);

	private static final String QTD_CLIENTES_ARQ = "Quantidade de clientes: ";
	private static final String QTD_VENDEDOR_ARQ = "Quantidade de vendedor: ";
	private static final String ID_VENDA_MAIS_CARA = "ID Maior venda: ";
	private static final String PIOR_VENDEDOR = "Pior vendedor: ";


	public static String montarRelatorio(List<String> dados, List<Vendedor> relatorioVendedor,
			List<Cliente> relatorioCliente, List<Venda> relatorioVendas) {

		LOG.info(">>>>>Processando RelatorioService:: Montar Relatorio.....");
		StringBuilder conteudo = new StringBuilder();

		conteudo.append(QTD_CLIENTES_ARQ + relatorioCliente.size());
		conteudo.append("\r\n");
		conteudo.append(QTD_VENDEDOR_ARQ + relatorioVendedor.size());
		conteudo.append("\r\n");
		conteudo.append(ID_VENDA_MAIS_CARA + VendaService.obterIdMaiorVenda(relatorioVendas));
		conteudo.append("\r\n");
		conteudo.append(PIOR_VENDEDOR + VendaService.obterPiorVendador(relatorioVendas));

		return conteudo.toString();
	}
}
