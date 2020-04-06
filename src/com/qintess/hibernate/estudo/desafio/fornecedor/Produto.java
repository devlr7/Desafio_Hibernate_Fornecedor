package com.qintess.hibernate.estudo.desafio.fornecedor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto implements InterfaceModel {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id_produto;
	
	@Column(nullable = false)
	private double preco_venda;
	
	@Column(nullable = false)
	private short min_estoque;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 45)
	private String foto;

	//CONTRUTORES
	
	public Produto() {
		
		
	}

	public Produto(double preco_venda, short min_estoque, String nome, String foto) {
		
		this.preco_venda = preco_venda;
		this.min_estoque = min_estoque;
		this.nome = nome;
		this.foto = foto;
		
	}
	
	
	
	//METODOS
	
	@Override
	public String toString() {
		
		return "Produto [ID = "+ id_produto +",  nome = "+ nome  + ", Preço = " + preco_venda + ", Em estoque: " + min_estoque + ", Foto = " + foto +  "]";
		
	}
	
	
	public int getId_produto() {
		return id_produto;
	}
	
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}


	public double getPreco_venda() {
		return preco_venda;
	}

	public void setPreco_venda(double preco_venda) {
		this.preco_venda = preco_venda;
	}

	public short getMin_estoque() {
		return min_estoque;
	}

	public void setMin_estoque(short min_estoque) {
		this.min_estoque = min_estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public Object getId() {
	
		return null;
		
	}
	

}
