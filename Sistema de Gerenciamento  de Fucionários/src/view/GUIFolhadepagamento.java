/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import dao.FolhaDAO;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import model.FuncionarioVO;

/**
 *
 * @author guilherme-matte
 */
public class GUIFolhadepagamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form GUIFolhadepagamento
     */
    public GUIFolhadepagamento() {
        initComponents();
    }

    public String FormatarCampoValor(double valor) {
        String valorFormatado = String.format("%.2f", valor);
        String CampoFormatado = "R$: " + valorFormatado.replace('.', ',');
        return CampoFormatado;
    }

    public String FormatarCampoAliquota(double al) {
        String CampoFormatado = (String.format("%.1f", (al * 100)) + "%");
        return CampoFormatado;
    }

    public void preencherCampos() {

        try {
            FolhaDAO fDAO = new FolhaDAO();
            FuncionarioVO fVO = new FuncionarioVO();

            fVO = fDAO.pesquisarMatricula(Integer.parseInt(jtfPesquisa.getText()));

            if (fVO.getIdFuncionario() == 0) {
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado");
            } else {
                jtfmatricula.setText(String.valueOf(fVO.getIdFuncionario()));
                jtfNome.setText(fVO.getNome());

                jtfCargo.setText(fVO.getCargo());

                jtfSalario.setText(FormatarCampoValor(fVO.getSalario()));

                Float salario = fVO.getSalario();

                Float valeTransporte = 0f;

                Float valeAlimentacao = 0f;

                Float planoSaude = 0f;
                if (fVO.getVt() == 0) {

                    jtfVT.setText("Não tem");
                } else {
                    jtfVT.setText(FormatarCampoValor(fVO.getVt()));
                    valeTransporte = fVO.getVt();
                }

                if (fVO.getVr() == 0) {
                    jtfVA.setText("Não tem");

                } else {
                    jtfVA.setText(FormatarCampoValor(fVO.getVr()));
                    valeAlimentacao = fVO.getVr();

                }

                if (fVO.getPlano() == 0) {

                    jtfPlano.setText("Não tem");
                } else {
                    jtfPlano.setText(FormatarCampoValor(fVO.getPlano()));
                    planoSaude = fVO.getPlano();
                }
                calcularFolha(salario, valeAlimentacao, valeTransporte, planoSaude);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERRO AO COLETAR MATRICULA - " + e.getMessage());
        }
    }

    public double calcularINSS(double salario) {
        double alINSS = 0;
        double parcela = 0;
        double descontoINSS = 0f;
        if (salario <= 1412) {
            alINSS = 0.075;

            descontoINSS = (alINSS * salario);
        } else if (salario > 1412 && salario <= 2666.68) {
            alINSS = 0.09;
            parcela = 21.18;
            descontoINSS = (salario * alINSS) - parcela;
        } else if (salario > 2666.68 && salario <= 4000.03) {
            alINSS = 0.12;
            parcela = 101.18;
            descontoINSS = (salario * alINSS) - parcela;
        } else if (salario > 4000.03 && salario <= 7786.02) {
            alINSS = 0.14;
            parcela = 181.18;
            descontoINSS = (salario * alINSS) - parcela;

        } else if (salario > 7786.02) {
            alINSS = 0.14;
            descontoINSS = 908.86;
        }
        jtfDescINSS.setText(FormatarCampoValor(descontoINSS));

        jtfAlINSS.setText(FormatarCampoAliquota(alINSS));
        return descontoINSS;
    }

    public double calcularVR(double vr) {
        double descontoVR = vr * 0.20;

        jtfDescVA.setText(FormatarCampoValor(descontoVR));
        return descontoVR;
    }

    public double calcularVT(double salario, double vt) {
        double descontoVT = 0;

        if (vt <= 0) {
            jtfDescVT.setText(FormatarCampoValor(0));
        } else {
            descontoVT = salario * 0.06;
            jtfDescVT.setText(FormatarCampoValor(descontoVT));

        }
        return descontoVT;

    }

    public double calcularFGTS(double salario) {
        double descontoFGTS = 0;

        if ("Estagiário".equals(jtfCargo.getText())) {
            descontoFGTS = salario * 0.06;
        } else {
            descontoFGTS = salario * 0.08;
        }
        jtfDescFGTS.setText(FormatarCampoValor(descontoFGTS));
        return descontoFGTS;
    }

    public double calcularIRPF(double salario, double inss, double plano) {

        double descontoIRPF = 0d, alIRPF = 0d, parcela = 0d;
        double sb = salario - inss - plano;
        System.out.println((salario - inss));

        if (sb > 2259.20 && sb <= 2826.26) {
            parcela = 169.44;
            alIRPF = 0.075;
            descontoIRPF = (sb * alIRPF) - parcela;
        } else if (sb > 2826.26 && sb <= 3751.05) {
            parcela = 381.44;
            alIRPF = 0.15;
            descontoIRPF = (sb * alIRPF) - parcela;

        } else if (sb > 3751.06 && sb <= 4664.68) {
            parcela = 662.77;
            alIRPF = 0.225;
            descontoIRPF = (sb * alIRPF) - parcela;

        } else if (sb > 4664.68) {
            parcela = 896;
            alIRPF = 0.275;
            descontoIRPF = (sb * alIRPF) - parcela;
        }
        if (sb <= 2259.20) {
            jtfDescIRPF.setText("#ISENTO#");
            jtfAlIRPF.setText("#ISENTO#");

        } else {
            jtfDescIRPF.setText(FormatarCampoValor(descontoIRPF));
            jtfAlIRPF.setText(FormatarCampoAliquota(alIRPF));
        }
        return descontoIRPF;
    }

    public void calcularFolha(double salario, double vr, double vt, double plano) {

        double descontoINSS = calcularINSS(salario);

        double descontoVR = calcularVR(vr);

        double descontoVT = calcularVT(salario, vt);

        double descontoFGTS = calcularFGTS(salario);

        double descontoIRPF = calcularIRPF(salario, descontoINSS, plano);

        double descontoTotal = 0;

        if (salario - descontoINSS <= 2259.20) {

            descontoTotal = descontoINSS + descontoVR + descontoVT + descontoFGTS;

        } else {

            descontoTotal = descontoIRPF + descontoVR + descontoVT + descontoFGTS;

        }

        jtfDescTotal.setText(FormatarCampoValor(descontoTotal));

        jtfSalarioLiq.setText(FormatarCampoValor(salario - descontoTotal));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbtPesquisar = new javax.swing.JButton();
        jtfPesquisa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfmatricula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jtfCargo = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jtfSalario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfVT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jtfVA = new javax.swing.JTextField();
        Plano = new javax.swing.JLabel();
        jtfPlano = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtfDescINSS = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfAlINSS = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtfDescIRPF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfAlIRPF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfDescVA = new javax.swing.JTextField();
        jtfDescVT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtfDescTotal = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jtfSalarioLiq = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtfDescFGTS = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Matrícula");

        jbtPesquisar.setText("Pesquisar");
        jbtPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtPesquisarActionPerformed(evt);
            }
        });
        jbtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jbtPesquisarKeyPressed(evt);
            }
        });

        jtfPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisaActionPerformed(evt);
            }
        });
        jtfPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfPesquisaKeyPressed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nome do Funcionário");

        jtfNome.setEditable(false);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Matrícula");

        jtfmatricula.setEditable(false);
        jtfmatricula.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CARGO");

        jtfCargo.setEditable(false);
        jtfCargo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Salário");

        jtfSalario.setEditable(false);
        jtfSalario.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("VT");

        jtfVT.setEditable(false);
        jtfVT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("VA");

        jtfVA.setEditable(false);
        jtfVA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        Plano.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Plano.setText("Plano");

        jtfPlano.setEditable(false);
        jtfPlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DESCONTO INSS");

        jtfDescINSS.setEditable(false);
        jtfDescINSS.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("ALÍQUOTA INSS");

        jtfAlINSS.setEditable(false);
        jtfAlINSS.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("DESCONTO IR");

        jtfDescIRPF.setEditable(false);
        jtfDescIRPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("ALÍQUOTA IR");

        jtfAlIRPF.setEditable(false);
        jtfAlIRPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("DESCONTO VA");

        jtfDescVA.setEditable(false);
        jtfDescVA.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfDescVT.setEditable(false);
        jtfDescVT.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("DESCONTO VT");

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel14.setText("DESCONTOS");

        jtfDescTotal.setEditable(false);
        jtfDescTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel15.setText("SALARIO LIQUIDO");

        jtfSalarioLiq.setEditable(false);
        jtfSalarioLiq.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("FGTS");

        jtfDescFGTS.setEditable(false);
        jtfDescFGTS.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfAlINSS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfVT, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfVA, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Plano, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfPlano, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jtfDescIRPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jtfDescINSS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jtfDescVA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfDescVT, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jtfAlIRPF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfDescFGTS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDescTotal)
                            .addComponent(jtfSalarioLiq))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfSalario, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addComponent(jtfDescINSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jtfAlINSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jtfDescIRPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jtfAlIRPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtfDescVA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jtfDescVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jtfDescFGTS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfVT)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfVA)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Plano, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(jtfPlano))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfDescTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jtfSalarioLiq, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                            .addComponent(jtfNome)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtfmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jtfCargo)))
                .addGap(18, 18, 18)
                .addComponent(jbtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfPesquisa)
                    .addComponent(jbtPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfmatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesquisaActionPerformed

    private void jbtPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtPesquisarActionPerformed
        if ("".equals(jtfPesquisa.getText())) {
            JOptionPane.showMessageDialog(null, "Preencha o campo Matrícula");
        } else if (jtfmatricula.getText().equals(jtfPesquisa.getText())) {
            JOptionPane.showMessageDialog(null, "DIGITE UMA MATRICULA DIFERENTE");
        } else {

            preencherCampos();

        }


    }//GEN-LAST:event_jbtPesquisarActionPerformed

    private void jtfPesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfPesquisaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(jtfPesquisa.getText())) {
                JOptionPane.showMessageDialog(null, "Preencha o campo Matrícula");
            } else if (jtfmatricula.getText().equals(jtfPesquisa.getText())) {
                JOptionPane.showMessageDialog(null, "DIGITE UMA MATRICULA DIFERENTE");
            } else {

                preencherCampos();

            }
        }
    }//GEN-LAST:event_jtfPesquisaKeyPressed

    private void jbtPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jbtPesquisarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if ("".equals(jtfPesquisa.getText())) {
                JOptionPane.showMessageDialog(null, "Preencha o campo Matrícula");
            } else if (jtfmatricula.getText().equals(jtfPesquisa.getText())) {
                JOptionPane.showMessageDialog(null, "DIGITE UMA MATRICULA DIFERENTE");
            } else {

                preencherCampos();

            }

        }
    }//GEN-LAST:event_jbtPesquisarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Plano;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtPesquisar;
    private javax.swing.JTextField jtfAlINSS;
    private javax.swing.JTextField jtfAlIRPF;
    private javax.swing.JTextField jtfCargo;
    private javax.swing.JTextField jtfDescFGTS;
    private javax.swing.JTextField jtfDescINSS;
    private javax.swing.JTextField jtfDescIRPF;
    private javax.swing.JTextField jtfDescTotal;
    private javax.swing.JTextField jtfDescVA;
    private javax.swing.JTextField jtfDescVT;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfPesquisa;
    private javax.swing.JTextField jtfPlano;
    private javax.swing.JTextField jtfSalario;
    private javax.swing.JTextField jtfSalarioLiq;
    private javax.swing.JTextField jtfVA;
    private javax.swing.JTextField jtfVT;
    private javax.swing.JTextField jtfmatricula;
    // End of variables declaration//GEN-END:variables
}
