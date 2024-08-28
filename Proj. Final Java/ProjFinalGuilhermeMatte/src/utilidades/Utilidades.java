/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

import java.awt.Component;
import java.awt.Container;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author 182320034
 */
public class Utilidades {

    public void limparTela(JTabbedPane contanier) {

        Component components[] = contanier.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText(null);
            }//fim if

            if (component instanceof JFormattedTextField) {
                ((JFormattedTextField) component).setText(null);
            }//fim if

            if (component instanceof JTextArea) {
                ((JTextArea) component).setText(null);
            }//fim if
            if (component instanceof JComboBox) {
                ((JComboBox) component).setSelectedIndex(0);

            }

        }//fim for

    }//fim metodo limpar tela

    public void LimparCampos(Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JTextComponent) {
                ((JTextComponent) comp).setText("");
            } else if (comp instanceof Container) {
                LimparCampos((Container) comp);
            }

        }
    }
    boolean campo;

    public boolean getCampo() {
        return campo;
    }

    public void setCampo(boolean campo) {
        this.campo = campo;
    }

    
}
