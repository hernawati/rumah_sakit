/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmUtama.java
 *
 * Created on Aug 28, 2013, 1:11:44 PM
 */
package rumahsakit.Gui;

import java.awt.Dimension;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class FrmUtama extends javax.swing.JFrame {

    

    /** Creates new form FrmUtama */
    public FrmUtama() {
        initComponents();
        setLocationRelativeTo(this);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        mnuJaminan = new javax.swing.JMenuItem();
        mnuSpesialis = new javax.swing.JMenuItem();
        mnuPasien = new javax.swing.JMenuItem();
        mnuDokter = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setBackground(new java.awt.Color(127, 208, 215));

        jToolBar1.setRollover(true);

        jButton1.setText("jButton1");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        jButton2.setText("jButton2");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton2);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu3.setText("Data Master");

        mnuJaminan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_J, java.awt.event.InputEvent.CTRL_MASK));
        mnuJaminan.setText("Jaminan Pasien");
        mnuJaminan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuJaminanActionPerformed(evt);
            }
        });
        jMenu3.add(mnuJaminan);

        mnuSpesialis.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuSpesialis.setText("Spesialis Dokter");
        mnuSpesialis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSpesialisActionPerformed(evt);
            }
        });
        jMenu3.add(mnuSpesialis);

        mnuPasien.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnuPasien.setText("Data Pasien");
        mnuPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPasienActionPerformed(evt);
            }
        });
        jMenu3.add(mnuPasien);

        mnuDokter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        mnuDokter.setText("Data Dokter");
        mnuDokter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDokterActionPerformed(evt);
            }
        });
        jMenu3.add(mnuDokter);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Pendaftaran");

        jMenu4.setText("Registrasi Pasien");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Pasien Lama");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Pasien Baru");
        jMenu4.add(jMenuItem3);

        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        jMenu5.setText("JOptionPane");

        jMenuItem1.setText("Tesss");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuJaminanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuJaminanActionPerformed
        // TODO add your handling code here:
        FrmJaminan fj = new FrmJaminan();        
        Dimension parentSize = jDesktopPane1.getSize();
        Dimension childSize = fj.getSize();
        fj.setLocation((parentSize.width - childSize.width) / 2, (parentSize.height - childSize.height) / 2);       
        jDesktopPane1.add(fj);
        fj.show();
        fj.toFront();
    }//GEN-LAST:event_mnuJaminanActionPerformed

    private void mnuSpesialisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSpesialisActionPerformed
        // TODO add your handling code here:
        FrmSpesialis fs = new FrmSpesialis();
        Dimension parentSize = jDesktopPane1.getSize();
        Dimension childSize = fs.getSize();
        fs.setLocation((parentSize.width - childSize.width) / 2, (parentSize.height - childSize.height) / 2);
        jDesktopPane1.add(fs);
        fs.show();
        fs.toFront();
    }//GEN-LAST:event_mnuSpesialisActionPerformed

    private void mnuPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPasienActionPerformed
        // TODO add your handling code here:
        FrmPasien fp = new FrmPasien();
        Dimension parentSize = jDesktopPane1.getSize();
        Dimension childSize = fp.getSize();
        fp.setLocation((parentSize.width - childSize.width) / 2, (parentSize.height - childSize.height) / 2);
        jDesktopPane1.add(fp);
        fp.show();
        fp.toFront();
    }//GEN-LAST:event_mnuPasienActionPerformed

    private void mnuDokterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDokterActionPerformed
        // TODO add your handling code here:
        FrmDokter fp = new FrmDokter();
        Dimension parentSize = jDesktopPane1.getSize();
        Dimension childSize = fp.getSize();
        fp.setLocation((parentSize.width - childSize.width) / 2, (parentSize.height - childSize.height) / 2);
        jDesktopPane1.add(fp);
        fp.show();
        fp.toFront();
    }//GEN-LAST:event_mnuDokterActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        FrmPendaftaran fp = new FrmPendaftaran();
        Dimension parentSize = jDesktopPane1.getSize();
        Dimension childSize = fp.getSize();
        fp.setLocation((parentSize.width - childSize.width) / 2, (parentSize.height - childSize.height) / 2);
        jDesktopPane1.add(fp);
        fp.show();
        fp.toFront();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Teeeesssss!!!!");
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenuItem mnuDokter;
    private javax.swing.JMenuItem mnuJaminan;
    private javax.swing.JMenuItem mnuPasien;
    private javax.swing.JMenuItem mnuSpesialis;
    // End of variables declaration//GEN-END:variables
}
