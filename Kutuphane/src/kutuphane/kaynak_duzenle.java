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
public class kaynak_duzenle extends javax.swing.JFrame {
    private Connection baglanti;
    private Statement ifade;
    int tur_id = 0;
    
    public kaynak_duzenle() {
        initComponents();
        baslangic();
        DBBaglan();
    }
    
    private void baslangic(){
        jPanelGuncelle.setVisible(false);
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

        jPanelKaynakAra = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBarkodAra = new javax.swing.JTextField();
        jButtonAra = new javax.swing.JButton();
        jPanelGuncelle = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButtonGuncelle = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldBarkot = new javax.swing.JTextField();
        jTextFieldAd = new javax.swing.JTextField();
        jTextFieldBoyut = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldYayinEvi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldYazar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldBasimYili = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(400, 150));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel1.setText("Kaynak Barkodunu Girin :");

        jTextFieldBarkodAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBarkodAraActionPerformed(evt);
            }
        });

        jButtonAra.setText("ARA");
        jButtonAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelKaynakAraLayout = new javax.swing.GroupLayout(jPanelKaynakAra);
        jPanelKaynakAra.setLayout(jPanelKaynakAraLayout);
        jPanelKaynakAraLayout.setHorizontalGroup(
            jPanelKaynakAraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKaynakAraLayout.createSequentialGroup()
                .addGroup(jPanelKaynakAraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelKaynakAraLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldBarkodAra, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelKaynakAraLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jButtonAra, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanelKaynakAraLayout.setVerticalGroup(
            jPanelKaynakAraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelKaynakAraLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanelKaynakAraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldBarkodAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jButtonAra)
                .addContainerGap())
        );

        jLabel8.setText("Basım Yılı              : ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Türünü Seçin", "Kitap", "Dergi", "CD", "Gazete" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButtonGuncelle.setText("GÜNCELLE");
        jButtonGuncelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuncelleActionPerformed(evt);
            }
        });

        jLabel6.setText("Yazar                      :");

        jTextFieldBarkot.setEditable(false);

        jLabel2.setText("Barkod                   :");

        jLabel3.setText("Adı                         :");

        jLabel4.setText("Boyut(Sayfa/MB)   : ");

        jLabel5.setText("Yayın Evi                :");

        javax.swing.GroupLayout jPanelGuncelleLayout = new javax.swing.GroupLayout(jPanelGuncelle);
        jPanelGuncelle.setLayout(jPanelGuncelleLayout);
        jPanelGuncelleLayout.setHorizontalGroup(
            jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                    .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldAd, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                                    .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                                            .addGap(22, 22, 22)
                                            .addComponent(jTextFieldBarkot, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGuncelleLayout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTextFieldBoyut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldYayinEvi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldYazar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldBasimYili, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(jButtonGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(30, Short.MAX_VALUE)))
        );
        jPanelGuncelleLayout.setVerticalGroup(
            jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldBarkot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldAd)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldBoyut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelGuncelleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelGuncelleLayout.createSequentialGroup()
                            .addComponent(jTextFieldYayinEvi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(9, 9, 9)
                            .addComponent(jTextFieldYazar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8)
                            .addComponent(jTextFieldBasimYili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addComponent(jButtonGuncelle)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelKaynakAra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelGuncelle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelKaynakAra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelGuncelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBarkodAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBarkodAraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBarkodAraActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        //combo box da seçtiğimiz içeriği aldık.
        /*String value=jComboBoxTur.getSelectedItem().toString();
        System.out.println(value);
        */
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButtonGuncelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuncelleActionPerformed
        //yazılan veriler alınıp database e kaydedilecek.
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
        } catch (SQLException ex) {
            Logger.getLogger(kaynak_duzenle.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String barkot = jTextFieldBarkot.getText();
        //sql injection bırakıldı.
        //barkot = barkot.replace("'", "seni gidi küçük heçkır ");
        String ad = jTextFieldAd.getText();
        String boyut = jTextFieldBoyut.getText();
        String yayin_evi = jTextFieldYayinEvi.getText();
        String yazar = jTextFieldYazar.getText();
        String basim_yili = jTextFieldBasimYili.getText();
        String tur_adi = jComboBox2.getSelectedItem().toString();
        
        if(tur_adi == "Kitap") tur_id = 1;
        else if(tur_adi == "Dergi") tur_id = 2;
        else if(tur_adi == "CD") tur_id = 3;
        else if(tur_adi == "Gazete") tur_id = 4;
        
        try {
            String sql = "update KAYNAKLAR set BARKOD='"+barkot+"', AD='"+ad+"', BOYUT='"+boyut+"', YAYIN_EVI='"
                            +yayin_evi+"', YAZAR='"+yazar+"', BASIM_YILI='"+basim_yili+"', TUR_ID="
                            +tur_id+" where BARKOD='"+barkot+"'";
            ifade.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(kaynak_duzenle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.dispose();
    }//GEN-LAST:event_jButtonGuncelleActionPerformed

    private void jButtonAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAraActionPerformed
        //database de barkod numarasını arayıp bilgileri texfieldlara yazacak.
        jPanelGuncelle.setVisible(true);
        
        String arama = jTextFieldBarkodAra.getText();
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "select * from KAYNAKLAR where BARKOD='"+arama+"'";
            ResultSet rs = ifade.executeQuery(sql);
            rs.next();
            jTextFieldBarkot.setText(rs.getString("BARKOD"));
            jTextFieldAd.setText(rs.getString("AD"));
            jTextFieldBoyut.setText(rs.getString("BOYUT"));
            jTextFieldYayinEvi.setText(rs.getString("YAYIN_EVI"));
            jTextFieldYazar.setText(rs.getString("YAZAR"));
            jTextFieldBasimYili.setText(rs.getString("BASIM_YILI"));
            jComboBox2.setSelectedIndex(rs.getInt("TUR_ID"));
        } catch (SQLException ex) {
            Logger.getLogger(kaynak_duzenle.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(kaynak_duzenle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButtonAraActionPerformed

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
            java.util.logging.Logger.getLogger(kaynak_duzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kaynak_duzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kaynak_duzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kaynak_duzenle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kaynak_duzenle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAra;
    private javax.swing.JButton jButtonGuncelle;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanelGuncelle;
    private javax.swing.JPanel jPanelKaynakAra;
    private javax.swing.JTextField jTextFieldAd;
    private javax.swing.JTextField jTextFieldBarkodAra;
    private javax.swing.JTextField jTextFieldBarkot;
    private javax.swing.JTextField jTextFieldBasimYili;
    private javax.swing.JTextField jTextFieldBoyut;
    private javax.swing.JTextField jTextFieldYayinEvi;
    private javax.swing.JTextField jTextFieldYazar;
    // End of variables declaration//GEN-END:variables
}
