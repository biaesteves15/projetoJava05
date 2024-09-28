package repositories;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;

public class EstoqueRepositoryXmlImpl extends EstoqueRepositoryAbstract{

	@Override
	public void exportarDados(Estoque estoque) {
		
		try {
			var diretorio = "c:\\arquivos_xml";
			criarDiretorio(diretorio);
			
			var xmlMapper = new ObjectMapper();
			xmlMapper.writeValue(new File(diretorio + "\\estoque" + estoque.getId() + ".xml"), estoque);
			
			System.out.println("\nArquivo XML gravado com sucesso.");
			
		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
		}
		
	}

}
