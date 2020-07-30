/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhoinghi.ui;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import qlhoinghi.entity.*;
import qlhoinghi.util.HibernateUtil;
import qlhoinghi.ui.LichSuDangKy;

/**
 *
 * @author admin
 */
public class ManHinhChinh extends javax.swing.JFrame {
    /**
     * Creates new form ManHinhChinh
     */
    public ManHinhChinh() {
        
        initComponents();
        myInitComponents();
    }
    public ManHinhChinh(String username,String id) {
        initComponents();
        executeHQLQuery(HQL);
        home.setBackground(new java.awt.Color(204,204,255));
        tkChinh.setText(username);
        matk.setText(id);
        matk.setVisible(false);
        dnChinh.setVisible(false);
        dkChinh.setVisible(false);
        tkChinh.setVisible(true);
        dxChinh.setVisible(true);
        tkChiTiet.setText(username);
        dnChiTiet.setVisible(false);
        dkChiTiet.setVisible(false);
        tkChiTiet.setVisible(true);
        dxChiTiet.setVisible(true);
        if(username.compareTo("admin")!=0)
        {
            qlhn.setVisible(false);
            qluser.setVisible(false);
        }
    }
    public void myInitComponents()
    {
        executeHQLQuery(HQL);
        home.setBackground(new java.awt.Color(204,204,255));
        dnChinh.setVisible(true);
        dkChinh.setVisible(true);
        matk.setText("đây là mã tk");
        matk.setVisible(false);
        dxChinh.setVisible(false);
        dxChiTiet.setVisible(false);
        tkChinh.setText("đây là tk");
        tkChiTiet.setText("đây là tk");
        tkChinh.setVisible(false);
        tkChiTiet.setVisible(false);
        profile.setVisible(false);
        lsdk.setVisible(false);
        qlhn.setVisible(false);
        qluser.setVisible(false);
        dadk.setVisible(false);
        dnChiTiet.setVisible(true);
        dkChiTiet.setVisible(true);
    }
    public String getMd5(String input) 
    { 
        try { 
  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    } 
    private static String HQL="select h,d.ten from HoiNghi h join h.diaDiem d where h.thoiGianBatDau >= now()";
    private void executeHQLQuery(String hql) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List<Object[]> resultList = q.list();
            displayResult(resultList);
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    private void displayResult(List<Object[]> resultList) {
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Mã hội nghị"); 
        tableHeaders.add("Tên hội nghị"); 
        tableHeaders.add("Mô tả"); 
        tableHeaders.add("Thời gian bắt đầu");
        tableHeaders.add("Thời gian kết thúc"); 
        tableHeaders.add("Địa điểm"); 
        for(Object[] o : resultList) {
            HoiNghi h =(HoiNghi)o[0];
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(h.getId());
            oneRow.add(h.getTen());
            oneRow.add(h.getMoTaNgan());
            oneRow.add(h.getThoiGianBatDau());
            oneRow.add(h.getThoiGianKetThuc());
            oneRow.add(o[1]);
            tableData.add(oneRow);
        }
        resultTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        resultTable.setDefaultEditor(Object.class, null);
        resultTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 18));
        resultTable.setAutoCreateRowSorter(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        manHinhChiTietHoiNghi = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        moTa = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        thamduTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ma = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        diaDiem = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        diaChi = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        batDau = new javax.swing.JLabel();
        ketThuc = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dktd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ten = new javax.swing.JLabel();
        dadk = new javax.swing.JLabel();
        dkdu = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        dnChiTiet = new javax.swing.JButton();
        tkChiTiet = new javax.swing.JLabel();
        dxChiTiet = new javax.swing.JButton();
        dkChiTiet = new javax.swing.JButton();
        dangNhap = new javax.swing.JFrame();
        dn = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        dangKy = new javax.swing.JFrame();
        dk = new javax.swing.JButton();
        usernamedk = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        passdk = new javax.swing.JPasswordField();
        tendk = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        emaildk = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tkChinh = new javax.swing.JLabel();
        dnChinh = new javax.swing.JButton();
        dxChinh = new javax.swing.JButton();
        dkChinh = new javax.swing.JButton();
        matk = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        home = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        profile = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        qlhn = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        qluser = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lsdk = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();

        manHinhChiTietHoiNghi.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        manHinhChiTietHoiNghi.setTitle("Chi tiết hội nghị");
        manHinhChiTietHoiNghi.setMinimumSize(new java.awt.Dimension(966, 468));
        manHinhChiTietHoiNghi.setResizable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        moTa.setEditable(false);
        moTa.setBackground(new java.awt.Color(153, 153, 255));
        moTa.setBorder(null);
        moTa.setDisabledTextColor(new java.awt.Color(0, 51, 51));
        jScrollPane2.setViewportView(moTa);

        thamduTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên người tham dự", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(thamduTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jPanel4.setBackground(new java.awt.Color(102, 102, 255));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("Mã hội nghị");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(jLabel2, gridBagConstraints);

        ma.setText("đây là mã");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(ma, gridBagConstraints);

        jLabel3.setText("Địa điểm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(jLabel3, gridBagConstraints);

        diaDiem.setText("đây là địa điẻm");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(diaDiem, gridBagConstraints);

        jLabel5.setText("Địa chỉ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(jLabel5, gridBagConstraints);

        diaChi.setText("đây là địa chỉ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(diaChi, gridBagConstraints);

        jLabel7.setText("Thời gian từ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(jLabel7, gridBagConstraints);

        batDau.setText("bắt đầu");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        jPanel4.add(batDau, gridBagConstraints);

        ketThuc.setText("kết thúc");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        jPanel4.add(ketThuc, gridBagConstraints);

        jLabel10.setText(" - ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        jPanel4.add(jLabel10, gridBagConstraints);

        dktd.setText("Đăng ký tham dự");
        dktd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dktdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(dktd, gridBagConstraints);

        jLabel4.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        jPanel4.add(jLabel4, gridBagConstraints);

        jLabel6.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        jPanel4.add(jLabel6, gridBagConstraints);

        jLabel19.setText("Tên hội nghị");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(jLabel19, gridBagConstraints);

        ten.setText("đây là tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(ten, gridBagConstraints);

        dadk.setText("Đã đăng ký");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(dadk, gridBagConstraints);

        dkdu.setText("Đã hết chỗ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(dkdu, gridBagConstraints);

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        dnChiTiet.setText("Đăng nhập");
        dnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnChiTietActionPerformed(evt);
            }
        });

        tkChiTiet.setText("đây là tk");

        dxChiTiet.setText("Đăng xuất");
        dxChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dxChiTietActionPerformed(evt);
            }
        });

        dkChiTiet.setText("Đăng ký");
        dkChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dkChiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(tkChiTiet)
                .addGap(18, 18, 18)
                .addComponent(dxChiTiet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dkChiTiet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dnChiTiet)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dnChiTiet)
                    .addComponent(tkChiTiet)
                    .addComponent(dxChiTiet)
                    .addComponent(dkChiTiet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout manHinhChiTietHoiNghiLayout = new javax.swing.GroupLayout(manHinhChiTietHoiNghi.getContentPane());
        manHinhChiTietHoiNghi.getContentPane().setLayout(manHinhChiTietHoiNghiLayout);
        manHinhChiTietHoiNghiLayout.setHorizontalGroup(
            manHinhChiTietHoiNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manHinhChiTietHoiNghiLayout.createSequentialGroup()
                .addGroup(manHinhChiTietHoiNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(manHinhChiTietHoiNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        manHinhChiTietHoiNghiLayout.setVerticalGroup(
            manHinhChiTietHoiNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manHinhChiTietHoiNghiLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, manHinhChiTietHoiNghiLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        dangNhap.setTitle("Đăng nhập");
        dangNhap.setMinimumSize(new java.awt.Dimension(429, 200));
        dangNhap.setResizable(false);

        dn.setText("Đăng nhập");
        dn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnActionPerformed(evt);
            }
        });

        jLabel11.setText("Username");

        jLabel12.setText("Password");

        javax.swing.GroupLayout dangNhapLayout = new javax.swing.GroupLayout(dangNhap.getContentPane());
        dangNhap.getContentPane().setLayout(dangNhapLayout);
        dangNhapLayout.setHorizontalGroup(
            dangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dangNhapLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(dangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGroup(dangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dangNhapLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(username, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                    .addGroup(dangNhapLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(pass)))
                .addGap(32, 32, 32)
                .addComponent(dn)
                .addGap(31, 31, 31))
        );
        dangNhapLayout.setVerticalGroup(
            dangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dangNhapLayout.createSequentialGroup()
                .addGroup(dangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dangNhapLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addGroup(dangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dangNhapLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dangNhapLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(dn)))
                .addGap(90, 90, 90))
        );

        dangKy.setTitle("Đăng ký");
        dangKy.setResizable(false);

        dk.setText("Đăng ký");
        dk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dkActionPerformed(evt);
            }
        });

