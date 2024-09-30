/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import model.FuncionarioVO;
import persistencia.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.FuncionarioVO;
import persistencia.Conexao;

/**
 *
 * @author guilherme-matte
 */
public class AlterarFuncionarioDAO {

    public FuncionarioVO PreencherCamposFuncinario(String id) throws SQLException {
        Connection con = new Conexao().getConexao();
        try {

            String sql = "select * from funcionarios where idFuncionarios = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(1, Integer.parseInt(id));

            FuncionarioVO fVO = new FuncionarioVO();

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                fVO.setIdFuncionario(rs.getInt("idFuncionarios"));
                fVO.setNome(rs.getString("nomeFuncionario"));
                fVO.setCargo(rs.getString("cargoFuncionario"));
                fVO.setSalario(rs.getFloat("salarioFuncionario"));
                fVO.setVt(rs.getFloat("valeTransporte"));
                fVO.setVr(rs.getFloat("valeAlimentacao"));
                fVO.setPlano(rs.getFloat("planoSaude"));
            }
            return fVO;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR USUÁRIO - ALTERARFUNCIONARIODAO - " + se.getMessage());
        } finally {
            con.close();
        }
        return null;
    }

}
