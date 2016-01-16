package kutuphane;

import static java.lang.StrictMath.toIntExact;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hatice Ertürk
 */
public class oduncVerme extends javax.swing.JFrame {
    private Connection baglanti;
    private Statement ifade;
    String odunc_verilecek;
    String kullanici_tc;
    int tur = 0;
    String kime_verildi;
    boolean ceza_yedi = false;//ceza yememiş.
    
    public oduncVerme() {
        initComponents();
        DBBaglan();
        baslangic();
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

    public void bilgi_al(String tc){//giris sayfasından giriş yapan kişinin tc sini alıyoruz.
        kullanici_tc = tc;
        //System.out.println(kullanici_tc);
        jLabelPersonelTc.setText(kullanici_tc);
        jLabelPersonelTc2.setText(kullanici_tc);
        jLabelPersonelTc3.setText(kullanici_tc);
    }
    
    private void baslangic(){
        jPanelButun.setVisible(false);
        jPanelKaynakBilgi.setVisible(false);
        jPanelTur.setVisible(false);
        jPanelOduncOgrenci.setVisible(false);
        jPanelOduncOgretmen.setVisible(false);
        jPanelOduncDisaridan.setVisible(false);
        jPanelHata.setVisible(false);
        jPanelİade.setVisible(false);
        jPanelİadeKaynak.setVisible(false);
        buttonGroup1.add(jRadioButtonOgrenci);
        buttonGroup1.add(jRadioButtonOgretmen);
        buttonGroup1.add(jRadioButtonDisaridan);
        buttonGroup2.add(jRadioButtonOduncVerme);
        buttonGroup2.add(jRadioButtonİade);
    }
    
    private long time(String tarih1,String tarih2){
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
        String inputString1 = tarih1;
        String inputString2 = tarih2;
        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
           // System.out.println (TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace(); 
        }
        return 0;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanelButun = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldOduncBarkod = new javax.swing.JTextField();
        jButtonBarkodAra = new javax.swing.JButton();
        jPanelHata = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanelKaynak = new javax.swing.JPanel();
        jPanelKaynakBilgi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelAd = new javax.swing.JLabel();
        jLabelTur = new javax.swing.JLabel();
        jLabelBoyut = new javax.swing.JLabel();
        jLabelYayinEvi = new javax.swing.JLabel();
        jLabelYazar = new javax.swing.JLabel();
        jLabelBasimYili = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanelTur = new javax.swing.JPanel();
        jPanelOduncOgrenci = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldOgrenciOkulno = new javax.swing.JTextField();
        jButtonTamamlaOgrenci = new javax.swing.JButton();
        jLabelPersonelTc = new javax.swing.JLabel();
        jRadioButtonOgrenci = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jRadioButtonOgretmen = new javax.swing.JRadioButton();
        jRadioButtonDisaridan = new javax.swing.JRadioButton();
        jPanelOduncDisaridan = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldDisaridanTC = new javax.swing.JTextField();
        jButtonTamamlaDisaridan = new javax.swing.JButton();
        jLabelPersonelTc3 = new javax.swing.JLabel();
        jPanelOduncOgretmen = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldOgretmenTC = new javax.swing.JTextField();
        jButtonTamamlaOgretmen = new javax.swing.JButton();
        jLabelPersonelTc2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jRadioButtonOduncVerme = new javax.swing.JRadioButton();
        jRadioButtonİade = new javax.swing.JRadioButton();
        jPanelİade = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldİadeBarkod = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanelİadeKaynak = new javax.swing.JPanel();
        jPanelKaynakBilgi1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabelİadeAd = new javax.swing.JLabel();
        jLabelİadeTur = new javax.swing.JLabel();
        jLabelİadeBoyut = new javax.swing.JLabel();
        jLabelİadeYayinEvi = new javax.swing.JLabel();
        jLabelİadeYazar = new javax.swing.JLabel();
        jLabelİadeBasimYili = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jLabelOduncAlan = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabelOdenecekTutar = new javax.swing.JLabel();
        jCheckBoxOdendi = new javax.swing.JCheckBox();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(150, 50));
        setPreferredSize(new java.awt.Dimension(695, 600));

        jLabel1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel1.setText("Ödünç Verilecek Kaynağın Barkodunu Giriniz :  ");

