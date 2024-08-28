/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.ProdutoEmpresaVO;
import persistencia.Conexao;

/**
 *
 * @author Admin
 */
public class ConEmpresaDAO {

    public ArrayList<ProdutoEmpresaVO> FiltrarProdutoEmpresa(String opcao, String pesquisa) throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select* from cadastro_produto_empresas where " + opcao + " LIKE ?";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, pesquisa+"%");

            ResultSet rs = pstm.executeQuery();

            ArrayList<ProdutoEmpresaVO> pro = new ArrayList<>();
            while (rs.next()) {
                ProdutoEmpresaVO pVO = new ProdutoEmpresaVO();

                pVO.setIdProduto(rs.getInt("produto_id"));
                pVO.setCNPJ(rs.getString("cnpj"));
                pVO.setCategoria(rs.getString("categoria"));
                pVO.setQuantidade(rs.getInt("quantidade"));
                pVO.setNomeEmpresa(rs.getString("nomeEmpresa"));
                pVO.setResponsavelEmpresa(rs.getString("responsavel"));
                pVO.setDescricao(rs.getString("descricao"));
                pro.add(pVO);
            }
            pstm.close();
            return pro;
        } catch (SQLException se) {
            throw new SQLException("Erro! ConEmpresaDAO.FiltrarProdutoEmpresa - " + se.getMessage());
        } finally {
            con.close();
        }

    }

    public ArrayList<ProdutoEmpresaVO> PreencherTabela() throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select * from cadastro_produto_empresas";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            ArrayList<ProdutoEmpresaVO> empresas = new ArrayList<>();
            while (rs.next()) {
                ProdutoEmpresaVO pVO = new ProdutoEmpresaVO();

                pVO.setIdProduto(rs.getInt("produto_id"));
                pVO.setCNPJ(rs.getString("cnpj"));
                pVO.setCategoria(rs.getString("categoria"));
                pVO.setQuantidade(rs.getInt("quantidade"));
                pVO.setNomeEmpresa(rs.getString("nomeEmpresa"));
                pVO.setResponsavelEmpresa(rs.getString("responsavel"));
                pVO.setDescricao(rs.getString("descricao"));
                empresas.add(pVO);
            }
            pstm.close();
            return empresas;
        } catch (SQLException se) {
            throw new SQLException("Erro! ConEmpresaDAO.PreencherTabela - " + se.getMessage());
        } finally {
            con.close();
        }
    }
}
