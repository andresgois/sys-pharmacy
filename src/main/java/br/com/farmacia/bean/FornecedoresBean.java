package br.com.farmacia.bean;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.ListDataModel;

import br.com.farmacia.DAO.FornecedoresDAO;
import br.com.farmacia.domain.Fornecedores;

@ManagedBean(name = "MBFornecedores")
@ViewScoped
public class FornecedoresBean {

    private Fornecedores fornecedores;
    private ListDataModel<Fornecedores> itens;
    
    /***
     * Ao iniciar o projeto, ele executa esse método
     */
    @PostConstruct
    public void prepararPesquisa() {

        try {
            FornecedoresDAO fdao = new FornecedoresDAO();
            ArrayList<Fornecedores> lista = fdao.listar();
            itens = new ListDataModel<Fornecedores>(lista);

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            //JSFUtil.adicionarMensagemErro("ex.getMessage()");
            e.printStackTrace();
        }

    }
    public ListDataModel<Fornecedores> getItens() {
        return itens;
    }
    public void setItens(ListDataModel<Fornecedores> itens) {
        this.itens = itens;
    }
    public Fornecedores getFornecedores() {
        return fornecedores;
    }
    public void setFornecedores(Fornecedores fornecedores) {
        this.fornecedores = fornecedores;
    }

}
