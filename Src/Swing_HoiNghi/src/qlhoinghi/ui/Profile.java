/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhoinghi.ui;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Query;
import org.hibernate.Session;
import qlhoinghi.entity.TaiKhoan;
import qlhoinghi.util.HibernateUtil;

/**
 *
 * @author admin
 */
public class Profile extends javax.swing.JFrame {

    /**
     * Creates new form Profile
     */
    public Profile() {
        initComponents();
    }
    public Profile(String username,String id) {
        initComponents();
        profilep.setBackground(new java.awt.Color(204,204,255));
        tkP.setText(username);
        matkP.setText(id);
        matkP.setVisible(false);
        if(tkP.getText().compareTo("admin")!=0)
        {
            qlhnp.setVisible(false);
            qluserp.setVisible(false);
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("select t from TaiKhoan t where t.username = :username")
                .setParameter("username", tkP.getText());
        List resultList = q.list();
        session.getTransaction().commit();
        Object o = resultList.get(0);
        TaiKhoan t = (TaiKhoan)o;
        tenprofile.setText(t.getTen());
        emailprofile.setText(t.getEmail());
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel11 = new javax.swing.JPanel();
        homep = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        profilep = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        qlhnp = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        qluserp = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        lsdkp = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        tenprofile = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        emailprofile = new javax.swing.JTextField();
        doitt = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jPanel10 = new javax.swing.JPanel();
        tkP = new javax.swing.JLabel();
        dxLichSu1 = new javax.swing.JButton();
        matkP = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        doipass = new javax.swing.JButton();
        label2 = new java.awt.Label();
        passcu = new javax.swing.JPasswordField();
        passmoi = new javax.swing.JPasswordField();
        xnpassmoi = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profile");
        setResizable(false);

        jPanel11.setBackground(new java.awt.Color(102, 102, 255));

        homep.setBackground(new java.awt.Color(102, 102, 255));
        homep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homepMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homepMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homepMouseExited(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(204, 204, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-home-24 (1).png"))); // NOI18N
        jLabel31.setText("Trang chủ");

        javax.swing.GroupLayout homepLayout = new javax.swing.GroupLayout(homep);
        homep.setLayout(homepLayout);
        homepLayout.setHorizontalGroup(
            homepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        homepLayout.setVerticalGroup(
            homepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homepLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        profilep.setBackground(new java.awt.Color(102, 102, 255));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-male-user-24.png"))); // NOI18N
        jLabel32.setText("Profile");
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout profilepLayout = new javax.swing.GroupLayout(profilep);
        profilep.setLayout(profilepLayout);
        profilepLayout.setHorizontalGroup(
            profilepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profilepLayout.setVerticalGroup(
            profilepLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilepLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel32))
        );

        qlhnp.setBackground(new java.awt.Color(102, 102, 255));
        qlhnp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qlhnpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                qlhnpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                qlhnpMouseExited(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-management-24.png"))); // NOI18N
        jLabel33.setText("Quản lý hội nghị");

        javax.swing.GroupLayout qlhnpLayout = new javax.swing.GroupLayout(qlhnp);
        qlhnp.setLayout(qlhnpLayout);
        qlhnpLayout.setHorizontalGroup(
            qlhnpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        qlhnpLayout.setVerticalGroup(
            qlhnpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlhnpLayout.createSequentialGroup()
                .addComponent(jLabel33)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        qluserp.setBackground(new java.awt.Color(102, 102, 255));
        qluserp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qluserpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                qluserpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                qluserpMouseExited(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-management-24 (1).png"))); // NOI18N
        jLabel34.setText("Quản lý user");

        javax.swing.GroupLayout qluserpLayout = new javax.swing.GroupLayout(qluserp);
        qluserp.setLayout(qluserpLayout);
        qluserpLayout.setHorizontalGroup(
            qluserpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qluserpLayout.setVerticalGroup(
            qluserpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qluserpLayout.createSequentialGroup()
                .addComponent(jLabel34)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lsdkp.setBackground(new java.awt.Color(102, 102, 255));
        lsdkp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsdkpMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lsdkpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lsdkpMouseExited(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-activity-history-24.png"))); // NOI18N
        jLabel35.setText("Lịch sử đăng ký");

        javax.swing.GroupLayout lsdkpLayout = new javax.swing.GroupLayout(lsdkp);
        lsdkp.setLayout(lsdkpLayout);
        lsdkpLayout.setHorizontalGroup(
            lsdkpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lsdkpLayout.setVerticalGroup(
            lsdkpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lsdkpLayout.createSequentialGroup()
                .addComponent(jLabel35)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lsdkp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(profilep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(qlhnp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(qluserp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(homep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(profilep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lsdkp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(qlhnp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(qluserp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel36.setText("Tên");

        jLabel38.setText("Email");

        doitt.setText("Đổi thông tin");
        doitt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doittActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label1.setText("Đổi thông tin cá nhân");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel36)
                        .addGap(38, 38, 38)
                        .addComponent(tenprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(jLabel38)
                        .addGap(18, 18, 18)
                        .addComponent(emailprofile, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(doitt)))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(tenprofile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailprofile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(doitt)
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(1000, 51));

        tkP.setText("đây là tk");

        dxLichSu1.setText("Đăng xuất");
        dxLichSu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dxLichSu1ActionPerformed(evt);
            }
        });

        matkP.setText("đây là mã");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(matkP)
                .addGap(18, 18, 18)
                .addComponent(tkP)
                .addGap(18, 18, 18)
                .addComponent(dxLichSu1)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dxLichSu1)
                    .addComponent(tkP)
                    .addComponent(matkP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel42.setText("Mật khẩu cũ");

        jLabel43.setText("Xác nhận mật khẩu mới");

        jLabel44.setText("Mật khẩu mới");

        doipass.setText("Đổi mật khẩu");
        doipass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doipassActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label2.setText("Đổi mật khẩu");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel42)
                        .addGap(87, 87, 87)
                        .addComponent(passcu, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel43))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(xnpassmoi, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                            .addComponent(passmoi)))))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(343, 343, 343)
                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(361, 361, 361)
                .addComponent(doipass))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(passcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jLabel44))
                    .addComponent(passmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel43)
                    .addComponent(xnpassmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(doipass)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 867, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepMouseClicked
        this.setVisible(false);
        new ManHinhChinh(tkP.getText(),matkP.getText()).setVisible(true);
    }//GEN-LAST:event_homepMouseClicked

    private void homepMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepMouseEntered
        homep.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_homepMouseEntered

    private void homepMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homepMouseExited
        homep.setBackground(new java.awt.Color(102,102,255));
    }//GEN-LAST:event_homepMouseExited

    private void qlhnpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlhnpMouseEntered
        qlhnp.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_qlhnpMouseEntered

    private void qlhnpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlhnpMouseExited
        qlhnp.setBackground(new java.awt.Color(102,102,255));
    }//GEN-LAST:event_qlhnpMouseExited

    private void qluserpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserpMouseEntered
        qluserp.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_qluserpMouseEntered

    private void qluserpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserpMouseExited
        qluserp.setBackground(new java.awt.Color(102,102,255));
    }//GEN-LAST:event_qluserpMouseExited

    private void lsdkpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkpMouseClicked
        this.setVisible(false);
        new LichSuDangKy(tkP.getText(),matkP.getText()).setVisible(true);
    }//GEN-LAST:event_lsdkpMouseClicked

    private void lsdkpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkpMouseEntered
        lsdkp.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_lsdkpMouseEntered

    private void lsdkpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkpMouseExited
        lsdkp.setBackground(new java.awt.Color(102,102,255));
    }//GEN-LAST:event_lsdkpMouseExited

    private void doittActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doittActionPerformed
        if (tenprofile.getText().trim().isEmpty() || emailprofile.getText().trim().isEmpty()) 
            JOptionPane.showMessageDialog(null,"Không được để trống ô nào cả !!.","Thông báo",JOptionPane.ERROR_MESSAGE);
        else
        {
            Object[] options = {"Đồng ý","Hủy"};
            int YesOrNo = JOptionPane.showOptionDialog(null,
                "Xác nhận đổi thông tin ?",
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
                Query q =session.createSQLQuery("update tai_khoan set ten = :ten, email = :email where username = :username");
                q.setParameter("ten",tenprofile.getText());
                q.setParameter("email",emailprofile.getText());
                q.setParameter("username",tkP.getText());
                q.executeUpdate();
                session.getTransaction().commit();
                JOptionPane.showMessageDialog(null,"Đổi thông tin thành công!!.","Thông báo",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_doittActionPerformed

    private void doipassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doipassActionPerformed
        if ((new String(passcu.getPassword())).trim().isEmpty() || (new String(passmoi.getPassword())).trim().isEmpty() 
                || (new String(xnpassmoi.getPassword())).trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,"Không được để trống ô nào cả !!.","Thông báo",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if((new String(passmoi.getPassword())).compareTo((new String(xnpassmoi.getPassword())))!=0)
        {
            JOptionPane.showMessageDialog(null,"Xác nhận mật khẩu mới và mật khẩu mới không giống!!.","Thông báo",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            Object[] options = {"Đồng ý","Hủy"};
            int YesOrNo = JOptionPane.showOptionDialog(null,
                "Xác nhận đổi mật khẩu ?",
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
                Query q =session.createSQLQuery("update tai_khoan set pass = :passmoi where username = :username and pass = :passcu");
                q.setParameter("passmoi",getMd5(new String(passmoi.getPassword())));
                q.setParameter("username",tkP.getText());
                q.setParameter("passcu",getMd5(new String(passcu.getPassword())));
                int i = q.executeUpdate();
                session.getTransaction().commit();
                if(i > 0) 
                {
                    JOptionPane.showMessageDialog(null,"Đổi thông tin thành công, vui lòng đăng nhập lại!!.","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    new ManHinhChinh().setVisible(true);
                }
                else JOptionPane.showMessageDialog(null,"Password cũ không chính xác!!.","Thông báo",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_doipassActionPerformed

    private void dxLichSu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dxLichSu1ActionPerformed
        this.setVisible(false);
        new ManHinhChinh().setVisible(true);
    }//GEN-LAST:event_dxLichSu1ActionPerformed

    private void qluserpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserpMouseClicked
        this.setVisible(false);
        new QuanLyUser(tkP.getText(),matkP.getText()).setVisible(true);
    }//GEN-LAST:event_qluserpMouseClicked

    private void qlhnpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qlhnpMouseClicked
        this.setVisible(false);
        new QuanLyHoiNghi(tkP.getText(),matkP.getText()).setVisible(true);
    }//GEN-LAST:event_qlhnpMouseClicked

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doipass;
    private javax.swing.JButton doitt;
    private javax.swing.JButton dxLichSu1;
    private javax.swing.JTextField emailprofile;
    private javax.swing.JPanel homep;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private javax.swing.JPanel lsdkp;
    private javax.swing.JLabel matkP;
    private javax.swing.JPasswordField passcu;
    private javax.swing.JPasswordField passmoi;
    private javax.swing.JPanel profilep;
    private javax.swing.JPanel qlhnp;
    private javax.swing.JPanel qluserp;
    private javax.swing.JTextField tenprofile;
    private javax.swing.JLabel tkP;
    private javax.swing.JPasswordField xnpassmoi;
    // End of variables declaration//GEN-END:variables
}
