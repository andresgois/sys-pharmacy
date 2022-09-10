package br.com.farmacia.factory;

import java.sql.DriverManager;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    
    private static final String USUARIO = "andre";
    private static final String SENHA = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/farmacia";
    
    public static Connection conectar() throws SQLException {
        // DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection conexao = (Connection) DriverManager.getConnection(URL, USUARIO, SENHA);
        return conexao;
    }
    
    public static void main(String[] args) {
        try {
            Connection conexao = Connection.conectar();
            System.out.println("Conectado com sucesso!");
        } catch (SQLException e) { // TODO Auto-generated catch block
            System.out.println("Conexão Falhou"+e.getMessage());
            e.printStackTrace();
        }
    }
    
}
