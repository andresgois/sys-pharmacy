package br.com.farmacia.domain;

import javax.persistence.Table;

@Table(name = "fornecedores")
public class Fornecedores {
    
    private Long codigo;
    private String descricao;
    
    public Fornecedores() {}
    
    public Fornecedores(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public Long getCodigo() {
        return codigo;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
        return "Código: "+this.codigo+" Descrição: "+this.descricao;
    }
}
