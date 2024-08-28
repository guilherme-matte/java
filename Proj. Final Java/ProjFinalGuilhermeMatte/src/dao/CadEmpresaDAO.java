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
import model.EmpresaVO;
import model.ProdutoEmpresaVO;
import persistencia.Conexao;

/**
 *
 * @author Admin
 */
public class CadEmpresaDAO {

    Connection con = new Conexao().getConexao();

    public void CadEmpresa(EmpresaVO eVO) {
        try {

            String sql = "insert into empresas values(null, ?, ?, ?, ?, ?, ?, ? ,? , ?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, eVO.getCNPJ());

            pstm.setString(2, eVO.getNomeEmpresa());

            pstm.setString(3, eVO.getResponsavelEmpresa());

            pstm.setString(4, eVO.getTelefoneEmpresa());

            pstm.setString(5, eVO.getTelefoneResponsavel());

            pstm.setString(6, eVO.getEmailEmpresa());

            pstm.setString(7, eVO.getEmailResponsavel());

            pstm.setString(8, eVO.getCargoEmpresa());

            pstm.setDate(9, eVO.getDataCadastroEmpresa());

            pstm.execute();

            pstm.close();

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Erro de conexão! CadEmpresaDAO" + se);
        }

    }

    public EmpresaVO buscarEmpresa(String cnpj) throws SQLException {
        try {

            String sql = "select * from empresas where cnpj = ?";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, cnpj);

            ResultSet rs = pstm.executeQuery();

            EmpresaVO eVO = new EmpresaVO();

            if (rs.next()) {

                eVO.setIdEmpresa(rs.getInt("empresa_id"));

                eVO.setNomeEmpresa(rs.getString("nome_empresa"));

                eVO.setResponsavelEmpresa(rs.getString("nome_responsavel"));

            }

            pstm.close();

            return eVO;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar empresa! - " + se);
        } finally {
            con.close();
        }

    }

    public void CadProdEmpresa(ProdutoEmpresaVO pVO) {
        try {

            String sql = "insert into cadastro_produto_empresas values(null, ?,?,?,?,?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, pVO.getCNPJ());

            pstm.setString(2, pVO.getCategoria());

            pstm.setInt(3, pVO.getQuantidade());

            pstm.setString(4, pVO.getNomeEmpresa());

            pstm.setString(5, pVO.getResponsavelEmpresa());

            pstm.setString(6, pVO.getDescricao());

            pstm.setInt(7, pVO.getIdProdEmpresa());

            pstm.execute();

            pstm.close();

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto! - CadProdEmpresa" + se);
        }
    }

    public EmpresaVO preencherCamposGUIConsultaCadEmpresa(String cnpj) throws SQLException {
        try {

            String sql = "select * from empresas where cnpj = ?";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, cnpj);

            ResultSet rs = pstm.executeQuery();

            EmpresaVO eVO = new EmpresaVO();

            if (rs.next()) {

                eVO.setIdEmpresa(rs.getInt("empresa_id"));

                eVO.setCNPJ(rs.getString("cnpj"));

                eVO.setNomeEmpresa(rs.getString("nome_empresa"));

                eVO.setResponsavelEmpresa(rs.getString("nome_responsavel"));

                eVO.setTelefoneEmpresa(rs.getString("telefone_empresa"));

                eVO.setTelefoneResponsavel(rs.getString("telefone_responsavel"));

                eVO.setEmailEmpresa(rs.getString("email_empresa"));

                eVO.setEmailResponsavel(rs.getString("email_responsavel"));

                eVO.setCargoEmpresa(rs.getString("cargo"));

            }
            pstm.close();
            System.out.println("DAO" + cnpj);
            return eVO;
        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar empresa! - " + se.getMessage());
        }

    }

    public void alterarCadProdEmpresa(EmpresaVO eVO) throws SQLException {
        try {

            String sql = "update cadastro_produto_empresas set nomeEmpresa = ?, responsavel = ? where cnpj = ?";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, eVO.getNomeEmpresa());

            pstm.setString(2, eVO.getResponsavelEmpresa());

            pstm.setString(3, eVO.getCNPJ());

            pstm.execute();

            pstm.close();

        } catch (SQLException se) {
            throw new SQLException("Erro ao alterar empresa! - " + se.getMessage());
        }
    }

    public void alterarDadosEmpresa(EmpresaVO eVO) throws SQLException {
        try {

            String sql = "Update empresas set nome_empresa = ?, nome_responsavel = ?, telefone_empresa = ?, telefone_responsavel = ?, email_empresa = ?, email_responsavel = ?, cargo = ? where cnpj = ?";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, eVO.getNomeEmpresa());

            pstm.setString(2, eVO.getResponsavelEmpresa());

            pstm.setString(3, eVO.getTelefoneEmpresa());

            pstm.setString(4, eVO.getTelefoneResponsavel());

            pstm.setString(5, eVO.getEmailEmpresa());

            pstm.setString(6, eVO.getEmailResponsavel());

            pstm.setString(7, eVO.getCargoEmpresa());

            pstm.setString(8, eVO.getCNPJ());

            pstm.execute();

            pstm.close();

            JOptionPane.showMessageDialog(null, "Cadastro da Empresa alterado com sucesso!");
        } catch (SQLException se) {
            throw new SQLException("Erro ao alterar empresa! - " + se.getMessage());
        }

    }
}
