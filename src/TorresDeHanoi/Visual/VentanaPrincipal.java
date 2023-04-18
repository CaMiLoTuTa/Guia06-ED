/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TorresDeHanoi.Visual;

import TorresDeHanoi.Code.Disco;
import TorresDeHanoi.Code.TorresHanoi;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tutaa
 */

public class VentanaPrincipal extends javax.swing.JFrame {

        /**
         * Creates new form VentanaPrincipal
         */
        public VentanaPrincipal() {
                initComponents();
                setLocationRelativeTo(null);

                limpiarTablasJuego();
                habilitarTodosLosBotones(false);
        }

        public int totalMovimientos, movimientosRealizados, cantidadDiscos;

        public void iniciarPartida() {
                cantidadDiscos = Integer.parseInt((String) cbDiscos.getSelectedItem());
                movimientosRealizados = 0;

                int intentosPosibles = (int) ((Math.pow(2, cantidadDiscos)) - 1);
                totalMovimientos = intentosPosibles;

                txtMovimientosRealizables.setText(String.valueOf(intentosPosibles));

                new TorresHanoi(cantidadDiscos);

                mostrarTablasJuego();
                verificarTorresVacias();
        }

        public void reiniciarPartida(boolean habilitarBotones) {
                movimientosRealizados = 0;
                totalMovimientos = 0;
                txtMovimientosRealizables.setText(String.valueOf(0));
                txtMovimientosUsuario.setText(String.valueOf(0));
                limpiarTablasJuego();
                habilitarTodosLosBotones(habilitarBotones);
        }

        public boolean quedanIntentos() {
                if (totalMovimientos <= movimientosRealizados) {
                        habilitarTodosLosBotones(false);
                        JOptionPane.showMessageDialog(null, "Ya no tiene más intentos.");
                        return false;
                } else {
                        habilitarTodosLosBotones(true);
                        return true;
                }
        }

        public void aumentarMovimientosRealizados() {
                movimientosRealizados++;
                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
        }

        public void verificarVictoria() {
                if (!TorresHanoi.C.isEmpty()) {
                        if (TorresHanoi.C.size() == cantidadDiscos) {
                                JOptionPane.showMessageDialog(rootPane, "HAZ GANADO.");
                        }
                }
        }

        public void habilitarBotonesTorreA(boolean habilitar) {
                btnBTorreA.setEnabled(habilitar);
                btnCTorreA.setEnabled(habilitar);
        }

        public void habilitarBotonesTorreB(boolean habilitar) {
                btnATorreB.setEnabled(habilitar);
                btnCTorreB.setEnabled(habilitar);
        }

        public void habilitarBotonesTorreC(boolean habilitar) {
                btnATorreC.setEnabled(habilitar);
                btnBTorreC.setEnabled(habilitar);
        }

        public void habilitarTodosLosBotones(boolean habilitar) {
                habilitarBotonesTorreA(habilitar);
                habilitarBotonesTorreB(habilitar);
                habilitarBotonesTorreC(habilitar);
        }

        public void verificarTorresVacias() {
                if (TorresHanoi.A.isEmpty()) {
                        habilitarBotonesTorreA(false);

                }
                if (TorresHanoi.B.isEmpty()) {
                        habilitarBotonesTorreB(false);

                }
                if (TorresHanoi.C.isEmpty()) {
                        habilitarBotonesTorreC(false);
                }
        }

        public void mostrarTablasJuego() {
                // ? Centrar tablas
                CenterTableCellRenderer centerRenderer = new CenterTableCellRenderer();

                // ? Background de las tablas
                float[] hsbValues = Color.RGBtoHSB(243, 221, 207, null);
                Color bgColor = Color.getHSBColor(hsbValues[0], hsbValues[1], hsbValues[2]);

                // *TABLA A
                Object[][] dataA = new Object[TorresHanoi.A.size()][1];
                int i = TorresHanoi.A.size() - 1;
                for (Disco s : TorresHanoi.A) {
                        dataA[i][0] = s.getForma();
                        i--;
                }

                DefaultTableModel modelA = new DefaultTableModel(dataA, new String[] { "A" });

                JTable tableA = new JTable(modelA);

                jScrollPane2.setViewportView(tableA);
                tableA.setDefaultRenderer(Object.class, centerRenderer);

                tableA.setBackground(bgColor);

                // *TABLA B
                Object[][] dataB = new Object[TorresHanoi.B.size()][1];
                i = TorresHanoi.B.size() - 1;
                for (Disco s : TorresHanoi.B) {
                        dataB[i][0] = s.getForma();
                        i--;
                }

                DefaultTableModel modelB = new DefaultTableModel(dataB, new String[] { "B" });

                JTable tableB = new JTable(modelB);

                jScrollPane1.setViewportView(tableB);
                tableB.setDefaultRenderer(Object.class, centerRenderer);
                tableB.setBackground(bgColor);

                // *TABLA C
                Object[][] dataC = new Object[TorresHanoi.C.size()][1];
                i = TorresHanoi.C.size() - 1;
                for (Disco s : TorresHanoi.C) {
                        dataC[i][0] = s.getForma();
                        i--;
                }
                DefaultTableModel modelC = new DefaultTableModel(dataC, new String[] { "C" });

                JTable tableC = new JTable(modelC);

                jScrollPane3.setViewportView(tableC);
                tableC.setDefaultRenderer(Object.class, centerRenderer);
                tableC.setBackground(bgColor);
        }

