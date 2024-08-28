/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 182320034
 */
public class Conexao {
    
     public Connection getConexao() {
        Connection c = null;
        try {
            String url = "jdbc:mysql://localhost:3306/pids_tech?user=root&password=";
            c = DriverManager.getConnection(url);
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(
                    null,
                    "Erro ao Conectar! " + se.getMessage());
        }//fecha o try catch
        return c;
    }//fecha o método getConexao
    
}//fecha clasee
