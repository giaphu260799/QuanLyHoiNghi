/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhoinghi.ui;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class ManHinhChiTietHoinghi extends javax.swing.JFrame {

    /**
     * Creates new form ManHinhChiTietHoinghi
     */
    public ManHinhChiTietHoinghi() {
        initComponents();
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

        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
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
        jPanel10 = new javax.swing.JPanel();
        tkChiTiet = new javax.swing.JLabel();
        dxChiTiet = new javax.swing.JButton();
        matkChiTiet = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        moTa2 = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(1000, 51));

        tkChiTiet.setText("đây là tk");

        dxChiTiet.setText("Đăng xuất");
        dxChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dxChiTietActionPerformed(evt);
            }
        });

        matkChiTiet.setText("đây là mã");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addComponent(matkChiTiet)
                .addGap(31, 31, 31)
                .addComponent(tkChiTiet)
                .addGap(18, 18, 18)
                .addComponent(dxChiTiet)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dxChiTiet)
                    .addComponent(tkChiTiet)
                    .addComponent(matkChiTiet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(153, 153, 255));

        moTa2.setEditable(false);
        moTa2.setBackground(new java.awt.Color(153, 153, 255));
        moTa2.setBorder(null);
        moTa2.setDisabledTextColor(new java.awt.Color(0, 51, 51));
        jScrollPane4.setViewportView(moTa2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 482, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 421, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dktdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dktdActionPerformed

        /*if(tkChiTiet.getText().compareTo("đây là tk")==0)
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
        }*/
    }//GEN-LAST:event_dktdActionPerformed

    private void dxChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dxChiTietActionPerformed
        this.setVisible(false);
        new ManHinhChinh().setVisible(true);
    }//GEN-LAST:event_dxChiTietActionPerformed

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
            java.util.logging.Logger.getLogger(ManHinhChiTietHoinghi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManHinhChiTietHoinghi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManHinhChiTietHoinghi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManHinhChiTietHoinghi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManHinhChiTietHoinghi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel batDau;
    private javax.swing.JLabel dadk;
    public javax.swing.JLabel diaChi;
    public javax.swing.JLabel diaDiem;
    private javax.swing.JLabel dkdu;
    private javax.swing.JButton dktd;
    private javax.swing.JButton dxChiTiet;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JLabel ketThuc;
    public javax.swing.JLabel ma;
    private javax.swing.JLabel matkChiTiet;
    public javax.swing.JTextPane moTa;
    public javax.swing.JTextPane moTa1;
    public javax.swing.JTextPane moTa2;
    public javax.swing.JLabel ten;
    private javax.swing.JLabel tkChiTiet;
    // End of variables declaration//GEN-END:variables
}