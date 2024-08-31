/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arraysnotas;

import java.text.DecimalFormat;
import java.util.Random;

/**
 *
 * @author guilherme-matte
 */
public class ArraysNotas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random numRandom = new Random();
        DecimalFormat df = new DecimalFormat(",00");
        String[][] matrizPrincipal = new String[numRandom.nextInt(1, 10)][5];
        System.out.println("Numero de linhas: " + matrizPrincipal.length);
        for (int i = 0; i < matrizPrincipal.length; i++) {

            matrizPrincipal[i][0] = "Aluno " + (i + 1) + ": ";
            System.out.println(i);
            for (int j = 1; j < matrizPrincipal[i].length; j++) {
                switch (numRandom.nextInt(1, 4)) {
                    case 1:
                        matrizPrincipal[i][j] = "Matemática";
                        break;
                    case 2:
                        matrizPrincipal[i][j] = "Português";
                        break;
                    case 3:
                        matrizPrincipal[i][j] = "História";
                        break;
                    default:
                        throw new AssertionError();
                }

            }
            for (int j = 2; j < matrizPrincipal[i].length; j++) {
                matrizPrincipal[i][j] = df.format(numRandom.nextDouble(0, 10));
            }

        }
        float soma = 0;
        float media = 0;
        for (int i = 0; i < matrizPrincipal.length; i++) {
            soma = 0;
            media = 0;
            for (int j = 2; j < matrizPrincipal[i].length; j++) {

                soma += Float.parseFloat(matrizPrincipal[i][j]);
                media = (soma / 3);

            }
            String valorFormatado = String.format("%.2f", media);
            System.out.println("Média das notas do aluno " + (i + 1) + ": " + valorFormatado);
        }

        System.out.println("\nMatriz completa:");
        for (int i = 0; i < matrizPrincipal.length; i++) {
            for (int j = 0; j < matrizPrincipal[i].length; j++) {
                System.out.print(matrizPrincipal[i][j] + "|");
            }
            System.out.println();
        }

    }

}
