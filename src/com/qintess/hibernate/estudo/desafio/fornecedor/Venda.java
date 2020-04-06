package com.qintess.hibernate.estudo.desafio.fornecedor;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Venda implements InterfaceModel {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id_venda;
	
	private int cliente_id;
	
	private int desconto;
	
	private int forma_pagamento;
	
	private Date data;
	
	@OneToMany(mappedBy = "FKvenda")
	private List<VendaItens> itens = new ArrayList<VendaItens>();
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<VendaItens> vendaItens;
	
	//CONSTRUTORES
	
	public Venda() {

	}
	
	public Venda(int cliente_id, int desconto, int forma_pagamento, Date data) {

		this.cliente_id = cliente_id;
		this.desconto = desconto;
		this.forma_pagamento = forma_pagamento;
		this.data = data;
		
	}
	
	
	//METODOS
	
	@Override
	public String toString() {
		
		return "Venda [ ID = "+ id_venda +",  Id Cliente = "+ cliente_id  + ", Desconto = " + desconto + ", Forma de Pagamento = " + forma_pagamento + ", Data = " + data + " ]";
		
	}
	
	
	public int getId_venda() {
		return id_venda;
	}

	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public int getForma_pagamento() {
		return forma_pagamento;
	}

	public void setForma_pagamento(int forma_pagamento) {
		this.forma_pagamento = forma_pagamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public List<VendaItens> getVendaItens() {
		return vendaItens;
	}

	public void setVendaItens(List<VendaItens> vendaItens) {
		this.vendaItens = vendaItens;
	}

	public void addVendaItens(VendaItens vendaItens) {
		
		if (this.vendaItens == null) {
			this.vendaItens = new ArrayList<VendaItens>();
		}
		this.vendaItens.add(vendaItens);
		
	}

	@Override
	public Object getId() {

		return null;
		
	}

	
}

