/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.FuncionarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import persistencia.Conexao;

/**
 *
 * @author guilherme-matte
 */
public class CadastrarFuncionariosDAO {

    public void cadastrarFuncionarios() {

    }

    public void preencherMatricula() throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select * from empresa";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            FuncionarioVO fVO = new FuncionarioVO();
            if (rs.next()) {

                fVO.setIdFuncionario(rs.getInt("idFuncionario"));
            }

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERRO - preencherMatricula - " + se.getMessage());

        }
    }
}
