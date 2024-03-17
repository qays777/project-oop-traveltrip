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
public class TambahPelangganController implements ActionListener{
    Pelanggan model;
    TambahPelanggan view;
    Database con;

    public TambahPelangganController() throws SQLException {
        this.view = new TambahPelanggan();
        view.setController(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_tmbh_pel())){
            String nama = view.getTxt_nama().getText();
            String asl = view.getTxt_asal().getText();
            String no = view.getTxt_notelp().getText();
            model = new Pelanggan(nama, asl, no);
            try {
                con.savePelanggan(model);
                JOptionPane.showMessageDialog(view, "Data Pelanggan ditambahkan!");
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(TambahPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        if(source.equals(view.getBtn_back())){
            try {
                MainMenuController m = new MainMenuController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(EditWisataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