        public void limpiarTablasJuego() {
                TorresHanoi.A.clear();
                TorresHanoi.B.clear();
                TorresHanoi.C.clear();
                jScrollPane1.setViewportView(null);
                jScrollPane2.setViewportView(null);
                jScrollPane3.setViewportView(null);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jLabel1 = new javax.swing.JLabel();
                btnIniciar = new javax.swing.JButton();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                cbDiscos = new javax.swing.JComboBox<>();
                txtMovimientosRealizables = new javax.swing.JLabel();
                txtMovimientosUsuario = new javax.swing.JLabel();
                btnBorrar = new javax.swing.JButton();
                jScrollPane3 = new javax.swing.JScrollPane();
                tbC = new javax.swing.JTable();
                btnCTorreB = new javax.swing.JButton();
                btnATorreB = new javax.swing.JButton();
                btnBTorreC = new javax.swing.JButton();
                jScrollPane1 = new javax.swing.JScrollPane();
                tbB = new javax.swing.JTable();
                btnATorreC = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                tbA = new javax.swing.JTable();
                btnBTorreA = new javax.swing.JButton();
                btnCTorreA = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setBackground(new java.awt.Color(35, 41, 70));

                jPanel1.setBackground(new java.awt.Color(249, 244, 239));
                jPanel1.setForeground(new java.awt.Color(35, 41, 70));

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(2, 8, 38));
                jLabel1.setText("TORRES HANOI");

