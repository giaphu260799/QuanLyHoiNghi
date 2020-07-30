/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlhoinghi.ui;

import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.hibernate.Session;
import org.hibernate.Query;
import qlhoinghi.entity.DiaDiem;
import qlhoinghi.entity.HoiNghi;
import qlhoinghi.entity.YeuCau;
import qlhoinghi.entity.TaiKhoan;
import qlhoinghi.util.HibernateUtil;

/**
 *
 * @author admin
 */
public class QuanLyHoiNghi extends javax.swing.JFrame {
    public SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public SimpleDateFormat sdt = new SimpleDateFormat("HH:mm:ss");
    /**
     * Creates new form QuanLyHoiNghi
     */
    public QuanLyHoiNghi() {
        initComponents();
    }
    public QuanLyHoiNghi(String username,String id)
    {
        initComponents();
        tkHn.setText(username);
        matkHn.setText(id);
        matkHn.setVisible(false);
        dxHn.setVisible(true);
        qlhnh.setBackground(new java.awt.Color(204,204,255));
        displayTable();
    }
    public void displayTable()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select h, d from HoiNghi h join h.diaDiem d order by h.thoiGianBatDau DESC";
        Query q = session.createQuery(hql);
        List<Object[]> resultList = q.list();
        session.getTransaction().commit();
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Mã hội nghị");
        tableHeaders.add("Tên hội nghị");
        tableHeaders.add("Thời gian bắt đầu");
        tableHeaders.add("Thời gian kết thúc");
        tableHeaders.add("Địa điểm");
        tableHeaders.add("Số người tham dự");
        tableHeaders.add("Sức chứa");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();
        for(Object[] o : resultList) {
            HoiNghi h =(HoiNghi)o[0];
            DiaDiem d =(DiaDiem)o[1];
            Vector<Object> oneRow = new Vector<Object>();
            if(h.getThoiGianBatDau().toString().compareTo(dtf.format(now))>0 
                    && ((DefaultComboBoxModel)masua.getModel()).getIndexOf(h.getId().toString()) == -1)
                masua.addItem(h.getId().toString());
            oneRow.add(h.getId());
            oneRow.add(h.getTen());
            oneRow.add(h.getThoiGianBatDau());
            oneRow.add(h.getThoiGianKetThuc());
            oneRow.add(d.getTen());
            oneRow.add(h.getSoNguoiThamDu());
            oneRow.add(d.getSucChua());
            tableData.add(oneRow);
        }
        resultTableu.setModel(new DefaultTableModel(tableData, tableHeaders));
        resultTableu.setDefaultEditor(Object.class, null);
        resultTableu.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 18));
        resultTableu.setAutoCreateRowSorter(true);
    }
    void displayBangYeuCau()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select y from YeuCau y where y.xacNhan = 'Đang chờ'";
        Query q = session.createQuery(hql);
        List resultList = q.list();
        session.getTransaction().commit();
        Vector<String> tableHeaders = new Vector<String>();
        Vector tableData = new Vector();
        tableHeaders.add("Mã hội nghị");
        tableHeaders.add("Mã tài khoản");
        for(Object o : resultList) {
            YeuCau y =(YeuCau)o;
            Vector<Object> oneRow = new Vector<Object>();
            oneRow.add(y.getHoiNghi().getId());
            oneRow.add(y.getTaiKhoan().getId());
            tableData.add(oneRow);
        }
        bangyeucau.setModel(new DefaultTableModel(tableData, tableHeaders));
        bangyeucau.setDefaultEditor(Object.class, null);
        bangyeucau.getTableHeader().setFont(new java.awt.Font("Tahoma", 0, 18));
        bangyeucau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

        chonanh = new javax.swing.JFileChooser();
        suahoinghi = new javax.swing.JFrame();
        jLabel44 = new javax.swing.JLabel();
        motangansua = new javax.swing.JTextField();
        ngaybdsua = new com.toedter.calendar.JDateChooser();
        tensua = new javax.swing.JTextField();
        Date date2 = new Date();
        SpinnerDateModel sm2 =
        new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
        timebdsua = new javax.swing.JSpinner(sm2);
        jLabel43 = new javax.swing.JLabel();
        Date date3 = new Date();
        SpinnerDateModel sm3 =
        new SpinnerDateModel(date3, null, null, Calendar.HOUR_OF_DAY);
        timektsua = new javax.swing.JSpinner(sm3);
        jLabel40 = new javax.swing.JLabel();
        masua = new javax.swing.JComboBox<>();
        urlsua = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        chon1 = new javax.swing.JButton();
        diadiemsua = new javax.swing.JComboBox<>();
        ngayktsua = new com.toedter.calendar.JDateChooser();
        sua = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        motadaisua = new javax.swing.JTextArea();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        duyetyeucau = new javax.swing.JFrame();
        jScrollPane6 = new javax.swing.JScrollPane();
        bangyeucau = new javax.swing.JTable();
        yes = new javax.swing.JButton();
        no = new javax.swing.JButton();
        manHinhChiTietHoiNghi = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        ten1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        homeh = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        profileh = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        qlhnh = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        qluserh = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        lsdkh = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        tkHn = new javax.swing.JLabel();
        dxHn = new javax.swing.JButton();
        matkHn = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        ten = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        diadiem = new javax.swing.JComboBox<>();
        them = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        motangan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        motadai = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        chon = new javax.swing.JButton();
        url = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        ngaybd = new com.toedter.calendar.JDateChooser();
        ngaykt = new com.toedter.calendar.JDateChooser();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        timebd = new javax.swing.JSpinner(sm);
        Date date1 = new Date();
        SpinnerDateModel sm1 =
        new SpinnerDateModel(date1, null, null, Calendar.HOUR_OF_DAY);
        timekt = new javax.swing.JSpinner(sm1);
        jScrollPane5 = new javax.swing.JScrollPane();
        resultTableu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        suadoi = new javax.swing.JButton();
        xemyc = new javax.swing.JButton();

        suahoinghi.setTitle("Sửa hội nghị");
        suahoinghi.setMinimumSize(new java.awt.Dimension(776, 431));
        suahoinghi.setResizable(false);

        jLabel44.setText("Mô tả chi tiết");

        JTextFieldDateEditor editor2 = (JTextFieldDateEditor) ngaybdsua.getDateEditor();
        editor2.setEditable(false);

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(timebdsua, "HH:mm:ss");
        timebdsua.setEditor(de2);
        ((DefaultEditor) timebdsua.getEditor()).getTextField().setEditable(false);

        jLabel43.setText("Hình ảnh");

        JSpinner.DateEditor kt1 = new JSpinner.DateEditor(timektsua, "HH:mm:ss");
        timektsua.setEditor(kt1);
        ((DefaultEditor) timektsua.getEditor()).getTextField().setEditable(false);

        jLabel40.setText("Thời gian bắt đầu");

        masua.setToolTipText("");
        masua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                masuaItemStateChanged(evt);
            }
        });

        urlsua.setEditable(false);

        jLabel42.setText("Địa điểm");

        jLabel41.setText("Thời gian kết thúc");

        jLabel38.setText("Mã hội nghị");

        chon1.setText("Chọn");
        chon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chon1ActionPerformed(evt);
            }
        });

        diadiemsua.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ĐH KHTN CS2", "ĐH KHTN CS1", "Nhà Văn Hóa Sinh Viên" }));
        diadiemsua.setToolTipText("");

        JTextFieldDateEditor editor3 = (JTextFieldDateEditor) ngayktsua.getDateEditor();
        editor3.setEditable(false);

        sua.setText("Sửa");
        sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suaActionPerformed(evt);
            }
        });

        motadaisua.setColumns(20);
        motadaisua.setRows(5);
        jScrollPane2.setViewportView(motadaisua);

        jLabel37.setText("Mô tả ngắn");

        jLabel39.setText("Tên hội nghị");

        javax.swing.GroupLayout suahoinghiLayout = new javax.swing.GroupLayout(suahoinghi.getContentPane());
        suahoinghi.getContentPane().setLayout(suahoinghiLayout);
        suahoinghiLayout.setHorizontalGroup(
            suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suahoinghiLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(suahoinghiLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39))
                        .addGap(47, 47, 47)
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tensua, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(suahoinghiLayout.createSequentialGroup()
                                .addComponent(masua, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(178, 178, 178)
                                .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel37)
                                    .addComponent(motangansua, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(jLabel44)
                                    .addComponent(jScrollPane2)))))
                    .addGroup(suahoinghiLayout.createSequentialGroup()
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel41)
                                .addComponent(jLabel40))
                            .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel43)
                                .addComponent(jLabel42)))
                        .addGap(18, 18, 18)
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(suahoinghiLayout.createSequentialGroup()
                                .addComponent(urlsua, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(chon1))
                            .addGroup(suahoinghiLayout.createSequentialGroup()
                                .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ngayktsua, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addComponent(ngaybdsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timebdsua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timektsua, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(diadiemsua, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(50, 50, 50))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suahoinghiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sua)
                .addGap(340, 340, 340))
        );
        suahoinghiLayout.setVerticalGroup(
            suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, suahoinghiLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(suahoinghiLayout.createSequentialGroup()
                        .addComponent(ngaybdsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41)
                            .addComponent(ngayktsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timektsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(diadiemsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel43)
                            .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(urlsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(chon1))))
                    .addGroup(suahoinghiLayout.createSequentialGroup()
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(masua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel39)
                            .addComponent(tensua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(motangansua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel40)
                            .addGroup(suahoinghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(timebdsua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel44)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addGap(42, 42, 42)
                .addComponent(sua)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        duyetyeucau.setTitle("Xem xét các yêu câu");
        duyetyeucau.setMinimumSize(new java.awt.Dimension(623, 426));
        duyetyeucau.setResizable(false);

        bangyeucau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bangyeucau.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã hội nghị", "Mã tài khoản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangyeucau.setRowHeight(24);
        jScrollPane6.setViewportView(bangyeucau);

        yes.setText("Đồng ý");
        yes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yesActionPerformed(evt);
            }
        });

        no.setText("Không đồng ý");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout duyetyeucauLayout = new javax.swing.GroupLayout(duyetyeucau.getContentPane());
        duyetyeucau.getContentPane().setLayout(duyetyeucauLayout);
        duyetyeucauLayout.setHorizontalGroup(
            duyetyeucauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(duyetyeucauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(duyetyeucauLayout.createSequentialGroup()
                .addGap(165, 165, 165)
                .addComponent(yes)
                .addGap(130, 130, 130)
                .addComponent(no)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        duyetyeucauLayout.setVerticalGroup(
            duyetyeucauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(duyetyeucauLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(duyetyeucauLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yes)
                    .addComponent(no))
                .addGap(23, 23, 23))
        );

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
        jScrollPane3.setViewportView(moTa);

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
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
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

        ten1.setText("đây là tên");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        jPanel4.add(ten1, gridBagConstraints);

        javax.swing.GroupLayout manHinhChiTietHoiNghiLayout = new javax.swing.GroupLayout(manHinhChiTietHoiNghi.getContentPane());
        manHinhChiTietHoiNghi.getContentPane().setLayout(manHinhChiTietHoiNghiLayout);
        manHinhChiTietHoiNghiLayout.setHorizontalGroup(
            manHinhChiTietHoiNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manHinhChiTietHoiNghiLayout.createSequentialGroup()
                .addGroup(manHinhChiTietHoiNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        manHinhChiTietHoiNghiLayout.setVerticalGroup(
            manHinhChiTietHoiNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manHinhChiTietHoiNghiLayout.createSequentialGroup()
                .addGroup(manHinhChiTietHoiNghiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, manHinhChiTietHoiNghiLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý hội nghị");

        jPanel11.setBackground(new java.awt.Color(102, 102, 255));

        homeh.setBackground(new java.awt.Color(102, 102, 255));
        homeh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homehMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homehMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homehMouseExited(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(204, 204, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-home-24 (1).png"))); // NOI18N
        jLabel31.setText("Trang chủ");

        javax.swing.GroupLayout homehLayout = new javax.swing.GroupLayout(homeh);
        homeh.setLayout(homehLayout);
        homehLayout.setHorizontalGroup(
            homehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        homehLayout.setVerticalGroup(
            homehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homehLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        profileh.setBackground(new java.awt.Color(102, 102, 255));
        profileh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilehMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilehMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilehMouseExited(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-male-user-24.png"))); // NOI18N
        jLabel32.setText("Profile");
        jLabel32.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout profilehLayout = new javax.swing.GroupLayout(profileh);
        profileh.setLayout(profilehLayout);
        profilehLayout.setHorizontalGroup(
            profilehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        profilehLayout.setVerticalGroup(
            profilehLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, profilehLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel32))
        );

        qlhnh.setBackground(new java.awt.Color(102, 102, 255));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-management-24.png"))); // NOI18N
        jLabel33.setText("Quản lý hội nghị");

        javax.swing.GroupLayout qlhnhLayout = new javax.swing.GroupLayout(qlhnh);
        qlhnh.setLayout(qlhnhLayout);
        qlhnhLayout.setHorizontalGroup(
            qlhnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        qlhnhLayout.setVerticalGroup(
            qlhnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qlhnhLayout.createSequentialGroup()
                .addComponent(jLabel33)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        qluserh.setBackground(new java.awt.Color(102, 102, 255));
        qluserh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                qluserhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                qluserhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                qluserhMouseExited(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-management-24 (1).png"))); // NOI18N
        jLabel34.setText("Quản lý user");

        javax.swing.GroupLayout qluserhLayout = new javax.swing.GroupLayout(qluserh);
        qluserh.setLayout(qluserhLayout);
        qluserhLayout.setHorizontalGroup(
            qluserhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        qluserhLayout.setVerticalGroup(
            qluserhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qluserhLayout.createSequentialGroup()
                .addComponent(jLabel34)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        lsdkh.setBackground(new java.awt.Color(102, 102, 255));
        lsdkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lsdkhMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lsdkhMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lsdkhMouseExited(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-activity-history-24.png"))); // NOI18N
        jLabel35.setText("Lịch sử đăng ký");

        javax.swing.GroupLayout lsdkhLayout = new javax.swing.GroupLayout(lsdkh);
        lsdkh.setLayout(lsdkhLayout);
        lsdkhLayout.setHorizontalGroup(
            lsdkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        lsdkhLayout.setVerticalGroup(
            lsdkhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lsdkhLayout.createSequentialGroup()
                .addComponent(jLabel35)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lsdkh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(profileh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(qlhnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(qluserh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(homeh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(profileh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lsdkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(qlhnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(qluserh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(1000, 51));

        tkHn.setText("đây là tk");

        dxHn.setText("Đăng xuất");
        dxHn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dxHnActionPerformed(evt);
            }
        });

        matkHn.setText("đây là mã");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(matkHn)
                .addGap(31, 31, 31)
                .addComponent(tkHn)
                .addGap(18, 18, 18)
                .addComponent(dxHn)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dxHn)
                    .addComponent(tkHn)
                    .addComponent(matkHn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel25.setText("Tên hội nghị");

        jLabel26.setText("Mô tả chi tiết");

        jLabel27.setText("Địa điểm");

        jLabel30.setText("Hình ảnh");

        diadiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ĐH KHTN CS2", "ĐH KHTN CS1", "Nhà Văn Hóa Sinh Viên" }));
        diadiem.setToolTipText("");

        them.setText("Thêm");
        them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themActionPerformed(evt);
            }
        });

        jLabel28.setText("Mô tả ngắn");

        motadai.setColumns(20);
        motadai.setRows(5);
        jScrollPane1.setViewportView(motadai);

        jLabel29.setText("Thời gian bắt đầu");

        chon.setText("Chọn");
        chon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonActionPerformed(evt);
            }
        });

        url.setEditable(false);

        jLabel36.setText("Thời gian kết thúc");

        JTextFieldDateEditor editor = (JTextFieldDateEditor) ngaybd.getDateEditor();
        editor.setEditable(false);

        JTextFieldDateEditor editor1 = (JTextFieldDateEditor) ngaykt.getDateEditor();
        editor1.setEditable(false);

        JSpinner.DateEditor de = new JSpinner.DateEditor(timebd, "HH:mm:ss");
        timebd.setEditor(de);
        ((DefaultEditor) timebd.getEditor()).getTextField().setEditable(false);

        JSpinner.DateEditor kt = new JSpinner.DateEditor(timekt, "HH:mm:ss");
        timekt.setEditor(kt);
        ((DefaultEditor) timekt.getEditor()).getTextField().setEditable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(52, 52, 52)
                        .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(diadiem, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel30))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(motangan, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addGap(21, 21, 21)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ngaybd, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ngaykt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(timekt, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(164, 164, 164)
                                .addComponent(them))
                            .addComponent(timebd, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(motangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chon))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel36))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(them)
                                .addGap(24, 24, 24))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel27)
                                .addComponent(diadiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(ngaybd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(ngaykt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(timebd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(timekt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        resultTableu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        resultTableu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hội nghị", "Tên hội nghị", "Thời gian bắt đầu", "Thời gian kết thúc", "Địa điêm", "Số người tham dự", "Sức chứa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resultTableu.setRowHeight(24);
        resultTableu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resultTableuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(resultTableu);
        if (resultTableu.getColumnModel().getColumnCount() > 0) {
            resultTableu.getColumnModel().getColumn(6).setResizable(false);
        }

        suadoi.setText("Sửa đổi hội nghị");
        suadoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suadoiActionPerformed(evt);
            }
        });

        xemyc.setText("Xem xét các yêu cầu");
        xemyc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xemycActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(457, 457, 457)
                .addComponent(suadoi)
                .addGap(85, 85, 85)
                .addComponent(xemyc)
                .addContainerGap(422, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(suadoi)
                    .addComponent(xemyc))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 1240, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homehMouseClicked
        this.setVisible(false);
        new ManHinhChinh(tkHn.getText(),matkHn.getText()).setVisible(true);
    }//GEN-LAST:event_homehMouseClicked

    private void homehMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homehMouseEntered
        homeh.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_homehMouseEntered

    private void homehMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homehMouseExited
        homeh.setBackground(new java.awt.Color(102,102,255));
    }//GEN-LAST:event_homehMouseExited

    private void profilehMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilehMouseClicked
        this.setVisible(false);
        new Profile(tkHn.getText(),matkHn.getText()).setVisible(true);
    }//GEN-LAST:event_profilehMouseClicked

    private void profilehMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilehMouseEntered
        profileh.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_profilehMouseEntered

    private void profilehMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilehMouseExited
        profileh.setBackground(new java.awt.Color(102,102,255));
    }//GEN-LAST:event_profilehMouseExited

    private void lsdkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkhMouseClicked
        this.setVisible(false);
        new LichSuDangKy(tkHn.getText(),matkHn.getText()).setVisible(true);
    }//GEN-LAST:event_lsdkhMouseClicked

    private void lsdkhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkhMouseEntered
        lsdkh.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_lsdkhMouseEntered

    private void lsdkhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lsdkhMouseExited
        lsdkh.setBackground(new java.awt.Color(102,102,255));
    }//GEN-LAST:event_lsdkhMouseExited

    private void dxHnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dxHnActionPerformed
        this.setVisible(false);
        new ManHinhChinh().setVisible(true);
    }//GEN-LAST:event_dxHnActionPerformed

    private void themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themActionPerformed
         if (ten.getText().trim().isEmpty() || motangan.getText().trim().isEmpty()|| motadai.getText().trim().isEmpty()
                || url.getText().trim().isEmpty()|| ngaybd.getDate()== null || ngaykt.getDate()== null) 
            JOptionPane.showMessageDialog(null,"Không được để trống ô nào cả !!.","Thông báo",JOptionPane.ERROR_MESSAGE);
        else
        {
            Object valuetimebd = timebd.getValue();
            Date tgbd = (Date)valuetimebd;
            Object valuetimekt = timekt.getValue();
            String ngaybatdau = sdf.format(ngaybd.getDate())+" "+sdt.format(tgbd);
            Date tgkt = (Date)valuetimekt;
            String ngayketthuc = sdf.format(ngaykt.getDate())+" "+sdt.format(tgkt);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();
            if(ngaybatdau.compareTo(ngayketthuc)>=0 || ngaybatdau.compareTo(dtf.format(now))<0)
            {
                JOptionPane.showMessageDialog(null,"Thời gian kết thúc phải lớn hơn thời gian bắt đầu và cả 2 phải lớn hơn thời gian hiện tại!!.","Thông báo",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                Session session = HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                String hql = "select h from HoiNghi h where ('" + ngaybatdau + "' between h.thoiGianBatDau and h.thoiGianKetThuc "
                        + "or '" + ngayketthuc +"' between h.thoiGianBatDau and h.thoiGianKetThuc "
                        + "or ('" + ngayketthuc +"' > (select MAX(thoiGianKetThuc) from  HoiNghi where diaDiem.id = :id) and '" + ngaybatdau +"' < (select MAX(thoiGianKetThuc) from  HoiNghi where diaDiem.id = :id))"
                        + "or ('" + ngaybatdau +"' < (select MIN(thoiGianBatDau) from  HoiNghi where diaDiem.id = :id)and '" + ngayketthuc +"' > (select MIN(thoiGianBatDau) from  HoiNghi where diaDiem.id = :id)))"
                        + " and h.diaDiem.id = :id";
                System.out.println(ngaybatdau);
                Query q = session.createQuery(hql);
                q.setParameter("id",diadiem.getSelectedIndex()+1);
                List resultList = q.list();
                session.getTransaction().commit();
                if(resultList.size()>0)
                {
                    JOptionPane.showMessageDialog(null,"Thời gian đụng với hội nghị khác!!.","Thông báo",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Object[] options = {"Đồng ý","Hủy"};
                int YesOrNo = JOptionPane.showOptionDialog(null,
                    "Xác nhận thêm hội nghị ?",
                    "Thông báo",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[1]);
                if(YesOrNo == 0)
                {
                    session.beginTransaction();
                    q =session.createSQLQuery("insert into hoi_nghi values(null,:ten,:motangan,:motadai,:url,:ngaybd,:ngaykt,:diadiem,0)");
                    q.setParameter("ten",ten.getText());
                    q.setParameter("motangan",motangan.getText());
                    q.setParameter("motadai",motadai.getText());
                    q.setParameter("url",url.getText());
                    q.setParameter("ngaybd",ngaybatdau);
                    q.setParameter("ngaykt",ngayketthuc);
                    q.setParameter("diadiem",diadiem.getSelectedIndex()+1);
                    q.executeUpdate();
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null,"Thêm hội nghị thành công!!.","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    displayTable();
                }
            }
        }
    }//GEN-LAST:event_themActionPerformed

    private void suadoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suadoiActionPerformed
        suahoinghi.setLocationRelativeTo(null);
        suahoinghi.setVisible(true);
    }//GEN-LAST:event_suadoiActionPerformed

    private void qluserhMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserhMouseEntered
        qluserh.setBackground(new java.awt.Color(204,204,255));
    }//GEN-LAST:event_qluserhMouseEntered

    private void qluserhMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserhMouseExited
        qluserh.setBackground(new java.awt.Color(102,102,255));
    }//GEN-LAST:event_qluserhMouseExited

    private void qluserhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_qluserhMouseClicked
        this.setVisible(false);
        new QuanLyUser(tkHn.getText(),matkHn.getText()).setVisible(true);
    }//GEN-LAST:event_qluserhMouseClicked

    private void chonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonActionPerformed
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        chonanh.setFileFilter(imageFilter);
        chonanh.showDialog(this, "Chọn ảnh");
        if(chonanh.getSelectedFile()!=null)
            url.setText(chonanh.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_chonActionPerformed

    private void xemycActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xemycActionPerformed
        duyetyeucau.setLocationRelativeTo(null);
        duyetyeucau.setVisible(true);
        displayBangYeuCau();
    }//GEN-LAST:event_xemycActionPerformed

    private void chon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chon1ActionPerformed
        FileFilter imageFilter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
        chonanh.setFileFilter(imageFilter);
        chonanh.showDialog(this, "Chọn ảnh");
        if(chonanh.getSelectedFile()!=null)
            urlsua.setText(chonanh.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_chon1ActionPerformed

    private void suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suaActionPerformed
        if (tensua.getText().trim().isEmpty() || motangansua.getText().trim().isEmpty()|| motadaisua.getText().trim().isEmpty()) 
            JOptionPane.showMessageDialog(null,"Không được để trống ô nào cả !!.","Thông báo",JOptionPane.ERROR_MESSAGE);
        else
        {
            Object valuetimebd = timebdsua.getValue();
            Date tgbd = (Date)valuetimebd;
            Object valuetimekt = timektsua.getValue();
            String ngaybatdau = sdf.format(ngaybdsua.getDate())+" "+sdt.format(tgbd);
            Date tgkt = (Date)valuetimekt;
            String ngayketthuc = sdf.format(ngayktsua.getDate())+" "+sdt.format(tgkt);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
            LocalDateTime now = LocalDateTime.now();
            if(ngaybatdau.compareTo(ngayketthuc)>=0 || ngaybatdau.compareTo(dtf.format(now))<0)
            {
                JOptionPane.showMessageDialog(null,"Thời gian kết thúc phải lớn hơn thời gian bắt đầu và cả 2 phải lớn hơn thời gian hiện tại!!.","Thông báo",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                Object[] options = {"Đồng ý","Hủy"};
                int YesOrNo = JOptionPane.showOptionDialog(null,
                    "Xác nhận sửa hội nghị ?",
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
                    Query q =session.createSQLQuery("update hoi_nghi set ten = :ten, mo_ta_ngan = :motangan, mo_ta_dai = :motadai,"
                            + " hinh_anh = :url, thoi_gian_bat_dau = :ngaybd,thoi_gian_ket_thuc = :ngaykt,dia_diem = :diadiem where id = :id");
                    q.setParameter("ten",tensua.getText());
                    q.setParameter("motangan",motangansua.getText());
                    q.setParameter("motadai",motadaisua.getText());
                    q.setParameter("url",urlsua.getText());
                    q.setParameter("ngaybd",ngaybatdau);
                    q.setParameter("ngaykt",ngayketthuc);
                    q.setParameter("diadiem",diadiemsua.getSelectedIndex()+1);
                    q.setParameter("id",Integer.parseInt(masua.getSelectedItem().toString()));
                    q.executeUpdate();
                    session.getTransaction().commit();
                    JOptionPane.showMessageDialog(null,"Sửa hội nghị thành công!!.","Thông báo",JOptionPane.INFORMATION_MESSAGE);
                    displayTable();
                }
            }
        }
    }//GEN-LAST:event_suaActionPerformed

    private void masuaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_masuaItemStateChanged
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select h from HoiNghi h where h.id = :id";
        Query q = session.createQuery(hql);
        q.setParameter("id", Integer.parseInt(masua.getSelectedItem().toString()));
        List resultList = q.list();
        session.getTransaction().commit();
        for(Object o : resultList) {
            HoiNghi h =(HoiNghi)o;
            tensua.setText(h.getTen());
            motangansua.setText(h.getMoTaNgan());
            motadaisua.setText(h.getMoTaDai());
            urlsua.setText(h.getHinhAnh());
            ngaybdsua.setDate(h.getThoiGianBatDau());
            ngayktsua.setDate(h.getThoiGianKetThuc());
            timebdsua.setValue(h.getThoiGianBatDau());
            timektsua.setValue(h.getThoiGianKetThuc());
            diadiemsua.setSelectedIndex(h.getDiaDiem().getId()-1);
        }
    }//GEN-LAST:event_masuaItemStateChanged

    private void yesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yesActionPerformed
        DefaultTableModel model = (DefaultTableModel)bangyeucau.getModel();
        int selectedRowIndex = bangyeucau.getSelectedRow();
        if(bangyeucau.getSelectedRow()==-1)
            return;
        int idhn = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        int idtk = Integer.parseInt(model.getValueAt(selectedRowIndex, 1).toString());
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select h, d from HoiNghi h join h.diaDiem d where h.id = :id";
        Query q = session.createQuery(hql);
        q.setParameter("id", idhn);
        List<Object[]> resultList = q.list();
        session.getTransaction().commit();
        HoiNghi h = (HoiNghi)resultList.get(0)[0];
        DiaDiem d = (DiaDiem)resultList.get(0)[1];
        if(h.getSoNguoiThamDu()<d.getSucChua())
        {
            session.beginTransaction();
            q = session.createSQLQuery("update yeu_cau set xac_nhan = 'Đồng ý' where id_tk = :idtk and id_hn = :idhn");
            q.setParameter("idtk", idtk);
            q.setParameter("idhn", idhn);
            q.executeUpdate();
            q = session.createSQLQuery("update hoi_nghi set so_nguoi_tham_du = so_nguoi_tham_du + 1 where id = :idhn");
            q.setParameter("idhn", idhn);
            q.executeUpdate();
            session.getTransaction().commit();
            displayBangYeuCau();
            displayTable();
        }
        else
            JOptionPane.showMessageDialog(null,"Không đủ sức chứa!!.","Thông báo",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_yesActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        DefaultTableModel model = (DefaultTableModel)bangyeucau.getModel();
        int selectedRowIndex = bangyeucau.getSelectedRow();
        if(bangyeucau.getSelectedRow()==-1)
            return;
        int idhn = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        int idtk = Integer.parseInt(model.getValueAt(selectedRowIndex, 1).toString());
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "select h, d from HoiNghi h join h.diaDiem d where h.id = :id";
        Query q = session.createQuery(hql);
        q.setParameter("id", idhn);
        List<Object[]> resultList = q.list();
        session.getTransaction().commit();
        HoiNghi h = (HoiNghi)resultList.get(0)[0];
        DiaDiem d = (DiaDiem)resultList.get(0)[1];
        session.beginTransaction();
        q = session.createSQLQuery("update yeu_cau set xac_nhan = 'Không đồng ý' where id_tk = :idtk and id_hn = :idhn");
        q.setParameter("idtk", idtk);
        q.setParameter("idhn", idhn);
        q.executeUpdate();
        session.getTransaction().commit();
        displayBangYeuCau();
    }//GEN-LAST:event_noActionPerformed

    private void resultTableuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resultTableuMouseClicked
        int index = resultTableu.getSelectedRow();
        TableModel model = resultTableu.getModel();
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
    }//GEN-LAST:event_resultTableuMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyHoiNghi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoiNghi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoiNghi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHoiNghi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyHoiNghi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangyeucau;
    public javax.swing.JLabel batDau;
    private javax.swing.JButton chon;
    private javax.swing.JButton chon1;
    private javax.swing.JFileChooser chonanh;
    public javax.swing.JLabel diaChi;
    public javax.swing.JLabel diaDiem;
    private javax.swing.JComboBox<String> diadiem;
    private javax.swing.JComboBox<String> diadiemsua;
    private javax.swing.JFrame duyetyeucau;
    private javax.swing.JButton dxHn;
    private javax.swing.JPanel homeh;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JLabel ketThuc;
    private javax.swing.JPanel lsdkh;
    public javax.swing.JLabel ma;
    private javax.swing.JFrame manHinhChiTietHoiNghi;
    private javax.swing.JComboBox<String> masua;
    private javax.swing.JLabel matkHn;
    public javax.swing.JTextPane moTa;
    private javax.swing.JTextArea motadai;
    private javax.swing.JTextArea motadaisua;
    private javax.swing.JTextField motangan;
    private javax.swing.JTextField motangansua;
    private com.toedter.calendar.JDateChooser ngaybd;
    private com.toedter.calendar.JDateChooser ngaybdsua;
    private com.toedter.calendar.JDateChooser ngaykt;
    private com.toedter.calendar.JDateChooser ngayktsua;
    private javax.swing.JButton no;
    private javax.swing.JPanel profileh;
    private javax.swing.JPanel qlhnh;
    private javax.swing.JPanel qluserh;
    private javax.swing.JTable resultTableu;
    private javax.swing.JButton sua;
    private javax.swing.JButton suadoi;
    private javax.swing.JFrame suahoinghi;
    private javax.swing.JTextField ten;
    public javax.swing.JLabel ten1;
    private javax.swing.JTextField tensua;
    private javax.swing.JTable thamduTable;
    private javax.swing.JButton them;
    private javax.swing.JSpinner timebd;
    private javax.swing.JSpinner timebdsua;
    private javax.swing.JSpinner timekt;
    private javax.swing.JSpinner timektsua;
    private javax.swing.JLabel tkHn;
    private javax.swing.JTextField url;
    private javax.swing.JTextField urlsua;
    private javax.swing.JButton xemyc;
    private javax.swing.JButton yes;
    // End of variables declaration//GEN-END:variables
}
