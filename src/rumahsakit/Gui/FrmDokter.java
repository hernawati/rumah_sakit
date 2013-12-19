/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmDokter.java
 *
 * Created on Aug 30, 2013, 8:01:16 PM
 */
package rumahsakit.Gui;

import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import com.mysql.jdbc.Connection;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import rumahsakit.CustomTable.CustomTableUI;
import rumahsakit.Entity.Dokter;
import rumahsakit.RenderingTabel.RenderTengah;
import rumahsakit.Service.DokterService;
import rumahsakit.Service.SpesialisService;
import rumahsakit.TabelModel.TabelModelDokter;
import rumahsakit.TabelModel.TabelModelSpesialis;

/**
 *
 * @author asus
 */
public class FrmDokter extends javax.swing.JInternalFrame {

    DokterService ds = new DokterService();
    SpesialisService ss = new SpesialisService();
    TabelModelDokter tabelModelDokter = new TabelModelDokter();
    TabelModelSpesialis tabelModelSpesialis = new TabelModelSpesialis();
    Connection connection;    
    TableCellRenderer tengah = new RenderTengah();

    /** Creates new form FrmDokter */
    public FrmDokter() {
        initComponents();
        tabelDokter.setUI(new CustomTableUI());
        tabelDokter.setModel(tabelModelDokter);
        tabelDokter.getColumnModel().getColumn(0).setCellRenderer(tengah);
        tabelModelDokter.setData(ds.serviceGetAllDokter());
        sesuaikan();

        tabelDokter.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                int row = tabelDokter.getSelectedRow();
                if (row != -1) {
                    
                    String ID = tabelDokter.getValueAt(row, 0).toString();
                    String nama = tabelDokter.getValueAt(row, 1).toString();
                    String spesialis = tabelDokter.getValueAt(row, 2).toString();                    
                    txtIdDokter.setText(ID);
                    txtNamaDokter.setText(nama);
                    jComboBox1.setSelectedItem(spesialis);

                    //Dokter dokter = tabelModelDokter.getDokter(row);
                    //String ID = tabelModelDokter.getValueAt(row, 0).toString();
                    //String nama = tabelModelDokter.getValueAt(row, 1).toString();
                    //txtIdDokter.setText(dokter.getIdDokter());
                    //txtNamaDokter.setText(dokter.getNmDokter());
                    //jComboBox1.setSelectedItem(dokter.getIdSpesialis());
                                        
                }
            }
        });

        tabelModelSpesialis.setData(ss.serviceGetAllSpesialis());
        int a = tabelModelSpesialis.getRowCount();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(ss.serviceGetNamaSpesialis(a)));

        AutoCompleteSupport support = AutoCompleteSupport.install(
                this.jComboBox1, GlazedLists.eventListOf(ss.serviceGetNamaSpesialis(a)));

    }

    public void clear() {
        txtIdDokter.setText("");
        txtNamaDokter.setText("");
        tabelModelDokter.setData(ds.serviceGetAllDokter());
        jComboBox1.setSelectedItem("");
        txtIdDokter.requestFocus();
    }

    public final void sesuaikan(){
        TableColumnModel tcm = tabelDokter.getColumnModel();
        for(int kolom=0; kolom<tcm.getColumnCount(); kolom++){
            int lebarKolomMax=0;
            for(int baris=0; baris<tabelDokter.getRowCount(); baris++){
                TableCellRenderer tcr = tabelDokter.getCellRenderer(baris, kolom);
                Object nilaiTable = tabelDokter.getValueAt(baris, kolom);
                Component comp = tcr.getTableCellRendererComponent(tabelDokter, nilaiTable,
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
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdDokter = new javax.swing.JTextField();
        txtNamaDokter = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelDokter = new javax.swing.JTable();

        setClosable(true);
        setTitle("Daftar Dokter");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dokter"));

        jLabel1.setText("ID");

        jLabel2.setText("Nama");

        jLabel3.setText("Spesialis");

        jLabel4.setText(":");

        jLabel5.setText(":");

        jLabel6.setText(":");

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        jComboBox1.setEditable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, 318, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind)))
                .addGap(173, 173, 173))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(txtIdDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(txtNamaDokter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        tabelDokter.setAutoCreateRowSorter(true);
        tabelDokter.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelDokter.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tabelDokter);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInsert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                        .addComponent(btnRefresh)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsert)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        String pilih = (String) jComboBox1.getSelectedItem();        
        if ((pilih == null) || (pilih.equalsIgnoreCase("")) || (pilih.equalsIgnoreCase(" "))) {
            JOptionPane.showMessageDialog(rootPane, "Tidak Boleh Kosong!");
        } else {
            String id = ss.serviceGetIDSpesialis(pilih);            
            if (id == null) {
                JOptionPane.showMessageDialog(rootPane, "Cek Spesialis Dokter!");
            } else {
                Dokter d = new Dokter();
                d.setIdDokter(txtIdDokter.getText());
                d.setNmDokter(txtNamaDokter.getText().toUpperCase());
                d.setIdSpesialis(id);
                ds.serviceInsertDokter(d);
                clear();
            }
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String pilih = (String) jComboBox1.getSelectedItem();        
        if ((pilih == null) || (pilih.equalsIgnoreCase("")) || (pilih.equalsIgnoreCase(" "))) {
            JOptionPane.showMessageDialog(rootPane, "Tidak Boleh Kosong!");
        } else {
            String id = ss.serviceGetIDSpesialis(pilih);            
            if (id == null) {
                JOptionPane.showMessageDialog(rootPane, "Cek Spesialis Dokter!");
            } else {
                Dokter d = new Dokter();
                d.setNmDokter(txtNamaDokter.getText().toUpperCase());
                d.setIdSpesialis(id);
                ds.serviceUpdateDokter(d, txtIdDokter.getText());
                clear();
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int row = tabelDokter.getSelectedRow();
        if (row == -1) {
            return;
        }
        ds.serviceDeleteDokter(tabelDokter.getValueAt(row, 0).toString());
        //ds.serviceDeleteDokter(tabelModelDokter.getDokter(row).getIdDokter());
        clear();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        tabelModelDokter.setData(ds.serviceGetByIdDoker(txtIdDokter.getText()));
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnRefreshActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelDokter;
    private javax.swing.JTextField txtIdDokter;
    private javax.swing.JTextField txtNamaDokter;
    // End of variables declaration//GEN-END:variables
}