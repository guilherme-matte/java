/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.PessoaFisicaVO;
import model.ProdutoPessoaFisicaVO;
import persistencia.Conexao;

/**
 *
 * @author Admin
 */
public class CadPessoaFisicaDAO {

    Connection con = new Conexao().getConexao();

    public void CadPessoaFisicaDAO(PessoaFisicaVO pVO) {
        try {
            String sql = "insert into pessoa_fisica values (null,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, pVO.getCPF());
            
            pstm.setString(2, pVO.getNome());
            
            pstm.setString(3, pVO.getSobrenome());
            
            pstm.setString(4, pVO.getEmailPF());
            
            pstm.setString(5, pVO.getEndereco());
            
            pstm.setString(6, pVO.getCep());
            
            pstm.setDate(7, pVO.getDataCadastroPF());
            
            pstm.setString(8, pVO.getTelefonePF());
            
            pstm.execute();
            
            pstm.close();

        } catch (SQLException se) {
            
            JOptionPane.showMessageDialog(null, "Erro! - DAO.CadPessoaFisica " + se);
        
        }
    }

    public PessoaFisicaVO PesquisarPF(String cpf) {

        try {

            String sql = "select * from pessoa_fisica where cpf = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, cpf);

            ResultSet rs = pstm.executeQuery();

            PessoaFisicaVO pVO = new PessoaFisicaVO();
            if (rs.next()) {

                pVO.setIdPF(rs.getInt("pessoaFisica_id"));
                
                pVO.setCPF(rs.getString("cpf"));
                
                pVO.setNome(rs.getString("nome"));
                
                pVO.setSobrenome(rs.getString("sobrenome"));
                
                pVO.setEmailPF(rs.getString("email"));
                
                pVO.setEndereco(rs.getString("endereco"));
                
                pVO.setCep(rs.getString("cep"));
                
                pVO.setNomeCompleto(pVO.getNome() + " " + pVO.getSobrenome());

            }
            pstm.close();
            return pVO;
        } catch (SQLException se) {
            
            JOptionPane.showMessageDialog(null, "Erro! - DAO.PesquisarPF - " + se);
        
        }
        return null;
    }

    public void CadProdPessoaFisicaDAO(ProdutoPessoaFisicaVO pVO) {
        
        try {
                
            String sql = "insert into cadastro_produto_pessoafisica values(null ,?,?,?,?,?,?)";
            
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, pVO.getCPF());
            
            pstm.setString(2, pVO.getNomeCompleto());
            
            pstm.setInt(3, pVO.getQuantidade());
            
            pstm.setString(4, pVO.getCategoria());
            
            pstm.setString(5, pVO.getDescricao());
            
            pstm.setInt(6, pVO.getIdProdutoPF());

            pstm.execute();
            
            pstm.close();

        } catch (SQLException se) {
        
            JOptionPane.showMessageDialog(null, "Erro! CadProdPessoaFisicaDAO.CadProdPessoaFisicaDAO - " + se.getMessage());
        
        }
    }

    public PessoaFisicaVO preencherCamposGUIConPessoaFisica(String cpf) throws SQLException {

        try {
            
            String sql = "select * from pessoa_fisica where cpf = ?";
            
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, cpf);

            ResultSet rs = pstm.executeQuery();
           
            PessoaFisicaVO pVO = new PessoaFisicaVO();

            if (rs.next()) {

                pVO.setIdPF(rs.getInt("pessoaFisica_id"));

                pVO.setCPF(rs.getString("cpf"));

                pVO.setNome(rs.getString("nome"));

                pVO.setSobrenome(rs.getString("sobrenome"));

                pVO.setEmailPF(rs.getString("email"));

                pVO.setEndereco(rs.getString("endereco"));

                pVO.setCep(rs.getString("cep"));

                pVO.setTelefonePF(rs.getString("telefone"));
            }
            pstm.close();

            return pVO;
        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar pessoa! - " + se.getMessage());
        }
    }

    public void alterarCadPessoaFisica(PessoaFisicaVO pVO) throws SQLException {
        try {

            String sql = "Update pessoa_fisica set nome = ?, sobrenome = ?, email = ?, endereco = ?, cep = ?, telefone = ? where cpf = ?";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, pVO.getNome());

            pstm.setString(2, pVO.getSobrenome());

            pstm.setString(3, pVO.getEmailPF());

            pstm.setString(4, pVO.getEndereco());

            pstm.setString(5, pVO.getCep());

            pstm.setString(6, pVO.getTelefonePF());

            pstm.setString(7, pVO.getCPF());

            pstm.execute();
            
            pstm.close();

            JOptionPane.showMessageDialog(null, "Pessoa alterada com sucesso!");
        } catch (SQLException se) {
            throw new SQLException("Erro ao alterar pessoa! - alterarCadPessoaFisica - " + se.getMessage());
        }

    }
    public void alterarCadProdPessoaFisica(PessoaFisicaVO pVO) throws SQLException{
        try {
            String sql = "Update cadastro_produto_pessoafisica set nomePF = ? where cpf = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            
            pstm.setString(1, pVO.getNome()+" "+pVO.getSobrenome());
           
            pstm.setString(2, pVO.getCPF());
            
            pstm.execute();
            
            pstm.close();
        } catch (SQLException se) {
            throw new SQLException("Erro ao alterar a tabela produtos! - AlterarCadProdPessoaFisica" + se.getMessage());
        }
    }
}
