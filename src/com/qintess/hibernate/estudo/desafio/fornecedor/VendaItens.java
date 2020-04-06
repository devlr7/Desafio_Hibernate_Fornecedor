package com.qintess.hibernate.estudo.desafio.fornecedor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class VendaItens implements InterfaceModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vendaItens;

	@ManyToOne(fetch = FetchType.EAGER,  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	private Produto FKproduto;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH})
	private Venda FKvenda;

	@Column(nullable = false)
	private int qtd;

	@Column(nullable = false, precision = 2, length = 10)
	private short preco_custo;

	@Column(nullable = false, precision = 2, length = 10)
	private short preco_unit;

	//CONSTRUTORES
	
	public VendaItens() {
	}

	public VendaItens(Produto FKproduto, Venda FKvenda, int qtd, short preco_custo, short preco_unit) {
		this.FKvenda = FKvenda;
		this.FKproduto = FKproduto;
		this.qtd = qtd;
		this.preco_custo = preco_custo;
		this.preco_unit = preco_unit;
	}

	
	//METODOS
	

	@Override
	public String toString() {
		return "VendaItens [ ID =" + id_vendaItens + ", Venda =" + FKvenda + ", Produto=" + FKproduto + ", Quantidade = " + qtd
				+ ", Preço de Custo =" + preco_custo + ", Preço Unitário =" + preco_unit + " ]";
	}
	

	public int getId_vendaItens() {
		return id_vendaItens;
	}

	public void setId_vendaItens(int id_vendaItens) {
		this.id_vendaItens = id_vendaItens;
	}

	public Produto getFKproduto() {
		return FKproduto;
	}

	public void setFKproduto(Produto fKproduto) {
		FKproduto = fKproduto;
	}

	public Venda getFKvenda() {
		return FKvenda;
	}

	public void setFKvenda(Venda fKvenda) {
		FKvenda = fKvenda;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public short getPreco_custo() {
		return preco_custo;
	}

	public void setPreco_custo(short preco_custo) {
		this.preco_custo = preco_custo;
	}

	public short getPreco_unit() {
		return preco_unit;
	}

	public void setPreco_unit(short preco_unit) {
		this.preco_unit = preco_unit;
	}

	@Override
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}


	
}