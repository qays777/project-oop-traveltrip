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
public class EditPelangganController implements ActionListener{
    Pelanggan model;
    EditPelanggan view;
    Database con;
    
    public EditPelangganController() throws SQLException {
        this.view = new EditPelanggan();
        view.setController(this);
        view.setVisible(true);
        con = new Database();
        con.connect();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if(source.equals(view.getBtn_ubh_pel())){
            
            try {
                model = new Pelanggan(Integer.parseInt(view.getTxt_id().getText()), view.getTxt_nama().getText(), view.getTxt_asal().getText(), view.getTxt_notelp().getText());
                con.updatePelanggan(model);
                JOptionPane.showMessageDialog(view, "Data Pelanggan sudah diubah!");
                DataPelangganController v = new DataPelangganController();
                this.view.setVisible(false); 
            } catch (SQLException ex) {
                Logger.getLogger(EditPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(source.equals(view.getBtn_back())){
            try {
                DataPelangganController m = new DataPelangganController();
                this.view.setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(EditPelangganController.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    }
    
    
}
