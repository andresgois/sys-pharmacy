package br.com.farmacia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.farmacia.domain.Fornecedores;
import br.com.farmacia.factory.ConnectionFactory;

public class FornecedoresDAO {
  
    public void salvar(Fornecedores f) throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO fornecedores ");
        sb.append(" (descricao) ");
        sb.append(" VALUES (?) ");
        
        Connection con = ConnectionFactory.conectar();
        
        PreparedStatement ps = con.prepareStatement(sb.toString());
        ps.setString(1, f.getDescricao());
        ps.executeUpdate();
    }
    
    public void excluir(Fornecedores f) throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM fornecedores");
        sb.append(" WHERE codigo = ?;");
        
        Connection con = ConnectionFactory.conectar();
        
        PreparedStatement ps = con.prepareStatement(sb.toString());
        ps.setLong(1, f.getCodigo());
        ps.executeUpdate();
    }
    
    public void editar(Fornecedores f) throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE fornecedores ");
        sb.append("SET descricao = ? ");
        sb.append("WHERE codigo = ?");
        
        Connection con = ConnectionFactory.conectar();
        
        PreparedStatement ps = con.prepareStatement(sb.toString());
        ps.setString(1, f.getDescricao());
        ps.setLong(2, f.getCodigo());
        ps.executeUpdate();
    }
    
    public Fornecedores buscaPorCodigo(Fornecedores f) throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM fornecedores ");
        sb.append("WHERE codigo = ?");
        
        Connection con = ConnectionFactory.conectar();
        
        PreparedStatement ps = con.prepareStatement(sb.toString());
        ps.setLong(1, f.getCodigo());
        
        ResultSet rs = ps.executeQuery();
        Fornecedores retorno = null;
        
        if(rs.next()) {
            retorno = new Fornecedores();
            retorno.setCodigo(rs.getLong("codigo"));
            retorno.setDescricao(rs.getString("descricao"));   
        }
        return retorno;
    }
    
    public ArrayList<Fornecedores> buscaPorDescricao(Fornecedores f) throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM fornecedores ");
        sb.append("WHERE descricao LIKE ?");
        sb.append(" ORDER BY descricao DESC");
        
        Connection con = ConnectionFactory.conectar();
        PreparedStatement ps = con.prepareStatement(sb.toString());
        ps.setString(1, "%"+f.getDescricao()+"%");
        
        ResultSet rs = ps.executeQuery();
        ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();
        
        while(rs.next()) {
            Fornecedores item = new Fornecedores();
            item.setCodigo(rs.getLong("codigo"));
            item.setDescricao(rs.getString("descricao"));
            lista.add(item);
        }
        return lista;
    }
    
    public ArrayList<Fornecedores> listar() throws SQLException{
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM fornecedores ");
        sb.append("ORDER BY descricao DESC");
        
        Connection con = ConnectionFactory.conectar();
        PreparedStatement ps = con.prepareStatement(sb.toString());
        
        ResultSet rs = ps.executeQuery();
        ArrayList<Fornecedores> lista = new ArrayList<Fornecedores>();
        
        while(rs.next()) {
            Fornecedores f = new Fornecedores();
            f.setCodigo(rs.getLong("codigo"));
            f.setDescricao(rs.getString("descricao"));
            lista.add(f);
        }
        return lista;
    }
    
    public static void main(String[] args) {
        /*
        // Salvando dados
        FornecedoresDAO fdao =  new FornecedoresDAO();
        Fornecedores f1 = new Fornecedores();
        f1.setDescricao("Descrição 1");
        Fornecedores f2 = new Fornecedores();
        f2.setDescricao("Descrição 2");
        
        
        try {
            fdao.salvar(f1);
            fdao.salvar(f2);
            System.out.println("==== Salvo com sucesso!");
        } catch (SQLException e) {
            System.out.println("==== Erro ao salva!");
            e.printStackTrace();
        }*/
        
        /*
         // Deletando dados
        FornecedoresDAO fdao =  new FornecedoresDAO();
        Fornecedores f1 = new Fornecedores();
        f1.setCodigo(1L);        
        
        try {
            fdao.excluir(f1);
            System.out.println("==== Deletador com sucesso!");
        } catch (SQLException e) {
            System.out.println("==== Erro ao deletar!");
            e.printStackTrace();
        }*/
        
        /*
        // Ediçao dados
        FornecedoresDAO fdao =  new FornecedoresDAO();
        Fornecedores f1 = new Fornecedores();
        f1.setCodigo(2L);
        f1.setDescricao("Descrição 2 - Atualizado");
        
        try {
            fdao.editar(f1);
            System.out.println("==== Atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("==== Erro ao atualizado!");
            e.printStackTrace();
        }*/
        
        /*
        // busca por código
        FornecedoresDAO fdao =  new FornecedoresDAO();
        Fornecedores f1 = new Fornecedores();
        f1.setCodigo(4L);        
        
        try {
            Fornecedores forn = fdao.buscaPorCodigo(f1);
            System.out.println("==== Encontrado com sucesso!");
            System.out.println(forn);
        } catch (SQLException e) {
            System.out.println("==== Erro ao pesquisa!");
            e.printStackTrace();
        }*/
        
        /*
        // listar todos
        FornecedoresDAO fdao =  new FornecedoresDAO();
        try {
            ArrayList<Fornecedores> lista = fdao.listar();
            for(Fornecedores f : lista) {
                System.out.println("Resultado: "+f);
            }
        } catch (SQLException e) {
            System.out.println("==== Erro ao listar!");
            e.printStackTrace();
        }*/
        
        // buscar por descrição
        FornecedoresDAO fdao =  new FornecedoresDAO();
        Fornecedores f1 = new Fornecedores();
        f1.setDescricao("Descrição 2");        
        
        try {
            ArrayList<Fornecedores> lista = fdao.buscaPorDescricao(f1);
            for(Fornecedores f : lista) {
                System.out.println("Resultado: "+f);
            }
        } catch (SQLException e) {
            System.out.println("==== Erro ao buscar!");
            e.printStackTrace();
        }
    }
}
