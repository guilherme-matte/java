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
        Random numRandom = new Random();
        int[] matriz1 = new int[5];
        for (int i = 0; i < 5; i++) {

            int num = numRandom.nextInt(50);
            matriz1[i] = num;

        }

        float sub = 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Valor armazenado no " + (i + 1) + "º indice: " + matriz1[i]);

            sub += matriz1[i];

        }
        System.out.println("---------------------");
        int sub1 = 0;
        for (int i = 4; i > -1; i--) {

            sub1++;

            System.out.println("Valor invertido armazenado no " + sub1 + "º indice: " + matriz1[i]);

        }

        int maiorNum = matriz1[0];

        int menorNum = matriz1[0];

        for (int i = 1; i < 5; i++) {
            if (matriz1[i] > maiorNum) {
                maiorNum = matriz1[i];
            }
            if (matriz1[i] < menorNum) {
                menorNum = matriz1[i];
            }

        }

        System.out.println("O maior número é: " + maiorNum);

        System.out.println("O menor número é: " + menorNum);
        System.out.println("Media dos números é: " + (sub / 5));

    }

}
