package kutuphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hatice Ertürk
 */
public class anasayfa extends javax.swing.JFrame {
    String kullanici_tc;
    private Connection baglanti;
    private Statement ifade;
    private Statement ifade2;
    ResultSet rs;
       
    public anasayfa() {
        initComponents();
        DBBaglan();
    }

    public void bilgi_al(String tc){//giris sayfasından giriş yapan kişinin tc sini alıyoruz.
        kullanici_tc = tc;
        //System.out.println(kullanici_tc);
        baslangic();
    }
    
    private void baslangic(){
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            
            String sql = "select AD,SOYAD from PERSONEL where TC='"+kullanici_tc+"'";
            
            rs = ifade.executeQuery(sql);
            
            rs.next();
            String kullanici = "Hoşgeldin "+rs.getString("AD")+" "+rs.getString("SOYAD");
            //System.out.println(kullanici);
            jMenuKullanici.setText(kullanici);
            
            rs.close();
            ifade.close();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(anasayfa.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                rs.close();
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(anasayfa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    private void DBBaglan(){
        String baglantiUrl = "jdbc:derby://localhost:1527/Kutuphane";
        String userName = "hatice";
        String password = "123";
        
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            baglanti = DriverManager.getConnection(baglantiUrl,userName,password);
            ifade = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ifade2 = baglanti.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
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
    
    private static String USER_NAME = "mail_adresiniz";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "mail_sifreniz"; // GMail password
    
    private void mail_yolla(){
        String from = USER_NAME;
        String pass = PASSWORD;
        ArrayList<String> to = new ArrayList<String>();
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        
        try {
            if(baglanti.isClosed()){
                    DBBaglan();
            }
            
            String sql = "select * from OGRENCI_ODUNC where O_KAYNAK_DURUMU=false";
            ResultSet rs = ifade.executeQuery(sql);
            while(rs.next()){
                if(baglanti.isClosed()){
                    DBBaglan();
                }
                long kac_gun = time(rs.getString("O_VERILIS_TARIH"), timeStamp);
                //System.out.println("kac gun : "+kac_gun);
                if(kac_gun == 31){
                    String sql2 = "select MAIL from OGRENCI_UYE where OKUL_NO='"+rs.getString("O_VERILEN")+"'";
                    ResultSet rs2 = ifade2.executeQuery(sql2);
                    if(rs2.next()){
                       // System.out.println(rs2.getString(1));
                        to.add(rs2.getString(1));
                    }
                }
            }
            sql = "select * from OGRETMEN_ODUNC where O_KAYNAK_DURUMU=false";
            rs = ifade.executeQuery(sql);
            while(rs.next()){
                if(baglanti.isClosed()){
                    DBBaglan();
                }
                long kac_gun = time(rs.getString("O_VERILIS_TARIH"), timeStamp);
                //System.out.println("kac gun : "+kac_gun);
                if(kac_gun == 31){
                    String sql2 = "select MAIL from OGRETMEN_UYE where TC='"+rs.getString("O_VERILEN")+"'";
                    ResultSet rs2 = ifade2.executeQuery(sql2);
                    if(rs2.next()){
                       // System.out.println(rs2.getString(1));
                        to.add(rs2.getString(1));
                    }
                }
            }
            sql = "select * from DISARIDAN_ODUNC where O_KAYNAK_DURUMU=false";
            rs = ifade.executeQuery(sql);
            while(rs.next()){
                if(baglanti.isClosed()){
                    DBBaglan();
                }
                long kac_gun = time(rs.getString("O_VERILIS_TARIH"), timeStamp);
                //System.out.println("kac gun : "+kac_gun);
                if(kac_gun == 31){
                    String sql2 = "select MAIL from DISARIDAN_UYE where TC='"+rs.getString("O_VERILEN")+"'";
                    ResultSet rs2 = ifade2.executeQuery(sql2);
                    if(rs2.next()){
                       // System.out.println(rs2.getString(1));
                        to.add(rs2.getString(1));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(anasayfa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //String[] to = { "haticeerturk27@gmail.com"}; // list of recipient email addresses
        String subject = "Kütüphane Ceza Bilgilendirme";
        String body = "Merhaba,\n"
                + "Çanakkale 18 Mart Üniversitesi Kütüphanesinden ödünç aldığınız kaynağın iade günü geçmiştir.\n"
                + "Eğer Öğrenci üye iseniz günlük 25 kuruş ceza işlemi bugünden itibaren başlamıştır.\n"
                + "Eğer Öğretmen üye iseniz günlük 50 kuruş ceza işlemi bugünden itibaren başlamıştır.\n"
                + "Eğer Dışarıdan kayıtlı üye iseniz günlük 75 kuruş ceza işlemi bugünden itibaren başlamıştır.\n"
                + "Lütfen en kısa zaman da ödünç aldığınız kaynağı kütüphanemize iade ediniz!\n"
                + "İyi günler dileriz.";
        
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.size()];

            // To get the array of addresses
            for( int i = 0; i < to.size(); i++ ) {
                toAddress[i] = new InternetAddress(to.get(i));
                System.out.println(toAddress[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuUyeEkle = new javax.swing.JMenuItem();
        jMenuUyeListele = new javax.swing.JMenuItem();
        jMenuUyeDuzenle = new javax.swing.JMenuItem();
        jMenuUyeSil = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuKaynakEkle = new javax.swing.JMenuItem();
        jMenuKaynakArama = new javax.swing.JMenuItem();
        jMenuKaynakDuzenle = new javax.swing.JMenuItem();
        jMenuKaynakSil = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuPersonelEkle = new javax.swing.JMenuItem();
        jMenuPersonelAra = new javax.swing.JMenuItem();
        jMenuPersonelDuzenle = new javax.swing.JMenuItem();
        jMenuPersonelSil = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemOduncVerme = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItemCezaOdeme = new javax.swing.JMenuItem();
        jMenuItemCezaMail = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuKullanici = new javax.swing.JMenu();
        jMenuItemKullaniciUyelikBilgileri = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(200, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\Clementinum_library.jpg")); // NOI18N

        jMenuBar1.setPreferredSize(new java.awt.Dimension(209, 35));

        jMenu2.setText("Üyelik İşlemleri");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuUyeEkle.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_register.png")); // NOI18N
        jMenuUyeEkle.setText("Üye Ekle");
        jMenuUyeEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUyeEkleActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuUyeEkle);

        jMenuUyeListele.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_1400228985_friends.png")); // NOI18N
        jMenuUyeListele.setText("Üye Listele");
        jMenuUyeListele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUyeListeleActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuUyeListele);

        jMenuUyeDuzenle.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_edit_user.png")); // NOI18N
        jMenuUyeDuzenle.setText("Üye Düzenle");
        jMenuUyeDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUyeDuzenleActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuUyeDuzenle);

        jMenuUyeSil.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_remove_user.png")); // NOI18N
        jMenuUyeSil.setText("Üye Sil");
        jMenuUyeSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUyeSilActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuUyeSil);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Kaynak İşlemleri");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuKaynakEkle.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_file_text_document_page_paper_new_add_plus-128.png")); // NOI18N
        jMenuKaynakEkle.setText("Kaynak Ekle");
        jMenuKaynakEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKaynakEkleActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuKaynakEkle);

        jMenuKaynakArama.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_document.png")); // NOI18N
        jMenuKaynakArama.setText("Kaynak Arama");
        jMenuKaynakArama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKaynakAramaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuKaynakArama);

        jMenuKaynakDuzenle.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_files-edit-file-icon.png")); // NOI18N
        jMenuKaynakDuzenle.setText("Kaynak Düzenle");
        jMenuKaynakDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKaynakDuzenleActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuKaynakDuzenle);

        jMenuKaynakSil.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_delete_file-512.png")); // NOI18N
        jMenuKaynakSil.setText("Kaynak Sil");
        jMenuKaynakSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKaynakSilActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuKaynakSil);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Personel İşlemleri");
        jMenu4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuPersonelEkle.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_register.png")); // NOI18N
        jMenuPersonelEkle.setText("Personel Ekle");
        jMenuPersonelEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPersonelEkleActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuPersonelEkle);

        jMenuPersonelAra.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_1400228985_friends.png")); // NOI18N
        jMenuPersonelAra.setText("Personel Ara");
        jMenuPersonelAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPersonelAraActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuPersonelAra);

        jMenuPersonelDuzenle.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_edit_user.png")); // NOI18N
        jMenuPersonelDuzenle.setText("Personel Düzenle");
        jMenuPersonelDuzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPersonelDuzenleActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuPersonelDuzenle);

