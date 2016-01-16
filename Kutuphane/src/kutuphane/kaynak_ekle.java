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
public class kaynak_ekle extends javax.swing.JFrame {
    private Connection baglanti;
    private Statement ifade;
    int tur_id;
    public kaynak_ekle() {
        initComponents();
        DBBaglan();
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxKaynakTur = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldKaynakAd = new javax.swing.JTextField();
        jTextFieldKaynakBoyut = new javax.swing.JTextField();
        jTextFieldKaynakYayinevi = new javax.swing.JTextField();
        jTextFieldKaynakYazar = new javax.swing.JTextField();
        jTextFieldKaynakYili = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonKaynakEkle = new javax.swing.JButton();
        jLabelBarkod = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(400, 200));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel1.setText("KAYNAK BİLGİLERİNİ GİRİN");

        jLabel2.setText("Barkod                   :");

        jLabel3.setText("Adı                         :");

        jLabel4.setText("Boyut(Sayfa/MB)   : ");

        jLabel5.setText("Yayın Evi                :");

        jComboBoxKaynakTur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Türünü Seçin", "Kitap", "Dergi", "CD", "Gazete" }));
        jComboBoxKaynakTur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxKaynakTurActionPerformed(evt);
            }
        });

        jLabel6.setText("Yazar                      :");

        jLabel8.setText("Basım Yılı              : ");

        jButtonKaynakEkle.setText("KAYDET");
        jButtonKaynakEkle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonKaynakEkleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(jButtonKaynakEkle))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(57, 57, 57)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldKaynakAd, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(22, 22, 22)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldKaynakBoyut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldKaynakYayinevi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldKaynakYazar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldKaynakYili, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(114, 114, 114)
                            .addComponent(jComboBoxKaynakTur, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxKaynakTur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelBarkod, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldKaynakAd)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldKaynakBoyut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldKaynakYayinevi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jTextFieldKaynakYazar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jTextFieldKaynakYili, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 19, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10)))
                .addComponent(jButtonKaynakEkle)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxKaynakTurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxKaynakTurActionPerformed
        String tur_adi = jComboBoxKaynakTur.getSelectedItem().toString();
        
        if(tur_adi.equals("Kitap")) {
            for(int i=1; i<101; i++) { //raf sayısı buradaki.
                String sql = "select count(*) as x from KAYNAKLAR where "
                        + "TUR_ID IN (select TUR_ID from KAYNAK_TUR where "
                        + "TUR_AD = 'Kitap') AND BARKOD LIKE 'KTP-"+Integer.toString(i)+"-%'";
                ResultSet rs;
                try {
                    rs = ifade.executeQuery(sql);
                    rs.next();
                    //Kutuphanede bir rafa 100 kitap yerleştirilebiliyor.
                    if(rs.getString("x").equals("100")){
                        continue;
                    }
                    else{
                        String yeni_barkod = "KTP-"+Integer.toString(i)+"-"+String.format("%03d", Integer.parseInt(rs.getString("x"))+1);
                        jLabelBarkod.setText(yeni_barkod);
                        break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(kaynak_ekle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                      
        }
        else if(tur_adi.equals("Dergi")) {
            for(int i=1; i<101; i++) { //raf sayısı buradaki.
                String sql = "select count(*) as x from KAYNAKLAR where "
                        + "TUR_ID IN (select TUR_ID from KAYNAK_TUR where "
                        + "TUR_AD = 'Dergi') AND BARKOD LIKE 'DRG-"+Integer.toString(i)+"-%'";
                ResultSet rs;
                try {
                    rs = ifade.executeQuery(sql);
                    rs.next();
                    //Kutuphanede bir rafa 200 dergi yerleştirilebiliyor.
                    if(rs.getString("x").equals("200")){
                        continue;
                    }
                    else{
                        String yeni_barkod = "DRG-"+Integer.toString(i)+"-"+String.format("%03d", Integer.parseInt(rs.getString("x"))+1);
                        jLabelBarkod.setText(yeni_barkod);
                        break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(kaynak_ekle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                      
        }
        else if(tur_adi.equals("CD")) {
            for(int i=1; i<101; i++) { //raf sayısı buradaki.
                String sql = "select count(*) as x from KAYNAKLAR where "
                        + "TUR_ID IN (select TUR_ID from KAYNAK_TUR where "
                        + "TUR_AD = 'CD') AND BARKOD LIKE 'CD-"+Integer.toString(i)+"-%'";
                ResultSet rs;
                try {
                    rs = ifade.executeQuery(sql);
                    rs.next();
                    //Kutuphanede bir rafa 200 CD yerleştirilebiliyor.
                    if(rs.getString("x").equals("200")){
                        continue;
                    }
                    else{
                        String yeni_barkod = "CD-"+Integer.toString(i)+"-"+String.format("%03d", Integer.parseInt(rs.getString("x"))+1);
                        System.out.println(yeni_barkod);
                        jLabelBarkod.setText(yeni_barkod);
                        break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(kaynak_ekle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                      
        }
        else if(tur_adi.equals("Gazete")) {
            for(int i=1; i<101; i++) { //raf sayısı buradaki.
                String sql = "select count(*) as x from KAYNAKLAR where "
                        + "TUR_ID IN (select TUR_ID from KAYNAK_TUR where "
                        + "TUR_AD = 'Gazete') AND BARKOD LIKE 'GZT-"+Integer.toString(i)+"-%'";
                ResultSet rs;
                try {
                    rs = ifade.executeQuery(sql);
                    rs.next();
                    //Kutuphanede bir rafa 100 Gazete yerleştirilebiliyor.
                    if(rs.getString("x").equals("100")){
                        continue;
                    }
                    else{
                        String yeni_barkod = "GZT-"+Integer.toString(i)+"-"+String.format("%03d", Integer.parseInt(rs.getString("x"))+1);
                        jLabelBarkod.setText(yeni_barkod);
                        break;
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(kaynak_ekle.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                      
        }
    }//GEN-LAST:event_jComboBoxKaynakTurActionPerformed

    private void jButtonKaynakEkleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonKaynakEkleActionPerformed
        //yazılan veriler alınıp database e kaydedilecek.
        
        String barkod = jLabelBarkod.getText();
        String ad = jTextFieldKaynakAd.getText();
        String boyut = jTextFieldKaynakBoyut.getText();
        String yayin_evi = jTextFieldKaynakYayinevi.getText();
        String yazar = jTextFieldKaynakYazar.getText();
        String basim_yili = jTextFieldKaynakYili.getText();
        String tur_adi = jComboBoxKaynakTur.getSelectedItem().toString();
        
        if(tur_adi.equals("Kitap")) tur_id = 1;
        else if(tur_adi.equals("Dergi")) tur_id = 2;
        else if(tur_adi.equals("CD")) tur_id = 3;
        else if(tur_adi.equals("Gazete")) tur_id = 4;
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "insert into KAYNAKLAR values('"+barkod+"','"+ad+"','"+boyut+"','"+yayin_evi+"','"+yazar+"','"+basim_yili+"',"+tur_id+",false)";
            ifade.executeUpdate(sql);        
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(kaynak_ekle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.dispose();
    }//GEN-LAST:event_jButtonKaynakEkleActionPerformed

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
            java.util.logging.Logger.getLogger(kaynak_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(kaynak_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(kaynak_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(kaynak_ekle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new kaynak_ekle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonKaynakEkle;
    private javax.swing.JComboBox jComboBoxKaynakTur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelBarkod;
    private javax.swing.JTextField jTextFieldKaynakAd;
    private javax.swing.JTextField jTextFieldKaynakBoyut;
    private javax.swing.JTextField jTextFieldKaynakYayinevi;
    private javax.swing.JTextField jTextFieldKaynakYazar;
    private javax.swing.JTextField jTextFieldKaynakYili;
    // End of variables declaration//GEN-END:variables
}
