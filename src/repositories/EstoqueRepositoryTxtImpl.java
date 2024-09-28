package repositories;

import java.io.PrintWriter;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;

public class EstoqueRepositoryTxtImpl extends EstoqueRepositoryAbstract{

	@Override
	public void exportarDados(Estoque estoque) {
		
		try {
			
			var diretorio = "c:\\arquivos_txt";
			criarDiretorio(diretorio);
			
			var printWriter = new PrintWriter(diretorio + "\\estoque" + estoque.getId() + ".txt");
			
			printWriter.write("\n" + estoque.getId());
			printWriter.write("\n" + estoque.getNome());
			
			for(var produto : estoque.getProdutos()) {
				printWriter.write("\n" + produto.getId());
				printWriter.write("\n" + produto.getNome());
				printWriter.write("\n" + produto.getPreco());
				printWriter.write("\n" + produto.getQuantidade());
			}
			
			printWriter.close();
			
			System.out.println("\nArquivo TXT gravado com sucesso.");
			
		}
		catch (Exception e){
			System.out.println("Erro: " + e.getMessage());
		}
		
	}
	
}
