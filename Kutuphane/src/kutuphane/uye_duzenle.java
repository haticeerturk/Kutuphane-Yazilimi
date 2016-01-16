package kutuphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hatice Ertürk
 */
public class uye_duzenle extends javax.swing.JFrame {
    private Connection baglanti;
    private Statement ifade;
    
    public uye_duzenle() {
        initComponents();
        baslangic();
        DBBaglan();
    }
    
    private void baslangic(){
        buttonGroup1.add(jRadioButtonOgrenci);
        buttonGroup1.add(jRadioButtonOgretmen);
        buttonGroup1.add(jRadioButtonDisaridan);
        jPanelAraOgrenci.setVisible(false);
        jPanelAraOgretmen.setVisible(false);
        jPanelAraDisaridan.setVisible(false);
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
        jLabel1 = new javax.swing.JLabel();
        jRadioButtonOgrenci = new javax.swing.JRadioButton();
        jRadioButtonOgretmen = new javax.swing.JRadioButton();
        jRadioButtonDisaridan = new javax.swing.JRadioButton();
        jPanelOgrenciArama = new javax.swing.JPanel();
        jPanelOgrenci = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldOgrAd = new javax.swing.JTextField();
        jTextFieldOgrSoyad = new javax.swing.JTextField();
        jTextFieldOgrMail = new javax.swing.JTextField();
        jButtonOgrenciGuncelle = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldOgrBolum = new javax.swing.JTextField();
        jTextFieldOgrParola = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabelOgrNumara = new javax.swing.JLabel();
        jPanelAraOgrenci = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldOgrNo = new javax.swing.JTextField();
        jButtonOgrenciAra = new javax.swing.JButton();
        jPanelOgretmen = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextOgretmenAd = new javax.swing.JTextField();
        jTextOgretmenSoyad = new javax.swing.JTextField();
        jTextFieldOgretmenMail = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldOgretmenClsYer = new javax.swing.JTextField();
        jButtonOgretmenGuncelle = new javax.swing.JButton();
        jTextFieldOgretmenParola = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabelOgretmenTC = new javax.swing.JLabel();
        jPanelAraOgretmen = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldOgretmenAra = new javax.swing.JTextField();
        jButtonOgretmenAra = new javax.swing.JButton();
        jPanelAraDisaridan = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldDisaridanTCAra = new javax.swing.JTextField();
        jButtonDisaridanAra = new javax.swing.JButton();
        jPanelDisaridan = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldDisaridanAD = new javax.swing.JTextField();
        jTextFieldDisaridanSoyad = new javax.swing.JTextField();
        jTextFieldDisaridanMail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextFieldDisaridanEv = new javax.swing.JTextField();
        jButtonDisaridanGuncelle = new javax.swing.JButton();
        jTextFieldDisaridanParola = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabelDisaridanTC = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(350, 100));
        setPreferredSize(new java.awt.Dimension(511, 600));
        setResizable(false);

        jLabel1.setText("Düzenleme Yapacağınız Üyenin Tipini Seçin");

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

        jLabel2.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel2.setText("Öğrenci Okul Numarası          : ");

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