        jLabel15.setText("Username");

        jLabel16.setText("Password");

        jLabel17.setText("Tên");

        jLabel18.setText("Email");

        javax.swing.GroupLayout dangKyLayout = new javax.swing.GroupLayout(dangKy.getContentPane());
        dangKy.getContentPane().setLayout(dangKyLayout);
        dangKyLayout.setHorizontalGroup(
            dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dangKyLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(dangKyLayout.createSequentialGroup()
                        .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tendk, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emaildk, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dangKyLayout.createSequentialGroup()
                        .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dangKyLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(usernamedk, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                            .addGroup(dangKyLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(passdk)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(dk)
                .addGap(36, 36, 36))
        );
        dangKyLayout.setVerticalGroup(
            dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dangKyLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(usernamedk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dangKyLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(passdk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dangKyLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel17))
                            .addComponent(tendk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(dangKyLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(dk)))
                .addGap(18, 18, 18)
                .addGroup(dangKyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(emaildk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trang chủ");
        setMaximumSize(new java.awt.Dimension(1368, 660));
        setMinimumSize(new java.awt.Dimension(1368, 660));
        setPreferredSize(new java.awt.Dimension(1368, 660));
        setResizable(false);
        setSize(new java.awt.Dimension(1368, 660));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 51));

        tkChinh.setText("đây là tk");

        dnChinh.setText("Đăng nhập");
        dnChinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dnChinhActionPerformed(evt);
            }
        });

