package com.example.Spring02.model.conexoes;
import java.sql.Connection;

public interface ConexaoJDBC {
    public Connection criarConexao();

}
