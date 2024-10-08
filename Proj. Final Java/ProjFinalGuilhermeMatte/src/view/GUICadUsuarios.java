/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.LoginDAO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import model.LoginVO;

/**
 *
 * @author Admin
 */
public class GUICadUsuarios extends javax.swing.JInternalFrame implements InternalFrameListener {

    /**
     * Creates new form GUICadUsuarios
     */
    public GUICadUsuarios() {
        initComponents();
        jtbConsulta.setModel(dtmUsuarios);
        preencherTabela();
    }
    DefaultTableModel dtmUsuarios = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"ID do Usuário", "CPF", "Login", "Nome Completo", "Email", "Perfil"}
    );

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbUsuarios = new javax.swing.JTabbedPane();
        jpnCadastro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfLogin = new javax.swing.JTextField();
        jftfCPF = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jtfSobrenome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jpfSenha = new javax.swing.JPasswordField();
        jcbNivelDeAcesso = new javax.swing.JComboBox<>();
        jbtCriar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jpnConsulta = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfPesquisa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbConsulta = new javax.swing.JTable();
        jcbPesquisa = new javax.swing.JComboBox<>();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Nível de Acesso");

        jLabel4.setText("Senha");

        jLabel7.setText("Login");

        jtfLogin.setEditable(false);

        try {
            jftfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jftfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jftfCPFActionPerformed(evt);
            }
        });

        jLabel2.setText("CPF");

        jLabel1.setText("Nome");

        jtfNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfNomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfNomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfNomeKeyTyped(evt);
            }
        });

        jtfSobrenome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfSobrenomeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfSobrenomeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfSobrenomeKeyTyped(evt);
            }
        });

        jLabel6.setText("Sobrenome");

        jcbNivelDeAcesso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuário", "Administrador" }));

        jbtCriar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jbtCriar.setForeground(new java.awt.Color(0, 0, 0));
        jbtCriar.setText("Criar Usuário");
        jbtCriar.setBorder(null);
        jbtCriar.setContentAreaFilled(false);
        jbtCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jbtCriar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbtCriarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbtCriarMouseExited(evt);
            }
        });
        jbtCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCriarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cadastro de Usuários");

        jLabel11.setText("Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel7))
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jftfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11))
                                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jcbNivelDeAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jbtCriar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(jtfSobrenome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jftfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jpfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbNivelDeAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(34, 34, 34)
                .addComponent(jbtCriar)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpnCadastroLayout = new javax.swing.GroupLayout(jpnCadastro);
        jpnCadastro.setLayout(jpnCadastroLayout);
        jpnCadastroLayout.setHorizontalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jpnCadastroLayout.setVerticalGroup(
            jpnCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnCadastroLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jtbUsuarios.addTab("Cadastrar", jpnCadastro);

        jLabel5.setText("Pesquisar Usuário");

        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyReleased(evt);
            }
        });

        jtbConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbConsultaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbConsulta);

        jcbPesquisa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID do Usuário", "CPF", "Login", "Nome Completo", "Perfil", "E-mail" }));

        javax.swing.GroupLayout jpnConsultaLayout = new javax.swing.GroupLayout(jpnConsulta);
        jpnConsulta.setLayout(jpnConsultaLayout);
        jpnConsultaLayout.setHorizontalGroup(
            jpnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jpnConsultaLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(241, Short.MAX_VALUE))
        );
        jpnConsultaLayout.setVerticalGroup(
            jpnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnConsultaLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jpnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpnConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jtfPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jtbUsuarios.addTab("Consultar", jpnConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbUsuarios)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jtbUsuarios)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void atualizarLoginTextField() {
        jtfLogin.setText(jtfNome.getText().toLowerCase() + "-" + jtfSobrenome.getText().toLowerCase());
    }

    public void preencherTabela() {

        try {
            LoginDAO lDAO = new LoginDAO();
            ArrayList<LoginVO> users = new ArrayList<>();

            users = lDAO.preencherTabela();

            for (int i = 0; i < users.size(); i++) {
                dtmUsuarios.addRow(new String[]{
                    String.valueOf(users.get(i).getIdLogin()),
                    String.valueOf(users.get(i).getCpf()),
                    String.valueOf(users.get(i).getLogin()),
                    String.valueOf(users.get(i).getNomeCompleto()),
                    String.valueOf(users.get(i).getEmail()),
                    String.valueOf(users.get(i).getPerfil())
                }
                );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela Usuários! " + e.getMessage());
        }

    }

    public void limparTela() {

        dtmUsuarios.setNumRows(0);

    }

    public void filtrarUsuario() {
        try {
            if (jtfPesquisa.getText().isEmpty()) {
                limparTela();
                preencherTabela();
            } else {
                String opcao = null, pesquisa = null;

                switch (jcbPesquisa.getSelectedItem().toString()) {

                    case "ID do Usuário":
                        opcao = "login_id";
                        break;
                    case "CPF":
                        opcao = "cpf";
                        break;
                    case "Login":
                        opcao = "usuario";
                        break;
                    case "Nome Completo":
                        opcao = "nome_completo";
                        break;
                    case "Perfil":
                        opcao = "perfil";
                        break;
                    case "E-mail":
                        opcao = "email";
                        break;

                }
                pesquisa = jtfPesquisa.getText();

                LoginDAO lDAO = new LoginDAO();

                ArrayList<LoginVO> users = new ArrayList<>();

                users = lDAO.filtrarUsuarios(opcao, pesquisa);

                for (int i = 0; i < users.size(); i++) {
                    dtmUsuarios.addRow(new String[]{
                        String.valueOf(users.get(i).getIdLogin()),
                        String.valueOf(users.get(i).getCpf()),
                        String.valueOf(users.get(i).getLogin()),
                        String.valueOf(users.get(i).getSenha()),
                        String.valueOf(users.get(i).getNomeCompleto()),
                        String.valueOf(users.get(i).getPerfil())
                    }
                    );
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao filtrar usuário! - " + e.getMessage());
        }
    }

    public void criarUsuario() {
        try {
            LoginVO lVO = new LoginVO();

            lVO.setNomeCompleto(jtfNome.getText() + " " + jtfSobrenome.getText());

            lVO.setLogin(jtfLogin.getText());

            lVO.setCpf(jftfCPF.getText());

            lVO.setSenha(jpfSenha.getText());

            lVO.setPerfil(jcbNivelDeAcesso.getSelectedItem().toString());

            lVO.setEmail(jtfEmail.getText());

            LoginDAO lDAO = new LoginDAO();

            lDAO.criarUsuario(lVO);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao criar usuário");
        }
    }
    private void jftfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jftfCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jftfCPFActionPerformed

    private void jtfNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyTyped
    }//GEN-LAST:event_jtfNomeKeyTyped

    private void jtfSobrenomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSobrenomeKeyTyped
    }//GEN-LAST:event_jtfSobrenomeKeyTyped

    private void jtfSobrenomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSobrenomeKeyPressed
        atualizarLoginTextField();

    }//GEN-LAST:event_jtfSobrenomeKeyPressed

    private void jtfNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyPressed
        atualizarLoginTextField();
    }//GEN-LAST:event_jtfNomeKeyPressed

    private void jtfNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfNomeKeyReleased
        atualizarLoginTextField();
    }//GEN-LAST:event_jtfNomeKeyReleased

    private void jtfSobrenomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfSobrenomeKeyReleased
        atualizarLoginTextField();
    }//GEN-LAST:event_jtfSobrenomeKeyReleased

    private void jbtCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCriarActionPerformed
        if (jtfNome.getText().isEmpty() || jtfSobrenome.getText().isEmpty() || jftfCPF.getText() == "   .   .   -  " || jpfSenha.getText().isEmpty()) {

        } else {
            UIManager.put("OptionPane.yesButtonText", "Confirmar");

            UIManager.put("OptionPane.noButtonText", "Cancelar");

            int resposta = JOptionPane.showConfirmDialog(null, "Deseja criar o usuário?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {

                criarUsuario();

                limparTela();

                preencherTabela();

            } else {

                JOptionPane.showMessageDialog(null, "Operação Cancelada");

            }
        }
    }//GEN-LAST:event_jbtCriarActionPerformed

    private void jbtCriarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCriarMouseEntered
        jbtCriar.setForeground(Color.CYAN);
    }//GEN-LAST:event_jbtCriarMouseEntered

    private void jbtCriarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtCriarMouseExited
        jbtCriar.setForeground(Color.BLACK);
    }//GEN-LAST:event_jbtCriarMouseExited

    private void jtfPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyReleased
        limparTela();
        filtrarUsuario();
    }//GEN-LAST:event_jtfPesquisaKeyReleased

    private void jtbConsultaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbConsultaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jtbConsultaMouseClicked

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCriar;
    private javax.swing.JComboBox<String> jcbNivelDeAcesso;
    private javax.swing.JComboBox<String> jcbPesquisa;
    private javax.swing.JFormattedTextField jftfCPF;
    private javax.swing.JPasswordField jpfSenha;
    private javax.swing.JPanel jpnCadastro;
    private javax.swing.JPanel jpnConsulta;
    private javax.swing.JTable jtbConsulta;
    private javax.swing.JTabbedPane jtbUsuarios;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfLogin;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtfSobrenome;
    // End of variables declaration//GEN-END:variables
}
