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
import javax.swing.JOptionPane;
import model.LoginVO;
import persistencia.Conexao;

/**
 *
 * @author Admin
 */
public class LoginDAO {

    public ArrayList<LoginVO> preencherTabela() throws SQLException {
        Connection con = new Conexao().getConexao();

        try {
            String sql = "select * from login";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            ArrayList<LoginVO> users = new ArrayList<>();

            while (rs.next()) {
                LoginVO lVO = new LoginVO();

                lVO.setIdLogin(rs.getInt("login_id"));

                lVO.setCpf(rs.getString("cpf"));

                lVO.setNomeCompleto(rs.getString("nome_completo"));

                lVO.setLogin(rs.getString("usuario"));

                lVO.setPerfil(rs.getString("perfil"));

                lVO.setEmail(rs.getString("email"));

                users.add(lVO);

            }
            pstm.close();

            return users;
        } catch (SQLException se) {
            throw new SQLException("Erro! - LoginDAO.preencherTabela - " + se.getMessage());
        }
    }

    public ArrayList<LoginVO> filtrarUsuarios(String opçao, String pesquisa) throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select * from login where " + opçao + " LIKE ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, "%" + pesquisa + "%");

            ResultSet rs = pstm.executeQuery();

            ArrayList<LoginVO> users = new ArrayList<>();

            while (rs.next()) {
                LoginVO lVO = new LoginVO();

                lVO.setIdLogin(rs.getInt("login_id"));

                lVO.setCpf(rs.getString("cpf"));

                lVO.setNomeCompleto(rs.getString("nome_completo"));

                lVO.setLogin(rs.getString("usuario"));

                lVO.setSenha(rs.getString("senha"));

                lVO.setPerfil(rs.getString("perfil"));

                lVO.setEmail(rs.getString("email"));

                users.add(lVO);

            }

            pstm.close();

            return users;

        } catch (SQLException se) {
            throw new SQLException("Erro! LoginDAO.FiltrarUsuario - " + se.getMessage());
        }

    }

    public void criarUsuario(LoginVO lVO) throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "insert into login values( null , ? , ? , ? , ? , ? ,?)";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, lVO.getCpf());

            pstm.setString(2, lVO.getNomeCompleto());

            pstm.setString(3, lVO.getLogin());

            pstm.setString(4, lVO.getSenha());

            pstm.setString(5, lVO.getPerfil());

            pstm.setString(6, lVO.getEmail());

            pstm.execute();

            pstm.close();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");

        } catch (SQLException se) {
            throw new SQLException("Erro! LoginDAO.criarUsuario - " + se.getMessage());
        }
    }
}
