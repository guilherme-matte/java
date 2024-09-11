import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class CampoMoedaExemplo {
    public static void main(String[] args) {
        // Cria o frame
        JFrame frame = new JFrame("Campo Monetário - Esquerda para Direita");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());

        // Cria o campo de texto
        JTextField campoMoeda = new JTextField(10);
        
        // Formato para exibir os números com duas casas decimais
        DecimalFormat formatoMoeda = new DecimalFormat("#,##0.00");
        
        // Adiciona o KeyListener para tratar as teclas digitadas
        campoMoeda.addKeyListener(new KeyAdapter() {
            private StringBuilder valor = new StringBuilder("0000");

            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                
                // Verifica se a tecla digitada é um número
                if (Character.isDigit(c)) {
                    // Adiciona o dígito no final e remove o primeiro dígito
                    valor.append(c);
                    valor.deleteCharAt(0);
                    
                    // Atualiza o texto do campo formatando como moeda
                    atualizaCampo();
                } else if (c == KeyEvent.VK_BACK_SPACE && valor.length() > 3) {
                    // Se o backspace for pressionado, remove o último dígito
                    valor.insert(0, '0');
                    valor.deleteCharAt(valor.length() - 1);
                    
                    atualizaCampo();
                }

                e.consume(); // Impede o comportamento padrão da tecla
            }

            private void atualizaCampo() {
                // Converte para um número e formata com duas casas decimais
                double valorNumerico = Double.parseDouble(valor.toString()) / 100;
                campoMoeda.setText(formatoMoeda.format(valorNumerico));
            }
        });
        
        // Adiciona o campo ao frame
        frame.add(new JLabel("Valor em R$:"));
        frame.add(campoMoeda);

        // Exibe o frame
        frame.setVisible(true);
    }
}
