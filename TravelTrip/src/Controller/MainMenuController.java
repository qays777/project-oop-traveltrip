package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author raybnsr
 */
public class MainMenuController implements ActionListener{
    MainMenu view;
    Database con;
    
    public MainMenuController() throws SQLException {
        this.view = new MainMenu();
        view.setController(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_tmbh_wisata())){
            try {
                TambahWisataController m = new TambahWisataController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        if(source.equals(view.getBtn_ubh_wisata())){
            try {
                DataWisataController c = new DataWisataController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_tmbh_pel())){
            try {
                TambahPelangganController c = new TambahPelangganController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_ubh_pel())){
            try {
                DataPelangganController c = new DataPelangganController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_tmbh_kend())){
            try {
                TambahKendaraanController c = new TambahKendaraanController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_ubh_kend())){
            try {
                DataKendaraanController c = new DataKendaraanController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_tmbh_pems())){
            try {
                TambahTransaksiController c = new TambahTransaksiController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_ubh_pems())){
            try {
                DataTransaksiController c = new DataTransaksiController();
                 this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(MainMenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_logout())){
            try {
                int selectedOption = JOptionPane.showConfirmDialog(null, "Apakah anda akan logout aplikasi?", "Logout Account", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION){
                    this.view.setVisible(false);
                    LoginController L = new LoginController();  
                }
            } catch (SQLException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_keluar())){
                int selectedOption = JOptionPane.showConfirmDialog(null, "Apakah anda akan keluar aplikasi?", "Exit", JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION){
                    System.exit(0);
            }
            
        }
    }
}