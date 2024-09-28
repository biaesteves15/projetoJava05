package controllers;

import java.util.ArrayList;
import java.util.UUID;

import javax.swing.JOptionPane;

import abstractions.EstoqueRepositoryAbstract;
import entities.Estoque;
import entities.Produto;
import repositories.EstoqueRepositoryJsonImpl;
import repositories.EstoqueRepositoryTxtImpl;
import repositories.EstoqueRepositoryXmlImpl;

public class EstoqueController {

	public void cadastrarEstoque() {

		var estoque = obterDadosEstoque();

		var numProdutos = Integer.parseInt(JOptionPane.showInputDialog("Informe o número de produtos: "));
		if (numProdutos > 0) {

			var lista = new ArrayList<Produto>();

			for (var i = 0; i < numProdutos; i++) {
				JOptionPane.showMessageDialog(null, "Preenchimento do " + (i + 1) + "º produto: ");
				lista.add(obterDadosProduto());
			}

			estoque.setProdutos(lista);
		}
		
		EstoqueRepositoryAbstract estoqueRepository = null;
		
		var formato = JOptionPane.showInputDialog("Informe 'TXT' ou 'XML' ou 'JSON':");
		switch(formato) {
		case "TXT":
			estoqueRepository = new EstoqueRepositoryTxtImpl();
			break;
		case "XML":
			estoqueRepository = new EstoqueRepositoryXmlImpl();
			break;
		case "JSON":
			estoqueRepository = new EstoqueRepositoryJsonImpl();
			break;
		}
		
		estoqueRepository.exportarDados(estoque);
	}

	private Estoque obterDadosEstoque() {

		var estoque = new Estoque();

		estoque.setId(UUID.randomUUID());
		estoque.setNome(JOptionPane.showInputDialog("Nome do estoque:"));

		return estoque;
	}

	private Produto obterDadosProduto() {

		var produto = new Produto();

		produto.setId(UUID.randomUUID());
		produto.setNome(JOptionPane.showInputDialog("Nome do produto: "));
		produto.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Preço: ")));
		produto.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog("Quantidade: ")));

		return produto;
	}
}
