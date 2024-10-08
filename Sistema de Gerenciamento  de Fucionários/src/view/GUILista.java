/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.ListarFuncionariosDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;
import model.FuncionarioVO;
import util.PosicaoTela;
import static view.GUIPrincipal.jdpAreadeTrabalho;

/**
 *
 * @author guilherme-matte
 */
public class GUILista extends javax.swing.JInternalFrame implements InternalFrameListener {

    DefaultTableModel dtmFuncionarios = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"ID", "Funcionário", "Cargo", "Salário"}
    );

    public GUILista() {
        initComponents();
        jtbFuncionarios.setModel(dtmFuncionarios);
        preencherTabela();
    }

    public void preencherTabela() {
        try {
            ListarFuncionariosDAO lDAO = new ListarFuncionariosDAO();

            ArrayList<FuncionarioVO> funcionarios = new ArrayList<>();
            funcionarios = lDAO.preencherLista();

            for (int i = 0; i < funcionarios.size(); i++) {
                dtmFuncionarios.addRow(new String[]{
                    String.valueOf(funcionarios.get(i).getIdFuncionario()),
                    String.valueOf(funcionarios.get(i).getNome()),
                    String.valueOf(funcionarios.get(i).getCargo()),
                    String.valueOf(funcionarios.get(i).getSalario())
                });

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO PREENCHER TABELA FUNCIONARIOS - " + e.getMessage());
        }
    }

    public void filtrarTabela() {
        try {

            if (jtfIDFuncionario.getText().isEmpty() && jtfNomeFuncionario.getText().isEmpty() && jcbCargo.getSelectedIndex() == 3) {
                preencherTabela();
            } else {
                ListarFuncionariosDAO lDAO = new ListarFuncionariosDAO();

                ArrayList<FuncionarioVO> funcionarios = new ArrayList<>();

                int id = 0, cargo = jcbCargo.getSelectedIndex();
                if (jtfIDFuncionario.getText().isEmpty()) {
                    id = 0;
                } else {
                    id = Integer.parseInt(jtfIDFuncionario.getText());
                }
                String nome = jtfNomeFuncionario.getText();

                funcionarios = lDAO.pesquisarFuncionario(id, nome, cargo);
                for (int i = 0; i < funcionarios.size(); i++) {
                    dtmFuncionarios.addRow(new String[]{
                        String.valueOf(funcionarios.get(i).getIdFuncionario()),
                        String.valueOf(funcionarios.get(i).getNome()),
                        String.valueOf(funcionarios.get(i).getCargo()),
                        String.valueOf(funcionarios.get(i).getSalario())

                    });
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO FILTRAR TABELA FUNCIONARIO - " + e.getMessage());
        }
    }

    public void limparLista() {
        dtmFuncionarios.setNumRows(0);
    }

    public void calcularSalarioTodos() {
        double total = 0;
        for (int i = 0; i < jtbFuncionarios.getRowCount(); i++) {

            total += Double.parseDouble((String) jtbFuncionarios.getValueAt(i, 3));
        }
        System.out.println(jtbFuncionarios.getRowCount());
        System.out.println(total);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbFuncionarios = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfNomeFuncionario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfIDFuncionario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jcbCargo = new javax.swing.JComboBox<>();
        jbtPesquisar = new javax.swing.JButton();
        jbtAlterar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jtbFuncionarios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Cargo", "Salário"
            }
        ));
        jtbFuncionarios.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(jtbFuncionarios);

        jLabel1.setText("Nome do Funcionário");

        jLabel2.setText("ID do Funcionário");

        jLabel3.setText("Cargo do Funcionário");

        jcbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionário", "Estagiário", "Gerente", "" }));
        jcbCargo.setSelectedIndex(3);

        jbtPesquisar.setText("Pesquisar");
        jbtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisarActionPerformed(evt);
            }
        });

        jbtAlterar.setText("Alterar");
        jbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNomeFuncionario)
                            .addComponent(jtfIDFuncionario)
                            .addComponent(jcbCargo, 0, 342, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfIDFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisarActionPerformed
        limparLista();
        filtrarTabela();
    }//GEN-LAST:event_jbtPesquisarActionPerformed
    public void abrirGUIAlterarFuncionario() {
        GUIAlterarFuncionario gfa = new GUIAlterarFuncionario();

        jdpAreadeTrabalho.add(gfa);
        gfa.setVisible(true);
        gfa.addInternalFrameListener(this);
    }
    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed
        int linha = jtbFuncionarios.getSelectedRow();

        if (linha < 0) {
            JOptionPane.showMessageDialog(null, "Favor Selecione um funcionário.");
        } else {

            String id = jtbFuncionarios.getValueAt(linha, 0).toString();
            PosicaoTela form = new PosicaoTela();
            GUIAlterarFuncionario gaf = new GUIAlterarFuncionario();

            form.abrirTelaCentro(gaf, jdpAreadeTrabalho);

            gaf.preencherCamposGAF(id);
        }
    }//GEN-LAST:event_jbtAlterarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAlterar;
    private javax.swing.JButton jbtPesquisar;
    private javax.swing.JComboBox<String> jcbCargo;
    private javax.swing.JTable jtbFuncionarios;
    private javax.swing.JTextField jtfIDFuncionario;
    private javax.swing.JTextField jtfNomeFuncionario;
    // End of variables declaration//GEN-END:variables

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
}
