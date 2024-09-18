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

    public ArrayList<FuncionarioVO> pesquisarFuncionario(int id, String nome, int cargo) throws SQLException {
        Connection con = new Conexao().getConexao();

        try {

            String pesquisaCargo = null;
            switch (cargo) {
                case 0:
                    pesquisaCargo = "Funcionário";
                    break;
                case 1:
                    pesquisaCargo = "Estagiário";
                    break;
                case 2:
                    pesquisaCargo = "Gerente";
                    break;
                case 3:
                    pesquisaCargo = "('Funcionário', 'Estagiário' ,'Gerente')";
                    break;
            }

            StringBuilder sql = new StringBuilder("Select * from funcionarios where 1=1");

            if (id > 0) {
                sql.append(" AND idFuncionarios = ?");
            }
            if (nome != null && !nome.isEmpty()) {
                sql.append(" AND nomeFuncionario like ?");
            }
            if (pesquisaCargo != null & cargo != 3) {

                sql.append(" AND cargoFuncionario = ?");
            } else if (cargo == 3) {
                sql.append(" AND cargoFuncionario in ").append(pesquisaCargo);
            }

            PreparedStatement pstm = con.prepareStatement(sql.toString());
            int parametro = 1;
            if (id > 0) {
                pstm.setInt(parametro++, id);
            }
            if (nome != null && !nome.isEmpty()) {
                pstm.setString(parametro++, "%" + nome + "%");
            }
            if (pesquisaCargo != null & cargo != 3) {
                pstm.setString(parametro++, pesquisaCargo);
            }
            ResultSet rs = pstm.executeQuery();

            ArrayList<FuncionarioVO> funcionario = new ArrayList<>();

            while (rs.next()) {
                FuncionarioVO fVO = new FuncionarioVO();
                fVO.setIdFuncionario(rs.getInt("idFuncionarios"));
                fVO.setNome(rs.getString("nomeFuncionario"));
                fVO.setCargo(rs.getString("cargoFuncionario"));
                fVO.setSalario(rs.getFloat("salarioFuncionario"));
                fVO.setVt(rs.getFloat("valeTransporte"));
                fVO.setVr(rs.getFloat("valeAlimentacao"));
                fVO.setPlano(rs.getFloat("planoSaude"));
                funcionario.add(fVO);
            }

            return funcionario;

        } catch (SQLException se) {
            System.out.println(se.getMessage());
        } finally {
            con.close();
        }
        return null;
    }

}
