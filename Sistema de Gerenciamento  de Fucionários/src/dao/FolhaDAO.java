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
import model.FuncionarioVO;
import persistencia.Conexao;

/**
 *
 * @author Admin
 */
public class FolhaDAO {

    public FuncionarioVO pesquisarMatricula(int id) throws SQLException {

        Connection con = new Conexao().getConexao();

        try {
            String sql = "select * from funcionarios where idFuncionarios = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
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

            pstm.close();
            return fVO;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR FUNCIONÁRIO - " + se);
        } finally {
            con.close();
        }
        return null;
    }

    public FuncionarioVO pesquisarFuncionario(int id, String nome, int cargo) throws SQLException {
        Connection con = new Conexao().getConexao();

        try {
            String cargoFuncionario;
            switch (cargo) {
                case 0:
                  cargoFuncionario = "Funcionário";
                    break;
                case 1:
                    cargoFuncionario = "Estagiário";
                    break;
                    case 2:
                    cargoFuncionario = "Gerente";
                    break;
                    case 3:
                    cargoFuncionario = "'Funcionário' or 'Estagiário' or 'Gerente'";
                    break;
            }
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERRO AO PESQUISAR FUNCIONARIO - "+se.getMessage());
        } finally {
            con.close();
        }
        return null;
    }
}