        jButtonOgrenciGuncelle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonOgrenciGuncelle.setText("GÜNCELLE");
        jButtonOgrenciGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOgrenciGuncelleActionPerformed(evt);
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
                        .addComponent(jButtonOgrenciGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOgrenciLayout.createSequentialGroup()
                                    .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
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
                            .addComponent(jTextFieldOgrAd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldOgrSoyad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldOgrMail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                            .addComponent(jTextFieldOgrBolum, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldOgrParola, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelOgrNumara, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 66, Short.MAX_VALUE))
        );
        jPanelOgrenciLayout.setVerticalGroup(
            jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jLabelOgrNumara, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jButtonOgrenciGuncelle))
        );

        jLabel6.setText("Öğrenci Okul Numarasını Girin : ");

        jTextFieldOgrNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOgrNoActionPerformed(evt);
            }
        });

        jButtonOgrenciAra.setText("ARA");
        jButtonOgrenciAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOgrenciAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAraOgrenciLayout = new javax.swing.GroupLayout(jPanelAraOgrenci);
        jPanelAraOgrenci.setLayout(jPanelAraOgrenciLayout);
        jPanelAraOgrenciLayout.setHorizontalGroup(
            jPanelAraOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAraOgrenciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldOgrNo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOgrenciAra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAraOgrenciLayout.setVerticalGroup(
            jPanelAraOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAraOgrenciLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelAraOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jTextFieldOgrNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOgrenciAra))
                .addGap(22, 22, 22))
        );

        jLabel8.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel8.setText("Öğretmen TC Numarası             : ");

        jLabel9.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel9.setText("Öğretmen Adı                              : ");

        jLabel10.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel10.setText(" Öğretmen Soyadı                        :");

        jLabel11.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel11.setText("Öğretmen Mail Adresi                 :");

        jTextOgretmenSoyad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextOgretmenSoyadActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel12.setText("Öğretmenin Çalıştığı Yer            :");

        jButtonOgretmenGuncelle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonOgretmenGuncelle.setText("GÜNCELLE");
        jButtonOgretmenGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOgretmenGuncelleActionPerformed(evt);
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
                            .addComponent(jTextOgretmenAd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextOgretmenSoyad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldOgretmenMail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldOgretmenClsYer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jTextFieldOgretmenParola, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelOgretmenTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButtonOgretmenGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanelOgretmenLayout.setVerticalGroup(
            jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jLabelOgretmenTC, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextOgretmenAd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextOgretmenSoyad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(18, 18, 18)
                .addComponent(jButtonOgretmenGuncelle)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel13.setText("Öğretmen TC Numarasını Girin :");

        jButtonOgretmenAra.setText("ARA");
        jButtonOgretmenAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOgretmenAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAraOgretmenLayout = new javax.swing.GroupLayout(jPanelAraOgretmen);
        jPanelAraOgretmen.setLayout(jPanelAraOgretmenLayout);
        jPanelAraOgretmenLayout.setHorizontalGroup(
            jPanelAraOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAraOgretmenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldOgretmenAra, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonOgretmenAra)
                .addGap(22, 22, 22))
        );
        jPanelAraOgretmenLayout.setVerticalGroup(
            jPanelAraOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAraOgretmenLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelAraOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOgretmenAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOgretmenAra))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel14.setText("TC Numarasını Girin : ");

        jButtonDisaridanAra.setText("ARA");
        jButtonDisaridanAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisaridanAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAraDisaridanLayout = new javax.swing.GroupLayout(jPanelAraDisaridan);
        jPanelAraDisaridan.setLayout(jPanelAraDisaridanLayout);
        jPanelAraDisaridanLayout.setHorizontalGroup(
            jPanelAraDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAraDisaridanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(67, 67, 67)
                .addComponent(jTextFieldDisaridanTCAra, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonDisaridanAra)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAraDisaridanLayout.setVerticalGroup(
            jPanelAraDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAraDisaridanLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanelAraDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldDisaridanTCAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDisaridanAra))
                .addContainerGap(29, Short.MAX_VALUE))
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

        jButtonDisaridanGuncelle.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonDisaridanGuncelle.setText("GÜNCELLE");
        jButtonDisaridanGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisaridanGuncelleActionPerformed(evt);
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
                            .addComponent(jTextFieldDisaridanAD)
                            .addComponent(jTextFieldDisaridanSoyad)
                            .addComponent(jTextFieldDisaridanMail, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jTextFieldDisaridanEv)
                            .addComponent(jTextFieldDisaridanParola)
                            .addComponent(jLabelDisaridanTC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jButtonDisaridanGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 108, Short.MAX_VALUE))
        );
        jPanelDisaridanLayout.setVerticalGroup(
            jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel21)
                    .addComponent(jLabelDisaridanTC, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jButtonDisaridanGuncelle)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelOgrenciAramaLayout = new javax.swing.GroupLayout(jPanelOgrenciArama);
        jPanelOgrenciArama.setLayout(jPanelOgrenciAramaLayout);
        jPanelOgrenciAramaLayout.setHorizontalGroup(
            jPanelOgrenciAramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgrenciAramaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOgrenciAramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelAraOgrenci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelOgretmen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAraOgretmen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelAraDisaridan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelOgrenci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDisaridan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanelOgrenciAramaLayout.setVerticalGroup(
            jPanelOgrenciAramaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOgrenciAramaLayout.createSequentialGroup()
                .addComponent(jPanelAraOgrenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAraOgretmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelAraDisaridan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOgrenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOgretmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDisaridan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelOgrenciArama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioButtonOgrenci)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonOgretmen)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButtonDisaridan)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonOgrenci)
                    .addComponent(jRadioButtonOgretmen)
                    .addComponent(jRadioButtonDisaridan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOgrenciArama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldOgrSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOgrSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOgrSoyadActionPerformed

    private void jButtonOgrenciGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOgrenciGuncelleActionPerformed
        // Bu butona tiklanildiginda kullanicidan alinan bilgiler sql ile veritabanina islenecek.
        String okul_no = jLabelOgrNumara.getText();
        //sql injection bırakıldı.
        //okul_no = okul_no.replace("'", "seni gidi küçük heçkır ");
        String ad = jTextFieldOgrAd.getText();
        String soyad = jTextFieldOgrSoyad.getText();
        String mail = jTextFieldOgrMail.getText();
        String bolum = jTextFieldOgrBolum.getText();
        String parola = jTextFieldOgrParola.getText();
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "update OGRENCI_UYE set ADI='"+ad+"', SOYAD='"+soyad+"', MAIL='"+mail+"', BOLUM='"
                            +bolum+"', PAROLA='"+parola+"' where OKUL_NO='"+okul_no+"'";
            ifade.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.dispose();
    }//GEN-LAST:event_jButtonOgrenciGuncelleActionPerformed

    private void jRadioButtonOgrenciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOgrenciActionPerformed
        jPanelAraOgrenci.setVisible(true);
        jPanelAraOgretmen.setVisible(false);
        jPanelAraDisaridan.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jPanelOgrenci.setVisible(false);
    }//GEN-LAST:event_jRadioButtonOgrenciActionPerformed

    private void jTextFieldOgrNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOgrNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOgrNoActionPerformed

    private void jButtonOgrenciAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOgrenciAraActionPerformed
        jPanelAraOgrenci.setVisible(false);
        jPanelOgrenci.setVisible(true);
        String ogr_no = jTextFieldOgrNo.getText();
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "select * from OGRENCI_UYE where OKUL_NO='"+ogr_no+"'";
            ResultSet rs = ifade.executeQuery(sql);
            rs.next();
            jLabelOgrNumara.setText(rs.getString("OKUL_NO"));
            jTextFieldOgrAd.setText(rs.getString("ADI"));
            jTextFieldOgrSoyad.setText(rs.getString("SOYAD"));
            jTextFieldOgrMail.setText(rs.getString("MAIL"));
            jTextFieldOgrBolum.setText(rs.getString("BOLUM"));
            jTextFieldOgrParola.setText(rs.getString("PAROLA"));
        } catch (SQLException ex) {
            Logger.getLogger(uye_duzenle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(uye_duzenle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonOgrenciAraActionPerformed

    private void jTextOgretmenSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextOgretmenSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextOgretmenSoyadActionPerformed

    private void jButtonOgretmenGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOgretmenGuncelleActionPerformed
        //alinan veriler veritabanina eklenecek.
        
        String ogretmen_tc = jLabelOgretmenTC.getText();
        //sql injection bırakıldı.
        //ogretmen_tc = ogretmen_tc.replace("'", "seni gidi küçük heçkır ");
        String ad = jTextOgretmenAd.getText();
        String soyad = jTextOgretmenSoyad.getText();
        String mail = jTextFieldOgretmenMail.getText();
        String cls_yer = jTextFieldOgretmenClsYer.getText();
        String parola = jTextFieldOgretmenParola.getText();
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "update OGRETMEN_UYE set AD='"+ad+"', SOYAD='"+soyad+"', MAIL='"+mail+"', CALISTIGI_YER='"
                            +cls_yer+"', PAROLA='"+parola+"' where TC='"+ogretmen_tc+"'";
            ifade.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.dispose();
    }//GEN-LAST:event_jButtonOgretmenGuncelleActionPerformed

    private void jRadioButtonOgretmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOgretmenActionPerformed
        jPanelAraOgretmen.setVisible(true);
        jPanelAraOgrenci.setVisible(false);
        jPanelAraDisaridan.setVisible(false);
        jPanelOgrenci.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jPanelDisaridan.setVisible(false);
    }//GEN-LAST:event_jRadioButtonOgretmenActionPerformed

    private void jTextFieldDisaridanSoyadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDisaridanSoyadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDisaridanSoyadActionPerformed

    private void jButtonDisaridanGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisaridanGuncelleActionPerformed
        //alinan veriler veritabanina eklenecek.
        
        String tc = jLabelDisaridanTC.getText();
        //sql injection bırakıldı.
        //tc = tc.replace("'", "seni gidi küçük heçkır ");
        String ad = jTextFieldDisaridanAD.getText();
        String soyad = jTextFieldDisaridanSoyad.getText();
        String mail = jTextFieldDisaridanMail.getText();
        String ev = jTextFieldDisaridanEv.getText();
        String parola = jTextFieldDisaridanParola.getText();
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "update DISARIDAN_UYE set AD='"+ad+"', SOYAD='"+soyad+"', MAIL='"+mail+"', EV_ADRES='"
                            +ev+"', PAROLA='"+parola+"' where TC='"+tc+"'";
            ifade.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.dispose();
    }//GEN-LAST:event_jButtonDisaridanGuncelleActionPerformed

    private void jButtonOgretmenAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOgretmenAraActionPerformed
        jPanelAraOgretmen.setVisible(false);
        jPanelOgretmen.setVisible(true);
        String ogretmen_tc = jTextFieldOgretmenAra.getText();
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "select * from OGRETMEN_UYE where TC='"+ogretmen_tc+"'";
            ResultSet rs = ifade.executeQuery(sql);
            rs.next();
            jLabelOgretmenTC.setText(rs.getString("TC"));
            jTextOgretmenAd.setText(rs.getString("AD"));
            jTextOgretmenSoyad.setText(rs.getString("SOYAD"));
            jTextFieldOgretmenMail.setText(rs.getString("MAIL"));
            jTextFieldOgretmenClsYer.setText(rs.getString("CALISTIGI_YER"));
            jTextFieldOgretmenParola.setText(rs.getString("PAROLA"));
        } catch (SQLException ex) {
            Logger.getLogger(uye_duzenle.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(uye_duzenle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonOgretmenAraActionPerformed

    private void jRadioButtonDisaridanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDisaridanActionPerformed
        jPanelAraDisaridan.setVisible(true);
        jPanelAraOgrenci.setVisible(false);
        jPanelAraOgretmen.setVisible(false);
        jPanelOgrenci.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jPanelDisaridan.setVisible(false);
    }//GEN-LAST:event_jRadioButtonDisaridanActionPerformed

    private void jButtonDisaridanAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisaridanAraActionPerformed
        jPanelAraDisaridan.setVisible(false);
        jPanelAraOgrenci.setVisible(false);
        jPanelAraOgretmen.setVisible(false);
        jPanelOgrenci.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jPanelDisaridan.setVisible(true);
        
        String tc = jTextFieldDisaridanTCAra.getText();
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "select * from DISARIDAN_UYE where TC='"+tc+"'";
            ResultSet rs = ifade.executeQuery(sql);
            rs.next();
            jLabelDisaridanTC.setText(rs.getString("TC"));
            jTextFieldDisaridanAD.setText(rs.getString("AD"));
            jTextFieldDisaridanSoyad.setText(rs.getString("SOYAD"));
            jTextFieldDisaridanMail.setText(rs.getString("MAIL"));
            jTextFieldDisaridanEv.setText(rs.getString("EV_ADRES"));
            jTextFieldDisaridanParola.setText(rs.getString("PAROLA"));
        } catch (SQLException ex) {
            Logger.getLogger(uye_duzenle.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(uye_duzenle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonDisaridanAraActionPerformed

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
            java.util.logging.Logger.getLogger(uye_duzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uye_duzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uye_duzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uye_duzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uye_duzenle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonDisaridanAra;
    private javax.swing.JButton jButtonDisaridanGuncelle;
    private javax.swing.JButton jButtonOgrenciAra;
    private javax.swing.JButton jButtonOgrenciGuncelle;
    private javax.swing.JButton jButtonOgretmenAra;
    private javax.swing.JButton jButtonOgretmenGuncelle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JLabel jLabelDisaridanTC;
    private javax.swing.JLabel jLabelOgrNumara;
    private javax.swing.JLabel jLabelOgretmenTC;
    private javax.swing.JPanel jPanelAraDisaridan;
    private javax.swing.JPanel jPanelAraOgrenci;
    private javax.swing.JPanel jPanelAraOgretmen;
    private javax.swing.JPanel jPanelDisaridan;
    private javax.swing.JPanel jPanelOgrenci;
    private javax.swing.JPanel jPanelOgrenciArama;
    private javax.swing.JPanel jPanelOgretmen;
    private javax.swing.JRadioButton jRadioButtonDisaridan;
    private javax.swing.JRadioButton jRadioButtonOgrenci;
    private javax.swing.JRadioButton jRadioButtonOgretmen;
    private javax.swing.JTextField jTextFieldDisaridanAD;
    private javax.swing.JTextField jTextFieldDisaridanEv;
    private javax.swing.JTextField jTextFieldDisaridanMail;
    private javax.swing.JTextField jTextFieldDisaridanParola;
    private javax.swing.JTextField jTextFieldDisaridanSoyad;
    private javax.swing.JTextField jTextFieldDisaridanTCAra;
    private javax.swing.JTextField jTextFieldOgrAd;
    private javax.swing.JTextField jTextFieldOgrBolum;
    private javax.swing.JTextField jTextFieldOgrMail;
    private javax.swing.JTextField jTextFieldOgrNo;
    private javax.swing.JTextField jTextFieldOgrParola;
    private javax.swing.JTextField jTextFieldOgrSoyad;
    private javax.swing.JTextField jTextFieldOgretmenAra;
    private javax.swing.JTextField jTextFieldOgretmenClsYer;
    private javax.swing.JTextField jTextFieldOgretmenMail;
    private javax.swing.JTextField jTextFieldOgretmenParola;
    private javax.swing.JTextField jTextOgretmenAd;
    private javax.swing.JTextField jTextOgretmenSoyad;
    // End of variables declaration//GEN-END:variables
}
