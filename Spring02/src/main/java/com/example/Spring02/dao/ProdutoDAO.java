package com.example.Spring02.dao;
import com.example.Spring02.model.conexoes.MinhaConexao;
import com.example.Spring02.model.entity.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    Connection con;
    public ProdutoDAO(){
        con = MinhaConexao.conexao();
    }

    public List<Produto> buscarProdutos() {
        try {
            String sql = "select * from produto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<Produto> produtos = new ArrayList();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setValor(rs.getLong("valor"));

                produtos.add(p);
            }
            return produtos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean remove(Long id) {
        try {
            String sql = "delete from produto where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            if(ps.executeUpdate()==1)
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean save(Produto produto) {
        try {
            String sql = "insert into produto (descricao, id, valor) values (?,?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produto.getDescricao());
            ps.setLong(2, produto.getId());
            ps.setLong(3, produto.getValor());

            if(ps.executeUpdate()==1)
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean update(Produto produto) {
        try {
            String sql = "update produto set descricao = ?,valor where id= ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, produto.getId());
            ps.setString(2, produto.getDescricao());
            ps.setLong(3, produto.getValor());


            if (ps.executeUpdate()==1)
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Produto buscarProduto(Long id) {
        try {
            String sql = "select * from produto where id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setValor(rs.getLong("valor"));
                p.setDescricao(rs.getString("descricao"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}