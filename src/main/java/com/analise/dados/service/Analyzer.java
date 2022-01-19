package com.analise.dados.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.analise.dados.model.Cliente;
import com.analise.dados.model.Venda;
import com.analise.dados.model.Vendedor;

public class Analyzer {

	private static final Log LOG = LogFactory.getLog(Analyzer.class);

	private static final String FILTRO_VENDEDOR = "001ç";
	private static final String FILTRO_CLIENTE = "002ç";
	private static final String FILTRO_VENDAS = "003ç";

	public static void main(String[] args) {

		LOG.info("Processo Iniciando.....");

		String nameArquivo = "dados";

		List<String> dados = ReadFile.obterDados(nameArquivo);

		List<Vendedor> relatorioVendedor = VendedorService.gerarRelatorio(obterDadosRelatorio(dados, FILTRO_VENDEDOR));

		List<Cliente> relatorioCliente = ClienteService.gerarRelatorio(obterDadosRelatorio(dados, FILTRO_CLIENTE));

		List<Venda> relatorioVendas = VendaService.gerarRelatorio(obterDadosRelatorio(dados, FILTRO_VENDAS));

		String conteudo = RelatorioService.montarRelatorio(dados, relatorioVendedor, relatorioCliente, relatorioVendas);

		ReadFile.gravarDados(nameArquivo, conteudo);

		LOG.info("Processo finalizado.....");
	}

	private static List<String> obterDadosRelatorio(List<String> dados, String filtro) {
		return dados.stream().filter(l -> l.contains(filtro)).collect(Collectors.toList());
	}

}
