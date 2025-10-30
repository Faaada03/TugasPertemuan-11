/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author MyBook Hype AMD
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class ConnectCURD extends javax.swing.JFrame {

    private String oldNoSeri;
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    DefaultTableModel model;
    private javax.persistence.EntityManagerFactory emf;

    public ConnectCURD() {
        initComponents();
        connectDB();
        loadData();
    }

    private void connectDB() {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/DB_PBO_PRAK5";
            String user = "postgres";
            String pass = "123ADMIN3";
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil ke PostgreSQL!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e.getMessage());
        }
    }

    //membuat tempat untuk menyimpan
    private void loadData() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"No Seri", "Nama Barang", "Jenis", "Jumlah"}, 0);
        try {
            String sql = "SELECT * FROM barang";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("no_seri"),
                    rs.getString("nama_barang"),
                    rs.getString("jenis"),
                    rs.getInt("jumlah")
                });
            }
            jTable1.setModel(model);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal load data: " + e.getMessage());
        }
    }

    //mereset semua kolom ketika tidak jadi mengetik
    // untuk dialog insert
    private void ResetFormInsert() {
        txtNoSeri.setText("");
        txtNamaBarang.setText("");
        txtJenis.setText("");
        txtJumlah.setText("");
    }

    //untuk dialog update
    private void ResetFormUpdate() {
        txtNamaBarang1.setText("");
        txtJenis1.setText("");
        txtJumlah1.setText("");
        txtNoSeri1.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Insert = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNoSeri = new javax.swing.JTextField();
        txtNamaBarang = new javax.swing.JTextField();
        txtJenis = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        Update = new javax.swing.JDialog();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtNoSeri1 = new javax.swing.JTextField();
        txtNamaBarang1 = new javax.swing.JTextField();
        txtJenis1 = new javax.swing.JTextField();
        txtJumlah1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        Delete = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtNoSeriDelete = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtNamaBarangDelete = new javax.swing.JLabel();
        txtJenisDelete = new javax.swing.JLabel();
        txtJumlahDelete = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setText("Jumlah Stok");

        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel7.setText("Jenis Barang");

        jLabel8.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel8.setText("nama Barang");

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel9.setText("No Seri");

        txtNoSeri.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNoSeri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoSeriActionPerformed(evt);
            }
        });

        txtNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarangActionPerformed(evt);
            }
        });

        jButton6.setText("SUBMIT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel15.setText("INSERT");

        jButton4.setText("RESET");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InsertLayout = new javax.swing.GroupLayout(Insert.getContentPane());
        Insert.getContentPane().setLayout(InsertLayout);
        InsertLayout.setHorizontalGroup(
            InsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertLayout.createSequentialGroup()
                .addGroup(InsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InsertLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtNoSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InsertLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8)
                        .addGap(41, 41, 41)
                        .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InsertLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InsertLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(InsertLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)))
                .addContainerGap(24, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InsertLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(124, 124, 124))
        );

        InsertLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton4, jButton6});

        InsertLayout.setVerticalGroup(
            InsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InsertLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(InsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoSeri, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(InsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(InsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(InsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(InsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton4))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        InsertLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton4, jButton6});

        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel10.setText("Jumlah Stok");

        jLabel11.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel11.setText("Jenis Barang");

        jLabel12.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel12.setText("nama Barang");

        jLabel13.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel13.setText("No Seri");

        txtNoSeri1.setCaretColor(new java.awt.Color(255, 255, 255));
        txtNoSeri1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoSeri1ActionPerformed(evt);
            }
        });

        txtNamaBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaBarang1ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jButton7.setText("SUBMIT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel14.setText("UPDATE");

        jButton8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 12)); // NOI18N
        jButton8.setText("RESET");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UpdateLayout = new javax.swing.GroupLayout(Update.getContentPane());
        Update.getContentPane().setLayout(UpdateLayout);
        UpdateLayout.setHorizontalGroup(
            UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateLayout.createSequentialGroup()
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtNoSeri1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel12)
                        .addGap(41, 41, 41)
                        .addComponent(txtNamaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtJenis1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtJumlah1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(UpdateLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8))
                    .addGroup(UpdateLayout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel14)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        UpdateLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton7, jButton8});

        UpdateLayout.setVerticalGroup(
            UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoSeri1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaBarang1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJenis1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJumlah1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        UpdateLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton7, jButton8});

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("APAKAH YAKIN AKAN MENGHAPUS DATA INI ?");

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setText("IYA");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setText("TIDAK");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtNoSeriDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("NO SERI");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("NAMA BARANG");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("JENIS BARANG");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("JUMLAH STOK");

        txtNamaBarangDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtJenisDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtJumlahDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtNoSeriDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNamaBarangDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJenisDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtJumlahDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel3, jLabel4, txtJenisDelete, txtJumlahDelete, txtNamaBarangDelete, txtNoSeriDelete});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNamaBarangDelete)
                        .addComponent(txtJenisDelete)
                        .addComponent(txtJumlahDelete))
                    .addComponent(txtNoSeriDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel16, jLabel17, jLabel3, jLabel4});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtJenisDelete, txtJumlahDelete, txtNamaBarangDelete, txtNoSeriDelete});

        javax.swing.GroupLayout DeleteLayout = new javax.swing.GroupLayout(Delete.getContentPane());
        Delete.getContentPane().setLayout(DeleteLayout);
        DeleteLayout.setHorizontalGroup(
            DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteLayout.createSequentialGroup()
                .addGroup(DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DeleteLayout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton10))
                    .addGroup(DeleteLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DeleteLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        DeleteLayout.setVerticalGroup(
            DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DeleteLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(DeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        jButton11.setText("jButton11");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton1.setText("INSERT");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton3.setText("DELETE");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No Seri", "Nama Barang", "Jenis Barang", "Jumlah Stok"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("DATA BARANG SWALAYAN");

        jButton5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jButton5.setText("CLEAR");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setText("CETAK");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setText("UPLOAD");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton3)
                            .addComponent(jButton5)
                            .addComponent(jButton2))
                        .addContainerGap(16, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //insert Data
        Insert.pack();
        Insert.setLocationRelativeTo(this);
        Insert.setModal(true);
        Insert.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Update Data
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris data yang akan diupdate terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String noSeri = jTable1.getValueAt(selectedRow, 0).toString();
            oldNoSeri = noSeri;

            txtNoSeri1.setText(noSeri);
            txtNamaBarang1.setText(jTable1.getValueAt(selectedRow, 1).toString());
            txtJenis1.setText(jTable1.getValueAt(selectedRow, 2).toString());
            txtJumlah1.setText(jTable1.getValueAt(selectedRow, 3).toString());

            Update.pack();
            Update.setLocationRelativeTo(this);
            Update.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data update: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Delete Data
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih dulu data yang mau dihapus!");
            return;
        }

        String noSeri = jTable1.getValueAt(row, 0).toString();
        String nama = jTable1.getValueAt(row, 1).toString();
        String jenis = jTable1.getValueAt(row, 2).toString();
        String stok = jTable1.getValueAt(row, 3).toString();

        txtNoSeriDelete.setText(noSeri);
        txtNamaBarangDelete.setText(nama);
        txtJenisDelete.setText(jenis);
        txtJumlahDelete.setText(stok);

        Delete.pack();
        Delete.setLocationRelativeTo(this);
        Delete.setModal(true);
        Delete.setVisible(true);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:    
        //ClearData (Delete All)
        int confirm = JOptionPane.showConfirmDialog(this,
                "Yakin ingin menghapus SEMUA data?",
                "Konfirmasi Hapus Semua",
                JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try (PreparedStatement pst = conn.prepareStatement("DELETE FROM barang")) {
            int affected = pst.executeUpdate();
            JOptionPane.showMessageDialog(this, affected + " data berhasil dihapus!");
            loadData();  // refresh tabel

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal hapus semua: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtNoSeriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoSeriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSeriActionPerformed

    private void txtNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarangActionPerformed

    /*   
================================================================================
        BATASAN ANTARA SC UNTUK JFORM DAN JDIALOG
================================================================================
    
     */

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Insert Data(JDialog)
        if (txtNoSeri.getText().equals("") || txtNamaBarang.getText().equals("") || txtJenis.getText().equals("") || txtJumlah.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            String NoSeri, namaBarang, jenisBarang;
            NoSeri = txtNoSeri.getText();
            namaBarang = txtNamaBarang.getText();
            jenisBarang = txtJenis.getText();
            int jumlah;

            try {
                jumlah = Integer.parseInt(txtJumlah.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Jumlah harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_PBO_PRAK5");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Barang B = new Barang();
            B.setNoSeri(NoSeri);
            B.setNamaBarang(namaBarang);
            B.setJenis(jenisBarang);
            B.setJumlah(jumlah);

            em.persist(B);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Sukses diinput");

            ResetFormInsert();
            loadData();

            em.close();
            emf.close();
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtNoSeri1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoSeri1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSeri1ActionPerformed

    private void txtNamaBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaBarang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaBarang1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // Update Data (JDialog)
        if (txtNoSeri1.getText().isEmpty() || txtNamaBarang1.getText().isEmpty() || txtJenis1.getText().isEmpty() || txtJumlah1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            String NoSeri, namaBarang, jenisBarang;
            NoSeri = txtNoSeri1.getText();
            namaBarang = txtNamaBarang1.getText();
            jenisBarang = txtJenis1.getText();
            int jumlah;

            try {
                jumlah = Integer.parseInt(txtJumlah1.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "jumlah harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DB_PBO_PRAK5");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Barang B = em.find(Barang.class, NoSeri);
            if (B == null) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            } else {
                B.setNoSeri(NoSeri);
                B.setNamaBarang(namaBarang);
                B.setJenis(jenisBarang);
                B.setJumlah(jumlah);

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

                em.close();
                emf.close();
                ResetFormUpdate();
                txtNoSeri1.setEditable(true);
            }
        }

    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Reset Form Insert
        ResetFormInsert();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //Reset Form Delete
        ResetFormUpdate();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //Delete Data (JDialog)
        String NoSeri = txtNoSeriDelete.getText();

        int jawab = JOptionPane.showConfirmDialog(null, "Yakin ingin menghapus data dengan NoSeri : ",
                "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (jawab == JOptionPane.YES_OPTION) {

            EntityManager em = null;
            EntityManagerFactory emf = null;

            try {

                emf = javax.persistence.Persistence.createEntityManagerFactory("DB_PBO_PRAK5"); // Pastikan nama PU benar
                em = emf.createEntityManager();
                em.getTransaction().begin();

                Barang B = em.find(Barang.class, NoSeri);

                if (B == null) {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
                } else {

                    em.remove(B);
                    em.getTransaction().commit();

                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

                    loadData();
                }

            } catch (Exception ex) {
                if (em != null && em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                JOptionPane.showMessageDialog(this, "Gagal hapus data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                if (em != null) {
                    em.close();
                }
                if (emf != null) {

                }
                Delete.dispose();
            }
        } else {

            Delete.dispose();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // Cancel Delete (JDialog)(Button = Tidak)

        Delete.dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed


    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // Button cetak:
        JasperReport reports;
        if (conn == null) {
            Logger.getLogger(ConnectCURD.class.getName()).log(Level.SEVERE, "Koneksi database (conn) adalah null.");
            return;
        }

        try {
            // Path ke file jrxml
            String jrxmlPath = "C:\\Users\\MyBook Hype AMD\\Downloads\\TugasPertemuan-6-main\\TugasPertemuan-6-main\\TestGuiWithCurd\\src\\reportStokbarang.jrxml";

            String jasperPath = "C:\\Users\\MyBook Hype AMD\\Downloads\\TugasPertemuan-6-main\\TugasPertemuan-6-main\\TestGuiWithCurd\\src\\reportStokbarang.jasper";

            // Compile file jrxml ke jasper
            JasperCompileManager.compileReportToFile(jrxmlPath, jasperPath);
            JasperPrint jprint = JasperFillManager.fillReport(jasperPath, null, conn);

            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ConnectCURD.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("File dipilih: " + filePilihan.getAbsolutePath());

            try (BufferedReader br = new BufferedReader(new FileReader(filePilihan))) {
                if (conn == null || conn.isClosed()) {
                    connectDB();
                }

                String baris;
                String pemisah = ";";

                while ((baris = br.readLine()) != null) {
                    if (baris.trim().isEmpty() || baris.toLowerCase().contains("kode")) {
                        continue;
                    }

                    String[] data = baris.split(pemisah);
                    if (data.length < 4) {
                        continue;
                    }

                    String kode = data[0].trim();
                    kode = kode.replace("\uFEFF", "");
                    String nama = data[1].trim();
                    String jenis = data[2].trim();
                    String jumlah = data[3].trim();

                    if (!kode.isEmpty() && !nama.isEmpty() && !jenis.isEmpty() && !jumlah.isEmpty()) {
                        String sql = "INSERT INTO barang (no_seri, nama_barang, jenis, jumlah) VALUES (?,?,?,?)";
                        pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, kode);
                        pstmt.setString(2, nama);
                        pstmt.setString(3, jenis);
                        pstmt.setInt(4, Integer.parseInt(jumlah));
                        pstmt.executeUpdate();
                    }
                }

                JOptionPane.showMessageDialog(this, "Import data CSV berhasil!");

                loadData();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Kesalahan SQL: " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_jButton13ActionPerformed

    /*
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
            java.util.logging.Logger.getLogger(ConnectCURD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConnectCURD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConnectCURD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConnectCURD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConnectCURD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Delete;
    private javax.swing.JDialog Insert;
    private javax.swing.JDialog Update;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtJenis;
    private javax.swing.JTextField txtJenis1;
    private javax.swing.JLabel txtJenisDelete;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtJumlah1;
    private javax.swing.JLabel txtJumlahDelete;
    private javax.swing.JTextField txtNamaBarang;
    private javax.swing.JTextField txtNamaBarang1;
    private javax.swing.JLabel txtNamaBarangDelete;
    private javax.swing.JTextField txtNoSeri;
    private javax.swing.JTextField txtNoSeri1;
    private javax.swing.JLabel txtNoSeriDelete;
    // End of variables declaration//GEN-END:variables

}
