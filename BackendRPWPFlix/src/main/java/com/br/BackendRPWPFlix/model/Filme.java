package com.br.BackendRPWPFlix.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name="filme")
	public class Filme {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@Column(name="titulo")
		private String titulo;
		
		@Column(name="diretor")
		private String diretor;
		
		@Column(name="anolancamento")
		private int anolancamento;
		
		@Column(name="genero")
		private String genero;
		
		@Column(name="duracao")
		private int duracao;


		//Construtor padrão
		public Filme() {
			super();
		}


		public Filme(Long id, String titulo, String diretor, int anolancamento, String genero, int duracao) {
			super();
			this.id = id;
			this.titulo = titulo;
			this.diretor = diretor;
			this.anolancamento = anolancamento;
			this.genero = genero;
			this.duracao = duracao;
		}

		//Gets e Sets
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getDiretor() {
			return diretor;
		}

		public void setDiretor(String diretor) {
			this.diretor = diretor;
		}

		public int getAnolancamento() {
			return anolancamento;
		}

		public void setAnolancamento(int anolancamento) {
			this.anolancamento = anolancamento;
		}

		public String getGenero() {
			return genero;
		}

		public void setGenero(String genero) {
			this.genero = genero;
		}

		public int getDuracao() {
			return duracao;
		}

		public void setDuracao(int duracao) {
			this.duracao = duracao;
		}
		

	}