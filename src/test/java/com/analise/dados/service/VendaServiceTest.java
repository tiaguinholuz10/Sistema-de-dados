package com.analise.dados.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.analise.dados.model.Venda;

class VendaServiceTest {

	private String line1 = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çPedro";
	private String line2 = "003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo";
	private List<Venda> gerarRelatorio;

	@Before
	public void start() {

	}

	@Test
	void testGerarRelatorio() {	
		gerarRelatorio = VendaService.gerarRelatorio(Arrays.asList(line1, line2));
		assertTrue(!gerarRelatorio.get(0).getVendedor().isEmpty());
	}

	@Test
	void testObterIdMaiorVenda() {
		Integer expectedId = 10;

		Integer obterIdMaiorVenda = VendaService.obterIdMaiorVenda(VendaService.gerarRelatorio(Arrays.asList(line1, line2)));

		assertEquals(expectedId, obterIdMaiorVenda);
	}

	@Test
	void testObterPiorVendador() {
		String expectedVendedor = "Paulo";
		String obterPiorVendador = VendaService.obterPiorVendador(VendaService.gerarRelatorio(Arrays.asList(line1, line2)));
		
		assertEquals(expectedVendedor, obterPiorVendador);
	}

}
