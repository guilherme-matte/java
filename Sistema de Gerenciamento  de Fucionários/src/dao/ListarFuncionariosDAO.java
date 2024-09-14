/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import model.FuncionarioVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import persistencia.Conexao;

/**
 *
 * @author guilherme-matte
 */
public class ListarFuncionariosDAO {

    public ArrayList<FuncionarioVO> preencherLista() throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select * from funcionarios";

            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();

            ArrayList<FuncionarioVO> funcionario = new ArrayList<>();

            
            while (rs.next()) {
                FuncionarioVO fVO = new FuncionarioVO();
                fVO.setIdFuncionario(rs.getInt("idFuncionarios"));

                fVO.setNome(rs.getString("nomeFuncionario"));

                fVO.setCargo(rs.getString("cargoFuncionario"));

                fVO.setSalario(rs.getFloat("salarioFuncionario"));

                funcionario.add(fVO);
            }
            pstm.close();
            return funcionario;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERRO! ListarFuncionarioDAO - " + se.getMessage());
        } finally {
            con.close();
        }

        return null;
    }
}