        jMenuPersonelSil.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_remove_user.png")); // NOI18N
        jMenuPersonelSil.setText("Personel Sil");
        jMenuPersonelSil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPersonelSilActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuPersonelSil);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Ödünç/İade İşlemleri");
        jMenu5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItemOduncVerme.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_defult_text.png")); // NOI18N
        jMenuItemOduncVerme.setText("Ödünç/İade İşlemleri");
        jMenuItemOduncVerme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemOduncVermeActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemOduncVerme);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Ceza İşlemleri");
        jMenu7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jMenuItemCezaOdeme.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_credito.png")); // NOI18N
        jMenuItemCezaOdeme.setText("Ceza Ödeme");
        jMenuItemCezaOdeme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCezaOdemeActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemCezaOdeme);

        jMenuItemCezaMail.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_mail_-2.png")); // NOI18N
        jMenuItemCezaMail.setText("Ceza Bilgi Maili Yolla");
        jMenuItemCezaMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCezaMailActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItemCezaMail);

        jMenuBar1.add(jMenu7);

        jMenu1.setText("                                                                                 ");
        jMenuBar1.add(jMenu1);

        jMenuKullanici.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_user.png")); // NOI18N
        jMenuKullanici.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        jMenuKullanici.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuKullaniciActionPerformed(evt);
            }
        });

        jMenuItemKullaniciUyelikBilgileri.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hatice Ertürk\\Desktop\\Java\\Kutuphane\\rsz_1user.png")); // NOI18N
        jMenuItemKullaniciUyelikBilgileri.setText("Üyelik Bilgileri");
        jMenuItemKullaniciUyelikBilgileri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKullaniciUyelikBilgileriActionPerformed(evt);
            }
        });
        jMenuKullanici.add(jMenuItemKullaniciUyelikBilgileri);

        jMenuBar1.add(jMenuKullanici);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 645, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuUyeEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUyeEkleActionPerformed
       new uye_ekle().setVisible(true);
    }//GEN-LAST:event_jMenuUyeEkleActionPerformed

    private void jMenuKaynakEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKaynakEkleActionPerformed
        new kaynak_ekle().setVisible(true);
    }//GEN-LAST:event_jMenuKaynakEkleActionPerformed

    private void jMenuUyeListeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUyeListeleActionPerformed
        new uye_listele().setVisible(true);
    }//GEN-LAST:event_jMenuUyeListeleActionPerformed

    private void jMenuUyeDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUyeDuzenleActionPerformed
        new uye_duzenle().setVisible(true);
    }//GEN-LAST:event_jMenuUyeDuzenleActionPerformed

    private void jMenuUyeSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUyeSilActionPerformed
        new uye_sil().setVisible(true);
    }//GEN-LAST:event_jMenuUyeSilActionPerformed

    private void jMenuKaynakDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKaynakDuzenleActionPerformed
        new kaynak_duzenle().setVisible(true);
    }//GEN-LAST:event_jMenuKaynakDuzenleActionPerformed

    private void jMenuKaynakSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKaynakSilActionPerformed
        new kaynak_sil().setVisible(true);
    }//GEN-LAST:event_jMenuKaynakSilActionPerformed

    private void jMenuKaynakAramaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKaynakAramaActionPerformed
        new kaynak_ara().setVisible(true);
    }//GEN-LAST:event_jMenuKaynakAramaActionPerformed

    private void jMenuPersonelEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPersonelEkleActionPerformed
        new personel_ekle().setVisible(true);
    }//GEN-LAST:event_jMenuPersonelEkleActionPerformed

    private void jMenuPersonelDuzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPersonelDuzenleActionPerformed
        new personel_duzenle().setVisible(true);
    }//GEN-LAST:event_jMenuPersonelDuzenleActionPerformed

    private void jMenuPersonelSilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPersonelSilActionPerformed
        new personel_sil().setVisible(true);
    }//GEN-LAST:event_jMenuPersonelSilActionPerformed

    private void jMenuPersonelAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPersonelAraActionPerformed
        new personel_listele().setVisible(true);
    }//GEN-LAST:event_jMenuPersonelAraActionPerformed

    private void jMenuKullaniciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuKullaniciActionPerformed
        
    }//GEN-LAST:event_jMenuKullaniciActionPerformed
   
    private void jMenuItemKullaniciUyelikBilgileriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKullaniciUyelikBilgileriActionPerformed
        KullaniciUyelikBilgileri kullanicitc = new KullaniciUyelikBilgileri();
        kullanicitc.bilgi_al(kullanici_tc);
        kullanicitc.setVisible(true);
    }//GEN-LAST:event_jMenuItemKullaniciUyelikBilgileriActionPerformed

    private void jMenuItemOduncVermeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemOduncVermeActionPerformed
        oduncVerme veren = new oduncVerme();
        veren.bilgi_al(kullanici_tc);
        veren.setVisible(true);
    }//GEN-LAST:event_jMenuItemOduncVermeActionPerformed

    private void jMenuItemCezaOdemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCezaOdemeActionPerformed
        new CezaOdeme().setVisible(true);
    }//GEN-LAST:event_jMenuItemCezaOdemeActionPerformed

    private void jMenuItemCezaMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCezaMailActionPerformed
        mail_yolla();
        //System.out.println("adasd");
    }//GEN-LAST:event_jMenuItemCezaMailActionPerformed

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
            java.util.logging.Logger.getLogger(anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anasayfa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new anasayfa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemCezaMail;
    private javax.swing.JMenuItem jMenuItemCezaOdeme;
    private javax.swing.JMenuItem jMenuItemKullaniciUyelikBilgileri;
    private javax.swing.JMenuItem jMenuItemOduncVerme;
    private javax.swing.JMenuItem jMenuKaynakArama;
    private javax.swing.JMenuItem jMenuKaynakDuzenle;
    private javax.swing.JMenuItem jMenuKaynakEkle;
    private javax.swing.JMenuItem jMenuKaynakSil;
    private javax.swing.JMenu jMenuKullanici;
    private javax.swing.JMenuItem jMenuPersonelAra;
    private javax.swing.JMenuItem jMenuPersonelDuzenle;
    private javax.swing.JMenuItem jMenuPersonelEkle;
    private javax.swing.JMenuItem jMenuPersonelSil;
    private javax.swing.JMenuItem jMenuUyeDuzenle;
    private javax.swing.JMenuItem jMenuUyeEkle;
    private javax.swing.JMenuItem jMenuUyeListele;
    private javax.swing.JMenuItem jMenuUyeSil;
    // End of variables declaration//GEN-END:variables
}