        dxChinh.setText("Đăng xuất");
        dxChinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dxChinhActionPerformed(evt);
            }
        });

        dkChinh.setText("Đăng ký");
        dkChinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dkChinhActionPerformed(evt);
            }
        });

        matk.setText("đây là mã tk");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(735, Short.MAX_VALUE)
                .addComponent(matk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tkChinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dxChinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dkChinh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dnChinh)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dxChinh)
                        .addComponent(tkChinh)
                        .addComponent(matk))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dnChinh)
                        .addComponent(dkChinh)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 723;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel1, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(102, 102, 255));

        home.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-home-24 (1).png"))); // NOI18N
        jLabel1.setText("Trang chủ");

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        profile.setBackground(new java.awt.Color(102, 102, 255));
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-male-user-24.png"))); // NOI18N
        jLabel8.setText("Profile");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout profileLayout = new javax.swing.GroupLayout(profile);
        profile.setLayout(profileLayout);
        profileLayout.setHorizontalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profileLayout.setVerticalGroup(
            profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profileLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        qlhn.setBackground(new java.awt.Color(102, 102, 255));
        qlhn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qlhnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                qlhnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                qlhnMouseExited(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-management-24.png"))); // NOI18N
        jLabel14.setText("Quản lý hội nghị");

        javax.swing.GroupLayout qlhnLayout = new javax.swing.GroupLayout(qlhn);
        qlhn.setLayout(qlhnLayout);
        qlhnLayout.setHorizontalGroup(
            qlhnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qlhnLayout.setVerticalGroup(
            qlhnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlhnLayout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        qluser.setBackground(new java.awt.Color(102, 102, 255));
        qluser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qluserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                qluserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                qluserMouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-management-24 (1).png"))); // NOI18N
        jLabel13.setText("Quản lý user");

        javax.swing.GroupLayout qluserLayout = new javax.swing.GroupLayout(qluser);
        qluser.setLayout(qluserLayout);
        qluserLayout.setHorizontalGroup(
            qluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qluserLayout.setVerticalGroup(
            qluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qluserLayout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lsdk.setBackground(new java.awt.Color(102, 102, 255));
        lsdk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsdkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lsdkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lsdkMouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-activity-history-24.png"))); // NOI18N
        jLabel9.setText("Lịch sử đăng ký");

        javax.swing.GroupLayout lsdkLayout = new javax.swing.GroupLayout(lsdk);
        lsdk.setLayout(lsdkLayout);
        lsdkLayout.setHorizontalGroup(
            lsdkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lsdkLayout.setVerticalGroup(
            lsdkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lsdkLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lsdk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(qlhn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(qluser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lsdk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(qlhn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(qluser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 218;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(jPanel6, gridBagConstraints);

        jScrollPane3.setMinimumSize(new java.awt.Dimension(100, 100));

        jTextPane1.setEditable(false);
        jTextPane1.setBackground(new java.awt.Color(204, 204, 255));
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextPane1.setText("Chào mừng bạn đến với phần mềm của chúng tôi. Bạn sẽ có những trải nghiệm tuyệt vời nhất trong việc lựa chọn các cuộc hội nghị sắp diễn ra. Đăng ký tham dự ngay nhé !!");
        jTextPane1.setMaximumSize(null);
        jTextPane1.setMinimumSize(new java.awt.Dimension(85, 100));
        jScrollPane3.setViewportView(jTextPane1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 900;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane3, gridBagConstraints);

        resultTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hội nghị", "Tên hội nghị", "Mô tả", "Thời gian bắt đầu", "Thời gian kêt thúc", "Địa điểm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultTable.setRowHeight(24);
        resultTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(resultTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 973;
        gridBagConstraints.ipady = 470;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dnChinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnChinhActionPerformed
        dangNhap.setVisible(true);
        dangNhap.pack();
        dangNhap.setLocationRelativeTo(null);
        username.setText("");
        pass.setText("");
    }//GEN-LAST:event_dnChinhActionPerformed

    private void dktdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dktdActionPerformed

        if(tkChiTiet.getText().compareTo("đây là tk")==0)
        {
            Object[] options = {"Đã có tài khoản","Chưa có tài khoản"};
            int YesOrNo = JOptionPane.showOptionDialog(null,
            "Bạn có tài khoản chưa ?",
            "Thông báo",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]);
            if(YesOrNo == 0)
            {
                dangNhap.setVisible(true);
                dangNhap.pack();
                dangNhap.setLocationRelativeTo(null);
                username.setText("");
                pass.setText("");
            }
            else
            {
                dangKy.setVisible(true);
                dangKy.pack();
                dangKy.setLocationRelativeTo(null);
                usernamedk.setText("");
                passdk.setText("");
                emaildk.setText("");
                tendk.setText("");
            }
        }
        else
        {
            Object[] options = {"Đồng ý","Hủy"};
            int YesOrNo = JOptionPane.showOptionDialog(null,
            "Xác nhận đăng ký tham dự ?",
            "Thông báo",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[1]);
            if(YesOrNo == 0)
            {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                Query q =session.createSQLQuery("insert into yeu_cau values(null,:idtk,:idhn,'Đang chờ')");
                q.setParameter("idtk",Integer.parseInt(matk.getText()));
                q.setParameter("idhn",Integer.parseInt(ma.getText()));
                q.executeUpdate();
                session.getTransaction().commit();
                JOptionPane.showMessageDialog(null,"Đăng ký tham dự thành công!!.","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                dadk.setVisible(true);
                dktd.setVisible(false);
            }
        }
    }//GEN-LAST:event_dktdActionPerformed

    private void dnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnChiTietActionPerformed
        dangNhap.setVisible(true);
        dangNhap.pack();
        dangNhap.setLocationRelativeTo(null);
        username.setText("");
        pass.setText("");
    }//GEN-LAST:event_dnChiTietActionPerformed

    private void dnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dnActionPerformed
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q =session.createQuery("select t from TaiKhoan t where t.username = :username and t.pass = :pass and t.truyCap = true")
                .setParameter("username",username.getText());
        q.setParameter("pass",getMd5(new String(pass.getPassword())));
        List resultList = q.list();
        session.getTransaction().commit();
        if(resultList.size()>0)
        {
            Object o = resultList.get(0);
            TaiKhoan t = (TaiKhoan)o;
            tkChiTiet.setVisible(true);
            tkChiTiet.setText(t.getUsername());
            matk.setText(t.getId().toString());
            dnChiTiet.setVisible(false);
            dkChinh.setVisible(false);
            dkChiTiet.setVisible(false);
            tkChinh.setVisible(true);
            tkChinh.setText(t.getUsername());
            dnChinh.setVisible(false);
            dangNhap.setVisible(false);
            dxChinh.setVisible(true);
            dxChiTiet.setVisible(true);
            if(t.getUsername().compareTo("admin")==0)
            {
                qlhn.setVisible(true);
                qluser.setVisible(true);
            }
            profile.setVisible(true);
            lsdk.setVisible(true);
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            if(ma.getText().compareTo("đây là mã")!=0)
            {
                q =session.createQuery("from TaiKhoan t join t.yeuCaus y where t.username = :username and y.hoiNghi.id = :id")
                .setParameter("username",username.getText());
                q.setParameter("id", Integer.parseInt(ma.getText()));
                resultList = q.list();
                if(resultList.size()>0)
                {
                    dadk.setVisible(true);
                    dktd.setVisible(false);
                }
                session.getTransaction().commit();
            }
        }
        else JOptionPane.showMessageDialog(null,"Username hoặc password không đúng.","Thông báo",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_dnActionPerformed

    private void dxChinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dxChinhActionPerformed
        myInitComponents();
    }//GEN-LAST:event_dxChinhActionPerformed

    private void dxChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dxChiTietActionPerformed
        myInitComponents();
    }//GEN-LAST:event_dxChiTietActionPerformed

    private void resultTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultTableMouseClicked
        int index = resultTable.getSelectedRow();
        TableModel model = resultTable.getModel();
        String id = model.getValueAt(index, 0).toString();
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Object[]> resultList = session.createQuery("select h,d from HoiNghi h join h.diaDiem d where h.id = :id")
        .setParameter("id",Integer.parseInt(id)).list();
        session.getTransaction().commit();
        Object o = resultList.get(0)[0];
        HoiNghi h = (HoiNghi)o;
        o = resultList.get(0)[1];
        DiaDiem d = (DiaDiem)o;
        manHinhChiTietHoiNghi.setVisible(true);
        manHinhChiTietHoiNghi.pack();
        manHinhChiTietHoiNghi.setLocationRelativeTo(null);
        manHinhChiTietHoiNghi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon(h.getHinhAnh());
        Image img = icon.getImage();
        Image imgScale = img.getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon iconScale = new ImageIcon(imgScale);
        image.setIcon(iconScale);
        ma.setText(h.getId().toString());
        ten.setText(h.getTen());
        diaDiem.setText(d.getTen());
        diaChi.setText(d.getDiaChi());
        batDau.setText(h.getThoiGianBatDau().toString());
        ketThuc.setText(h.getThoiGianKetThuc().toString());
        moTa.setText(h.getMoTaDai());
        dadk.setVisible(false);
        session.beginTransaction();
        List thamdu = session.createQuery("select t from YeuCau y join y.taiKhoan t where y.hoiNghi.id = :id and y.xacNhan = 'Đồng ý'")
        .setParameter("id",Integer.parseInt(id)).list();
        session.getTransaction().commit();
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Tên người tham dự"); 
        tableHeaders.add("Email"); 
        for(Object ob : thamdu) {
            TaiKhoan t =(TaiKhoan)ob;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(t.getTen());
            oneRow.add(t.getEmail());
            tableData.add(oneRow);
        }
        thamduTable.setModel(new DefaultTableModel(tableData, tableHeaders));
        thamduTable.setDefaultEditor(Object.class, null);
        thamduTable.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 18));
        thamduTable.setAutoCreateRowSorter(true);
        session.beginTransaction();
        List songuoidk = session.createQuery("select count(y.taiKhoan.id)  from YeuCau y where y.hoiNghi.id = :id")
        .setParameter("id",Integer.parseInt(id)).list();
        session.getTransaction().commit();
        o = songuoidk.get(0);
        long songuoi_dk = (long)o;
        if(songuoi_dk<d.getSucChua())
        {
            dkdu.setVisible(false);
            dktd.setVisible(true);
        }
        else 
        {
            dkdu.setVisible(true);
            dktd.setVisible(false);
        }
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        if(ma.getText().compareTo("đây là tk")!=0)
        {
            Query q =session.createQuery("from TaiKhoan t join t.yeuCaus y where t.username = :username and y.hoiNghi.id = :id")
                .setParameter("username",tkChinh.getText());
            q.setParameter("id", Integer.parseInt(ma.getText()));
            resultList = q.list();
            if(resultList.size()>0)
            {
                dadk.setVisible(true);
                dktd.setVisible(false);
            }
        }
    }//GEN-LAST:event_resultTableMouseClicked

    private void profileMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseEntered
        profile.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_profileMouseEntered

    private void profileMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseExited
        profile.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_profileMouseExited

    private void qlhnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlhnMouseEntered
        qlhn.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_qlhnMouseEntered

    private void qlhnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlhnMouseExited
        qlhn.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_qlhnMouseExited

    private void qluserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserMouseEntered
        qluser.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_qluserMouseEntered

    private void qluserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserMouseExited
        qluser.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_qluserMouseExited

    private void lsdkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkMouseEntered
        lsdk.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_lsdkMouseEntered

    private void lsdkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkMouseExited
        lsdk.setBackground(new java.awt.Color(102, 102, 255));
    }//GEN-LAST:event_lsdkMouseExited

    private void dkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dkActionPerformed

        if (tendk.getText().trim().isEmpty() || usernamedk.getText().trim().isEmpty() 
                || (new String(passdk.getPassword())).trim().isEmpty() || emaildk.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Không được để trống ô nào cả !!.","Thông báo",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q =session.createQuery("select t from TaiKhoan t where t.username = :username")
                .setParameter("username",usernamedk.getText());
            List resultList = q.list();
            if(resultList.size()>0)
            {
                JOptionPane.showMessageDialog(null,"Username đã tồn tại. Vui lòng nhập username khác!!.","Thông báo",JOptionPane.ERROR_MESSAGE);
                session.getTransaction().rollback();
            }
            else{
                TaiKhoan t = new TaiKhoan(tendk.getText(),usernamedk.getText(),getMd5(new String(passdk.getPassword())),emaildk.getText(),true);
                session.save(t);
                session.getTransaction().commit();
                JOptionPane.showMessageDialog(null,"Đăng ký thành công!!.","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                dangKy.setVisible(false);
            }
        }
    }//GEN-LAST:event_dkActionPerformed

    private void dkChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dkChiTietActionPerformed
        dangKy.setVisible(true);
        dangKy.pack();
        dangKy.setLocationRelativeTo(null);
        usernamedk.setText("");
        passdk.setText("");
        emaildk.setText("");
        tendk.setText("");
    }//GEN-LAST:event_dkChiTietActionPerformed

    private void dkChinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dkChinhActionPerformed
        dangKy.setVisible(true);
        dangKy.pack();
        dangKy.setLocationRelativeTo(null);
        usernamedk.setText("");
        passdk.setText("");
        emaildk.setText("");
        tendk.setText("");
    }//GEN-LAST:event_dkChinhActionPerformed

    private void lsdkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkMouseClicked
        this.setVisible(false);
        new LichSuDangKy(tkChinh.getText(),matk.getText()).setVisible(true);
        manHinhChiTietHoiNghi.setVisible(false);
    }//GEN-LAST:event_lsdkMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
        this.setVisible(false);
        new Profile(tkChinh.getText(),matk.getText()).setVisible(true);
        manHinhChiTietHoiNghi.setVisible(false);
    }//GEN-LAST:event_profileMouseClicked

    private void qluserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserMouseClicked
        this.setVisible(false);
        new QuanLyUser(tkChinh.getText(),matk.getText()).setVisible(true);
        manHinhChiTietHoiNghi.setVisible(false);
    }//GEN-LAST:event_qluserMouseClicked

    private void qlhnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlhnMouseClicked
        this.setVisible(false);
        new QuanLyHoiNghi(tkChinh.getText(),matk.getText()).setVisible(true);
        manHinhChiTietHoiNghi.setVisible(false);
    }//GEN-LAST:event_qlhnMouseClicked

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
            java.util.logging.Logger.getLogger(ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinhChinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhChinh().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel batDau;
    private javax.swing.JLabel dadk;
    private javax.swing.JFrame dangKy;
    private javax.swing.JFrame dangNhap;
    public javax.swing.JLabel diaChi;
    public javax.swing.JLabel diaDiem;
    private javax.swing.JButton dk;
    private javax.swing.JButton dkChiTiet;
    private javax.swing.JButton dkChinh;
    private javax.swing.JLabel dkdu;
    private javax.swing.JButton dktd;
    private javax.swing.JButton dn;
    private javax.swing.JButton dnChiTiet;
    private javax.swing.JButton dnChinh;
    private javax.swing.JButton dxChiTiet;
    private javax.swing.JButton dxChinh;
    private javax.swing.JTextField emaildk;
    private javax.swing.JPanel home;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    public javax.swing.JLabel ketThuc;
    private javax.swing.JPanel lsdk;
    public javax.swing.JLabel ma;
    private javax.swing.JFrame manHinhChiTietHoiNghi;
    private javax.swing.JLabel matk;
    public javax.swing.JTextPane moTa;
    private javax.swing.JPasswordField pass;
    private javax.swing.JPasswordField passdk;
    private javax.swing.JPanel profile;
    private javax.swing.JPanel qlhn;
    private javax.swing.JPanel qluser;
    private javax.swing.JTable resultTable;
    public javax.swing.JLabel ten;
    private javax.swing.JTextField tendk;
    private javax.swing.JTable thamduTable;
    private javax.swing.JLabel tkChiTiet;
    private javax.swing.JLabel tkChinh;
    private javax.swing.JTextField username;
    private javax.swing.JTextField usernamedk;
    // End of variables declaration//GEN-END:variables
}