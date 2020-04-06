package com.qintess.principal;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.qintess.hibernate.dao.DaoGenerico;
import com.qintess.hibernate.estudo.desafio.fornecedor.Fornecedor;
import com.qintess.hibernate.estudo.desafio.fornecedor.FornecedorHasProduto;
import com.qintess.hibernate.estudo.desafio.fornecedor.Produto;
import com.qintess.hibernate.estudo.desafio.fornecedor.Venda;
import com.qintess.hibernate.estudo.desafio.fornecedor.VendaItens;

public class App {

	public static void main(String[] args) {

		// CADASTRANDO PROTUDO

		DaoGenerico<Produto> daoProduto = new DaoGenerico<Produto>();

		Produto produto1 = new Produto(3.00, (short) 100, "Eisenbahn", "foto");
		Produto produto2 = new Produto(2.80, (short) 80, "Budweiser", "foto");
		daoProduto.salvar(produto1);
		daoProduto.salvar(produto2);

		// CADASTRANDO FORNECEDOR

		DaoGenerico<Fornecedor> daoFornecedor = new DaoGenerico<Fornecedor>();
		DaoGenerico<FornecedorHasProduto> daoFornecedorHasProduto = new DaoGenerico<FornecedorHasProduto>();

		Fornecedor fornecedor1 = new Fornecedor("Ambev", "3471-2853", "ambev@gmail.com");
		Fornecedor fornecedor2 = new Fornecedor("Vebma", "3456-1236", "vebma@gmail.com");
		daoFornecedor.salvar(fornecedor1);
		daoFornecedor.salvar(fornecedor2);

		Fornecedor fornecedorBanco1 = daoProduto.listaPorId(Fornecedor.class, 1);
		Fornecedor fornecedorBanco2 = daoProduto.listaPorId(Fornecedor.class, 2);
		
		Produto addproduto1 = daoProduto.listaPorId(Produto.class, 1);
		Produto addproduto2 = daoProduto.listaPorId(Produto.class, 2);

		FornecedorHasProduto fornecedorHasProduto1 = new FornecedorHasProduto();
		FornecedorHasProduto fornecedorHasProduto2 = new FornecedorHasProduto();

		fornecedorHasProduto1.setId(new com.qintess.hibernate.estudo.desafio.fornecedor.FornecedorHasProdutoId(
				fornecedorBanco1, addproduto1));
		fornecedorHasProduto2.setId(new com.qintess.hibernate.estudo.desafio.fornecedor.FornecedorHasProdutoId(
				fornecedorBanco2, addproduto2));

		fornecedorHasProduto1.setEstoque(500);
		fornecedorHasProduto2.setEstoque(1000);

		fornecedorHasProduto1.setPrecoCusto(3000);
		fornecedorHasProduto2.setPrecoCusto(7000);

		daoFornecedorHasProduto.salvar(fornecedorHasProduto1);
		daoFornecedorHasProduto.salvar(fornecedorHasProduto2);

		// CADASTRANDO VENDA

		DaoGenerico<Venda> daoVenda = new DaoGenerico<Venda>();

		Venda venda1 = new Venda(1, 15, 2, Timestamp.valueOf(LocalDateTime.now()));
		Venda venda2 = new Venda(2, 30, 3, Timestamp.valueOf(LocalDateTime.now()));
		
		daoVenda.salvar(venda1);
		daoVenda.salvar(venda2);
		
		Venda addvenda1 = daoVenda.listaPorId(Venda.class, 1);
		Venda addvenda2 = daoVenda.listaPorId(Venda.class, 2);
		
		// CARRINHO
		
		DaoGenerico<VendaItens> daoVendaItens = new DaoGenerico<VendaItens>();
		
		VendaItens vendaItens1 =  new VendaItens(addproduto1, addvenda1, 150, (short)fornecedorHasProduto1.getPrecoCusto(), 
				(short)addproduto1.getPreco_venda()); 
				
		VendaItens vendaItens2 = new VendaItens(addproduto2, addvenda2, 50, (short)fornecedorHasProduto2.getPrecoCusto(), 
				(short)addproduto2.getPreco_venda());
		
		
		daoVendaItens.salvar(vendaItens1);
		daoVendaItens.salvar(vendaItens2);

		// EXIBIÇÃO
		

		for(FornecedorHasProduto s : daoFornecedorHasProduto.buscarTodos(FornecedorHasProduto.class)){
			System.out.print("\n" + s.getId().getFornecedor() + "\n");
			System.out.println(s.getId().getProduto() + "\n");
		}
			

		
		
	}
}
