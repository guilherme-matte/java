/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arrays;

import java.util.Random;

/**
 *
 * @author guilherme-matte
 */
public class Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] matriz1 = new int[5];
        int[] matriz2 = new int[5];
        for (int i = 0; i < 5; i++) {
            Random numRandom = new Random();
            int num = numRandom.nextInt(50);
            matriz1[i] = num;

        }

        float sub = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Valor armazenado na " + (i + 1) + "º indice: " + matriz1[i]);

            sub += matriz1[i];

        }
        System.out.println("Media dos números é: " + (sub / 5));
        //-------------------------------
        sub = matriz1[1];

        float maiorNum = 0;

        float menorNum = 0;

        for (int i = 1; i < 5; i++) {

            if (sub <= matriz1[i]) {
                sub = matriz1[i];
                maiorNum = sub;
            }

        }
        for (int i = 1; i < 5; i++) {
            if (sub >= matriz1[i]) {
                sub = matriz1[i];
                menorNum = sub;
            }
        }
        System.out.println("O maior número é: " + maiorNum);

        System.out.println("O menor número é: " + menorNum);
        matriz2 = matriz1;
        int sub1 = 0;
        for (int i = 4; i > -1; i--) {

            matriz1[sub1] = matriz2[i];
            
            sub1++;
            
            System.out.println("Matriz invertida indice " + sub1 + ": " + matriz1);
        }
    }

}
