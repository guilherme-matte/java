import java.util.Random;

public class teste {
    public static void main(String[] args) {
        String[][] matrizPrincipal = new String[5][4]; // Exemplo com 5 alunos e 4 colunas
        Random numRandom = new Random();

        for (int i = 0; i < matrizPrincipal.length; i++) {
            matrizPrincipal[i][0] = "Aluno " + (i + 1); // Nome do aluno na primeira coluna
            
            for (int j = 1; j < matrizPrincipal[i].length; j++) { // Colunas 1 a 3 para números aleatórios
                matrizPrincipal[i][j] = String.valueOf(numRandom.nextInt(10));
                System.out.println("Valor coluna " + (j + 1) + ": " + matrizPrincipal[i][j]);
            }
        }

        // Exemplo de exibição da matriz completa
        System.out.println("\nMatriz completa:");
        for (int i = 0; i < matrizPrincipal.length; i++) {
            for (int j = 0; j < matrizPrincipal[i].length; j++) {
                System.out.print(matrizPrincipal[i][j] + " ");
            }
            System.out.println();
        }
    }
}
