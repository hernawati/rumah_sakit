/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmJaminan.java
 *
 * Created on Aug 28, 2013, 1:13:02 PM
 */
package rumahsakit.Gui;

import com.mysql.jdbc.Connection;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import rumahsakit.CustomTable.CustomTableUI;
import rumahsakit.Entity.Jaminan;
import rumahsakit.PembatasanKarakter.JTextFieldFiltering;
import rumahsakit.RenderingTabel.RenderTengah;
import rumahsakit.Service.JaminanService;
import rumahsakit.TabelModel.TabelModelJaminan;

/**
 *
 * @author asus
 */
public class FrmJaminan extends javax.swing.JInternalFrame {

    JaminanService js = new JaminanService();
    TabelModelJaminan tabelModelJaminan = new TabelModelJaminan();
    Connection connection;
    JRootPane root = this.getRootPane();
    ActionListener actionPilihTabel, actionFocusNama, actionFocusCari;
    KeyStroke keyPilihTabel, keyFocusNama, keyFocusCari;
    TableCellRenderer tengah = new RenderTengah();

    /** Creates new form FrmJaminan */
    public FrmJaminan() {
        initComponents();
        tabelJaminan.setUI(new CustomTableUI());
        tabelJaminan.setModel(tabelModelJaminan);
        tabelJaminan.getColumnModel().getColumn(0).setCellRenderer(tengah);
//        tabelJaminan.getColumnModel().getColumn(0).setPreferredWidth(80);
//        tabelJaminan.getColumnModel().getColumn(1).setPreferredWidth(150);
        tabelModelJaminan.setData(js.serviceGetAllJaminan());
        sesuaikan();
        txtNamaJaminan.requestFocus();
        txtNamaJaminan.setDocument(new JTextFieldFiltering(JTextFieldFiltering.APLHABETIC, 45));
        jLabel5.setText(tabelModelJaminan.getRowCount() + "");
        jLabel6.setText("0 /");

        tabelJaminan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tabelJaminan.getSelectedRow();
                if (row != -1) {
                    
                    String ID = tabelJaminan.getValueAt(row, 0).toString();
                    String nama = tabelJaminan.getValueAt(row, 1).toString();
                    txtIdJaminan.setText(ID);
                    txtNamaJaminan.setText(nama);

//                    Jaminan jaminan = tabelModelJaminan.getJaminan(row);
//                    txtIdJaminan.setText(jaminan.getIdJaminan());
//                    txtNamaJaminan.setText(jaminan.getNmJaminan());

                    jLabel6.setText((row + 1) + " /");
                    kondisiBtnPilihTabel();
                }
            }
        });

        actionPilihTabel = new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                tabelJaminan.setRowSelectionInterval(0, 0);
                tabelJaminan.requestFocus();
            }
        };

        actionFocusNama = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                txtNamaJaminan.requestFocus();
                txtNamaJaminan.selectAll();
            }
        };

        actionFocusCari = new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                txtKodeNama.requestFocus();
                txtKodeNama.selectAll();
                kondisiBtnPencarian();
            }
        };

        keyPilihTabel = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
        keyFocusNama = KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_DOWN_MASK);
        keyFocusCari = KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.ALT_DOWN_MASK);
        root.registerKeyboardAction(actionPilihTabel, keyPilihTabel, JComponent.WHEN_IN_FOCUSED_WINDOW);
        root.registerKeyboardAction(actionFocusNama, keyFocusNama, JComponent.WHEN_IN_FOCUSED_WINDOW);
        root.registerKeyboardAction(actionFocusCari, keyFocusCari, JComponent.WHEN_IN_FOCUSED_WINDOW);

    }

    public void clear() {
        txtIdJaminan.setText("");
        txtNamaJaminan.setText("");
        txtKodeNama.setText("");
        txtNamaJaminan.requestFocus();
        tabelModelJaminan.setData(js.serviceGetAllJaminan());
        jLabel5.setText(tabelModelJaminan.getRowCount() + "");
        jLabel6.setText("0 /");
        kondisiBtnClear();
    }

    public void kondisiBtnPencarian() {
        btnInsertJaminan.setEnabled(false);
        btnInsertJaminan.setActionCommand("Disable");
        btnUpdateJaminan.setEnabled(false);
        btnUpdateJaminan.setActionCommand("Disable");
        btnDeleteJaminan.setEnabled(false);
        btnDeleteJaminan.setActionCommand("Disable");
    }

    public void kondisiBtnClear() {
        btnInsertJaminan.setEnabled(true);
        btnInsertJaminan.setActionCommand("Enable");
        btnUpdateJaminan.setEnabled(false);
        btnUpdateJaminan.setActionCommand("Disable");
        btnDeleteJaminan.setEnabled(false);
        btnDeleteJaminan.setActionCommand("Disable");
    }

    public void kondisiBtnPilihTabel() {
        btnInsertJaminan.setEnabled(false);
        btnInsertJaminan.setActionCommand("Disable");
        btnUpdateJaminan.setEnabled(true);
        btnUpdateJaminan.setActionCommand("Enable");
        btnDeleteJaminan.setEnabled(true);
        btnDeleteJaminan.setActionCommand("Enable");
    }

    public final void sesuaikan(){
        TableColumnModel tcm = tabelJaminan.getColumnModel();
        for(int kolom=0; kolom<tcm.getColumnCount(); kolom++){
            int lebarKolomMax=0;
            for(int baris=0; baris<tabelJaminan.getRowCount(); baris++){
                TableCellRenderer tcr = tabelJaminan.getCellRenderer(baris, kolom);
                Object nilaiTable = tabelJaminan.getValueAt(baris, kolom);
                Component comp = tcr.getTableCellRendererComponent(tabelJaminan, nilaiTable,
                        false, false, baris, kolom);
                lebarKolomMax = Math.max(comp.getPreferredSize().width, lebarKolomMax);
            }
            TableColumn tc = tcm.getColumn(kolom);
            tc.setPreferredWidth(lebarKolomMax);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdJaminan = new javax.swing.JTextField();
        txtNamaJaminan = new javax.swing.JTextField();
        btnRefreshJaminan = new javax.swing.JButton();
        btnInsertJaminan = new javax.swing.JButton();
        btnUpdateJaminan = new javax.swing.JButton();
        btnDeleteJaminan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelJaminan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKodeNama = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Jaminan Kesehatan");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Jaminan"));

        jLabel1.setText("ID");

        jLabel2.setText("<html><u>N</u>ama");

        jLabel3.setText(":");

        jLabel4.setText(":");

        txtIdJaminan.setEditable(false);
        txtIdJaminan.setFocusable(false);
        txtIdJaminan.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtIdJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtNamaJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRefreshJaminan.setMnemonic(KeyEvent.VK_R);
        btnRefreshJaminan.setText("<html><u>R</u>efresh");
        btnRefreshJaminan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshJaminanActionPerformed(evt);
            }
        });

        btnInsertJaminan.setMnemonic(KeyEvent.VK_I);
        btnInsertJaminan.setText("<html><u>I</u>nsert");
        btnInsertJaminan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertJaminanActionPerformed(evt);
            }
        });

        btnUpdateJaminan.setMnemonic(KeyEvent.VK_U);
        btnUpdateJaminan.setText("<html><u>U</u>pdate");
        btnUpdateJaminan.setActionCommand("Disable");
        btnUpdateJaminan.setEnabled(false);
        btnUpdateJaminan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateJaminanActionPerformed(evt);
            }
        });

        btnDeleteJaminan.setMnemonic(KeyEvent.VK_D);
        btnDeleteJaminan.setText("<html><u>D</u>elete");
        btnDeleteJaminan.setActionCommand("Disable");
        btnDeleteJaminan.setEnabled(false);
        btnDeleteJaminan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJaminanActionPerformed(evt);
            }
        });

        tabelJaminan.setAutoCreateRowSorter(true);
        tabelJaminan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelJaminan.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tabelJaminan);

        jLabel5.setText("0");

        jLabel6.setText("/");

        jLabel7.setText("<html><u>M</u>asukkan kode / nama jaminan");

        txtKodeNama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtKodeNamaFocusGained(evt);
            }
        });
        txtKodeNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKodeNamaKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 11));
        jLabel8.setText("* Tekan F1 untuk menyeleksi tabel");

        jLabel9.setText(":");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9))
                    .addComponent(txtKodeNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsertJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                        .addComponent(btnRefreshJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefreshJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsertJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteJaminan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtKodeNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertJaminanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertJaminanActionPerformed
        // TODO add your handling code here:
        Jaminan jaminan = new Jaminan();
        jaminan.setNmJaminan(txtNamaJaminan.getText().toUpperCase());
        js.serviceInsertJaminan("JM" + js.serviceGetMaxIdJaminan(), jaminan);
        clear();
    }//GEN-LAST:event_btnInsertJaminanActionPerformed

    private void btnRefreshJaminanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshJaminanActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnRefreshJaminanActionPerformed

    private void txtKodeNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKodeNamaKeyReleased
        // TODO add your handling code here:
        tabelModelJaminan.setData(js.serviceGetIdJaminan(txtKodeNama.getText()));
        if (tabelModelJaminan.getRowCount() == 0) {
            tabelModelJaminan.setData(js.serviceGetNmJaminan(txtKodeNama.getText()));
        }
        jLabel5.setText(tabelModelJaminan.getRowCount() + "");
        jLabel6.setText("0 /");
    }//GEN-LAST:event_txtKodeNamaKeyReleased

    private void btnUpdateJaminanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateJaminanActionPerformed
        // TODO add your handling code here:
        Jaminan jaminan = new Jaminan();
        jaminan.setNmJaminan(txtNamaJaminan.getText().toUpperCase());
        js.serviceUpdateJaminan(jaminan, txtIdJaminan.getText());
        clear();
    }//GEN-LAST:event_btnUpdateJaminanActionPerformed

    private void btnDeleteJaminanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJaminanActionPerformed
        // TODO add your handling code here:
        int row = tabelJaminan.getSelectedRow();
        if (row == -1) {
            return;
        }
        int konfirmasi = JOptionPane.showConfirmDialog(null,
                //"Anda yakin ingin menghapus '" + tabelModelJaminan.getJaminan(row).getNmJaminan() + "'?",
                "Anda yakin ingin menghapus '" + tabelJaminan.getValueAt(row, 1).toString() + "'?",
                "Konfirmasi - Delete Jaminan",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            //js.serviceDeleteJaminan(tabelModelJaminan.getJaminan(row).getIdJaminan());
            js.serviceDeleteJaminan(tabelJaminan.getValueAt(row, 0).toString());
        }
        clear();
    }//GEN-LAST:event_btnDeleteJaminanActionPerformed

    private void txtKodeNamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtKodeNamaFocusGained
        // TODO add your handling code here:
        kondisiBtnPencarian();
    }//GEN-LAST:event_txtKodeNamaFocusGained

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteJaminan;
    private javax.swing.JButton btnInsertJaminan;
    private javax.swing.JButton btnRefreshJaminan;
    private javax.swing.JButton btnUpdateJaminan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelJaminan;
    private javax.swing.JTextField txtIdJaminan;
    private javax.swing.JTextField txtKodeNama;
    private javax.swing.JTextField txtNamaJaminan;
    // End of variables declaration//GEN-END:variables
}