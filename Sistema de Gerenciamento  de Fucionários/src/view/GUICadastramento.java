/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.CadastrarFuncionariosDAO;
import java.util.Random;
import javax.swing.JOptionPane;
import model.FuncionarioVO;

/**
 *
 * @author guilherme-matte
 */
public class GUICadastramento extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUICadastramento
     */
    public GUICadastramento() {
        initComponents();
        preencherMatricula();

    }

    public void preencherMatricula() {
        try {
            CadastrarFuncionariosDAO cDAO = new CadastrarFuncionariosDAO();
            FuncionarioVO fVO = new FuncionarioVO();
            fVO = cDAO.preencherMatricula();
            jtfMatricula.setText(String.valueOf((fVO.getIdFuncionario() + 1)));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Matricula");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtfMatricula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNomeFuncionario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jcbCargo = new javax.swing.JComboBox<>();
        jcbVA = new javax.swing.JCheckBox();
        jcbPlano = new javax.swing.JCheckBox();
        jcbVT = new javax.swing.JCheckBox();
        jbtCadastrar = new javax.swing.JButton();
        jbtLimpar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfSalario = new javax.swing.JTextField();
        jtfVT = new javax.swing.JTextField();
        jtfPlano = new javax.swing.JTextField();
        jtfVA = new javax.swing.JTextField();
        jbtAutomacao = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setName(""); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastrar Funcionário");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Matrícula");

        jtfMatricula.setEditable(false);
        jtfMatricula.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jtfMatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfMatricula.setEnabled(false);
        jtfMatricula.setRequestFocusEnabled(false);
        jtfMatricula.setVerifyInputWhenFocusTarget(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("NOME DO FUNCIONÁRIO");

        jtfNomeFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("SALÁRIO DO FUNCIONARIO");

        jcbCargo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Estagiário", "Gerente" }));

        jcbVA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbVA.setText("VALE ALIMENTAÇÃO");
        jcbVA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVAActionPerformed(evt);
            }
        });

        jcbPlano.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbPlano.setText("PLANO DE SAÚDE");
        jcbPlano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPlanoActionPerformed(evt);
            }
        });

        jcbVT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbVT.setText("VALE TRANSPORTE");
        jcbVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbVTActionPerformed(evt);
            }
        });

        jbtCadastrar.setText("CADASTRAR");
        jbtCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCadastrarActionPerformed(evt);
            }
        });

        jbtLimpar.setText("LIMPAR");
        jbtLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtLimparActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("CARGO DO FUNCIONÁRIO");

        jtfVT.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jtfVT.setEnabled(false);

        jtfPlano.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jtfPlano.setEnabled(false);

        jtfVA.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jtfVA.setEnabled(false);

        jbtAutomacao.setText("AUTOMAÇÂO");
        jbtAutomacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAutomacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 272, Short.MAX_VALUE)
                        .addComponent(jtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfNomeFuncionario)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbPlano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbVT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfVA, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfPlano, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                            .addComponent(jtfVT))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtAutomacao)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(jtfSalario)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNomeFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfVT, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jcbVT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbVA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfVA, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcbPlano, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtAutomacao))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void automacao(int quantidade) {
        Random rdm = new Random();
        for (int i = 0; i < quantidade; i++) {
            jtfNomeFuncionario.setText("guilherme teste " + jtfMatricula.getText());
            jtfSalario.setText(String.valueOf(rdm.nextDouble(1, 10000)));
            jcbCargo.setSelectedIndex(rdm.nextInt(0, 3));

            int bit = rdm.nextInt(0, 2);
            if (bit == 1) {
                jcbPlano.setSelected(true);
                jtfPlano.setText(String.valueOf(rdm.nextDouble(0, 300)));
            } else {
                jtfPlano.setText("");
                jcbPlano.setSelected(false);
            }
            bit = rdm.nextInt(0, 2);
            if (bit == 1) {
                jcbVA.setSelected(true);
                jtfVA.setText(String.valueOf(rdm.nextDouble(0, 300)));
            } else {
                jtfVA.setText("");
                jcbVA.setSelected(false);
            }
            bit = rdm.nextInt(0, 2);
            if (bit == 1) {
                jcbVT.setSelected(true);
                jtfVT.setText(String.valueOf(rdm.nextDouble(0, 300)));
            } else {
                jtfVT.setText("");
                jcbVT.setSelected(false);
            }
            cadastrarFuncionario();
            limparCampos();
        }
        JOptionPane.showMessageDialog(null, "CONCLUIDO");
    }

    public void cadastrarFuncionario() {

        try {
            FuncionarioVO fVO = new FuncionarioVO();

            fVO.setIdFuncionario(Integer.parseInt(jtfMatricula.getText()));

            fVO.setNome(jtfNomeFuncionario.getText());

            fVO.setSalario(Float.parseFloat(jtfSalario.getText()));

            fVO.setCargo(String.valueOf(jcbCargo.getSelectedItem()));

            if (jcbVT.isSelected()) {
                fVO.setVt(Float.parseFloat(jtfVT.getText()));
            } else {
                fVO.setVt(0);
            }

            if (jcbVA.isSelected()) {
                fVO.setVr(Float.parseFloat(jtfVA.getText()));
            } else {
                fVO.setVr(0);
            }

            if (jcbPlano.isSelected()) {
                fVO.setPlano(Float.parseFloat(jtfPlano.getText()));

            } else {
                fVO.setPlano(0);
            }

            CadastrarFuncionariosDAO cDAO = new CadastrarFuncionariosDAO();

            cDAO.cadastrarFuncionarios(fVO);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR USUÁRIO - " + e.getMessage());
        }
    }


    private void jcbVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVTActionPerformed
        if (jcbVT.isSelected()) {
            jtfVT.setEnabled(true);
        } else {
            jtfVT.setEnabled(false);
        }
        jtfVT.setText(null);
    }//GEN-LAST:event_jcbVTActionPerformed

    private void jcbVAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbVAActionPerformed
        if (jcbVA.isSelected()) {
            jtfVA.setEnabled(true);
        } else {
            jtfVA.setEnabled(false);

        }
        jtfVA.setText(null);
    }//GEN-LAST:event_jcbVAActionPerformed

    private void jcbPlanoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPlanoActionPerformed
        if (jcbPlano.isSelected()) {
            jtfPlano.setEnabled(true);
        } else {
            jtfPlano.setEnabled(false);

        }
    }//GEN-LAST:event_jcbPlanoActionPerformed

    private void jbtCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCadastrarActionPerformed

        if (jcbVT.isSelected() && jtfVT.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor preencha ou desabilite o campo vale transporte");
        } else if (jcbVA.isSelected() && jtfVA.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor preencha ou desabilite o campo vale alimentação");
        } else if (jcbPlano.isSelected() && jtfPlano.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor preencha ou desabilite o campo plano de saúde");
        } else {
            cadastrarFuncionario();
            limparCampos();
        }


    }//GEN-LAST:event_jbtCadastrarActionPerformed
    public void limparCampos() {
        preencherMatricula();
        jtfNomeFuncionario.setText("");
        jtfPlano.setText("");
        jtfPlano.setEnabled(false);
        jtfSalario.setText("");
        jtfVA.setText("");
        jtfVA.setEnabled(false);
        jtfVT.setText("");
        jtfVT.setEnabled(false);
        jcbCargo.setSelectedIndex(0);
        jcbPlano.setSelected(false);
        jcbVA.setSelected(false);
        jcbVT.setSelected(false);

    }
    private void jbtLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_jbtLimparActionPerformed

    private void jbtAutomacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAutomacaoActionPerformed
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog("DIGITE A QUANTIDADE DE FUNCIONÁRIOS A SEREM GERADOS"));

        automacao(quantidade);

    }//GEN-LAST:event_jbtAutomacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtAutomacao;
    private javax.swing.JButton jbtCadastrar;
    private javax.swing.JButton jbtLimpar;
    private javax.swing.JComboBox<String> jcbCargo;
    private javax.swing.JCheckBox jcbPlano;
    private javax.swing.JCheckBox jcbVA;
    private javax.swing.JCheckBox jcbVT;
    private javax.swing.JTextField jtfMatricula;
    private javax.swing.JTextField jtfNomeFuncionario;
    private javax.swing.JTextField jtfPlano;
    private javax.swing.JTextField jtfSalario;
    private javax.swing.JTextField jtfVA;
    private javax.swing.JTextField jtfVT;
    // End of variables declaration//GEN-END:variables
}
