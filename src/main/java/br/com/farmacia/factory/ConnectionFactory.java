package br.com.farmacia.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String USUARIO = "andre";
    private static final String SENHA = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/farmacia?autoReconnect=true&useSSL=false";
    
    public static Connection conectar() throws SQLException {
        // Driver referência para versões antigas do java
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        
        Connection conexao = (Connection) DriverManager.getConnection(URL,
                USUARIO, SENHA);
        return conexao;
    }
    
    public static void main(String[] args) {
        try {
            Connection conexao = ConnectionFactory.conectar();
            System.out.println("Conectado com sucesso!!");
        } catch (Exception e) {
            System.out.println("Falha na Coneção");
        }
    }
    
}
