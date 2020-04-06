package com.qintess.hibernate.estudo.desafio.fornecedor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fornecedor implements InterfaceModel {
		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id_fornecedor;

		@Column(length = 45, nullable = false)
		private String nome;
		
		@Column(length = 45, nullable = false)
		private String telefone;
		
		@Column(length = 45, nullable = false)
		private String contato;

			
		public Fornecedor() {

		}

		public Fornecedor(String nome, String telefone, String contato) {

			this.nome = nome;
			this.telefone = telefone;
			this.contato = contato;
		}

		
		@Override
		public Integer getId() {
			return id_fornecedor;
		}

		public void setId(int id_fornecedor) {
			this.id_fornecedor = id_fornecedor;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getTelefone() {
			return telefone;
		}

		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}

		public String getContato() {
			return contato;
		}

		public void setContato(String contato) {
			this.contato = contato;
		}

		@Override
		public String toString() {
			return "Fornecedor [ Id =" + id_fornecedor + ", Nome = " + nome + ", Telefone = " + telefone + ", Contato = " + contato + "]";
		}

		@Override
		public int hashCode() {
			
			final int prime = 31;
			
			int result = 1;
			
			result = prime * result + id_fornecedor;
			
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			
			if (this == obj) {
				
				return true;
			}
			
			if (obj == null) {
				
				return false;
			
			}
			
			if (getClass() != obj.getClass()) {
				
				return false;
			}
			
			Fornecedor other = (Fornecedor) obj;
			
			if (id_fornecedor != other.id_fornecedor) {
				
				return false;
			}
			
			return true;
		}
		
		
	
}
