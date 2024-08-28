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
import model.ProdutoPessoaFisicaVO;
import persistencia.Conexao;

/**
 *
 * @author Admin
 */
public class ConPessoaFisicaDAO {
    
    public ArrayList<ProdutoPessoaFisicaVO> preencherTabela()throws SQLException{
        try {
            Connection con = new Conexao().getConexao();
            String sql = "select * from cadastro_produto_pessoafisica";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            ResultSet rs = pstm.executeQuery();
            ArrayList<ProdutoPessoaFisicaVO> pro = new ArrayList<>();
            
            while (rs.next()) {                
                ProdutoPessoaFisicaVO pVO = new ProdutoPessoaFisicaVO();
                pVO.setIdProdutoPF(rs.getInt("pfproduto_id"));
                pVO.setCPF(rs.getString("cpf"));
                pVO.setNomeCompleto(rs.getString("nomePF"));
                pVO.setQuantidade(rs.getInt("quantidade"));
                pVO.setCategoria(rs.getString("categoria"));
                pVO.setDescricao(rs.getString("descricao"));
                pro.add(pVO);
            }
            pstm.close();
            return pro;
                    
        } catch (SQLException se) {
            throw new SQLException("Erro! - ConPessoaFisicaDAO.preencherTabela - "+se.getMessage());
        }
    }
}
