package kutuphane;

import com.sun.org.apache.bcel.internal.generic.L2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hatice Ertürk
 */
public class uye_listele extends javax.swing.JFrame {
    private Connection baglanti;
    private Statement ifade;
    int kackez;
    int tur = 0;
    
    public uye_listele() {
        initComponents();
        baslangic();
        DBBaglan();
        //biz tek tıklayınca row a o 2 tıklama zannediyordu bu yüzden bizde 2nin katları şeklinde tıklamaları varsaydık.
        //yani bir kez tıklayınca artık bize tek bir kere getiricek.yani 2 kere yazmıcak.
        jTableOgrenci.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                kackez++;
                if(kackez%2 == 0){
                    String no = jTableOgrenci.getValueAt(jTableOgrenci.getSelectedRow(), 0).toString();
                    tur = 1;
                    kitaplariListele(no,tur);
                }
            }
        });
        //öğretmenler için
        jTableOgretmen.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                kackez++;
                if(kackez%2 == 0){
                    String no = jTableOgretmen.getValueAt(jTableOgretmen.getSelectedRow(), 0).toString();
                    tur = 2;
                    kitaplariListele(no,tur);
                }
            }
        });
        //Dışarıdan kayıtlı üyeler için
        jTableDisaridan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                kackez++;
                if(kackez%2 == 0){
                    String no = jTableDisaridan.getValueAt(jTableDisaridan.getSelectedRow(), 0).toString();
                    tur = 3;
                    kitaplariListele(no,tur);
                }
            }
        });
    }

    private void baslangic(){
        buttonGroup1.add(jRadioButtonOgrenci);
        buttonGroup1.add(jRadioButtonOgretmen);
        buttonGroup1.add(jRadioButtonDisaridan);
        jPanelOgrenci.setVisible(false);
        jLabel1.setVisible(false);
        jPanelListKitaplar.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jPanelDisaridan.setVisible(false);
    }
    
   public void kitaplariListele(String no, int tur){
       DefaultListModel model = new DefaultListModel();
       jListKitaplar.setModel(model);
       // gelen no degiskenine gore veritabanindan kullanicinin sahip oldugu kitaplar cekilir.
       //modelnormal oluşturulur dahasonra listeye set edilir.sonrada eleman eklenir.
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            if(tur == 1){
                String sql = "select (select AD from KAYNAKLAR where BARKOD=OGRENCI_ODUNC.O_KAYNAK) from OGRENCI_ODUNC where O_VERILEN='"+no+"' and O_KAYNAK_DURUMU=false";
                ResultSet rs = ifade.executeQuery(sql);
                
                boolean hic = false;
                while(rs.next()){
                    hic = true;
                    model.addElement(rs.getString(1));
                } 
                if(!hic){
                    model.addElement("Üye Üzerinde Kitap Bulunmamaktadır!");
                }
            }
            
            else if(tur == 2){
                String sql = "select (select AD from KAYNAKLAR where BARKOD=OGRETMEN_ODUNC.O_KAYNAK) from OGRETMEN_ODUNC where O_VERILEN='"+no+"' and O_KAYNAK_DURUMU=false";
                ResultSet rs = ifade.executeQuery(sql);

                boolean hic = false;
                while(rs.next()){
                    hic = true;
                    model.addElement(rs.getString(1));
                } 
                if(!hic){
                    model.addElement("Üye Üzerinde Kitap Bulunmamaktadır!");
                }
            }
            
            else {
                String sql = "select (select AD from KAYNAKLAR where BARKOD=DISARIDAN_ODUNC.O_KAYNAK) from DISARIDAN_ODUNC where O_VERILEN='"+no+"' and O_KAYNAK_DURUMU=false";
                ResultSet rs = ifade.executeQuery(sql);

                boolean hic = false;
                while(rs.next()){
                    hic = true;
                    model.addElement(rs.getString(1));
                } 
                if(!hic){
                    model.addElement("Üye Üzerinde Kitap Bulunmamaktadır!");
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
           try {
               baglanti.close();
           } catch (SQLException ex) {
               Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
       
       //model.addElement("Ömer seyfettin");
       
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jRadioButtonOgrenci = new javax.swing.JRadioButton();
        jRadioButtonOgretmen = new javax.swing.JRadioButton();
        jRadioButtonDisaridan = new javax.swing.JRadioButton();
        jPanelOgrenci = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableOgrenci = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldOgrenciNumara = new javax.swing.JTextField();
        jButtonOgrenciAra = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanelListKitaplar = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListKitaplar = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jPanelOgretmen = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableOgretmen = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldOgretmenTC = new javax.swing.JTextField();
        jButtonOgretmenAra = new javax.swing.JButton();
        jPanelDisaridan = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableDisaridan = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldDisaridanTC = new javax.swing.JTextField();
        jButtonDisaridanAra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(300, 25));
        setPreferredSize(new java.awt.Dimension(900, 700));
        setResizable(false);

        jRadioButtonOgrenci.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jRadioButtonOgrenci.setText("ÖĞRENCİ");
        jRadioButtonOgrenci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOgrenciActionPerformed(evt);
            }
        });

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

        jTableOgrenci.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jTableOgrenci.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Öğrenci Numarası", "Öğrenci Adı", "Öğrenci Soyadı", "Öğrenci Mail Adresi", "Öğrencinin Okuduğu Bölüm"
            }
        ));
        jScrollPane1.setViewportView(jTableOgrenci);

        jLabel3.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel3.setText("Öğrenci Numarasını Girin : ");

        jTextFieldOgrenciNumara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOgrenciNumaraActionPerformed(evt);
            }
        });

        jButtonOgrenciAra.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButtonOgrenciAra.setText("ARA");
        jButtonOgrenciAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOgrenciAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOgrenciLayout = new javax.swing.GroupLayout(jPanelOgrenci);
        jPanelOgrenci.setLayout(jPanelOgrenciLayout);
        jPanelOgrenciLayout.setHorizontalGroup(
            jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addGap(35, 35, 35))
            .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(jTextFieldOgrenciNumara, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
            .addGroup(jPanelOgrenciLayout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(jButtonOgrenciAra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOgrenciLayout.setVerticalGroup(
            jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOgrenciLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOgrenciLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldOgrenciNumara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonOgrenciAra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel2.setText("Lütfen Üye Türünü Seçiniz");

        jListKitaplar.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jScrollPane3.setViewportView(jListKitaplar);

        jLabel1.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel1.setText("Üyenin Sahip Olduğu Kitaplar");

        javax.swing.GroupLayout jPanelListKitaplarLayout = new javax.swing.GroupLayout(jPanelListKitaplar);
        jPanelListKitaplar.setLayout(jPanelListKitaplarLayout);
        jPanelListKitaplarLayout.setHorizontalGroup(
            jPanelListKitaplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListKitaplarLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelListKitaplarLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelListKitaplarLayout.setVerticalGroup(
            jPanelListKitaplarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListKitaplarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTableOgretmen.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jTableOgretmen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Öğretmen TC Numarası", "Öğretmen Adı", "ÖğretmenSoyadı", "Öğretmen Mail Adresi", "Öğretmenin Çalıştığı Yer"
            }
        ));
        jScrollPane2.setViewportView(jTableOgretmen);

        jLabel4.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel4.setText("Öğretmenin TC Numarasını Girin :");

        jTextFieldOgretmenTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldOgretmenTCActionPerformed(evt);
            }
        });

        jButtonOgretmenAra.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButtonOgretmenAra.setText("ARA");
        jButtonOgretmenAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOgretmenAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOgretmenLayout = new javax.swing.GroupLayout(jPanelOgretmen);
        jPanelOgretmen.setLayout(jPanelOgretmenLayout);
        jPanelOgretmenLayout.setHorizontalGroup(
            jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addGap(35, 35, 35))
            .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jTextFieldOgretmenTC, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelOgretmenLayout.createSequentialGroup()
                        .addGap(276, 276, 276)
                        .addComponent(jButtonOgretmenAra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelOgretmenLayout.setVerticalGroup(
            jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOgretmenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelOgretmenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldOgretmenTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonOgretmenAra)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
        );

        jTableDisaridan.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jTableDisaridan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TC Numarası", "Adı", "Soyadı", "Mail Adresi", "Ev Adresi"
            }
        ));
        jScrollPane4.setViewportView(jTableDisaridan);

        jLabel5.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel5.setText("Dışarıdan TC Numarasını Girin :");

        jTextFieldDisaridanTC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDisaridanTCActionPerformed(evt);
            }
        });

        jButtonDisaridanAra.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jButtonDisaridanAra.setText("ARA");
        jButtonDisaridanAra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDisaridanAraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDisaridanLayout = new javax.swing.GroupLayout(jPanelDisaridan);
        jPanelDisaridan.setLayout(jPanelDisaridanLayout);
        jPanelDisaridanLayout.setHorizontalGroup(
            jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
                .addGap(35, 35, 35))
            .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jTextFieldDisaridanTC, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDisaridanLayout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jButtonDisaridanAra, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDisaridanLayout.setVerticalGroup(
            jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDisaridanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDisaridanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldDisaridanTC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDisaridanAra)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelOgrenci, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelOgretmen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jRadioButtonOgrenci)
                                .addGap(32, 32, 32)
                                .addComponent(jRadioButtonOgretmen)
                                .addGap(32, 32, 32)
                                .addComponent(jRadioButtonDisaridan)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanelDisaridan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jPanelListKitaplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonOgrenci)
                    .addComponent(jRadioButtonOgretmen)
                    .addComponent(jRadioButtonDisaridan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelOgrenci, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelOgretmen, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDisaridan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelListKitaplar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(449, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonDisaridanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDisaridanActionPerformed
        jPanelOgrenci.setVisible(false);
        jPanelOgretmen.setVisible(false);
        jLabel1.setVisible(true);
        jPanelListKitaplar.setVisible(true);
        jPanelDisaridan.setVisible(true);
        jTableDisaridan.setVisible(true);
        
        try {
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "select * from DISARIDAN_UYE";
            ResultSet rs = ifade.executeQuery(sql);
            int kacsutun = rs.getMetaData().getColumnCount(); //veritabanında kaç tane sütün olduğunu söylüyor.
            DefaultTableModel model = (DefaultTableModel) jTableDisaridan.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
            model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
            
            while(rs.next()){
                Object[] row = new Object[kacsutun];
                for(int i=0;i<kacsutun;i++){
                    row[i] = rs.getObject(i+1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*
        model.addRow(new Object[]{"130401027","Hatice","ERTÜRK","haticeerturk27@gmail.com","Bursa"});
        model.addRow(new Object[]{"g111210061","Mert","TAŞCI","merttasci2@gmail.com","İstanbul"});
        model.addRow(new Object[]{"1","Zehra","ERTÜRK","cilgin_zehra@gmail.com","Bursa"});
        model.addRow(new Object[]{"10","merve","taşcı","utanmaz_asi@gmail.com","unkown"});
        */
    }//GEN-LAST:event_jRadioButtonDisaridanActionPerformed

    private void jRadioButtonOgrenciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOgrenciActionPerformed
       jPanelOgretmen.setVisible(false);
       jPanelOgrenci.setVisible(true);
       jPanelDisaridan.setVisible(false);
       jPanelListKitaplar.setVisible(true);
       jLabel1.setVisible(true);
        // SQL ile tipi ogrenci olanlar cekilir.
       
       try {
           if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "select * from OGRENCI_UYE";
            ResultSet rs = ifade.executeQuery(sql);
            int kacsutun = rs.getMetaData().getColumnCount(); //veritabanında kaç tane sütün olduğunu söylüyor.
            DefaultTableModel model = (DefaultTableModel) jTableOgrenci.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
            model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
            
            while(rs.next()){
                Object[] row = new Object[kacsutun];
                for(int i=0;i<kacsutun;i++){
                    row[i] = rs.getObject(i+1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
           try {
               baglanti.close();
           } catch (SQLException ex) {
               Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       
        /*DefaultTableModel model = (DefaultTableModel) jTableOgrenci.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
        model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
        
        model.addRow(new Object[]{"130401027","Hatice","ERTÜRK","haticeerturk27@gmail.com","Bilgisayar Mühendisliği"});
        model.addRow(new Object[]{"g111210061","Mert","TAŞCI","merttasci2@gmail.com","Bilgisayar Mühendisliği"});
        model.addRow(new Object[]{"1","Zehra","ERTÜRK","cilgin_zehra@gmail.com","Bilgisayar Mühendisliği"});
        model.addRow(new Object[]{"10","merve","taşcı","utanmaz_asi@gmail.com","Su Mühendisliği"});
        */
    }//GEN-LAST:event_jRadioButtonOgrenciActionPerformed

    private void jRadioButtonOgretmenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOgretmenActionPerformed
        jPanelDisaridan.setVisible(false);
        jPanelOgrenci.setVisible(false);
        jPanelOgretmen.setVisible(true);
        jPanelListKitaplar.setVisible(true);
        jLabel1.setVisible(true);
        
        try{
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String sql = "select * from OGRETMEN_UYE";
            ResultSet rs = ifade.executeQuery(sql);
            int kacsutun = rs.getMetaData().getColumnCount(); //veritabanında kaç tane sütün olduğunu söylüyor.
            DefaultTableModel model = (DefaultTableModel) jTableOgretmen.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
            model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
            
            while(rs.next()){
                Object[] row = new Object[kacsutun];
                for(int i=0;i<kacsutun;i++){
                    row[i] = rs.getObject(i+1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*
        DefaultTableModel model = (DefaultTableModel) jTableOgretmen.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
        model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
        
        model.addRow(new Object[]{"130401027","Hatice","ERTÜRK","haticeerturk27@gmail.com","Bilgisayar Mühendisliği"});
        model.addRow(new Object[]{"g111210061","Mert","TAŞCI","merttasci2@gmail.com","Bilgisayar Mühendisliği"});
        model.addRow(new Object[]{"1","Zehra","ERTÜRK","cilgin_zehra@gmail.com","Bilgisayar Mühendisliği"});
        model.addRow(new Object[]{"10","merve","taşcı","tan_asi@gmail.com","Su Mühendisliği"});
        */
    }//GEN-LAST:event_jRadioButtonOgretmenActionPerformed

    private void jTextFieldOgrenciNumaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOgrenciNumaraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOgrenciNumaraActionPerformed

    private void jButtonOgrenciAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOgrenciAraActionPerformed
        try{
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String aranacak_ogr = jTextFieldOgrenciNumara.getText();
            String sql = "select * from OGRENCI_UYE where OKUL_NO='"+aranacak_ogr+"'";
            ResultSet rs = ifade.executeQuery(sql);
            int kacsutun = rs.getMetaData().getColumnCount(); //veritabanında kaç tane sütün olduğunu söylüyor.
            DefaultTableModel model = (DefaultTableModel) jTableOgrenci.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
            model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
            
            while(rs.next()){
                Object[] row = new Object[kacsutun];
                for(int i=0;i<kacsutun;i++){
                    row[i] = rs.getObject(i+1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonOgrenciAraActionPerformed

    private void jTextFieldOgretmenTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldOgretmenTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldOgretmenTCActionPerformed

    private void jButtonOgretmenAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOgretmenAraActionPerformed
        try{
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String aranacak_ogretmen = jTextFieldOgretmenTC.getText();
            String sql = "select * from OGRETMEN_UYE where TC='"+aranacak_ogretmen+"'";
            ResultSet rs = ifade.executeQuery(sql);
            int kacsutun = rs.getMetaData().getColumnCount(); //veritabanında kaç tane sütün olduğunu söylüyor.
            DefaultTableModel model = (DefaultTableModel) jTableOgretmen.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
            model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
            
            while(rs.next()){
                Object[] row = new Object[kacsutun];
                for(int i=0;i<kacsutun;i++){
                    row[i] = rs.getObject(i+1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonOgretmenAraActionPerformed

    private void jTextFieldDisaridanTCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDisaridanTCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDisaridanTCActionPerformed

    private void jButtonDisaridanAraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDisaridanAraActionPerformed
        try{
            if(baglanti.isClosed()){
                DBBaglan();
            }
            String aranacak_disaridan = jTextFieldDisaridanTC.getText();
            String sql = "select * from DISARIDAN_UYE where TC='"+aranacak_disaridan+"'";
            ResultSet rs = ifade.executeQuery(sql);
            int kacsutun = rs.getMetaData().getColumnCount(); //veritabanında kaç tane sütün olduğunu söylüyor.
            DefaultTableModel model = (DefaultTableModel) jTableDisaridan.getModel();//veri ekleyeceğimiz ortamı oluşturduk.
            model.setRowCount(0);//butona her tıklanıldığında aynı şeyi eklememesi için tablo içeriğini sıfırlar.
            
            while(rs.next()){
                Object[] row = new Object[kacsutun];
                for(int i=0;i<kacsutun;i++){
                    row[i] = rs.getObject(i+1);
                }
                model.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                baglanti.close();
            } catch (SQLException ex) {
                Logger.getLogger(uye_listele.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(uye_listele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(uye_listele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(uye_listele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(uye_listele.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new uye_listele().setVisible(true);
            }
        });
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonDisaridanAra;
    private javax.swing.JButton jButtonOgrenciAra;
    private javax.swing.JButton jButtonOgretmenAra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList jListKitaplar;
    private javax.swing.JPanel jPanelDisaridan;
    private javax.swing.JPanel jPanelListKitaplar;
    private javax.swing.JPanel jPanelOgrenci;
    private javax.swing.JPanel jPanelOgretmen;
    private javax.swing.JRadioButton jRadioButtonDisaridan;
    private javax.swing.JRadioButton jRadioButtonOgrenci;
    private javax.swing.JRadioButton jRadioButtonOgretmen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableDisaridan;
    private javax.swing.JTable jTableOgrenci;
    private javax.swing.JTable jTableOgretmen;
    private javax.swing.JTextField jTextFieldDisaridanTC;
    private javax.swing.JTextField jTextFieldOgrenciNumara;
    private javax.swing.JTextField jTextFieldOgretmenTC;
    // End of variables declaration//GEN-END:variables
}