                btnIniciar.setBackground(new java.awt.Color(140, 120, 81));
                btnIniciar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                btnIniciar.setForeground(new java.awt.Color(255, 255, 254));
                btnIniciar.setText("Iniciar");
                btnIniciar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnIniciarActionPerformed(evt);
                        }
                });

                jLabel2.setBackground(new java.awt.Color(35, 41, 70));
                jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(2, 8, 38));
                jLabel2.setText("Discos:");

                jLabel3.setBackground(new java.awt.Color(35, 41, 70));
                jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(2, 8, 38));
                jLabel3.setText("Movimientos posibles:");

                jLabel5.setBackground(new java.awt.Color(35, 41, 70));
                jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(2, 8, 38));
                jLabel5.setText("Sus totalMovimientos:");

                cbDiscos.setBackground(new java.awt.Color(140, 120, 81));
                cbDiscos.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
                cbDiscos.setForeground(new java.awt.Color(35, 41, 70));
                cbDiscos.setModel(new javax.swing.DefaultComboBoxModel<>(
                                new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

                txtMovimientosRealizables.setBackground(new java.awt.Color(35, 41, 70));
                txtMovimientosRealizables.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                txtMovimientosRealizables.setForeground(new java.awt.Color(2, 8, 38));
                txtMovimientosRealizables.setText("0");

                txtMovimientosUsuario.setBackground(new java.awt.Color(35, 41, 70));
                txtMovimientosUsuario.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
                txtMovimientosUsuario.setForeground(new java.awt.Color(2, 8, 38));
                txtMovimientosUsuario.setText("0");

                btnBorrar.setBackground(new java.awt.Color(140, 120, 81));
                btnBorrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                btnBorrar.setForeground(new java.awt.Color(255, 255, 254));
                btnBorrar.setText("Borrar");
                btnBorrar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBorrarActionPerformed(evt);
                        }
                });

                tbC.setForeground(new java.awt.Color(35, 41, 70));
                tbC.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null }
                                },
                                new String[] {
                                                "C"
                                }));
                jScrollPane3.setViewportView(tbC);

                btnCTorreB.setBackground(new java.awt.Color(140, 120, 81));
                btnCTorreB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnCTorreB.setForeground(new java.awt.Color(255, 255, 254));
                btnCTorreB.setText("C");
                btnCTorreB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCTorreBActionPerformed(evt);
                        }
                });

                btnATorreB.setBackground(new java.awt.Color(140, 120, 81));
                btnATorreB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnATorreB.setForeground(new java.awt.Color(255, 255, 254));
                btnATorreB.setText("A");
                btnATorreB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnATorreBActionPerformed(evt);
                        }
                });

                btnBTorreC.setBackground(new java.awt.Color(140, 120, 81));
                btnBTorreC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnBTorreC.setForeground(new java.awt.Color(255, 255, 254));
                btnBTorreC.setText("B");
                btnBTorreC.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBTorreCActionPerformed(evt);
                        }
                });

                tbB.setForeground(new java.awt.Color(35, 41, 70));
                tbB.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null }
                                },
                                new String[] {
                                                "B"
                                }));
                tbB.getTableHeader().setReorderingAllowed(false);
                jScrollPane1.setViewportView(tbB);

                btnATorreC.setBackground(new java.awt.Color(140, 120, 81));
                btnATorreC.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnATorreC.setForeground(new java.awt.Color(255, 255, 254));
                btnATorreC.setText("A");
                btnATorreC.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnATorreCActionPerformed(evt);
                        }
                });

                tbA.setForeground(new java.awt.Color(35, 41, 70));
                tbA.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null },
                                                { null }
                                },
                                new String[] {
                                                "A"
                                }));
                tbA.getTableHeader().setReorderingAllowed(false);
                jScrollPane2.setViewportView(tbA);

                btnBTorreA.setBackground(new java.awt.Color(140, 120, 81));
                btnBTorreA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnBTorreA.setForeground(new java.awt.Color(255, 255, 254));
                btnBTorreA.setText("B");
                btnBTorreA.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBTorreAActionPerformed(evt);
                        }
                });

                btnCTorreA.setBackground(new java.awt.Color(140, 120, 81));
                btnCTorreA.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
                btnCTorreA.setForeground(new java.awt.Color(255, 255, 254));
                btnCTorreA.setText("C");
                btnCTorreA.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCTorreAActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(52, Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addComponent(jLabel3)
                                                                                                                .addComponent(jLabel5))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(txtMovimientosRealizables,
                                                                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(txtMovimientosUsuario,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                73,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(cbDiscos,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btnIniciar)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnBorrar)))
                                                                .addGap(45, 45, 45)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btnBTorreA,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                43,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnCTorreA,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                43,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                106,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(53, 53, 53)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                106,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btnATorreB,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                43,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnCTorreB,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                43,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(54, 54, 54)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jScrollPane3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                106,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(btnATorreC,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                43,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnBTorreC,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                43,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(24, 24, 24))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(302, 302, 302)
                                                                .addComponent(jLabel1)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1)
                                                                .addGap(53, 53, 53)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jLabel3)
                                                                                                                .addComponent(txtMovimientosRealizables))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jLabel5)
                                                                                                                .addComponent(txtMovimientosUsuario))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jLabel2)
                                                                                                                .addComponent(cbDiscos,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                200,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                0,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jScrollPane3,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                0,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(btnBTorreA)
                                                                                                                .addComponent(btnCTorreA)
                                                                                                                .addComponent(btnATorreB)
                                                                                                                .addComponent(btnCTorreB)
                                                                                                                .addComponent(btnATorreC)
                                                                                                                .addComponent(btnBTorreC)
                                                                                                                .addComponent(btnBorrar)
                                                                                                                .addComponent(btnIniciar))))
                                                                .addGap(40, 58, Short.MAX_VALUE)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        // & TORRE A
        private void btnBTorreAActionPerformed(java.awt.event.ActionEvent evt) {
                if (quedanIntentos()) {
                        if (!TorresHanoi.B.isEmpty()) {
                                var peekA = TorresHanoi.A.peek();
                                var peekB = TorresHanoi.B.peek();
                                if (peekA.getTamaño() < peekB.getTamaño()) {
                                        Disco sacar = TorresHanoi.A.pop();
                                        TorresHanoi.B.push(sacar);
                                        mostrarTablasJuego();
                                        verificarTorresVacias();
                                        aumentarMovimientosRealizados();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.A.pop();
                                TorresHanoi.B.push(sacar);
                                mostrarTablasJuego();
                                verificarTorresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarVictoria();
        }

        private void btnCTorreAActionPerformed(java.awt.event.ActionEvent evt) {
                if (quedanIntentos()) {
                        if (!TorresHanoi.C.isEmpty()) {

                                var peekA = TorresHanoi.A.peek();
                                var peekC = TorresHanoi.C.peek();
                                if (peekA.getTamaño() < peekC.getTamaño()) {
                                        Disco sacar = TorresHanoi.A.pop();
                                        TorresHanoi.C.push(sacar);
                                        mostrarTablasJuego();
                                        verificarTorresVacias();
                                        aumentarMovimientosRealizados();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.A.pop();
                                TorresHanoi.C.push(sacar);
                                mostrarTablasJuego();
                                verificarTorresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarVictoria();
        }

        // & TORRE B
        private void btnATorreBActionPerformed(java.awt.event.ActionEvent evt) {
                if (quedanIntentos()) {
                        if (!TorresHanoi.A.isEmpty()) {

                                var peekB = TorresHanoi.B.peek();
                                var peekA = TorresHanoi.A.peek();
                                if (peekB.getTamaño() < peekA.getTamaño()) {
                                        Disco sacar = TorresHanoi.B.pop();
                                        TorresHanoi.A.push(sacar);
                                        mostrarTablasJuego();
                                        verificarTorresVacias();
                                        aumentarMovimientosRealizados();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.B.pop();
                                TorresHanoi.A.push(sacar);
                                mostrarTablasJuego();
                                verificarTorresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarVictoria();
        }

        private void btnCTorreBActionPerformed(java.awt.event.ActionEvent evt) {
                if (quedanIntentos()) {
                        if (!TorresHanoi.C.isEmpty()) {

                                var peekB = TorresHanoi.B.peek();
                                var peekC = TorresHanoi.C.peek();
                                if (peekB.getTamaño() < peekC.getTamaño()) {
                                        Disco sacar = TorresHanoi.B.pop();
                                        TorresHanoi.C.push(sacar);
                                        mostrarTablasJuego();
                                        verificarTorresVacias();
                                        aumentarMovimientosRealizados();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.B.pop();
                                TorresHanoi.C.push(sacar);
                                mostrarTablasJuego();
                                verificarTorresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarVictoria();
        }

        // & TORRE C
        private void btnATorreCActionPerformed(java.awt.event.ActionEvent evt) {
                if (quedanIntentos()) {
                        if (!TorresHanoi.A.isEmpty()) {

                                var peekC = TorresHanoi.C.peek();
                                var peekA = TorresHanoi.A.peek();
                                if (peekC.getTamaño() < peekA.getTamaño()) {
                                        Disco sacar = TorresHanoi.C.pop();
                                        TorresHanoi.A.push(sacar);
                                        mostrarTablasJuego();
                                        verificarTorresVacias();
                                        aumentarMovimientosRealizados();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.C.pop();
                                TorresHanoi.A.push(sacar);
                                mostrarTablasJuego();
                                verificarTorresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarVictoria();
        }

        private void btnBTorreCActionPerformed(java.awt.event.ActionEvent evt) {
                if (quedanIntentos()) {
                        if (!TorresHanoi.B.isEmpty()) {

                                var peekC = TorresHanoi.C.peek();
                                var peekB = TorresHanoi.B.peek();
                                if (peekC.getTamaño() < peekB.getTamaño()) {
                                        Disco sacar = TorresHanoi.C.pop();
                                        TorresHanoi.B.push(sacar);
                                        mostrarTablasJuego();
                                        verificarTorresVacias();
                                        aumentarMovimientosRealizados();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.C.pop();
                                TorresHanoi.B.push(sacar);
                                mostrarTablasJuego();
                                verificarTorresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarVictoria();
        }

        // ~ BOTONES EJECUCIÓN
        private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarPartida(true);
                iniciarPartida();
        }

        private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarPartida(false);
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                new VentanaPrincipal().setVisible(true);
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnATorreB;
        private javax.swing.JButton btnATorreC;
        private javax.swing.JButton btnBTorreA;
        private javax.swing.JButton btnBTorreC;
        private javax.swing.JButton btnBorrar;
        private javax.swing.JButton btnCTorreA;
        private javax.swing.JButton btnCTorreB;
        private javax.swing.JButton btnIniciar;
        private javax.swing.JComboBox<String> cbDiscos;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JTable tbA;
        private javax.swing.JTable tbB;
        private javax.swing.JTable tbC;
        private javax.swing.JLabel txtMovimientosRealizables;
        private javax.swing.JLabel txtMovimientosUsuario;
        // End of variables declaration//GEN-END:variables
}
