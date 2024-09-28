package abstractions;

import java.io.File;

import entities.Estoque;

public abstract class EstoqueRepositoryAbstract {
	
	public void criarDiretorio(String caminho) {
		
		var file = new File(caminho);
		if(!file.exists()) {
			file.mkdir();
			System.out.println("Diret�rio criado com sucesso.");
		}
		else {
			System.out.println("Diret�rio j� existente.");
		}
		
	}
	
	public abstract void exportarDados(Estoque estoque);

}
