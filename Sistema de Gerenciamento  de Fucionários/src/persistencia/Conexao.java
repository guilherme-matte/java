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
 * @author guilherme-matte
 */
public class Conexao {

    public Connection getConexao() {
        Connection c = null;
        try {
            String url = "jdbc:mysql://localhost:3306/empresa?user=root&password=";
            c = DriverManager.getConnection(url);

        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, "ERRO AO CONECTAR! "+se.getMessage());
        }
    return c;
    }
    
}
