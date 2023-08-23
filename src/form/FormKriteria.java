/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author One For All
 */
public class FormKriteria extends javax.swing.JFrame {
    private final Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode,tabmode1;
    int mousepX ;
    int mousepY ;
    public FormKriteria() {
        initComponents();
        setLocationRelativeTo(null);
        datatable();
        datatableKriteria();
        datatablePembagi();
        datatableNormalisasi();
    }

    protected void aktif(){
    }
    
    protected void kosong(){
    }
    
    protected void datatable(){
        Object[] Baris={"Plat Nomor", "Type", "Harga", "Tahun", "Jumlah Penumpang", "Kekuatan Mesin", "Konsumsi Bbm", "Kecepatan Maksimum"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelMobil.setModel(tabmode);
        String sql="SELECT * from mobil";
        try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            while(hasil.next()){
                String a=hasil.getString("no_plat");
                String b=hasil.getString("type");
                String c=hasil.getString("harga");
                String d=hasil.getString("tahun");
                String e=hasil.getString("jumlah_penumpang");
                String f=hasil.getString("kekuatan_mesin");
                String g=hasil.getString("konsumsi_bbm");
                String h=hasil.getString("kecepatan_maksimum");
                String[] data={a,b,c,d,e,f,g,h};
                tabmode.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Tidak Bisa Menampilkan Tabel "+e);
        }
    }
    
    protected void datatableKriteria(){
        Object[] Baris={"Plat Nomor", "Type", "C1", "C2", "C3", "C4", "C5", "C6"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelKriteria.setModel(tabmode);
        String sql="SELECT * from mobil";
        try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            while(hasil.next()){
                String a=hasil.getString("no_plat");
                String b=hasil.getString("type");
                String c=hasil.getString("harga");
                String d=hasil.getString("tahun");
                String e=hasil.getString("jumlah_penumpang");
                String f=hasil.getString("kekuatan_mesin");
                String g=hasil.getString("konsumsi_bbm");
                String h=hasil.getString("kecepatan_maksimum");
                String[] data={a,b,c,d,e,f,g,h};
                tabmode.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Tidak Bisa Menampilkan Tabel Kriteria"+e);
        }
    }
    static String a,b,c,d,e,f;
    protected void datatablePembagi(){
        Object[] Baris={"C1", "C2", "C3", "C4", "C5", "C6"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelPembagi.setModel(tabmode);
        String sql="SELECT DISTINCT SQRT(SUM(POW(harga,2))) AS bgharga, SQRT(SUM(POW(tahun,2))) AS bgtahun, SQRT(SUM(POW(jumlah_penumpang,2))) AS bgpenumpang, SQRT(SUM(POW(kekuatan_mesin,2))) AS bgmesin, SQRT(SUM(POW(konsumsi_bbm,2))) AS bgbbm, SQRT(SUM(POW(kecepatan_maksimum,2))) AS bgkecepatan  FROM mobil";
        try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil=stat.executeQuery(sql);
            while(hasil.next()){
                a=hasil.getString("bgharga");
                b=hasil.getString("bgtahun");
                c=hasil.getString("bgpenumpang");
                d=hasil.getString("bgmesin");
                e=hasil.getString("bgbbm");
                f=hasil.getString("bgkecepatan");
                String[] data={a,b,c,d,e,f};
                tabmode.addRow(data);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Tidak Bisa Menampilkan Tabel Pembagi "+e);
        }
    }
    
    static double nHarga, nTahun, nPenumpang, nMesin, nBbm, nKecepatan;
    static String a2,b2;
    protected void datatableNormalisasi(){
        Object[] Baris1={"Plat Nomor", "Type", "C1", "C2", "C3", "C4", "C5", "C6"};
                tabmode = new DefaultTableModel(null,Baris1);
                tabelNormalisasi.setModel(tabmode);
                String sql="SELECT * from mobil";
                try{
                    java.sql.Statement stat=conn.createStatement();
                    ResultSet hasil=stat.executeQuery(sql);
                        while(hasil.next()){
                            a2=hasil.getString("no_plat");
                            b2=hasil.getString("type");
                            double c2= Double.valueOf(hasil.getString("harga"));
                            double d2= Double.valueOf(hasil.getString("tahun"));
                            double e2= Double.valueOf(hasil.getString("jumlah_penumpang"));
                            double f2= Double.valueOf(hasil.getString("kekuatan_mesin"));
                            double g2= Double.valueOf(hasil.getString("konsumsi_bbm"));
                            double h2= Double.valueOf(hasil.getString("kecepatan_maksimum"));
                            double bgharga = Double.parseDouble(a);
                            double bgtahun = Double.parseDouble(b);
                            double bgpenumpang = Double.parseDouble(c);
                            double bgmesin = Double.parseDouble(d);
                            double bgbbm = Double.parseDouble(e);
                            double bgkecepatan = Double.parseDouble(f);
                              nHarga = c2/bgharga;
                              nTahun = d2/bgtahun;
                              nPenumpang = e2/bgpenumpang;
                              nMesin = f2/bgmesin;
                              nBbm = g2/bgbbm;
                              nKecepatan = h2/bgkecepatan;
                              String c22 = String.valueOf(nHarga);
                              String d22 = String.valueOf(nTahun);
                              String e22 = String.valueOf(nPenumpang);
                              String f22 = String.valueOf(nMesin);
                              String g22 = String.valueOf(nBbm);
                              String h22 = String.valueOf(nKecepatan);
                              String[] data={a2,b2,c22,d22,e22,f22,g22,h22};
                              tabmode.addRow(data);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Tidak Bisa Menampilkan Tabel Normalisasi "+e);
                }
    }
    
    
    static double maksHarga=0.0,minHarga=1000,maksTahun=0.00,minTahun=1000,maksPenumpang=0.00,minPenumpang=1000,maksMesin=0.00,minMesin=1000,maksBbm=0.00,minBbm=1000,maksKecepatan=0.00,minKecepatan=1000;
    static double ntHarga,ntTahun,ntPenumpang,ntMesin,ntBbm,ntKecepatan;
    static int x;
    static String n2Harga,n2Tahun,n2Penumpang,n2Mesin,n2Bbm,n2Kecepatan;
    protected void datatableTerbobot(){
        Object[] Baris={"Plat Nomor", "Type", "C1", "C2", "C3", "C4", "C5", "C6"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelNormalisasiTerbobot.setModel(tabmode);
                String sql="SELECT * from mobil";
                try{
                    java.sql.Statement stat=conn.createStatement();
                    ResultSet hasil=stat.executeQuery(sql);
                        while(hasil.next()){ 
                            a2=hasil.getString("no_plat");
                            b2=hasil.getString("type");
                            double c2= Double.valueOf(hasil.getString("harga"));
                            double d2= Double.valueOf(hasil.getString("tahun"));
                            double e2= Double.valueOf(hasil.getString("jumlah_penumpang"));
                            double f2= Double.valueOf(hasil.getString("kekuatan_mesin"));
                            double g2= Double.valueOf(hasil.getString("konsumsi_bbm"));
                            double h2= Double.valueOf(hasil.getString("kecepatan_maksimum"));
                            double bgharga = Double.parseDouble(a);
                            double bgtahun = Double.parseDouble(b);
                            double bgpenumpang = Double.parseDouble(c);
                            double bgmesin = Double.parseDouble(d);
                            double bgbbm = Double.parseDouble(e);
                            double bgkecepatan = Double.parseDouble(f);
                                nHarga = c2/bgharga;
                                nTahun = d2/bgtahun;
                                nPenumpang = e2/bgpenumpang;
                                nMesin = f2/bgmesin;
                                nBbm = g2/bgbbm;
                                nKecepatan = h2/bgkecepatan;
                                ntHarga=bobotc1*nHarga;
                                ntTahun=bobotc2*nTahun;
                                ntPenumpang=bobotc3*nPenumpang;
                                ntMesin=bobotc4*nMesin;
                                ntBbm=bobotc5*nBbm;
                                ntKecepatan=bobotc6*nKecepatan;
                                n2Harga = String.valueOf(ntHarga);
                                n2Tahun = String.valueOf(ntTahun);
                                n2Penumpang = String.valueOf(ntPenumpang);
                                n2Mesin = String.valueOf(ntMesin);
                                n2Bbm = String.valueOf(ntBbm);
                                n2Kecepatan = String.valueOf(ntKecepatan);
                                String[] data={a2,b2,n2Harga,n2Tahun,n2Penumpang,n2Mesin,n2Bbm,n2Kecepatan};
                                tabmode.addRow(data);
                                if(ntHarga>maksHarga){
                                    maksHarga=ntHarga;
                                }
                                if(ntHarga<minHarga){
                                    minHarga=ntHarga;
                                }      
                                if(ntTahun>maksTahun){
                                    maksTahun=ntTahun;
                                }
                                if(ntTahun<minTahun){
                                    minTahun=ntTahun;
                                }      
                                if(ntPenumpang>maksPenumpang){
                                    maksPenumpang=ntPenumpang;
                                }
                                if(ntPenumpang<minPenumpang){
                                    minPenumpang=ntPenumpang;
                                }      
                                if(ntMesin>maksMesin){
                                    maksMesin=ntMesin;
                                }
                                if(ntMesin<minMesin){
                                    minMesin=ntMesin;
                                }      
                                if(ntBbm>maksBbm){
                                    maksBbm=ntBbm;
                                }
                                if(ntBbm<minBbm){
                                    minBbm=ntBbm;
                                }      
                                if(ntKecepatan>maksKecepatan){
                                    maksKecepatan=ntKecepatan;
                                }
                                if(ntKecepatan<minKecepatan){
                                    minKecepatan=ntKecepatan;
                                }      
                        }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Tidak Bisa Menampilkan Tabel Terbobot "+e);
                }
    }
    String smaksHarga,sminHarga,smaksTahun,sminTahun,smaksPenumpang,sminPenumpang,smaksBbm,sminBbm,smaksMesin,sminMesin,smaksKecepatan,sminKecepatan;
    protected void datatableMinMax(){
        Object[] Baris={"Keterangan", "C1", "C2", "C3", "C4", "C5", "C6"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelMinMax.setModel(tabmode);
                smaksHarga=String.valueOf(maksHarga);
                sminHarga=String.valueOf(minHarga);
                smaksTahun=String.valueOf(maksTahun);
                sminTahun=String.valueOf(minTahun);
                smaksPenumpang=String.valueOf(maksPenumpang);
                sminPenumpang=String.valueOf(minPenumpang);
                smaksBbm=String.valueOf(maksBbm);
                sminBbm=String.valueOf(minBbm);
                smaksMesin=String.valueOf(maksMesin);
                sminMesin=String.valueOf(minMesin);
                smaksKecepatan=String.valueOf(maksKecepatan);
                sminKecepatan=String.valueOf(minKecepatan);
        String[] data={"Nilai Minimum",smaksHarga,sminTahun,sminPenumpang,sminMesin,sminBbm,sminKecepatan};
        String[] data2={"Nilai Maksimum",sminHarga,smaksTahun,smaksPenumpang,smaksMesin,smaksBbm,smaksKecepatan};
        tabmode.addRow(data);
        tabmode.addRow(data2);
    }
    int i=1;
    protected void solusiIdeal(){
        Object[] Baris={"Plat Nomor", "Type", "D+", "D-"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelSolusiIdeal.setModel(tabmode);
                String sql="SELECT * from mobil";
                try{
                    java.sql.Statement stat=conn.createStatement();
                    ResultSet hasil=stat.executeQuery(sql);
                        while(hasil.next()){ 
                            a2=hasil.getString("no_plat");
                            b2=hasil.getString("type");
                            double c2= Double.valueOf(hasil.getString("harga"));
                            double d2= Double.valueOf(hasil.getString("tahun"));
                            double e2= Double.valueOf(hasil.getString("jumlah_penumpang"));
                            double f2= Double.valueOf(hasil.getString("kekuatan_mesin"));
                            double g2= Double.valueOf(hasil.getString("konsumsi_bbm"));
                            double h2= Double.valueOf(hasil.getString("kecepatan_maksimum"));
                            double bgharga = Double.parseDouble(a);
                            double bgtahun = Double.parseDouble(b);
                            double bgpenumpang = Double.parseDouble(c);
                            double bgmesin = Double.parseDouble(d);
                            double bgbbm = Double.parseDouble(e);
                            double bgkecepatan = Double.parseDouble(f);
                              nHarga = c2/bgharga;
                              nTahun = d2/bgtahun;
                              nPenumpang = e2/bgpenumpang;
                              nMesin = f2/bgmesin;
                              nBbm = g2/bgbbm;
                              nKecepatan = h2/bgkecepatan;
                ntHarga=bobotc1*nHarga;
                ntTahun=bobotc2*nTahun;
                ntPenumpang=bobotc3*nPenumpang;
                ntMesin=bobotc4*nMesin;
                ntBbm=bobotc5*nBbm;
                ntKecepatan=bobotc6*nKecepatan;
                            double minnHarga=Double.parseDouble(sminHarga);
                            double makssHarga=Double.parseDouble(smaksHarga);
                            double minnTahun=Double.parseDouble(sminTahun);
                            double makssTahun=Double.parseDouble(smaksTahun);
                            double minnPenumpang=Double.parseDouble(sminPenumpang);
                            double makssPenumpang=Double.parseDouble(smaksPenumpang);
                            double minnMesin=Double.parseDouble(sminMesin);
                            double makssMesin=Double.parseDouble(smaksMesin);
                            double minnBbm=Double.parseDouble(sminBbm);
                            double makssBbm=Double.parseDouble(smaksBbm);
                            double minnKecepatan=Double.parseDouble(sminKecepatan);
                            double makssKecepatan=Double.parseDouble(smaksKecepatan);
                            double hrg = Math.pow(ntHarga-makssHarga,2);
                            double thn = Math.pow(ntTahun-minnTahun,2);
                            double pnm = Math.pow(ntPenumpang-minnPenumpang,2);
                            double msn = Math.pow(ntMesin-minnMesin,2);
                            double bbm = Math.pow(ntBbm-minnBbm,2);
                            double kcp = Math.pow(ntKecepatan-minnKecepatan,2);
                            double d= Math.sqrt(hrg+thn+pnm+msn+bbm+kcp);
                            String dmin=String.valueOf(d);
                            double hrg2 = Math.pow(minnHarga-ntHarga,2);
                            double thn2 = Math.pow(makssTahun-ntTahun,2);
                            double pnm2 = Math.pow(makssPenumpang-ntPenumpang,2);
                            double msn2 = Math.pow(makssMesin-ntMesin,2);
                            double bbm2 = Math.pow(makssBbm-ntBbm,2);
                            double kcp2 = Math.pow(makssKecepatan-ntKecepatan,2);
                            double e= Math.sqrt(hrg2+thn2+pnm2+msn2+bbm2+kcp2);
                            String dplus=String.valueOf(e);
                            double pref1=d/(e+d);
                            String preff=String.valueOf(pref1);
                            double pref=e/(d+e);
                            String sql3="UPDATE mobil SET preferensi=? WHERE no_plat=?";
                            PreparedStatement pstat = conn.prepareStatement(sql3);
                            pstat.setString(1,preff);
                            pstat.setString(2,a2);
                            pstat.executeUpdate();
                            String[] data={a2,b2,dplus,dmin};
                            tabmode.addRow(data);
                        }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Tidak Bisa Menampilkan Tabel Solusi Ideal"+e);
                }
    }
    
    protected void rangking(){
        Object[] Baris={"Rangking","Plat Nomor", "Type", "Preference"};
        tabmode = new DefaultTableModel(null,Baris);
        tabelRangking.setModel(tabmode);
        String sql="SELECT * from mobil ORDER BY preferensi DESC";
        int i=1;
        try{
            java.sql.Statement stat=conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while(hasil.next()){
                String noPlat=hasil.getString("no_plat");
                String type=hasil.getString("type");
                String pref=hasil.getString("preferensi");
                System.out.println(noPlat);
                String ii=String.valueOf(i);
                String[] data = {ii,noPlat,type,pref};
                tabmode.addRow(data);
                i = i+1;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Tidak Bisa Menampilkan Tabel Rangking "+e);
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
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelNormalisasi = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelKriteria = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelMobil = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelPembagi = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelMinMax = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelNormalisasiTerbobot = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelRangking = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelSolusiIdeal = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        panelMobil2 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        c6 = new javax.swing.JComboBox<>();
        c5 = new javax.swing.JComboBox<>();
        c4 = new javax.swing.JComboBox<>();
        c3 = new javax.swing.JComboBox<>();
        c2 = new javax.swing.JComboBox<>();
        c1 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        panelMobil3 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
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
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, 30, -1));

        tabelNormalisasi.setBackground(new java.awt.Color(1, 135, 100));
        tabelNormalisasi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelNormalisasi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelNormalisasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelNormalisasiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabelNormalisasi);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 590, 130));

        tabelKriteria.setBackground(new java.awt.Color(1, 135, 100));
        tabelKriteria.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelKriteria.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelKriteria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKriteriaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelKriteria);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 590, 130));

        tabelMobil.setBackground(new java.awt.Color(1, 135, 100));
        tabelMobil.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelMobil.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMobil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMobilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelMobil);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 590, 130));

        tabelPembagi.setBackground(new java.awt.Color(1, 135, 100));
        tabelPembagi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelPembagi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelPembagi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelPembagiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelPembagi);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 520, 50));

        jLabel15.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(249, 188, 97));
        jLabel15.setText("Penentuan Kriteria");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 20));

        jLabel16.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(249, 188, 97));
        jLabel16.setText("Pembagi");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, -1, 20));

        jLabel17.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(249, 188, 97));
        jLabel17.setText("Matriks Ternormalisasi");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, 20));

        jLabel18.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(249, 188, 97));
        jLabel18.setText("Solusi Ideal Positi & Solusi Ideal Negatif");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 350, -1, 20));

        tabelMinMax.setBackground(new java.awt.Color(1, 135, 100));
        tabelMinMax.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelMinMax.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelMinMax.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMinMaxMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelMinMax);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 290, 590, 60));

        tabelNormalisasiTerbobot.setBackground(new java.awt.Color(1, 135, 100));
        tabelNormalisasiTerbobot.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelNormalisasiTerbobot.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelNormalisasiTerbobot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelNormalisasiTerbobotMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelNormalisasiTerbobot);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 590, 130));

        jLabel19.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(249, 188, 97));
        jLabel19.setText("Data Mobil");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 20));

        jLabel20.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(249, 188, 97));
        jLabel20.setText("Normalisasi Terbobot");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, -1, 20));

        tabelRangking.setBackground(new java.awt.Color(1, 135, 100));
        tabelRangking.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelRangking.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelRangking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelRangkingMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tabelRangking);

        jPanel1.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, 590, 130));

        tabelSolusiIdeal.setBackground(new java.awt.Color(1, 135, 100));
        tabelSolusiIdeal.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tabelSolusiIdeal.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelSolusiIdeal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSolusiIdealMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelSolusiIdeal);

        jPanel1.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 370, 590, 130));

        jLabel21.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(249, 188, 97));
        jLabel21.setText("Rangking");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 500, -1, 20));

        jLabel22.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(249, 188, 97));
        jLabel22.setText("Nilai Maksimum dan Minimum");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 270, -1, 20));

        panelMobil2.setBackground(new java.awt.Color(0, 71, 67));
        panelMobil2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Bobot Kriteria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Demi ITC", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panelMobil2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearch.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cari.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.setInheritsPopupMenu(true);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        panelMobil2.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 110, -1));

        c6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "1", "2", "3", "4", "5" }));
        c6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c6ActionPerformed(evt);
            }
        });
        panelMobil2.add(c6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 60, -1));

        c5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "1", "2", "3", "4", "5" }));
        c5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c5ActionPerformed(evt);
            }
        });
        panelMobil2.add(c5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 60, -1));

        c4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "1", "2", "3", "4", "5" }));
        c4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4ActionPerformed(evt);
            }
        });
        panelMobil2.add(c4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 60, -1));

        c3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "1", "2", "3", "4", "5" }));
        c3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3ActionPerformed(evt);
            }
        });
        panelMobil2.add(c3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 60, -1));

        c2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "1", "2", "3", "4", "5" }));
        c2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2ActionPerformed(evt);
            }
        });
        panelMobil2.add(c2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 60, -1));

        c1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--", "1", "2", "3", "4", "5" }));
        c1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1ActionPerformed(evt);
            }
        });
        panelMobil2.add(c1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 60, -1));

        jLabel23.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(249, 188, 97));
        jLabel23.setText("C1");
        panelMobil2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 20, 20, 20));

        jLabel28.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(249, 188, 97));
        jLabel28.setText("C2");
        panelMobil2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 20, 20));

        jLabel24.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(249, 188, 97));
        jLabel24.setText("C3");
        panelMobil2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 20, 20));

        jLabel25.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(249, 188, 97));
        jLabel25.setText("C4");
        panelMobil2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 20, 20));

        jLabel26.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(249, 188, 97));
        jLabel26.setText("C5");
        panelMobil2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 20, 20));

        jLabel27.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(249, 188, 97));
        jLabel27.setText("C6");
        panelMobil2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 20, 20));

        jPanel1.add(panelMobil2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 590, 80));

        panelMobil3.setBackground(new java.awt.Color(0, 71, 67));
        panelMobil3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Demi ITC", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        panelMobil3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(249, 188, 97));
        jLabel34.setText("Cetak Hasil Perhitungan Topsis");
        panelMobil3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 220, 30));

        btnPrint.setFont(new java.awt.Font("Eras Demi ITC", 1, 12)); // NOI18N
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-print-32.png"))); // NOI18N
        btnPrint.setText("Print");
        btnPrint.setInheritsPopupMenu(true);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        panelMobil3.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 100, 30));

        jPanel1.add(panelMobil3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, 380, 70));

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
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 670));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1400, 670);

        setSize(new java.awt.Dimension(1271, 665));
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
    
   
    private void tabelMobilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMobilMouseClicked
        int bar = tabelMobil.getSelectedRow();
        String a = tabmode.getValueAt(bar,0).toString();
        String b = tabmode.getValueAt(bar,1).toString();
        String c = tabmode.getValueAt(bar,2).toString();
        String d = tabmode.getValueAt(bar,3).toString();
        String e = tabmode.getValueAt(bar,4).toString();
    }//GEN-LAST:event_tabelMobilMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        datatableTerbobot();
        datatableMinMax();
        solusiIdeal();
        rangking();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tabelKriteriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKriteriaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelKriteriaMouseClicked

    private void tabelPembagiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelPembagiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelPembagiMouseClicked

    private void tabelNormalisasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelNormalisasiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelNormalisasiMouseClicked

    private void tabelNormalisasiTerbobotMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelNormalisasiTerbobotMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelNormalisasiTerbobotMouseClicked

    private void tabelMinMaxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMinMaxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelMinMaxMouseClicked

    private void tabelSolusiIdealMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSolusiIdealMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelSolusiIdealMouseClicked

    private void tabelRangkingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelRangkingMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelRangkingMouseClicked
    static double bobotc1, bobotc2, bobotc3, bobotc4, bobotc5, bobotc6;
    private void c1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1ActionPerformed
        String pilih = c1.getSelectedItem().toString();
        switch (pilih){
            case"--Pilih--":
            JOptionPane.showMessageDialog(null,"Pilih Bobot !");
            break;
            case"1":
            bobotc1=1;
            break;
            case"2":
            bobotc1=2;
            break;
            case"3":
            bobotc1=3;
            break;
            case"4":
            bobotc1=4;
            break;
            case"5":
            bobotc1=5;
            break;
        }
    }//GEN-LAST:event_c1ActionPerformed

    private void c2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2ActionPerformed
        String pilih = c2.getSelectedItem().toString();
        switch (pilih){
            case"--Pilih--":
            JOptionPane.showMessageDialog(null,"Pilih Bobot !");
            break;
            case"1":
            bobotc2=1;
            break;
            case"2":
            bobotc2=2;
            break;
            case"3":
            bobotc2=3;
            break;
            case"4":
            bobotc2=4;
            break;
            case"5":
            bobotc2=5;
            break;
        }
    }//GEN-LAST:event_c2ActionPerformed
    private void c3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3ActionPerformed
        String pilih = c3.getSelectedItem().toString();
        switch (pilih){
            case"--Pilih--":
            JOptionPane.showMessageDialog(null,"Pilih Bobot !");
            break;
            case"1":
            bobotc3=1;
            break;
            case"2":
            bobotc3=2;
            break;
            case"3":
            bobotc3=3;
            break;
            case"4":
            bobotc3=4;
            break;
            case"5":
            bobotc3=5;
            break;
        }
    }//GEN-LAST:event_c3ActionPerformed
    private void c4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4ActionPerformed
        String pilih = c4.getSelectedItem().toString();
        switch (pilih){
            case"--Pilih--":
            JOptionPane.showMessageDialog(null,"Pilih Bobot !");
            break;
            case"1":
            bobotc4=1;
            break;
            case"2":
            bobotc4=2;
            break;
            case"3":
            bobotc4=3;
            break;
            case"4":
            bobotc4=4;
            break;
            case"5":
            bobotc4=5;
            break;
        }
    }//GEN-LAST:event_c4ActionPerformed
    private void c5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c5ActionPerformed
        String pilih = c5.getSelectedItem().toString();
        switch (pilih){
            case"--Pilih--":
            JOptionPane.showMessageDialog(null,"Pilih Bobot !");
            break;
            case"1":
            bobotc5=1;
            break;
            case"2":
            bobotc5=2;
            break;
            case"3":
            bobotc5=3;
            break;
            case"4":
            bobotc5=4;
            break;
            case"5":
            bobotc5=5;
            break;
        }
    }//GEN-LAST:event_c5ActionPerformed
    private void c6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c6ActionPerformed
        String pilih = c6.getSelectedItem().toString();
        switch (pilih){
            case"--Pilih--":
            JOptionPane.showMessageDialog(null,"Pilih Bobot !");
            break;
            case"1":
            bobotc6=1;
            break;
            case"2":
            bobotc6=2;
            break;
            case"3":
            bobotc6=3;
            break;
            case"4":
            bobotc6=4;
            break;
            case"5":
            bobotc6=5; 
            break;
        }
    }//GEN-LAST:event_c6ActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try{
            File file = new File("src/report/dataMobilTopsis.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            Map <String,Object> parham = new HashMap<>();
             parham.clear();
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parham,conn);
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data tidak dapat dicetak!"+ "\n" + e.getMessage(), "Cetak Data", JOptionPane.ERROR_MESSAGE);
        }  
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(FormKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormKriteria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormKriteria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSearch;
    protected javax.swing.JComboBox<String> c1;
    protected javax.swing.JComboBox<String> c2;
    protected javax.swing.JComboBox<String> c3;
    protected javax.swing.JComboBox<String> c4;
    protected javax.swing.JComboBox<String> c5;
    protected javax.swing.JComboBox<String> c6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPanel panelMobil2;
    private javax.swing.JPanel panelMobil3;
    private javax.swing.JTable tabelKriteria;
    private javax.swing.JTable tabelMinMax;
    private javax.swing.JTable tabelMobil;
    private javax.swing.JTable tabelNormalisasi;
    private javax.swing.JTable tabelNormalisasiTerbobot;
    private javax.swing.JTable tabelPembagi;
    private javax.swing.JTable tabelRangking;
    private javax.swing.JTable tabelSolusiIdeal;
    // End of variables declaration//GEN-END:variables
}
