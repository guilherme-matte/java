/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.EmpresaVO;
import model.PessoaFisicaVO;
import persistencia.Conexao;

/**
 *
 * @author Admin
 */
public class ColaboradoresDAO {

    public ArrayList<EmpresaVO> filtrarTabelaEmpresa(String opcao, String pesquisa) throws SQLException {
        Connection con = new Conexao().getConexao();

        try {
            String sql = "select * from empresas where " + opcao + " like ?";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, "%" + pesquisa + "%");

            ResultSet rs = pstm.executeQuery();
            ArrayList<EmpresaVO> empresas = new ArrayList<>();

            while (rs.next()) {
                EmpresaVO eVO = new EmpresaVO();

                eVO.setIdEmpresa(rs.getInt("empresa_id"));

                eVO.setCNPJ(rs.getString("cnpj"));

                eVO.setNomeEmpresa(rs.getString("nome_empresa"));

                eVO.setResponsavelEmpresa(rs.getString("nome_responsavel"));

                eVO.setCargoEmpresa(rs.getString("cargo"));

                eVO.setEmailEmpresa(rs.getString("email_empresa"));

                eVO.setTelefoneEmpresa(rs.getString("telefone_empresa"));

                eVO.setEmailResponsavel(rs.getString("email_responsavel"));

                eVO.setTelefoneResponsavel(rs.getString("telefone_responsavel"));

                Date data = rs.getDate("data_cadastro");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                String dataFormatada = sdf.format(data);

                eVO.setDataFormatada(dataFormatada);

                empresas.add(eVO);
            }
            pstm.close();
            return empresas;
        } catch (SQLException se) {
            throw new SQLException("Erro! - Colaboradores.filtrarTabelaEmpresa - " + se.getMessage());
        }
    }

    public ArrayList<PessoaFisicaVO> filtrarTabelaPessoaFisica(String opcao, String pesquisa) throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select * from pessoa_fisica where " + opcao + " LIKE ?";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, "%" + pesquisa + "%");

            ResultSet rs = pstm.executeQuery();

            ArrayList<PessoaFisicaVO> pessoas = new ArrayList<>();

            while (rs.next()) {
                PessoaFisicaVO pVO = new PessoaFisicaVO();

                pVO.setIdPF(rs.getInt("pessoaFisica_id"));

                pVO.setCPF(rs.getString("cpf"));

                pVO.setNomeCompleto(rs.getString("nome") + " " + rs.getString("sobrenome"));

                pVO.setEmailPF(rs.getString("email"));

                pVO.setEndereco(rs.getString("endereco"));

                pVO.setCep(rs.getString("cep"));

                Date data = rs.getDate("data_cadastro");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                String dataFormatada = sdf.format(data);

                pVO.setDataFormatada(dataFormatada);

                pVO.setTelefonePF(rs.getString("telefone"));

                pessoas.add(pVO);

            }

            pstm.close();

            return pessoas;

        } catch (SQLException se) {
            throw new SQLException("Erro! - ColaboradoresDAO.filtrarTabelaPessoaFisica" + se.getMessage());
        }
    }

    public ArrayList<PessoaFisicaVO> preencherTabelaPessaoFisica() throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select * from pessoa_fisica";

            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            ArrayList<PessoaFisicaVO> pessoas = new ArrayList<>();

            while (rs.next()) {
                PessoaFisicaVO pVO = new PessoaFisicaVO();

                pVO.setIdPF(rs.getInt("pessoaFisica_id"));

                pVO.setCPF(rs.getString("cpf"));

                pVO.setNomeCompleto(rs.getString("nome") + " " + rs.getString("sobrenome"));

                pVO.setEmailPF(rs.getString("email"));

                pVO.setEndereco(rs.getString("endereco"));

                pVO.setCep(rs.getString("cep"));

                Date data = rs.getDate("data_cadastro");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                String dataFormatada = sdf.format(data);

                pVO.setDataFormatada(dataFormatada);

                pVO.setTelefonePF(rs.getString("telefone"));

                pessoas.add(pVO);

            }
            pstm.close();
            return pessoas;
        } catch (SQLException se) {
            throw new SQLException("Erro! - ColaboradoresDAO.preencherTabelaPessoaFisica - " + se.getMessage());
        }

    }

    public ArrayList<EmpresaVO> preencherTabelaEmpresa() throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select * from empresas";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            ArrayList<EmpresaVO> empresas = new ArrayList<>();

            while (rs.next()) {
                EmpresaVO eVO = new EmpresaVO();

                eVO.setIdEmpresa(rs.getInt("empresa_id"));

                eVO.setCNPJ(rs.getString("cnpj"));

                eVO.setNomeEmpresa(rs.getString("nome_empresa"));

                eVO.setResponsavelEmpresa(rs.getString("nome_responsavel"));

                eVO.setCargoEmpresa(rs.getString("cargo"));

                eVO.setEmailEmpresa(rs.getString("email_empresa"));

                eVO.setTelefoneEmpresa(rs.getString("telefone_empresa"));

                eVO.setEmailResponsavel(rs.getString("email_responsavel"));

                eVO.setTelefoneResponsavel(rs.getString("telefone_responsavel"));

                Date data = rs.getDate("data_cadastro");

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                String dataFormatada = sdf.format(data);

                eVO.setDataFormatada(dataFormatada);

                empresas.add(eVO);
            }
            pstm.close();
            return empresas;
        } catch (SQLException se) {

            throw new SQLException("Erro! - ColaboradoresDAO.preencherTabelaEmpresa - " + se.getMessage());
        }

    }
}
