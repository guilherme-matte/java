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

    public void cadastrarFuncionarios(FuncionarioVO fVO) throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "insert into funcionarios values (?,?,?,?,?,?,?)";

            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setInt(1, fVO.getIdFuncionario());

            pstm.setString(2, fVO.getNome());

            pstm.setString(3, fVO.getCargo());

            pstm.setFloat(4, fVO.getSalario());

            pstm.setFloat(5, fVO.getVt());

            pstm.setFloat(6, fVO.getVr());

            pstm.setFloat(7, fVO.getPlano());

            pstm.execute();
            
            pstm.close();
            
            JOptionPane.showMessageDialog(null, "ITEM CADASTRADO COM SUCESSO!");
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERRO - cadastrarFuncionarioDAO - " + se);
        } finally {
            con.close();
        }
    }

    public FuncionarioVO preencherMatricula() throws SQLException {
        Connection con = new Conexao().getConexao();
        try {
            String sql = "select * from funcionarios";
            PreparedStatement pstm = con.prepareStatement(sql);

            ResultSet rs = pstm.executeQuery();
            FuncionarioVO fVO = new FuncionarioVO();
            while (rs.next()) {

                fVO.setIdFuncionario(rs.getInt("idFuncionarios"));
            }
            return fVO;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERRO - preencherMatricula - " + se.getMessage());

        }
        return null;
    }
}
