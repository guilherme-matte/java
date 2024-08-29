/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrays;

import javax.swing.JOptionPane;

/**
 *
 * @author guilherme-matte
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] matriz = new int[5];
        for (int i = 0; i < 5; i++) {

            int num = Integer.parseInt(JOptionPane.showInputDialog("Digite o " + (i + 1) + "º número: "));
            matriz[i] = num;

        }
        float sub = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Valor armazenado na " + (i + 1) + "º indice: " + matriz[i]);

            sub += matriz[i];

        }
        System.out.println("Media dos números é: " + (sub / 5));
    }

}
