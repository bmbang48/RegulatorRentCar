/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

/**
 *
 * @author One For All
 */
public class FormSupir extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form login
     */
    int mousepX ;
    int mousepY ;
    public FormSupir() {
        initComponents();
        setLocationRelativeTo(null);
        datatable();
    }
    
    protected void aktif(){
        tNik.setEnabled(true);
        tNama.setEnabled(true);
        tAlamat.setEnabled(true);
        tTelp.setEnabled(true);
        tNik.requestFocus();
    }
    
    protected void kosong(){
        sim.setIcon(null);
        tNik.setText("");
        tNama.setText("");
        tAlamat.setText("");
        tTelp.setText("");
    }
    
    protected void datatable(){
        Object[] Baris={"No Induk","Nama Supir","No Telpon","Jasa Supir", "Alamat"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelSupir.setModel(tabmode);
        String sql="SELECT * FROM supir WHERE id_supir LIKE '%"+tCari.getText()+"%' "
                + "OR nama_supir LIKE '%"+tCari.getText()+"%' "
                + "OR telp LIKE '%"+tCari.getText()+"%' "
                + "OR alamat LIKE '%"+tCari.getText()+"%' "
                + "OR biaya LIKE '%"+tCari.getText()+"%' ";
        try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            while(hasil.next()){
                String a=hasil.getString("id_supir");
                String b=hasil.getString("nama_supir");
                String c=hasil.getString("telp");
                String d=hasil.getString("biaya");
                String e=hasil.getString("alamat");
                String[] data={a,b,c,d,e};
                tabmode.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tidak Bisa Menampilkan Tabel" + e);
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
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tNik = new javax.swing.JTextField();
        btnPilihFoto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        sim = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tTelp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSupir = new javax.swing.JTable();
        tCari = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tAlamat = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        tDelete1 = new javax.swing.JButton();
        tJasa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 350));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-cancel-30.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 30, -1));

        jLabel2.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(249, 188, 97));
        jLabel2.setText("NIK");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, -1));

        tNik.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNikActionPerformed(evt);
            }
        });
        jPanel1.add(tNik, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 180, -1));

        btnPilihFoto.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        btnPilihFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-choose-16.png"))); // NOI18N
        btnPilihFoto.setText("File");
        btnPilihFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihFotoActionPerformed(evt);
            }
        });
        jPanel1.add(btnPilihFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sim, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sim, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 280, 150));

        tNama.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaActionPerformed(evt);
            }
        });
        jPanel1.add(tNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 180, -1));

        jLabel3.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 188, 97));
        jLabel3.setText("Nama");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        tTelp.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tTelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tTelpActionPerformed(evt);
            }
        });
        jPanel1.add(tTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 180, -1));

        jLabel5.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(249, 188, 97));
        jLabel5.setText("Jasa Supir");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        btnSave.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/save-16x16i.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.setInheritsPopupMenu(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 110, 30));

        btnClear.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh26.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setInheritsPopupMenu(true);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel1.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 340, 110, 30));

        btnDelete.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/trash.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setInheritsPopupMenu(true);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 340, 110, 30));

        btnEdit.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/edit_f2.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setInheritsPopupMenu(true);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 110, 30));

        tabelSupir.setBackground(new java.awt.Color(1, 135, 100));
        tabelSupir.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelSupir.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelSupir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSupirMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSupir);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 580, 130));

        tCari.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariActionPerformed(evt);
            }
        });
        jPanel1.add(tCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 140, 30));

        tAlamat.setColumns(20);
        tAlamat.setRows(5);
        jScrollPane2.setViewportView(tAlamat);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 180, 80));

        jLabel6.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(249, 188, 97));
        jLabel6.setText("No Telpon");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        tDelete1.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        tDelete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cari.png"))); // NOI18N
        tDelete1.setText("Search");
        tDelete1.setInheritsPopupMenu(true);
        tDelete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tDelete1ActionPerformed(evt);
            }
        });
        jPanel1.add(tDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 110, 30));

        tJasa.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        tJasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tJasaActionPerformed(evt);
            }
        });
        jPanel1.add(tJasa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 180, -1));

        jLabel7.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(249, 188, 97));
        jLabel7.setText("Alamat");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/bg menu.png"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 620));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 640, 620);

        setSize(new java.awt.Dimension(640, 618));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        dispose();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
        mousepX = getX();
        mousepY = getY();
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
        int koordinatX = evt.getXOnScreen();
        int koordinatY = evt.getYOnScreen();
        this.setLocation(koordinatX-mousepX, koordinatY-mousepY);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void tNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNikActionPerformed
    
    private String filename;
    private void btnPilihFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihFotoActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File f = chooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(f.toString());
            Image img = icon.getImage().getScaledInstance(sim.getWidth(), sim.getHeight(), Image.SCALE_DEFAULT);
            ImageIcon ic = new ImageIcon(img);
            sim.setIcon(ic);
            filename = f.getAbsolutePath();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnPilihFotoActionPerformed
    public void foto(String a){
        String sql = "SELECT foto_sim FROM supir Where id_supir = '"+a+"'";
        try {
            java.sql.Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String foto = hasil.getString("foto_sim");
                ImageIcon icon = new ImageIcon(foto);
                Image img = icon.getImage().getScaledInstance(sim.getWidth(), sim.getHeight(), Image.SCALE_DEFAULT);
                ImageIcon ic = new ImageIcon(img);
                sim.setIcon(ic);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak Bisa Menampilkan Foto "+e);
        }
    }
    private void tNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaActionPerformed

    private void tTelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tTelpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tTelpActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String sql = "INSERT INTO supir VALUES(?,?,?,?,?,?)";
        try{
            String newpath = "src/upload";
            File directory = new File(newpath);
            if(!directory.exists()){
                directory.mkdirs();
            }
            File fileawal = null;
            File fileakhir = null;
            String ext = this.filename.substring(filename.lastIndexOf('.')+1);
            fileawal = new File(filename);
            fileakhir = new File(newpath+"/"+tNik.getText()+"."+ext);
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, tNik.getText());
            stat.setString(2, tNama.getText());
            stat.setString(3, tTelp.getText());
            stat.setString(4, tAlamat.getText());
            stat.setString(5, tJasa.getText());
            stat.setString(6, fileakhir.toString());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
            Files.copy(fileawal.toPath(), fileakhir.toPath());
            kosong();
            tNik.requestFocus();
            datatable();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Disimpan "+e);
        } catch (IOException ex) {
            Logger.getLogger(FormPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        kosong();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int ok = JOptionPane.showConfirmDialog(null,"Hapus ?","Konfirmasi Dialog", JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
            String sql="DELETE FROM supir WHERE id_supir='"+tNik.getText()+"'";
            try{
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
                kosong();
                tNik.requestFocus();
                datatable();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus"+e);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try{
            String sql = "UPDATE supir SET nama_supir=?,telp=?,alamat=?,biaya=?,foto_sim=? WHERE id_supir=?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,tNama.getText());
            stat.setString(2,tTelp.getText());
            stat.setString(3,tAlamat.getText());
            stat.setString(4,tJasa.getText());
            String newpath = "src/upload";
            File directory = new File(newpath);
            if(!directory.exists()){
                directory.mkdirs();
            }
            File fileawal = null;
            File fileakhir = null;
            String ext = this.filename.substring(filename.lastIndexOf('.')+1);
            fileawal = new File(filename);
            fileakhir = new File(newpath+"/"+tNik.getText()+"(1)."+ext);
            stat.setString(5,fileakhir.toString());
            stat.setString(6,tNik.getText());
            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            Files.copy(fileawal.toPath(), fileakhir.toPath());
            kosong();
            tNik.requestFocus();
            datatable();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Data Gagal Diubah "+e);
        } catch (IOException ex) {
            Logger.getLogger(FormPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tabelSupirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSupirMouseClicked
        int bar = tabelSupir.getSelectedRow();
        String a = tabmode.getValueAt(bar,0).toString();
        String b = tabmode.getValueAt(bar,1).toString();
        String c = tabmode.getValueAt(bar,2).toString();
        String d = tabmode.getValueAt(bar,3).toString();
        String e = tabmode.getValueAt(bar,4).toString();
        foto(a);
        tNik.setText(a);
        tNama.setText(b);
        tTelp.setText(c);
        tJasa.setText(d);
        tAlamat.setText(e);
    }//GEN-LAST:event_tabelSupirMouseClicked

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCariActionPerformed

    private void tDelete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tDelete1ActionPerformed
        datatable();
    }//GEN-LAST:event_tDelete1ActionPerformed

    private void tJasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tJasaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tJasaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormSupir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormSupir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormSupir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormSupir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormSupir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnPilihFoto;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel sim;
    private javax.swing.JTextArea tAlamat;
    private javax.swing.JTextField tCari;
    private javax.swing.JButton tDelete1;
    private javax.swing.JTextField tJasa;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNik;
    private javax.swing.JTextField tTelp;
    private javax.swing.JTable tabelSupir;
    // End of variables declaration//GEN-END:variables
}