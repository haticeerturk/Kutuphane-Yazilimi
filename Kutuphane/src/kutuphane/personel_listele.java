package kutuphane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hatice Ertürk
 */
public class personel_listele extends javax.swing.JFrame {
    private Connection baglanti;
    private Statement ifade;
    
    public personel_listele() {
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePersoneller = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPersonelTC = new javax.swing.JTextField();
        jButtonPersonelAra = new javax.swing.JButton();
        jButtonTumPersonelleriGoster = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(300, 100));
        setResizable(false);

        jTablePersoneller.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TC", "Adı", "Soyadı", "Görevi", "Adres", "Sabit Telefon", "Cep Telefon"
            }
        ));
        jScrollPane1.setViewportView(jTablePersoneller);

        jLabel1.setText("Personelin TC Numarasını Girin      :");

        jButtonPersonelAra.setText("ARA");
        jButtonPersonelAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPersonelAraActionPerformed(evt);
            }
        });

        jButtonTumPersonelleriGoster.setText("Tüm Personeller");
        jButtonTumPersonelleriGoster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTumPersonelleriGosterActionPerformed(evt);
            }
        });

        jLabel2.setText("Aranan Personelin Bilgileri");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117)
                        .addComponent(jTextFieldPersonelTC, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jButtonPersonelAra, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jButtonTumPersonelleriGoster, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPersonelTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPersonelAra)
                    .addComponent(jButtonTumPersonelleriGoster))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPersonelAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPersonelAraActionPerformed
        try {
            //TC si girilen personelin bilgileri listelenecek.
            if(baglanti.isClosed()){
                DBBaglan();
            }
        } catch (SQLException ex) {
            Logger.getLogger(personel_listele.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String aranacak = jTextFieldPersonelTC.getText();
        try {
            String sql = "select * from PERSONEL where TC='"+aranacak+"'";
            ResultSet rs;
            rs = ifade.executeQuery(sql);
            int kacsutun = rs.getMetaData().getColumnCount(); //veritabanında kaç tane sütün olduğunu söylüyor.
                
            DefaultTableModel model = (DefaultTableModel) jTablePersoneller.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
            model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.

            while(rs.next()){
                Object[] row = new Object[kacsutun];
                for(int i=0;i<kacsutun;i++){
                    row[i] = rs.getObject(i+1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(personel_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(personel_listele.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonPersonelAraActionPerformed

    private void jButtonTumPersonelleriGosterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTumPersonelleriGosterActionPerformed
         try{
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "select * from PERSONEL";
            ResultSet rs = ifade.executeQuery(sql);
            int kacsutun = rs.getMetaData().getColumnCount(); //veritabanında kaç tane sütün olduğunu söylüyor.
            
            DefaultTableModel model = (DefaultTableModel) jTablePersoneller.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
            model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
            
            while(rs.next()){
                Object[] row = new Object[kacsutun];
                for(int i=0;i<kacsutun;i++){
                    row[i] = rs.getObject(i+1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(personel_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(personel_listele.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        //baslangic();
    }//GEN-LAST:event_jButtonTumPersonelleriGosterActionPerformed

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
            java.util.logging.Logger.getLogger(personel_listele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(personel_listele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(personel_listele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(personel_listele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new personel_listele().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPersonelAra;
    private javax.swing.JButton jButtonTumPersonelleriGoster;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePersoneller;
    private javax.swing.JTextField jTextFieldPersonelTC;
    // End of variables declaration//GEN-END:variables
}
