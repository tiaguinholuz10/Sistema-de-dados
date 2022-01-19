package com.analise.dados.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ReadFile {

	private static final Log LOG = LogFactory.getLog(ReadFile.class);

	private static final String DIRETORIO_IN = "//data//in//";
	private static final String DIRETORIO_OUT = "//data//out//";
	private static final String FORMATO_ARQUIVO_IN = ".dat";
	private static final String FORMATO_ARQUIVO_OUT = ".done.dat";

	public static List<String> obterDados(String nameArquivo) {
		List<String> linhas = new ArrayList<String>();
		try {
			LOG.info("Lendo Arquivo .DAT");
			Path caminho = Paths.get(System.getenv("HOMEPATH"), DIRETORIO_IN + nameArquivo + FORMATO_ARQUIVO_IN);
			Files.lines(caminho, StandardCharsets.UTF_8).forEach(l -> linhas.add(l));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return linhas;
	}

	public static List<String> gravarDados(String nameArquivo, String conteudo) {
		LOG.info(">>>>>Gravando os Dados do Relatorio em Arquivo .DAT");
		
		List<String> linhas = new ArrayList<String>();
		try {
			
			String dir = System.getenv("HOMEPATH") + DIRETORIO_OUT;
			Path caminho = Paths.get(dir + nameArquivo + FORMATO_ARQUIVO_OUT);
			byte[] bytes = conteudo.getBytes(StandardCharsets.UTF_8);
			
			if(!Files.exists(Paths.get(dir))) {
				Files.createDirectories(Paths.get(dir));
			}
			Files.write(caminho, bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return linhas;
	}

}
