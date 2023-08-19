package com.example.Spring02.model.conexoes;

import java.sql.Connection;

public class MinhaConexao{

    public static Connection conexao(){
        ConexaoJDBC conexao = new ConexaoHdb();
        return conexao.criarConexao();
    }

}
