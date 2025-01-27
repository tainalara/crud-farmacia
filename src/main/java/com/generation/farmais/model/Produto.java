package com.generation.farmais.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table (name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo NOME é obrigatório")
	@Size(min = 5, max = 100, message = "O atributo Nome deve conter no mínimo 05 e no máximo 100 caracteres")
	private String nome;
	
	@NotNull (message = "O campo Preço é obrigatório para o cadastro do Produto") 
	@DecimalMin (value = "0.0", inclusive = false, message = "O preço cadastrado deve ser maior do que Zero")
	@Column (nullable = false, precision = 10, scale = 2) // Define que esse campo não pode ficar null, que pode receber até 10 números e 2 casas depois da vírgula
	private BigDecimal preco;
	
	@Min (value = 0, message = "A Quantidade no Estoque não pode ser negativa")
	private Long quantidade;
	
	@NotNull (message = "O campo Data de Validade é obrigatório. Use o formato AAAA-MM-DD") 
	private LocalDate validade;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Categoria categoria;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
