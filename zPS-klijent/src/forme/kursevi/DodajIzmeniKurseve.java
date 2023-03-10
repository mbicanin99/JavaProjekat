/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kursevi;

import domen.Kurs;
import domen.Menadzer;
import domen.Predavac;
import exception.ValidacijaException;
import forme.GlavnaFrm;
import forme.predavaci.DodajIzmeniPredavaca;
import forme.predavaci.PretraziPredavace;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;

/**
 *
 * @author hp
 */
public class DodajIzmeniKurseve extends javax.swing.JFrame {

    JFrame pretraziKurseve;
    Kurs kurs;
    String status;
    Menadzer ulogovaniMenadzer;
    /**
     * Creates new form DodajIzmeniKurseve
     */
   public DodajIzmeniKurseve(JFrame pretraziKurseve,Menadzer uloMenadzer) {
        initComponents();
        this.ulogovaniMenadzer=uloMenadzer;
        this.setTitle("Unos kursa");
        this.pretraziKurseve = pretraziKurseve;
        kurs=new Kurs(0, "", 0, "", "");
        this.status= "unos";
          setLocationRelativeTo(null);
    }
    
      
    public DodajIzmeniKurseve(PretraziKurseve pretraga, Kurs izabrani,Menadzer ulogovaniMenadzer) {
        initComponents();
        this.ulogovaniMenadzer=ulogovaniMenadzer;
        this.setTitle("Izmena kursa");
        this.pretraziKurseve = pretraga;
        this.kurs = izabrani;
        popuniPolja();
        this.status = "izmena";
          setLocationRelativeTo(null);
    }

    private DodajIzmeniKurseve() {
        initComponents();
          setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        txtBrojCasova = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cmbTipKursa = new javax.swing.JComboBox<>();
        btnSacuvaj = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnOdustani = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Naziv kursa:");

        jLabel2.setText("Broj ??asova:");

        jLabel3.setText("Opis:");

        txtOpis.setColumns(20);
        txtOpis.setRows(5);
        jScrollPane1.setViewportView(txtOpis);

        jLabel4.setText("Tip kursa:");

        cmbTipKursa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Osnovni nivo", "Srednji nivo", "Napredni nivo" }));

        btnSacuvaj.setText("Sa??uvaj");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        jLabel5.setText("Unesi podatke o kursu:");

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBrojCasova, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbTipKursa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(btnOdustani, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBrojCasova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbTipKursa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnOdustani))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        try {
        String naziv = txtNaziv.getText().trim();
        String brojCasova = txtBrojCasova.getText();
        String opis = txtOpis.getText().trim();
        String tipKursa = (String) cmbTipKursa.getSelectedItem();
        
        validirajIPostaviVrednosti(naziv,brojCasova,opis,tipKursa);
        
        Kurs k;
        
        if (status.equals("unos")) {
           k = (Kurs) Kontroler.vratiInstancu().sacuvajKurs(kurs);
          JOptionPane.showMessageDialog(this,  "\nNaziv: " + kurs.getNaziv()+ "\nBroj ??asova: " + kurs.getBrojCasova()+ "\nOpis : "+kurs.getOpis()+kurs.getTipKursa(),"Uspesno", JOptionPane.INFORMATION_MESSAGE);    

            } else {
           k = (Kurs) Kontroler.vratiInstancu().izmeniKurs(kurs);
          JOptionPane.showMessageDialog(this,  "\nNaziv: " + kurs.getNaziv()+ "\nBroj ??asova: " + kurs.getBrojCasova()+ "\nOpis : "+kurs.getOpis()+kurs.getTipKursa(),"Uspesno", JOptionPane.INFORMATION_MESSAGE);     
       
            }
        
            PretraziKurseve p=new PretraziKurseve(pretraziKurseve,ulogovaniMenadzer);
            p.srediTabelu();
            pretraziKurseve.setVisible(true);
            dispose();
       } catch (ValidacijaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Gre??ka", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(DodajIzmeniPredavaca.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        PretraziKurseve pk=new PretraziKurseve(pretraziKurseve,ulogovaniMenadzer);
        pk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

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
            java.util.logging.Logger.getLogger(DodajIzmeniKurseve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DodajIzmeniKurseve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DodajIzmeniKurseve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DodajIzmeniKurseve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DodajIzmeniKurseve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox<String> cmbTipKursa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBrojCasova;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration//GEN-END:variables
  private void validirajIPostaviVrednosti(String naziv, String brojCasova, String opis, String tipKursa) throws Exception {
        if (naziv.isEmpty() || brojCasova.isEmpty()|| opis.isEmpty() || tipKursa.isEmpty()) {
            throw new ValidacijaException("Sva polja su obavezna!");
        
        }
        
        kurs.setNaziv(naziv);
        kurs.setBrojCasova(Integer.parseInt(brojCasova));
        kurs.setOpis(opis);
        kurs.setTipKursa(tipKursa);
        
    }

    private void popuniPolja() {
//da li ovde treba i za id
        txtNaziv.setText(kurs.getNaziv());
        txtBrojCasova.setText(String.valueOf(kurs.getBrojCasova()));
        txtOpis.setText(kurs.getOpis());
        cmbTipKursa.addItem((String)kurs.getTipKursa());
       
    }





}