        jTextFieldOduncBarkod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOduncBarkodActionPerformed(evt);
            }
        });

        jButtonBarkodAra.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButtonBarkodAra.setText("ARA");
        jButtonBarkodAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBarkodAraActionPerformed(evt);
            }
        });

        jPanelHata.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel16.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 51));
        jLabel16.setText("Bu Kaynak Zaten Ödünç Verilmiş!");

        javax.swing.GroupLayout jPanelHataLayout = new javax.swing.GroupLayout(jPanelHata);
        jPanelHata.setLayout(jPanelHataLayout);
        jPanelHataLayout.setHorizontalGroup(
            jPanelHataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHataLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelHataLayout.setVerticalGroup(
            jPanelHataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelKaynakBilgi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel2.setText("Kaynak Bilgileri");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel3.setText("Adı                        :");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel4.setText("Türü                      :");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel5.setText("Boyut(MB/Sayfa)  : ");

        jLabel6.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel6.setText("Yayın Evi               :");

        jLabel7.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel7.setText("Yazar                    :");

        jLabel8.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel8.setText("Basım Yıl              :");

        jButton1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton1.setText("ÖDÜNÇ VER");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelKaynakBilgiLayout = new javax.swing.GroupLayout(jPanelKaynakBilgi);
        jPanelKaynakBilgi.setLayout(jPanelKaynakBilgiLayout);
        jPanelKaynakBilgiLayout.setHorizontalGroup(
            jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKaynakBilgiLayout.createSequentialGroup()
                .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKaynakBilgiLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelKaynakBilgiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelTur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelBoyut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelYayinEvi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelYazar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelBasimYili, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(jPanelKaynakBilgiLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanelKaynakBilgiLayout.setVerticalGroup(
            jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKaynakBilgiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAd, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelTur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBoyut, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelYayinEvi, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelYazar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKaynakBilgiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBasimYili, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelKaynakLayout = new javax.swing.GroupLayout(jPanelKaynak);
        jPanelKaynak.setLayout(jPanelKaynakLayout);
        jPanelKaynakLayout.setHorizontalGroup(
            jPanelKaynakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKaynakLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanelKaynakBilgi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelKaynakLayout.setVerticalGroup(
            jPanelKaynakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKaynakLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanelKaynakBilgi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jPanelOduncOgrenci.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel9.setText("Kaynağı Ödünç Veren Personel TC'si  :");

        jLabel10.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel10.setText("Ödünç Verilenin Okul Numarasını Giriniz :");

        jButtonTamamlaOgrenci.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButtonTamamlaOgrenci.setText("ÖDÜNÇ İŞLEMİNİ TAMAMLA");
        jButtonTamamlaOgrenci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTamamlaOgrenciActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOduncOgrenciLayout = new javax.swing.GroupLayout(jPanelOduncOgrenci);
        jPanelOduncOgrenci.setLayout(jPanelOduncOgrenciLayout);
        jPanelOduncOgrenciLayout.setHorizontalGroup(
            jPanelOduncOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOduncOgrenciLayout.createSequentialGroup()
                .addGroup(jPanelOduncOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOduncOgrenciLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jTextFieldOgrenciOkulno, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOduncOgrenciLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButtonTamamlaOgrenci))
                    .addGroup(jPanelOduncOgrenciLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOduncOgrenciLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(jPanelOduncOgrenciLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabelPersonelTc, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanelOduncOgrenciLayout.setVerticalGroup(
            jPanelOduncOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOduncOgrenciLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabelPersonelTc, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldOgrenciOkulno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonTamamlaOgrenci)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jRadioButtonOgrenci.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jRadioButtonOgrenci.setText("ÖĞRENCİ");
        jRadioButtonOgrenci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOgrenciActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel11.setText("Ödünç İşlemi İçin Üye Tipini Seçiniz :");

        jRadioButtonOgretmen.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jRadioButtonOgretmen.setText("ÖĞRETMEN");
        jRadioButtonOgretmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOgretmenActionPerformed(evt);
            }
        });

        jRadioButtonDisaridan.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jRadioButtonDisaridan.setText("DIŞARIDAN");
        jRadioButtonDisaridan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDisaridanActionPerformed(evt);
            }
        });

        jPanelOduncDisaridan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel12.setText("Kaynağı Ödünç Veren Personel TC'si  :");

        jLabel13.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel13.setText("Ödünç Verilenin Üyenin TC'sini Giriniz :");

        jButtonTamamlaDisaridan.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButtonTamamlaDisaridan.setText("ÖDÜNÇ İŞLEMİNİ TAMAMLA");
        jButtonTamamlaDisaridan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTamamlaDisaridanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOduncDisaridanLayout = new javax.swing.GroupLayout(jPanelOduncDisaridan);
        jPanelOduncDisaridan.setLayout(jPanelOduncDisaridanLayout);
        jPanelOduncDisaridanLayout.setHorizontalGroup(
            jPanelOduncDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOduncDisaridanLayout.createSequentialGroup()
                .addGroup(jPanelOduncDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOduncDisaridanLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jTextFieldDisaridanTC, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOduncDisaridanLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButtonTamamlaDisaridan))
                    .addGroup(jPanelOduncDisaridanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOduncDisaridanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel13))
                    .addGroup(jPanelOduncDisaridanLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabelPersonelTc3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanelOduncDisaridanLayout.setVerticalGroup(
            jPanelOduncDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOduncDisaridanLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPersonelTc3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldDisaridanTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonTamamlaDisaridan)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        jPanelOduncOgretmen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel14.setText("Kaynağı Ödünç Veren Personel TC'si  :");

        jLabel15.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel15.setText("Ödünç Verilenin Üyenin TC'sini Giriniz :");

        jButtonTamamlaOgretmen.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButtonTamamlaOgretmen.setText("ÖDÜNÇ İŞLEMİNİ TAMAMLA");
        jButtonTamamlaOgretmen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTamamlaOgretmenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOduncOgretmenLayout = new javax.swing.GroupLayout(jPanelOduncOgretmen);
        jPanelOduncOgretmen.setLayout(jPanelOduncOgretmenLayout);
        jPanelOduncOgretmenLayout.setHorizontalGroup(
            jPanelOduncOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOduncOgretmenLayout.createSequentialGroup()
                .addGroup(jPanelOduncOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOduncOgretmenLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jTextFieldOgretmenTC, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOduncOgretmenLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButtonTamamlaOgretmen))
                    .addGroup(jPanelOduncOgretmenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOduncOgretmenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(jPanelOduncOgretmenLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabelPersonelTc2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOduncOgretmenLayout.setVerticalGroup(
            jPanelOduncOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOduncOgretmenLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelPersonelTc2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldOgretmenTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButtonTamamlaOgretmen)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelTurLayout = new javax.swing.GroupLayout(jPanelTur);
        jPanelTur.setLayout(jPanelTurLayout);
        jPanelTurLayout.setHorizontalGroup(
            jPanelTurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTurLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTurLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTurLayout.createSequentialGroup()
                        .addGap(0, 18, Short.MAX_VALUE)
                        .addGroup(jPanelTurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelTurLayout.createSequentialGroup()
                                .addComponent(jRadioButtonOgrenci)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonOgretmen)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButtonDisaridan))
                            .addComponent(jPanelOduncOgrenci, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelOduncDisaridan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelOduncOgretmen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
        );
        jPanelTurLayout.setVerticalGroup(
            jPanelTurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTurLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTurLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonOgrenci)
                    .addComponent(jRadioButtonOgretmen)
                    .addComponent(jRadioButtonDisaridan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOduncOgrenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelOduncOgretmen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelOduncDisaridan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelButunLayout = new javax.swing.GroupLayout(jPanelButun);
        jPanelButun.setLayout(jPanelButunLayout);
        jPanelButunLayout.setHorizontalGroup(
            jPanelButunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButunLayout.createSequentialGroup()
                .addGroup(jPanelButunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelButunLayout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(jButtonBarkodAra, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelButunLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jPanelHata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelButunLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jTextFieldOduncBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelButunLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanelKaynak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jPanelTur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanelButunLayout.setVerticalGroup(
            jPanelButunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButunLayout.createSequentialGroup()
                .addGroup(jPanelButunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldOduncBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jButtonBarkodAra)
                .addGap(18, 18, 18)
                .addComponent(jPanelHata, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelButunLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelButunLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelTur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelButunLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanelKaynak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel17.setText("Yapmak İstediğiniz İşlemi Seçiniz");

        jRadioButtonOduncVerme.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jRadioButtonOduncVerme.setText("Odünç Verme İşlemi");
        jRadioButtonOduncVerme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOduncVermeActionPerformed(evt);
            }
        });

        jRadioButtonİade.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jRadioButtonİade.setText("İade İşlemi");
        jRadioButtonİade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonİadeActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel18.setText("İade Alınacak Kaynağın Barkodunu Girin :");

        jButton2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton2.setText("ARA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanelKaynakBilgi1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel19.setText("Kaynak Bilgileri");

        jLabel20.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel20.setText("Adı                        :");

        jLabel21.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel21.setText("Türü                      :");

        jLabel22.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel22.setText("Boyut(MB/Sayfa)  : ");

        jLabel23.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel23.setText("Yayın Evi               :");

        jLabel24.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel24.setText("Yazar                    :");

        jLabel25.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel25.setText("Basım Yıl              :");

        jButton3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jButton3.setText("İade İşlemini Tamamla");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel26.setText("Ödünç Alan     :   ");

        jLabel27.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel27.setText("Ödenecek Tutar  :");

        jCheckBoxOdendi.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jCheckBoxOdendi.setText("Ödendi");

        jLabel28.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel28.setText("Ceza Ödeme Durumu");

        javax.swing.GroupLayout jPanelKaynakBilgi1Layout = new javax.swing.GroupLayout(jPanelKaynakBilgi1);
        jPanelKaynakBilgi1.setLayout(jPanelKaynakBilgi1Layout);
        jPanelKaynakBilgi1Layout.setHorizontalGroup(
            jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKaynakBilgi1Layout.createSequentialGroup()
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKaynakBilgi1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelİadeAd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelİadeTur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelİadeBoyut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelİadeYayinEvi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelİadeYazar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelİadeBasimYili, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelOduncAlan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelOdenecekTutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanelKaynakBilgi1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelKaynakBilgi1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxOdendi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelKaynakBilgi1Layout.setVerticalGroup(
            jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKaynakBilgi1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelİadeAd, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelİadeTur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelİadeBoyut, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelİadeYayinEvi, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelİadeYazar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelİadeBasimYili, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addComponent(jLabelOduncAlan, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
                    .addComponent(jLabelOdenecekTutar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelKaynakBilgi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCheckBoxOdendi))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanelİadeKaynakLayout = new javax.swing.GroupLayout(jPanelİadeKaynak);
        jPanelİadeKaynak.setLayout(jPanelİadeKaynakLayout);
        jPanelİadeKaynakLayout.setHorizontalGroup(
            jPanelİadeKaynakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelİadeKaynakLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jPanelKaynakBilgi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanelİadeKaynakLayout.setVerticalGroup(
            jPanelİadeKaynakLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelİadeKaynakLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jPanelKaynakBilgi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanelİadeLayout = new javax.swing.GroupLayout(jPanelİade);
        jPanelİade.setLayout(jPanelİadeLayout);
        jPanelİadeLayout.setHorizontalGroup(
            jPanelİadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelİadeLayout.createSequentialGroup()
                .addGroup(jPanelİadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelİadeLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jTextFieldİadeBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelİadeLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jPanelİadeKaynak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelİadeLayout.createSequentialGroup()
                        .addGap(211, 211, 211)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanelİadeLayout.setVerticalGroup(
            jPanelİadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelİadeLayout.createSequentialGroup()
                .addGroup(jPanelİadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldİadeBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelİadeKaynak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(149, 149, 149)
                                .addComponent(jRadioButtonOduncVerme)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonİade)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelButun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelİade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButtonİade)
                    .addComponent(jRadioButtonOduncVerme))
                .addGap(21, 21, 21)
                .addComponent(jPanelButun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelİade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldOduncBarkodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOduncBarkodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOduncBarkodActionPerformed

    private void jButtonBarkodAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBarkodAraActionPerformed
        jPanelKaynak.setVisible(true);
        jPanelKaynakBilgi.setVisible(false);
        jPanelHata.setVisible(false);
        
        odunc_verilecek = jTextFieldOduncBarkod.getText();
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            
            String sql = "select (select TUR_AD from KAYNAK_TUR where TUR_ID=KAYNAKLAR.TUR_ID), AD, YAZAR, BOYUT, YAYIN_EVI, BASIM_YILI,ODUNC_ALINMISMI from KAYNAKLAR where BARKOD='"
                            +odunc_verilecek+"'";
            ResultSet rs = ifade.executeQuery(sql);
            rs.next();
            
            if(rs.getBoolean("ODUNC_ALINMISMI") != true){
                jPanelKaynakBilgi.setVisible(true);
                jLabelAd.setText(rs.getString("AD"));
                jLabelTur.setText(rs.getString(1));
                jLabelBoyut.setText(rs.getString("BOYUT"));
                jLabelYayinEvi.setText(rs.getString("YAYIN_EVI"));
                jLabelYazar.setText(rs.getString("YAZAR"));
                jLabelBasimYili.setText(rs.getString("BASIM_YILI"));
            }
            else {
                jPanelHata.setVisible(true);
                jPanelTur.setVisible(false);
                jPanelOduncOgrenci.setVisible(false);
                jPanelOduncOgretmen.setVisible(false);
                jPanelOduncDisaridan.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButtonBarkodAraActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jPanelTur.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonTamamlaOgrenciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTamamlaOgrenciActionPerformed
        String odunc_alan = jTextFieldOgrenciOkulno.getText();
        String odunc_veren = jLabelPersonelTc.getText();
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            
           // long t = System.currentTimeMillis();
            //Date today = new Date(t);
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            //System.out.println(timeStamp);
            
            // Kaynak durumu varsayilan olarak false yapılır. (en sondaki parametre.)
            // False olması kaynağın henüz teslim edilmediğini belirtmektedir.
            // True oldugu zaman kaynak teslim edilmiş fakat cezası ödenmemiş demektir.
            String sql = "insert into OGRENCI_ODUNC values('"+odunc_veren+"','"+odunc_alan+"','"+odunc_verilecek+"','"+timeStamp+"','',false)";
            ifade.executeUpdate(sql);
            
            String sql2 = "update KAYNAKLAR set ODUNC_ALINMISMI=true where BARKOD='"+odunc_verilecek+"'";
            ifade.executeUpdate(sql2);
            
        } catch (SQLException ex) {
            Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButtonTamamlaOgrenciActionPerformed

    private void jRadioButtonOgrenciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOgrenciActionPerformed
        jPanelOduncOgrenci.setVisible(true);
        jPanelOduncOgretmen.setVisible(false);
        jPanelOduncDisaridan.setVisible(false);
        
        
    }//GEN-LAST:event_jRadioButtonOgrenciActionPerformed

    private void jButtonTamamlaDisaridanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTamamlaDisaridanActionPerformed
        String odunc_veren = jLabelPersonelTc3.getText();
        String odunc_verilen = jTextFieldDisaridanTC.getText();
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            
           // long t = System.currentTimeMillis();
            //Date today = new Date(t);
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            //System.out.println(timeStamp);
            
            // Kaynak durumu varsayilan olarak false yapılır. (en sondaki parametre.)
            // False olması kaynağın henüz teslim edilmediğini belirtmektedir.
            // True oldugu zaman kaynak teslim edilmiş fakat cezası ödenmemiş demektir.
            String sql = "insert into DISARIDAN_ODUNC values('"+odunc_veren+"','"+odunc_verilen+"','"+odunc_verilecek+"','"+timeStamp+"','',false)";
            ifade.executeUpdate(sql);
            
            String sql2 = "update KAYNAKLAR set ODUNC_ALINMISMI=true where BARKOD='"+odunc_verilecek+"'";
            ifade.executeUpdate(sql2);
        } catch (SQLException ex) {
            Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButtonTamamlaDisaridanActionPerformed

    private void jButtonTamamlaOgretmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTamamlaOgretmenActionPerformed
        String odunc_veren = jLabelPersonelTc3.getText();
        String odunc_alan = jTextFieldOgretmenTC.getText();
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            
           // long t = System.currentTimeMillis();
            //Date today = new Date(t);
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            //System.out.println(timeStamp);
            
            // Kaynak durumu varsayilan olarak false yapılır. (en sondaki parametre.)
            // False olması kaynağın henüz teslim edilmediğini belirtmektedir.
            // True oldugu zaman kaynak teslim edilmiş fakat cezası ödenmemiş demektir.
            String sql = "insert into OGRETMEN_ODUNC values('"+odunc_veren+"','"+odunc_alan+"','"+odunc_verilecek+"','"+timeStamp+"','',false)";
            ifade.executeUpdate(sql);
            
            String sql2 = "update KAYNAKLAR set ODUNC_ALINMISMI=true where BARKOD='"+odunc_verilecek+"'";
            ifade.executeUpdate(sql2);
        } catch (SQLException ex) {
            Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dispose();
    }//GEN-LAST:event_jButtonTamamlaOgretmenActionPerformed

    private void jRadioButtonOgretmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOgretmenActionPerformed
        jPanelOduncOgretmen.setVisible(true);
        jPanelOduncOgrenci.setVisible(false);
        jPanelOduncDisaridan.setVisible(false);
        
        
    }//GEN-LAST:event_jRadioButtonOgretmenActionPerformed

    private void jRadioButtonDisaridanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDisaridanActionPerformed
        jPanelOduncDisaridan.setVisible(true);
        jPanelOduncOgrenci.setVisible(false);
        jPanelOduncOgretmen.setVisible(false);
    }//GEN-LAST:event_jRadioButtonDisaridanActionPerformed

    private void jRadioButtonOduncVermeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOduncVermeActionPerformed
        jPanelButun.setVisible(true);
        jPanelİade.setVisible(false);
    }//GEN-LAST:event_jRadioButtonOduncVermeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String barkod = jTextFieldİadeBarkod.getText();
        jPanelİadeKaynak.setVisible(true);
      
        ResultSet rs=null;
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql1 = "select (select TUR_AD from KAYNAK_TUR where TUR_ID=KAYNAKLAR.TUR_ID), AD, YAZAR, BOYUT, YAYIN_EVI, BASIM_YILI,ODUNC_ALINMISMI from KAYNAKLAR where BARKOD='"
                            +barkod+"' and ODUNC_ALINMISMI=true";
          
            rs = ifade.executeQuery(sql1);
            if(rs.next()){
                //System.out.println(rs.getString("AD"));
                jLabelİadeAd.setText(rs.getString("AD"));
                jLabelİadeTur.setText(rs.getString(1));
                jLabelİadeBoyut.setText(rs.getString("BOYUT"));
                jLabelİadeYayinEvi.setText(rs.getString("YAYIN_EVI"));
                jLabelİadeYazar.setText(rs.getString("YAZAR"));
                jLabelİadeBasimYili.setText(rs.getString("BASIM_YILI"));
            }
            else{
                jPanelİadeKaynak.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            String sql = "select * from OGRENCI_ODUNC where O_KAYNAK='"+barkod+"' and O_KAYNAK_DURUMU=false";
            ResultSet rs1 = ifade.executeQuery(sql);
            int _i1 = 0; rs1.last(); _i1 = rs1.getRow(); //Satır var mı yok mu anlamında.
            if(_i1 > 0){
                tur = 1;
                String o_verilen = rs1.getString("O_VERILEN");
                sql = "select ADI,SOYAD from OGRENCI_UYE where OKUL_NO='"+o_verilen+"'";
                rs1 = ifade.executeQuery(sql);
                rs1.next();
                kime_verildi = o_verilen;
                jLabelOduncAlan.setText(rs1.getString("ADI")+" "+rs1.getString("SOYAD"));
                
                String sql4 = "select O_VERILIS_TARIH from OGRENCI_ODUNC where O_KAYNAK='"+barkod+"' and O_KAYNAK_DURUMU=false";
                ResultSet rs5 = ifade.executeQuery(sql4);
                rs5.next();
            
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                long kac_gun = time(rs5.getString(1), timeStamp);
            
                String sql3 = "select * from AYARLAR where UYE_TUR='öğrenci'";
                ResultSet rs6 = ifade.executeQuery(sql3);
                rs6.next();
            
                if(kac_gun > rs6.getInt("KAC_GUN")){
                    ceza_yedi = true;
                    int kac = toIntExact(kac_gun) - rs6.getInt("KAC_GUN");
                
                    int kurus = kac*rs6.getInt("CEZA")%100;
                    int lira = kac*rs6.getInt("CEZA")/100;
                    String odenecek = Integer.toString(lira)+" lira "+Integer.toString(kurus)+" kuruş";
                
                    jLabelOdenecekTutar.setText(odenecek);
                }
                else {
                    // 30 gunden once getirildiyse buraya girilecek ve odenip odenmedigi
                    // bilgisi sorulmayacak.
                    // Bu bilgi bir global degiksen icerisinde tutulmaktadır.
                    ceza_yedi = false;
                    jLabelOdenecekTutar.setText("0 lira 0 kuruş");
                    jLabel28.setVisible(false);
                    jCheckBoxOdendi.setVisible(false);
                }
            }
            
            sql = "select * from OGRETMEN_ODUNC where O_KAYNAK='"+barkod+"' and O_KAYNAK_DURUMU=false";
            ResultSet rs2 = ifade.executeQuery(sql);
            int _i2 = 0; rs2.last(); _i2 = rs2.getRow();
            if(_i2 > 0) {
                tur = 2;
                String o_verilen = rs2.getString("O_VERILEN");
                sql = "select AD,SOYAD from OGRETMEN_UYE where TC='"+o_verilen+"'";
                rs2 = ifade.executeQuery(sql);
                rs2.next();
                kime_verildi = o_verilen;
                jLabelOduncAlan.setText(rs2.getString("AD")+" "+rs2.getString("SOYAD"));
                
                String sql4 = "select O_VERILIS_TARIH from OGRETMEN_ODUNC where O_KAYNAK='"+barkod+"' and O_KAYNAK_DURUMU=false";
                ResultSet rs5 = ifade.executeQuery(sql4);
                rs5.next();
            
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                long kac_gun = time(rs5.getString(1), timeStamp);
            
                String sql3 = "select * from AYARLAR where UYE_TUR='öğretmen'";
                ResultSet rs6 = ifade.executeQuery(sql3);
                rs6.next();
            
                if(kac_gun > rs6.getInt("KAC_GUN")){
                    int kac = toIntExact(kac_gun) - rs6.getInt("KAC_GUN");
                
                    int kurus = kac*rs6.getInt("CEZA")%100;
                    int lira = kac*rs6.getInt("CEZA")/100;
                    String odenecek = Integer.toString(lira)+" lira "+Integer.toString(kurus)+" kuruş";
                    
                    jLabelOdenecekTutar.setText(odenecek);
                }
                else {
                    // 30 gunden once getirildiyse buraya girilecek ve odenip odenmedigi
                    // bilgisi sorulmayacak.
                    // Bu bilgi bir global degiksen icerisinde tutulmaktadır.
                    ceza_yedi = false;
                    jLabelOdenecekTutar.setText("0 lira 0 kuruş");
                    jLabel28.setVisible(false);
                    jCheckBoxOdendi.setVisible(false);
                }
            }
            
            sql = "select * from DISARIDAN_ODUNC where O_KAYNAK='"+barkod+"' and O_KAYNAK_DURUMU=false";
            ResultSet rs3 = ifade.executeQuery(sql);
            int _i3 = 0; rs3.last(); _i3 = rs3.getRow();           
            if (_i3 > 0){
                tur = 3;
                String o_verilen = rs3.getString("O_VERILEN");
                sql = "select AD,SOYAD from DISARIDAN_UYE where TC='"+o_verilen+"'";
                rs3 = ifade.executeQuery(sql);
                rs3.next();
                kime_verildi = o_verilen;
                jLabelOduncAlan.setText(rs3.getString("AD")+" "+rs3.getString("SOYAD"));
                
                String sql4 = "select O_VERILIS_TARIH from DISARIDAN_ODUNC where O_KAYNAK='"+barkod+"' and O_KAYNAK_DURUMU=false";
                ResultSet rs5 = ifade.executeQuery(sql4);
                rs5.next();
            
                String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                long kac_gun = time(rs5.getString(1), timeStamp);
            
                String sql3 = "select * from AYARLAR where UYE_TUR='dışarıdan'";
                ResultSet rs6 = ifade.executeQuery(sql3);
                rs6.next();
            
                if(kac_gun > rs6.getInt("KAC_GUN")){
                    int kac = toIntExact(kac_gun) - rs6.getInt("KAC_GUN");
                
                    int kurus = kac*rs6.getInt("CEZA")%100;
                    int lira = kac*rs6.getInt("CEZA")/100;
                    String odenecek = Integer.toString(lira)+" lira "+Integer.toString(kurus)+" kuruş";
                    
                    jLabelOdenecekTutar.setText(odenecek);
                }
                else {
                    // 30 gunden once getirildiyse buraya girilecek ve odenip odenmedigi
                    // bilgisi sorulmayacak.
                    // Bu bilgi bir global degiksen icerisinde tutulmaktadır.
                    ceza_yedi = false;
                    jLabelOdenecekTutar.setText("0 lira 0 kuruş");
                    jLabel28.setVisible(false);
                    jCheckBoxOdendi.setVisible(false);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButtonİadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonİadeActionPerformed
       jPanelİade.setVisible(true);
       jPanelButun.setVisible(false);
       jPanelHata.setVisible(false);
    }//GEN-LAST:event_jRadioButtonİadeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        //System.out.println(timeStamp);
        String barkod = jTextFieldİadeBarkod.getText();
        boolean odendimi;
        if(jCheckBoxOdendi.isSelected()) // Cezanin odenip odenmeyecegi bilgisi alinir.
            odendimi = true;
        else
            odendimi = false;
        
        
        if(tur == 1){
            try {
                String sql3 = "select * from AYARLAR where UYE_TUR='öğrenci'";
                ResultSet rs6 = ifade.executeQuery(sql3);
                rs6.next();
                if(odendimi || !ceza_yedi) { // Kaynak cezasi odendi ise buraya girecektir.
                    String sql = "delete from OGRENCI_ODUNC where O_KAYNAK='"+barkod+"' and O_VERILEN='"+kime_verildi+"'";
                    ifade.executeUpdate(sql);
                }
                else { // Kaynak teslim edildi fakat cezasi odenmedi ise buraya girecektir.
                    String sql = "update OGRENCI_ODUNC set O_KAYNAK_DURUMU=true where O_KAYNAK='"+barkod+
                            "' and O_VERILEN='"+kime_verildi+"'";
                    ifade.executeUpdate(sql);
                }
                
                String sql2 = "update KAYNAKLAR set ODUNC_ALINMISMI=false where BARKOD='"+barkod+"'";
                ifade.executeUpdate(sql2);
            } catch (SQLException ex) {
                Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
        if(tur == 2){
            try {
                String sql = "select * from AYARLAR where UYE_TUR='öğretmen'";
                ResultSet rs = ifade.executeQuery(sql);
                rs.next();
                
                if(odendimi || !ceza_yedi) { // Kaynak cezasi odendi ise buraya girecektir.
                    String sql1 = "delete from OGRETMEN_ODUNC where O_KAYNAK='"+barkod+"' and O_VERILEN='"+kime_verildi+"'";
                    ifade.executeUpdate(sql1);
                }
                else { // Kaynak teslim edildi fakat cezasi odenmedi ise buraya girecektir.
                    String sql1 = "update OGRETMEN_ODUNC set O_KAYNAK_DURUMU=true where O_KAYNAK='"+barkod+
                            "' and O_VERILEN='"+kime_verildi+"'";
                    ifade.executeUpdate(sql1);
                }
                
                String sql2 = "update KAYNAKLAR set ODUNC_ALINMISMI=false where BARKOD='"+barkod+"'";
                ifade.executeUpdate(sql2);
            } catch (SQLException ex) {
                Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
        if(tur == 3){
           
            try {
                String sql = "select * from AYARLAR where UYE_TUR='dışarıdan'";
                ResultSet rs = ifade.executeQuery(sql);
                rs.next();
                
                if(odendimi || !ceza_yedi) { // Kaynak cezasi odendi ise buraya girecektir.
                    String sql1 = "delete from DISARIDAN_ODUNC where O_KAYNAK='"+barkod+"' and O_VERILEN='"+kime_verildi+"'";
                    ifade.executeUpdate(sql1);
                }
                else { // Kaynak teslim edildi fakat cezasi odenmedi ise buraya girecektir.
                    String sql1 = "update DISARIDAN_ODUNC set O_KAYNAK_DURUMU=true where O_KAYNAK='"+barkod+
                            "' and O_VERILEN='"+kime_verildi+"'";
                    ifade.executeUpdate(sql1);
                }
                
                String sql2 = "update KAYNAKLAR set ODUNC_ALINMISMI=false where BARKOD='"+barkod+"'";
                ifade.executeUpdate(sql2);
            } catch (SQLException ex) {
                Logger.getLogger(oduncVerme.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(oduncVerme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(oduncVerme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(oduncVerme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(oduncVerme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new oduncVerme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBarkodAra;
    private javax.swing.JButton jButtonTamamlaDisaridan;
    private javax.swing.JButton jButtonTamamlaOgrenci;
    private javax.swing.JButton jButtonTamamlaOgretmen;
    private javax.swing.JCheckBox jCheckBoxOdendi;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAd;
    private javax.swing.JLabel jLabelBasimYili;
    private javax.swing.JLabel jLabelBoyut;
    private javax.swing.JLabel jLabelOdenecekTutar;
    private javax.swing.JLabel jLabelOduncAlan;
    private javax.swing.JLabel jLabelPersonelTc;
    private javax.swing.JLabel jLabelPersonelTc2;
    private javax.swing.JLabel jLabelPersonelTc3;
    private javax.swing.JLabel jLabelTur;
    private javax.swing.JLabel jLabelYayinEvi;
    private javax.swing.JLabel jLabelYazar;
    private javax.swing.JLabel jLabelİadeAd;
    private javax.swing.JLabel jLabelİadeBasimYili;
    private javax.swing.JLabel jLabelİadeBoyut;
    private javax.swing.JLabel jLabelİadeTur;
    private javax.swing.JLabel jLabelİadeYayinEvi;
    private javax.swing.JLabel jLabelİadeYazar;
    private javax.swing.JPanel jPanelButun;
    private javax.swing.JPanel jPanelHata;
    private javax.swing.JPanel jPanelKaynak;
    private javax.swing.JPanel jPanelKaynakBilgi;
    private javax.swing.JPanel jPanelKaynakBilgi1;
    private javax.swing.JPanel jPanelOduncDisaridan;
    private javax.swing.JPanel jPanelOduncOgrenci;
    private javax.swing.JPanel jPanelOduncOgretmen;
    private javax.swing.JPanel jPanelTur;
    private javax.swing.JPanel jPanelİade;
    private javax.swing.JPanel jPanelİadeKaynak;
    private javax.swing.JRadioButton jRadioButtonDisaridan;
    private javax.swing.JRadioButton jRadioButtonOduncVerme;
    private javax.swing.JRadioButton jRadioButtonOgrenci;
    private javax.swing.JRadioButton jRadioButtonOgretmen;
    private javax.swing.JRadioButton jRadioButtonİade;
    private javax.swing.JTextField jTextFieldDisaridanTC;
    private javax.swing.JTextField jTextFieldOduncBarkod;
    private javax.swing.JTextField jTextFieldOgrenciOkulno;
    private javax.swing.JTextField jTextFieldOgretmenTC;
    private javax.swing.JTextField jTextFieldİadeBarkod;
    // End of variables declaration//GEN-END:variables
}
