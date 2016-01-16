package kutuphane;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hatice Ertürk
 */
public class uye_ekle extends javax.swing.JFrame {

    private Connection baglanti;
    private Statement ifade;
    //private ResultSet sonucKumesi;
    
    public uye_ekle() {
        initComponents();
        baslangic();
        DBBaglan();
    }

    private void baslangic(){
        buttonGroup1.add(jRadioButtonOgrenci);
        buttonGroup1.add(jRadioButtonOgretmen);
        buttonGroup1.add(jRadioButtonDisaridan);
        jPanelOgrenci.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jPanelDisaridan.setVisible(false);
    }
    
    private void DBBaglan(){
        String baglantiUrl = "jdbc:derby://localhost:1527/Kutuphane";
        String userName = "hatice";
        String password = "123";
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            baglanti = DriverManager.getConnection(baglantiUrl,userName,password);
            ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonOgrenci = new javax.swing.JRadioButton();
        jRadioButtonOgretmen = new javax.swing.JRadioButton();
        jRadioButtonDisaridan = new javax.swing.JRadioButton();
        jPanelOgrenci = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldOkulNumarasi = new javax.swing.JTextField();
        jTextFieldOgrAd = new javax.swing.JTextField();
        jTextFieldOgrSoyad = new javax.swing.JTextField();
        jTextFieldOgrMail = new javax.swing.JTextField();
        jButtonOgrenciEkle = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldOgrBolum = new javax.swing.JTextField();
        jTextFieldOgrParola = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jPanelOgretmen = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldOgretmenTC = new javax.swing.JTextField();
        jTextFieldOgretmenAD = new javax.swing.JTextField();
        jTextfieldOgretmenSoyad = new javax.swing.JTextField();
        jTextFieldOgretmenMail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldOgretmenClsYer = new javax.swing.JTextField();
        jButtonOgretmenEkle = new javax.swing.JButton();
        jTextFieldOgretmenParola = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jPanelDisaridan = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldDisaridanTC = new javax.swing.JTextField();
        jTextFieldDisaridanAD = new javax.swing.JTextField();
        jTextFieldDisaridanSoyad = new javax.swing.JTextField();
        jTextFieldDisaridanMail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldDisaridanEv = new javax.swing.JTextField();
        jButtonDisaridanEkle = new javax.swing.JButton();
        jTextFieldDisaridanParola = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setLocation(new java.awt.Point(450, 150));
        setPreferredSize(new java.awt.Dimension(577, 500));
        setResizable(false);

        jLabel2.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel2.setText("Yeni Üye Oluştur");

        jLabel6.setText("Oluşturmak İstediğiniz Üyenin Tipini Seçiniz");

        jRadioButtonOgrenci.setText("ÖĞRENCİ");
        jRadioButtonOgrenci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOgrenciActionPerformed(evt);
            }
        });

        jRadioButtonOgretmen.setText("ÖĞRETMEN");
        jRadioButtonOgretmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOgretmenActionPerformed(evt);
            }
        });

        jRadioButtonDisaridan.setText("DIŞARIDAN");
        jRadioButtonDisaridan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDisaridanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel1.setText("Öğrenci Okul Numarası          : ");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel3.setText("Öğrenci Adı                              : ");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel4.setText(" Öğrenci Soyadı                       :");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel5.setText("Öğrenci Mail Adresi                 :");

        jTextFieldOgrSoyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOgrSoyadActionPerformed(evt);
            }
        });

        jButtonOgrenciEkle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonOgrenciEkle.setText("OLUŞTUR");
        jButtonOgrenciEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOgrenciEkleActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel7.setText("Öğrencinin Okuduğu Bölüm    :");

        jLabel18.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel18.setText("Parola                                       :");

        javax.swing.GroupLayout jPanelOgrenciLayout = new javax.swing.GroupLayout(jPanelOgrenci);
        jPanelOgrenci.setLayout(jPanelOgrenciLayout);
        jPanelOgrenciLayout.setHorizontalGroup(
            jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jButtonOgrenciEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOgrenciLayout.createSequentialGroup()
                                    .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel5))
                                    .addGap(26, 26, 26))
                                .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(29, 29, 29)))
                            .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldOkulNumarasi)
                            .addComponent(jTextFieldOgrAd)
                            .addComponent(jTextFieldOgrSoyad)
                            .addComponent(jTextFieldOgrMail)
                            .addComponent(jTextFieldOgrBolum)
                            .addComponent(jTextFieldOgrParola, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
                .addGap(0, 68, Short.MAX_VALUE))
        );
        jPanelOgrenciLayout.setVerticalGroup(
            jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldOkulNumarasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldOgrAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOgrSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldOgrMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldOgrBolum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOgrParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jButtonOgrenciEkle))
        );

        jLabel8.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel8.setText("Öğretmen TC Numarası             : ");

        jLabel9.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel9.setText("Öğretmen Adı                              : ");

        jLabel10.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel10.setText(" Öğretmen Soyadı                        :");

        jLabel11.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel11.setText("Öğretmen Mail Adresi                 :");

        jTextfieldOgretmenSoyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextfieldOgretmenSoyadActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel12.setText("Öğretmenin Çalıştığı Yer            :");

        jButtonOgretmenEkle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonOgretmenEkle.setText("OLUŞTUR");
        jButtonOgretmenEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOgretmenEkleActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel19.setText("Parola                                          :");

        javax.swing.GroupLayout jPanelOgretmenLayout = new javax.swing.GroupLayout(jPanelOgretmen);
        jPanelOgretmen.setLayout(jPanelOgretmenLayout);
        jPanelOgretmenLayout.setHorizontalGroup(
            jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jButtonOgretmenEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOgretmenLayout.createSequentialGroup()
                                    .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel11))
                                    .addGap(26, 26, 26))
                                .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addGap(29, 29, 29)))
                            .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldOgretmenTC)
                            .addComponent(jTextFieldOgretmenAD)
                            .addComponent(jTextfieldOgretmenSoyad)
                            .addComponent(jTextFieldOgretmenMail, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jTextFieldOgretmenClsYer)
                            .addComponent(jTextFieldOgretmenParola))))
                .addGap(0, 68, Short.MAX_VALUE))
        );
        jPanelOgretmenLayout.setVerticalGroup(
            jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldOgretmenTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldOgretmenAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextfieldOgretmenSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldOgretmenMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldOgretmenClsYer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldOgretmenParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonOgretmenEkle)
                .addGap(296, 296, 296))
        );

        jLabel21.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel21.setText("TC Numarası                 : ");

        jLabel22.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel22.setText("Adı                                  : ");

        jLabel23.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel23.setText(" Soyadı                           :");

        jLabel24.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel24.setText("Mail Adresi                    :");

        jTextFieldDisaridanSoyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDisaridanSoyadActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel25.setText("Ev Adresi                       :");

        jButtonDisaridanEkle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonDisaridanEkle.setText("OLUŞTUR");
        jButtonDisaridanEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisaridanEkleActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel26.setText("Parola                            :");

        javax.swing.GroupLayout jPanelDisaridanLayout = new javax.swing.GroupLayout(jPanelDisaridan);
        jPanelDisaridan.setLayout(jPanelDisaridanLayout);
        jPanelDisaridanLayout.setHorizontalGroup(
            jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDisaridanLayout.createSequentialGroup()
                                    .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel22)
                                        .addComponent(jLabel24))
                                    .addGap(26, 26, 26))
                                .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addGap(29, 29, 29)))
                            .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel26))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldDisaridanTC)
                            .addComponent(jTextFieldDisaridanAD)
                            .addComponent(jTextFieldDisaridanSoyad)
                            .addComponent(jTextFieldDisaridanMail, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jTextFieldDisaridanEv)
                            .addComponent(jTextFieldDisaridanParola)))
                    .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jButtonDisaridanEkle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 68, Short.MAX_VALUE))
        );
        jPanelDisaridanLayout.setVerticalGroup(
            jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextFieldDisaridanTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextFieldDisaridanAD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDisaridanSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addGap(18, 18, 18)
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextFieldDisaridanMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jTextFieldDisaridanEv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldDisaridanParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonDisaridanEkle)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jRadioButtonOgrenci)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonOgretmen)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonDisaridan))
                            .addComponent(jPanelOgrenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelOgretmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelDisaridan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonOgrenci)
                    .addComponent(jRadioButtonOgretmen)
                    .addComponent(jRadioButtonDisaridan))
                .addGap(12, 12, 12)
                .addComponent(jPanelOgrenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOgretmen, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDisaridan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOgrenciEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOgrenciEkleActionPerformed
        // Bu butona tiklanildiginda kullanicidan alinan bilgiler sql ile veritabanina islenecek.
        String okul_no = jTextFieldOkulNumarasi.getText();
        //sql injection bırakıldı.
        //okul_no = okul_no.replace("'", "seni gidi küçük heçkır ");
        String ad = jTextFieldOgrAd.getText();
        String soyad = jTextFieldOgrSoyad.getText();
        String mail = jTextFieldOgrMail.getText();
        String bolum = jTextFieldOgrBolum.getText();
        String parola = jTextFieldOgrParola.getText();
        
        try {
            String sql = "insert into OGRENCI_UYE values('"+okul_no+"','"+ad+"','"+soyad+"','"+mail+"','"+bolum+"','"+parola+"')";
            ifade.executeUpdate(sql);
            
            /*sonucKumesi.moveToInsertRow();//Kaydın ekleneceği yeni satıra git demek.
            sonucKumesi.updateString("OKUL_NO",okul_no);
            sonucKumesi.updateString("ADI",ad);
            sonucKumesi.updateString("SOYAD",soyad);
            sonucKumesi.updateString("MAIL",mail);
            sonucKumesi.updateString("BOLUM",bolum);
            sonucKumesi.updateString("PAROLA",parola);
            sonucKumesi.insertRow();//Kaydı tabloya ekle demek.
            sonucKumesi.close();
            */
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.dispose();
    }//GEN-LAST:event_jButtonOgrenciEkleActionPerformed

    private void jTextFieldOgrSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOgrSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOgrSoyadActionPerformed

    private void jRadioButtonOgrenciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOgrenciActionPerformed
        jPanelDisaridan.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jPanelOgrenci.setVisible(true);
    }//GEN-LAST:event_jRadioButtonOgrenciActionPerformed

    private void jTextfieldOgretmenSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextfieldOgretmenSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextfieldOgretmenSoyadActionPerformed

    private void jButtonOgretmenEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOgretmenEkleActionPerformed
        //alinan veriler veritabanina eklenecek.
        
        String tc = jTextFieldOgretmenTC.getText();
        //sql injection bırakıldı.
        //tc = tc.replace("'", "seni gidi küçük heçkır ");
        String ad = jTextFieldOgretmenAD.getText();
        String soyad = jTextfieldOgretmenSoyad.getText();
        String mail = jTextFieldOgretmenMail.getText();
        String clsYer = jTextFieldOgretmenClsYer.getText();
        String parola = jTextFieldOgretmenParola.getText();
        
        try {
            String sql = "insert into OGRETMEN_UYE values('"+tc+"','"+ad+"','"+soyad+"','"+mail+"','"+clsYer+"','"+parola+"')";
            ifade.executeUpdate(sql);        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_jButtonOgretmenEkleActionPerformed

    private void jRadioButtonOgretmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOgretmenActionPerformed
        jPanelDisaridan.setVisible(false);
        jPanelOgrenci.setVisible(false);
        jPanelOgretmen.setVisible(true);
    }//GEN-LAST:event_jRadioButtonOgretmenActionPerformed

    private void jTextFieldDisaridanSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDisaridanSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDisaridanSoyadActionPerformed

    private void jButtonDisaridanEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisaridanEkleActionPerformed
        //alinan veriler veritabanina eklenecek.
        String tc = jTextFieldDisaridanTC.getText();
        //sql injection bırakıldı.
        //tc = tc.replace("'", "seni gidi küçük heçkır ");
        String ad = jTextFieldDisaridanAD.getText();
        String soyad = jTextFieldDisaridanSoyad.getText();
        String mail = jTextFieldDisaridanMail.getText();
        String ev = jTextFieldDisaridanEv.getText();
        String parola = jTextFieldDisaridanParola.getText();
        
        try {
            String sql = "insert into DISARIDAN_UYE values('"+tc+"','"+ad+"','"+soyad+"','"+mail+"','"+ev+"','"+parola+"')";
            ifade.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_jButtonDisaridanEkleActionPerformed

    private void jRadioButtonDisaridanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDisaridanActionPerformed
        jPanelOgrenci.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jPanelDisaridan.setVisible(true);
    }//GEN-LAST:event_jRadioButtonDisaridanActionPerformed

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
            java.util.logging.Logger.getLogger(uye_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uye_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uye_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uye_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uye_ekle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonDisaridanEkle;
    private javax.swing.JButton jButtonOgrenciEkle;
    private javax.swing.JButton jButtonOgretmenEkle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelDisaridan;
    private javax.swing.JPanel jPanelOgrenci;
    private javax.swing.JPanel jPanelOgretmen;
    private javax.swing.JRadioButton jRadioButtonDisaridan;
    private javax.swing.JRadioButton jRadioButtonOgrenci;
    private javax.swing.JRadioButton jRadioButtonOgretmen;
    private javax.swing.JTextField jTextFieldDisaridanAD;
    private javax.swing.JTextField jTextFieldDisaridanEv;
    private javax.swing.JTextField jTextFieldDisaridanMail;
    private javax.swing.JTextField jTextFieldDisaridanParola;
    private javax.swing.JTextField jTextFieldDisaridanSoyad;
    private javax.swing.JTextField jTextFieldDisaridanTC;
    private javax.swing.JTextField jTextFieldOgrAd;
    private javax.swing.JTextField jTextFieldOgrBolum;
    private javax.swing.JTextField jTextFieldOgrMail;
    private javax.swing.JTextField jTextFieldOgrParola;
    private javax.swing.JTextField jTextFieldOgrSoyad;
    private javax.swing.JTextField jTextFieldOgretmenAD;
    private javax.swing.JTextField jTextFieldOgretmenClsYer;
    private javax.swing.JTextField jTextFieldOgretmenMail;
    private javax.swing.JTextField jTextFieldOgretmenParola;
    private javax.swing.JTextField jTextFieldOgretmenTC;
    private javax.swing.JTextField jTextFieldOkulNumarasi;
    private javax.swing.JTextField jTextfieldOgretmenSoyad;
    // End of variables declaration//GEN-END:variables
}
