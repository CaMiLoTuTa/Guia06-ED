/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package TorresDeHanoi.Visual;

import TorresDeHanoi.Code.Disco;
import TorresDeHanoi.Code.TorresHanoi;

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

                bloquearTodosBotones(false);
        }

        public int movimientos, movimientosRealizados, nDiscos;

        // elemento sea el más pequeño.
        public void reiniciarJuego(boolean activarBotones) {
                movimientosRealizados = 0;
                movimientos = 0;
                txtMovimientosRealizables.setText(String.valueOf(0));
                txtMovimientosUsuario.setText(String.valueOf(0));
                limpiarTablas();
                bloquearTodosBotones(activarBotones);
        }

        public void cambiarMovimientos() {
                movimientosRealizados++;
                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));

        }

        public void verificarWin() {
                if (!TorresHanoi.C.isEmpty()) {
                        int peekC = TorresHanoi.C.peek().getTamaño();
                        if (TorresHanoi.C.size() == nDiscos && peekC == 1) {
                                JOptionPane.showMessageDialog(rootPane, "HAZ GANADO.");
                        }
                }
        }

        public void bloquearBotonesTorreA(boolean bool) {
                btnBTorreA.setEnabled(bool);
                btnCTorreA.setEnabled(bool);
        }

        public void bloquearBotonesTorreB(boolean bool) {
                btnATorreB.setEnabled(bool);
                btnCTorreB.setEnabled(bool);
        }

        public void bloquearBotonesTorreC(boolean bool) {
                btnATorreC.setEnabled(bool);
                btnBTorreC.setEnabled(bool);
        }

        public void bloquearTodosBotones(boolean bool) {
                bloquearBotonesTorreA(bool);
                bloquearBotonesTorreB(bool);
                bloquearBotonesTorreC(bool);
        }

        public void torresVacias() {
                if (TorresHanoi.A.isEmpty()) {
                        bloquearBotonesTorreA(false);

                }
                if (TorresHanoi.B.isEmpty()) {
                        bloquearBotonesTorreB(false);

                }
                if (TorresHanoi.C.isEmpty()) {
                        bloquearBotonesTorreC(false);
                }
        }

        public boolean tieneIntentos() {
                if (movimientos <= movimientosRealizados) {
                        bloquearTodosBotones(false);
                        JOptionPane.showMessageDialog(null, "Ya no tiene más intentos");
                        return false;
                } else {
                        bloquearTodosBotones(true);

                        return true;
                }
        }

        public void mostrarTablas() {
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
        }

        public void limpiarTablas() {
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
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                cbDiscos = new javax.swing.JComboBox<>();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                txtMovimientosRealizables = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                txtMovimientosUsuario = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                tbB = new javax.swing.JTable();
                jScrollPane2 = new javax.swing.JScrollPane();
                tbA = new javax.swing.JTable();
                jScrollPane3 = new javax.swing.JScrollPane();
                tbC = new javax.swing.JTable();
                btnBTorreA = new javax.swing.JButton();
                btnCTorreA = new javax.swing.JButton();
                btnCTorreB = new javax.swing.JButton();
                btnATorreB = new javax.swing.JButton();
                btnBTorreC = new javax.swing.JButton();
                btnATorreC = new javax.swing.JButton();
                btnReiniciar = new javax.swing.JButton();
                btnIniciar = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
                jLabel1.setText("TORRES HANOI");

                cbDiscos.setModel(
                                new javax.swing.DefaultComboBoxModel<>(
                                                new String[] { "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

                jLabel2.setText("Número de discos:");

                jLabel3.setText("Movimientos realizables:");

                txtMovimientosRealizables.setText("0");

                jLabel5.setText("Sus movimientos:");

                txtMovimientosUsuario.setText("0");

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

                btnBTorreA.setText("B");
                btnBTorreA.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBTorreAActionPerformed(evt);
                        }
                });

                btnCTorreA.setText("C");
                btnCTorreA.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCTorreAActionPerformed(evt);
                        }
                });

                btnCTorreB.setText("C");
                btnCTorreB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnCTorreBActionPerformed(evt);
                        }
                });

                btnATorreB.setText("A");
                btnATorreB.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnATorreBActionPerformed(evt);
                        }
                });

                btnBTorreC.setText("B");
                btnBTorreC.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBTorreCActionPerformed(evt);
                        }
                });

                btnATorreC.setText("A");
                btnATorreC.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnATorreCActionPerformed(evt);
                        }
                });

                btnReiniciar.setText("Reiniciar");
                btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnReiniciarActionPerformed(evt);
                        }
                });

                btnIniciar.setText("Iniciar");
                btnIniciar.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnIniciarActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(180, 180, 180)
                                                                .addComponent(jLabel1)
                                                                .addContainerGap(181, Short.MAX_VALUE))
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(59, 59, 59)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                false)
                                                                                .addGroup(layout.createSequentialGroup()
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
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                106,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(layout.createSequentialGroup()
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
                                                                .addGap(55, 55, 55)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addGroup(layout.createSequentialGroup()
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
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jScrollPane3,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                106,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(46, 46, 46))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addGap(121, 121, 121)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel5))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(btnReiniciar)
                                                                                .addGroup(layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(cbDiscos,
                                                                                                                                0,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addContainerGap(
                                                                                                                                164,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                                .addComponent(txtMovimientosRealizables,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addContainerGap(
                                                                                                                                229,
                                                                                                                                Short.MAX_VALUE))
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                                                layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(txtMovimientosUsuario,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addContainerGap(
                                                                                                                                                229,
                                                                                                                                                Short.MAX_VALUE)))))
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                                .addGap(131, 131, 131)
                                                                                .addComponent(btnIniciar)
                                                                                .addContainerGap(335,
                                                                                                Short.MAX_VALUE))));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1)
                                                                .addGap(28, 28, 28)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                false)
                                                                                .addComponent(jScrollPane3,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                189,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                0,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(jScrollPane2,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                0,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(btnBTorreA)
                                                                                                .addComponent(btnCTorreA))
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(btnATorreB)
                                                                                                .addComponent(btnCTorreB))
                                                                                .addGroup(layout.createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                .addComponent(btnATorreC)
                                                                                                .addComponent(btnBTorreC)))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                66,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(cbDiscos,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(txtMovimientosRealizables))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel5)
                                                                                .addComponent(txtMovimientosUsuario))
                                                                .addGap(95, 95, 95)
                                                                .addComponent(btnReiniciar)
                                                                .addGap(86, 86, 86))
                                                .addGroup(layout.createParallelGroup(
                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                                                layout.createSequentialGroup()
                                                                                                .addContainerGap(546,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(btnIniciar)
                                                                                                .addGap(87, 87, 87))));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        // & TORRE A
        private void btnBTorreAActionPerformed(java.awt.event.ActionEvent evt) {
                if (tieneIntentos()) {
                        if (!TorresHanoi.B.isEmpty()) {
                                var peekA = TorresHanoi.A.peek();
                                var peekB = TorresHanoi.B.peek();
                                if (peekA.getTamaño() < peekB.getTamaño()) {
                                        Disco sacar = TorresHanoi.A.pop();
                                        TorresHanoi.B.push(sacar);
                                        mostrarTablas();
                                        torresVacias();
                                        cambiarMovimientos();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.A.pop();
                                TorresHanoi.B.push(sacar);
                                mostrarTablas();
                                torresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarWin();
        }

        private void btnCTorreAActionPerformed(java.awt.event.ActionEvent evt) {
                if (tieneIntentos()) {
                        if (!TorresHanoi.C.isEmpty()) {

                                var peekA = TorresHanoi.A.peek();
                                var peekC = TorresHanoi.C.peek();
                                if (peekA.getTamaño() < peekC.getTamaño()) {
                                        Disco sacar = TorresHanoi.A.pop();
                                        TorresHanoi.C.push(sacar);
                                        mostrarTablas();
                                        torresVacias();
                                        cambiarMovimientos();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.A.pop();
                                TorresHanoi.C.push(sacar);
                                mostrarTablas();
                                torresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarWin();
        }

        // & TORRE B
        private void btnATorreBActionPerformed(java.awt.event.ActionEvent evt) {
                if (tieneIntentos()) {
                        if (!TorresHanoi.A.isEmpty()) {

                                var peekB = TorresHanoi.B.peek();
                                var peekA = TorresHanoi.A.peek();
                                if (peekB.getTamaño() < peekA.getTamaño()) {
                                        Disco sacar = TorresHanoi.B.pop();
                                        TorresHanoi.A.push(sacar);
                                        mostrarTablas();
                                        torresVacias();
                                        cambiarMovimientos();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.B.pop();
                                TorresHanoi.A.push(sacar);
                                mostrarTablas();
                                torresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarWin();
        }

        private void btnCTorreBActionPerformed(java.awt.event.ActionEvent evt) {
                if (tieneIntentos()) {
                        if (!TorresHanoi.C.isEmpty()) {

                                var peekB = TorresHanoi.B.peek();
                                var peekC = TorresHanoi.C.peek();
                                if (peekB.getTamaño() < peekC.getTamaño()) {
                                        Disco sacar = TorresHanoi.B.pop();
                                        TorresHanoi.C.push(sacar);
                                        mostrarTablas();
                                        torresVacias();
                                        cambiarMovimientos();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.B.pop();
                                TorresHanoi.C.push(sacar);
                                mostrarTablas();
                                torresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarWin();
        }

        // & TORRE C
        private void btnATorreCActionPerformed(java.awt.event.ActionEvent evt) {
                if (tieneIntentos()) {
                        if (!TorresHanoi.A.isEmpty()) {

                                var peekC = TorresHanoi.C.peek();
                                var peekA = TorresHanoi.A.peek();
                                if (peekC.getTamaño() < peekA.getTamaño()) {
                                        Disco sacar = TorresHanoi.C.pop();
                                        TorresHanoi.A.push(sacar);
                                        mostrarTablas();
                                        torresVacias();
                                        cambiarMovimientos();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.C.pop();
                                TorresHanoi.A.push(sacar);
                                mostrarTablas();
                                torresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarWin();
        }

        private void btnBTorreCActionPerformed(java.awt.event.ActionEvent evt) {
                if (tieneIntentos()) {
                        if (!TorresHanoi.B.isEmpty()) {

                                var peekC = TorresHanoi.C.peek();
                                var peekB = TorresHanoi.B.peek();
                                if (peekC.getTamaño() < peekB.getTamaño()) {
                                        Disco sacar = TorresHanoi.C.pop();
                                        TorresHanoi.B.push(sacar);
                                        mostrarTablas();
                                        torresVacias();
                                        cambiarMovimientos();
                                } else {
                                        JOptionPane.showMessageDialog(null,
                                                        "El disco no puede estar encima de uno más pequeño.");
                                }
                        } else {
                                Disco sacar = TorresHanoi.C.pop();
                                TorresHanoi.B.push(sacar);
                                mostrarTablas();
                                torresVacias();
                                movimientosRealizados++;
                                txtMovimientosUsuario.setText(String.valueOf(movimientosRealizados));
                        }
                }
                verificarWin();
        }

        // ~ BOTONES EJECUCIÓN
        private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarJuego(true);

                nDiscos = Integer.parseInt((String) cbDiscos.getSelectedItem());
                movimientosRealizados = 0;

                int formulaIntentos = (int) ((Math.pow(2, nDiscos)) - 1);
                movimientos = formulaIntentos;

                txtMovimientosRealizables.setText(String.valueOf(formulaIntentos));

                new TorresHanoi(nDiscos);

                mostrarTablas();

                torresVacias();
        }

        private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarJuego(false);
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
        private javax.swing.JButton btnCTorreA;
        private javax.swing.JButton btnCTorreB;
        private javax.swing.JButton btnIniciar;
        private javax.swing.JButton btnReiniciar;
        private javax.swing.JComboBox<String> cbDiscos;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel5;
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
