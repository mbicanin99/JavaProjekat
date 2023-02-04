/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme.kursevi;

import domen.AbstractObjekat;
import domen.Kurs;
import domen.Menadzer;
import exception.ValidacijaException;
import forme.GlavnaFrm;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import kontroler.Kontroler;
import model.ModelTabeleKursevi;

/**
 *
 * @author hp
 */
public class PretraziKurseve extends javax.swing.JFrame {

    JFrame glavna;
    ModelTabeleKursevi mtk;
    Menadzer ulogovaniMenadzer;

    /**
     * Creates new form PretraziKurseve
     */
    public PretraziKurseve() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public PretraziKurseve(JFrame glavna, Menadzer ulogovaniMenadzer) {
        initComponents();
        this.setTitle("Pretraga kurseva");
        this.glavna = glavna;
        this.ulogovaniMenadzer = ulogovaniMenadzer;
        srediFormu();
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
        txtNaziv = new javax.swing.JTextField();
        btnPretrazi = new javax.swing.JButton();
        btnOdustani = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKursevi = new javax.swing.JTable();
        btnDodaj = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pretraži grupe po nazivu:");

        btnPretrazi.setText("Pretraži");
        btnPretrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPretraziActionPerformed(evt);
            }
        });

        btnOdustani.setText("Odustani");
        btnOdustani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOdustaniActionPerformed(evt);
            }
        });

        tblKursevi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblKursevi);

        btnDodaj.setText("Dodaj kurs");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnIzmeni.setText("Izmeni kurs");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obriši kurs");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPretrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(btnOdustani)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPretrazi)
                    .addComponent(btnOdustani))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDodaj)
                    .addComponent(btnIzmeni)
                    .addComponent(btnObrisi))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOdustaniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOdustaniActionPerformed
        GlavnaFrm gf = new GlavnaFrm(ulogovaniMenadzer);
        gf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnOdustaniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int index = tblKursevi.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Izaberite kurs koji želite da obrišete!", "Greška", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                Kurs izabraniKurs = (Kurs) mtk.getLista().get(index);
                int odluka = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da želite da obrišete izabrani kurs sa nazivom:" + izabraniKurs.toString() + "?", "", JOptionPane.WARNING_MESSAGE);
                if (odluka == 0) {
                    Kurs k = (Kurs) Kontroler.vratiInstancu().obrisiKurs(izabraniKurs);
                    JOptionPane.showMessageDialog(rootPane, "Obrisali ste podatke o kursu " + k.toString(), "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    srediTabelu();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(rootPane, "Došlo je do greške prilikom brisanja kursa!", "Greška", JOptionPane.ERROR_MESSAGE);

            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed
        int index = tblKursevi.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(rootPane, "Izaberite kurs koji želite da izmenite!", "Greška", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Kurs izabrani = (Kurs) mtk.getLista().get(index);
            DodajIzmeniKurseve df = new DodajIzmeniKurseve(this, izabrani, ulogovaniMenadzer);
            df.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        DodajIzmeniKurseve kursFrm = new DodajIzmeniKurseve(this, ulogovaniMenadzer);
        kursFrm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPretraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPretraziActionPerformed
        try {
            String naziv = txtNaziv.getText().trim();
            if (naziv.isEmpty()) {
                List<AbstractObjekat> listaKurseva = Kontroler.vratiInstancu().ucitajKurseve();
                mtk = new ModelTabeleKursevi(listaKurseva);
                tblKursevi.setModel(mtk);
            } else {

                List<AbstractObjekat> listaKurseva = Kontroler.vratiInstancu().pretraziKurseve(naziv);
                if (listaKurseva.isEmpty()) {
                     JOptionPane.showMessageDialog(this, "Sistem ne može da nađe kurseve po zadatoj vrednosti!");
                } else {
                    mtk = new ModelTabeleKursevi(listaKurseva);
                    tblKursevi.setModel(mtk);
                }
            }
        } catch (ValidacijaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Greška", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPretraziActionPerformed

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
            java.util.logging.Logger.getLogger(PretraziKurseve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PretraziKurseve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PretraziKurseve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PretraziKurseve.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PretraziKurseve().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOdustani;
    private javax.swing.JButton btnPretrazi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblKursevi;
    private javax.swing.JTextField txtNaziv;
    // End of variables declaration//GEN-END:variables

    public void srediFormu() {
        srediTabelu();
    }

    public void srediTabelu() {

        try {
            List<AbstractObjekat> listaKurseva = Kontroler.vratiInstancu().ucitajKurseve();
            mtk = new ModelTabeleKursevi(listaKurseva);
            tblKursevi.setModel(mtk);
        } catch (Exception ex) {
            Logger.getLogger(PretraziKurseve.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
