package br.com.farmacia.domain;

import javax.persistence.Table;

@Table(name = "produtos")
public class Produtos {
   
    private Long codigo;
    private String descricao;
    private Long quantidade;
    private Double preco;
    private Fornecedores fornecedores = new Fornecedores();

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    
    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Fornecedores getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Fornecedores fornecedores) {
        this.fornecedores = fornecedores;
    }

    @Override
    public String toString() {
        return this.getDescricao() 
                + " - R$ " + this.getPreco() 
                + " - " + this.getQuantidade() 
                + " - " + this.getFornecedores();
    }

}
