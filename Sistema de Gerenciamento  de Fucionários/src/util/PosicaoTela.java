/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.awt.Desktop;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

/**
 *
 * @author guilherme-matte
 */
public class PosicaoTela {

    public void abrirTelaCentro(JInternalFrame tela, JDesktopPane jdp) {
        int lDesk = jdp.getWidth();
        int aDesk = jdp.getHeight();
        int lIframe = tela.getWidth();
        int aIframe = tela.getHeight();
        tela.setLocation(lDesk / 2 - lIframe / 2, aDesk / 2 - aIframe / 2);
        jdp.add(tela);
        tela.setVisible(true);
    }
}
